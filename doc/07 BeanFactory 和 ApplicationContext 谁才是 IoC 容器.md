# BeanFactory 和 ApplicationContext 谁才是 IoC 容器 ?

> ApplicationContext 是 BeanFactory 的超集，ApplicationContext is
> BeanFactory

* BeanFactory 则属于底层的容器，提供了配置框架和基础功能

* ApplicationContext 在 BeanFactory 基础上新增如下功能：
    * 面向切面（AOP）
    * 配置元信息（Configuration Metadata）
    * 资源管理（Resources）
    * 事件（Events）
    * 注解（Annotation）
    * Environment 抽象（Environment Abstract）
    

* ConfigurableApplicationContext <- ApplicationContext <- BeanFactory 