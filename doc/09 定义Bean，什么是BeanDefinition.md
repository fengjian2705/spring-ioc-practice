# 定义Bean

> 什么是 BeanDefinition

* BeanDefinition 是 SpringFramework 中定义 Bean 的配置元信息接口，包含：  
  * Bean 的类名
  * Bean 的行为配置元素，如作用域、自动绑定的模式、生命周期回调等
  * 其他 Bean 的引用，又可称合作者（Collaborators）或者依赖（Dependencies）
  * 配置设置，比如 Bean 属性（Properties）

> BeanDefinition 元信息

| 属性（Property）          | 说明                                 |
|-----------------------|------------------------------------|
| Class                 | Bean 的全类名，必须是具体类，不能是抽象类或接口         |
| Name                  | Bean 的名称或者 ID                      |
| Scope                 | Bean 的作用域（如：singleton、prototype 等） |
| Constructor arguments | Bean 构造器参数（用于依赖注入）                 |
| Properties            | Bean 属性设置（用于依赖注入）                  |
|Autowiring mode| Bean 自动绑定模式（如：byName）              |
|Lazy inilization mode| Bean 延迟初始化模式（延迟和非延迟）               |
|Inilization mothod| Bean 初始化回调方法名称                     |
|Destruction method| Bean 销毁回调方法名称                      |

> BeanDefinition 构建

* 通过 BeanDefinitionBuilder
* 通过 AbstractBeanDefinition 以及派生类

> 命名 Spring Bean

* Bean 的名称：每个 Bean 拥有一个活动多个标识符号（identifiers），这些标识符在 Bean 所在容器  
* 必须是唯一的。通常一个 Bean 仅有一个标识符，如果需要额外的，可以考虑使用别名（Alias）来扩充。  
* 在基于 XML 的配置元信息中，开发人员可用 id 或 name 属性来规定 Bean 的标识符。通常 Bean 的标识符  
* 由字母组成，允许出线特殊字符。如果想要引入 Bean 的别名的话，可在 name 属性使用半角逗号（,）或分号（;）  
* 来分隔。  
* Bean 的 id 或 name 属性必须指定，如果留空的话，容器会为 Bean 自动生成一个唯一的的名称。Bean的名称尽管  
* 没有限制，不过官方建议采用驼峰的方式，更符合 Java 的命名约定。

