# ImJavaer（基础篇）
本项目存放自己平时敲的示例代码，并会在`README.md`中记录，以便自己忘了的时候回来看。每个类中都有测试代码，直接运行可查看效果。

- JDK使用版本: 1.7
- 构建工具: Maven

## 项目结构及内容简介

#### Annotations
    |com.peierlong.annotations   //注解
        |com.peierlong.annotations.database
        |*.java
        |-----------------  //注解示例（DB）
        
#### Concurrency
    |com.peierlong.concurrency   //并发
        |LiftOff.java
        |-----------------  //LiftOff任务
        |BasicThreads.java
        |-----------------  //测试-启动5个线程来运行LiftOff任务
        |SynchronizedExample.java
        |-----------------  //SynchronizedExample
        
#### Containers
    |com.peierlong.containers   //容器
        |AssociativeArray.java
        |-----------------  //用数组实现的简单的Map
        
#### Enum
    |com.peierlong.enumerated   //枚举
        |HourlyEmployee.java
        |Sex.java
        |----------------- //使用枚举来取代普通的定义常量方式
        
#### IO
    |com.peierlong.io   //IO
        |BasicFileOutput.java
        |-----------------  //读取字符串 使用FileWriter输出到文件中 打印文件中的内容
        
#### Reflection
    |com.peierlong.reflection   //反射
        |ReflectionTest.java
        |-----------------  //反射测试类, 返回某个类的信息
        |ReflectionExample.java
        |-----------------  //反射相关例子
        |TraceHandler.java
        |ProxyTest.java
        |-----------------  //使用代理查看二分查找算法过程
        |DateInterval.java
        |-----------------  //泛型方法的擦除

#### Util
    |com.peierlong.util   //工具类
        |CollectionData.java
        |-----------------  //构建一个类，它的构造器接收Generator和quantity数值
        |ImgUtil.java
        |-----------------  //图片工具类
