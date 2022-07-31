package pro.fengjian.ioc.overview.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import pro.fengjian.ioc.overview.domain.User;

import java.util.Map;

/**
 * IoC 容器实例
 *
 * @author 风间
 * @since 2022/7/29 22:48
 */
public class ApplicationContextAsIoCContainer {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationContextAsIoCContainer.class);
        // 启动容器
        applicationContext.refresh();
        System.out.println(applicationContext.getBean(User.class));
        // 关闭容器
        applicationContext.close();
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(2L);
        user.setName("rose");
        return user;
    }


}
