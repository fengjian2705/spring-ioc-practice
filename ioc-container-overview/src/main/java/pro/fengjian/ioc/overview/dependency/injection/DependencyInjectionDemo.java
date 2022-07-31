package pro.fengjian.ioc.overview.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import pro.fengjian.ioc.overview.domain.User;
import pro.fengjian.ioc.overview.repository.UserRepository;

/**
 * 依赖注入示例
 *
 * @author 风间
 * @since 2022/7/29 0:04
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {

        // 配置 XML 文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");

        // 依赖来源一：依赖自动注入（byType），自定义Bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        System.out.println(userRepository.getUsers());

        // 内建Bean对象注入 BeanFactory
        // 依赖来源二：依赖注入，内建依赖
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == beanFactory);

        // 依赖查找 ：No qualifying bean of type 'org.springframework.beans.factory.BeanFactory'
        // System.out.println(beanFactory.getBean(BeanFactory.class));

        // 延迟注入
        ObjectFactory<User> userObjectFactory = userRepository.getUserObjectFactory();
        System.out.println(userObjectFactory.getObject());

        // 依赖来源三：容器内建 Bean
        ObjectFactory<ApplicationContext> contextObjectFactory = userRepository.getContextObjectFactory();
        System.out.println(contextObjectFactory.getObject() == beanFactory);

        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取 environment 类型 Bean：" + environment);

        //  No qualifying bean of type 'org.springframework.context.ApplicationContext' available
//        ApplicationContext applicationContext = beanFactory.getBean(ApplicationContext.class);
//        System.out.println("applicationContext: " + applicationContext);
    }

    public static void whoIsIoCContainer(UserRepository userRepository, BeanFactory beanFactory) {

        // 为什么结果是 false
        System.out.println(userRepository.getBeanFactory() == beanFactory);

    }
}
