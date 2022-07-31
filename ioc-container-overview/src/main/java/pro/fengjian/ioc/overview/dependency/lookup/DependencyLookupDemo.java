package pro.fengjian.ioc.overview.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pro.fengjian.ioc.overview.annotation.Super;
import pro.fengjian.ioc.overview.domain.User;

import java.util.Map;

/**
 * 依赖查找示例
 * 1. 通过名称的方式来查找
 * 1）实时查找
 * 2）延迟查找
 * 2. 通过类型的方式来查找
 * 1）单个Bean对象
 * 2）集合Bean对象
 * 3. 通过注解的方式来查找
 * 1）单个Bean对象
 * 2）集合Bean对象
 *
 * @author 风间
 * @since 2022/7/28 0:00
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {

        // 配置 XML 文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-lookup-context.xml");
        // 按照类型查找
        lookupByType(beanFactory);
        // 按照类型查找集合对象
        lookupCollectionByType(beanFactory);
        // 按照注解查找集合对象
        lookupCollectionByAnnotation(beanFactory);

//        lookupInRealTime(beanFactory);
//        lookupInLazy(beanFactory);


    }

    private static void lookupCollectionByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> userMap = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("通过注解查找bean："+userMap);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("User类型对象：" + userMap);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }

    /**
     * ObjectFactory: 定义一个工厂，它可以在被调用时返回一个 Object 实例（可能是共享的或独立的）。
     * 此接口通常用于封装通用工厂，该工厂在每次调用时返回某个目标对象的新实例（原型）。
     * 此接口类似于 FactoryBean，但后者的实现通常意味着定义为 BeanFactory 中的 SPI 实例，
     * 而此类的实现通常意味着作为 API 提供给其他 bean（通过注入）。 因此，getObject() 方法具有不同的异常处理行为。
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        beanFactory.getBean("objectFactory");
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找：" + user.hashCode());
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找：" + user.hashCode());
    }
}
