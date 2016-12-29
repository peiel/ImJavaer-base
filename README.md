# ImJavaer
本项目存放自己平时敲的示例代码，对一些基础知识的理解与认识，并会在`README.md`中记录，以便自己忘了的时候回来看。每个类中都有测试代码，直接运行可查看效果。

- JDK使用版本: 1.7
- 构建工具: Maven

## 项目结构及内容简介
####设计模式模块
    |com.elong.design.patterns
        |EnumSingleton.java
        |SingletonObject.java
        |-----------------  //单例模式
####并发编程模块
    |com.elong.concurrency
        |UnsafeSequence.java
        |-----------------  //非线程安全的数值生成器
        |Sequence.java
        |-----------------  //线程安全的数值生成器
        |NoVisibility.java
        |-----------------  //在没有同步的情况下共享变量
        |OneValueCache.java
        |-----------------  //对数值及其因数分解结果进行缓存的不可变容器类
        |PersonSet.java
        |-----------------  //通过实例封闭和加锁机制使一个类成为线程安全的(类的状态变量并不是线程安全的)
        |TestHarness.java
        |-----------------  //同步工具类: 闭锁: 使用CountDownLatch类启动和停止线程
        |BoundedHashSet.java
        |-----------------  //同步工具类: 使用Semaphore为容器设置边界
        |barrierTest.java
        |-----------------  //同步工具类: CyclicBarrier
        |custom.cache.*
        |-----------------  //构建高效的、可伸缩的结果缓存
        
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
        |AnnotatedElement.java``````
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
        |HourlyEmployee.java
        |Sex.java
        |----------------- //使用枚举来取代普通的定义常量方式
    |com.elong.thinking.io
    |-----------------  //IO
    |com.elong.thinking.util
    |-----------------  //工具类
####Core Java
    |com.elong.core.volume.one
        |ReflectionTest.java
        |-----------------  //反射测试类, 返回某个类的信息
        |ReflectionExample.java
        |-----------------  //反射相关例子
        |TraceHandler.java
        |ProxyTest.java
        |-----------------  //使用代理查看二分查找算法过程
        |DateInterval.java
        |-----------------  //泛型方法的擦除