# ImJavaer
本项目存放自己平时敲的示例代码，对一些基础知识的理解与认识，并会在`README.md`中记录，以便自己忘了的时候回来看。每个类中都有测试代码，直接运行可查看效果。

- JDK使用版本: 1.7
- 构建工具: Maven

## 项目结构及内容简介
####设计模式
    |com.elong.design.patterns
        |EnumSingleton.java
        |SingletonObject.java
        |-----------------  //单例模式
####Effective Java
    |com.elong.effective
        |Service.java
        |Provider.java
        |Services.java
        |-----------------  //服务提供者框架
        |Student.java
        |-----------------  //Builder模式
        |PhoneNumber.java
        |-----------------  //覆盖equals的同时要覆盖hashCode
        |Complex.java
        |-----------------  //不可变类的示例
        |Figure.java
        |FigureTrue.java
        |-----------------  //类层次优于标签类
        |Favorites.java
        |-----------------  //类型安全的异构容器的实现
        |AnnotatedElement.java
        |-----------------  /使用asSubclass方法在编译时读取类型未知的注解
        |Operation.java
        |-----------------  //利用枚举类型来实现特定运算
        |Phase.java
        |-----------------  //使用嵌套的EnumMap来构建关联的一对枚举
        |Period.java
        |-----------------  //必要时进行保护性拷贝
        |ReflectiveTest.java
        |-----------------  //使用反射类获取对象的实例
        |SetObserver.java
        |ForwardingSet.java
        |ObservableSet.java
        |-----------------  //避免过度同步(观察者模式)
####ifeve.com
    |com.elong.ifeve
        |BlockingQueue.java
        |-----------------  //一个阻塞队列的简单实现
        |CASDemo.java
        |-----------------  //原子包boolean原子性示例
        |FairLock.java
        |-----------------  //公平锁的实现
        |Lock.java
        |Synchronizer.java
        |LockTest.java
        |-----------------  //锁的实现与测试
        |MyWaitNotify.java
        |-----------------  //测试notify和wait的执行流程
        |QueueObject.java
        |-----------------  //信号量对象
        |ReadWriteLock.java
        |-----------------  //可重入的读写锁
        |ThreadLocalTest.java
        |-----------------  //ThreadLocalTest
        |死锁的演示.java
        |-----------------  //死锁示例
####Thinking in Java
    |com.elong.thinking.annotations
    |-----------------  //注解
    |com.elong.thinking.concurrency
    |-----------------  //并发
    |com.elong.thinking.containers
    |-----------------  //容器
    |com.elong.thinking.enumerated
    |-----------------  //枚举
    |com.elong.thinking.io
    |-----------------  //IO
    |com.elong.thinking.util
    |-----------------  //工具类
####Core Java
    |com.elong.core.volume.one
        |ReflectionTest.java
        |-----------------  //反射测试类, 返回某个类的信息