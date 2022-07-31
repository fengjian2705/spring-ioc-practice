# Spring IoC 容器生命周期

### 1. 启动

refresh() 方法

```java
public void refresh()throws BeansException,IllegalStateException{
    // 线程安全
    synchronized (this.startupShutdownMonitor){
        // Prepare this context for refreshing.
        // 记录启动时间，初始化 PropertySource，Environment 校验...
        prepareRefresh();

        // Tell the subclass to refresh the internal bean factory.
        // BeanFactory 实例化获取
        ConfigurableListableBeanFactory beanFactory=obtainFreshBeanFactory();
        
        // Prepare the bean factory for use in this context.
        // BeanFactory 初始化
        prepareBeanFactory(beanFactory);

        try{
        // Allows post-processing of the bean factory in context subclasses.
        postProcessBeanFactory(beanFactory);

        // Invoke factory processors registered as beans in the context.
        invokeBeanFactoryPostProcessors(beanFactory);

        // Register bean processors that intercept bean creation.
        registerBeanPostProcessors(beanFactory);

        // Initialize message source for this context.
        initMessageSource();

        // Initialize event multicaster for this context.
        initApplicationEventMulticaster();

        // Initialize other special beans in specific context subclasses.
        onRefresh();

        // Check for listener beans and register them.
        registerListeners();

        // Instantiate all remaining (non-lazy-init) singletons.
        finishBeanFactoryInitialization(beanFactory);

        // Last step: publish corresponding event.
        finishRefresh();
        }

        catch(BeansException ex){
        if(logger.isWarnEnabled()){
        logger.warn("Exception encountered during context initialization - "+
        "cancelling refresh attempt: "+ex);
        }

        // Destroy already created singletons to avoid dangling resources.
        destroyBeans();

        // Reset 'active' flag.
        cancelRefresh(ex);

        // Propagate exception to caller.
        throw ex;
        }

        finally{
        // Reset common introspection caches in Spring's core, since we
        // might not ever need metadata for singleton beans anymore...
        resetCommonCaches();
        }
        }
        }
```

### 2. 运行

### 3. 停止