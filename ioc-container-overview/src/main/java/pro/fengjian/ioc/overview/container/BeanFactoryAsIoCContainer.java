package pro.fengjian.ioc.overview.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import pro.fengjian.ioc.overview.domain.User;

import java.util.Map;

/**
 * IoC 容器实例
 *
 * @author 风间
 * @since 2022/7/29 22:48
 */
public class BeanFactoryAsIoCContainer {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String location = "classpath:META-INF/dependency-lookup-context.xml";
        int loadBeanDefinitions = reader.loadBeanDefinitions(location);

        System.out.println("Bean 定义加载的数量: "+ loadBeanDefinitions);

        lookupCollectionByType(defaultListableBeanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        ListableBeanFactory defaultListableBeanFactory  = (ListableBeanFactory) beanFactory;
        Map<String, User> users = defaultListableBeanFactory.getBeansOfType(User.class);
        System.out.println(users);
    }

}
