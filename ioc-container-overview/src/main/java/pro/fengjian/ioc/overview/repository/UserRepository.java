package pro.fengjian.ioc.overview.repository;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import pro.fengjian.ioc.overview.domain.User;

import java.util.Collection;

/**
 * 用户的信息仓库
 *
 * @author 风间
 * @since 2022/7/29 0:07
 */
public class UserRepository {

    private Collection<User> users;// 自定义 Bean

    private BeanFactory beanFactory;// 内建非 Bean 对象 （依赖）

    private ObjectFactory<User> userObjectFactory;

    private ObjectFactory<ApplicationContext> contextObjectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<User> getUserObjectFactory() {
        return userObjectFactory;
    }

    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
    }

    public ObjectFactory<ApplicationContext> getContextObjectFactory() {
        return contextObjectFactory;
    }

    public void setContextObjectFactory(ObjectFactory<ApplicationContext> contextObjectFactory) {
        this.contextObjectFactory = contextObjectFactory;
    }
}
