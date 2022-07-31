# BeanFactory 和 ApplicationContext 谁才是 IoC 容器 ?

> ApplicationContext 是 BeanFactory 的超集，ApplicationContext is
> BeanFactory

* BeanFactory 则属于底层的容器，提供了配置框架和基础功能

* ApplicationContext 在 BeanFactory 基础上新增如下功能：
    * Spring AOP 整合
    * 消息处理（国际化）
    * 事件发布
    * 应用层上下文（webApplication）

* ConfigurableApplicationContext <- ApplicationContext <- BeanFactory 