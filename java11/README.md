# java 11 新特性总结

java11 是长期支持版本。

### 1. 增加一些字符串处理方法

String类增加了几个方法，案例：`icu.zheteng.StringTest.main`

- 1.1 `isBlank()`判断一个字符串是否为空白（即只包含空格、制表符等不可见字符）
- 1.2 `lines()`  将一个字符串分割成多行，返回Stream<String>
- 1.3 `repeat()` 将一个字符串复制n次

### 2. HttpClient 支持HTTP/1.1和HTTP/2 ，也支持 websocket

##### 2.1 简介

通过 JEP 110标准化在 JDK 9 中引入并在 JDK 10 中更新的浮华 HTTP Client API。

HTTP Client 在 JDK 11 中已经标准化。之前孵化于`jdk.incubator.http`包中的 API，现在已经移除了。
现在可以从` java.net.http`中导入API

##### 2.2 使用

1. HttpClient 通过 builder 创建，可以通过 HttpClient 的静态方法 newBuilder() 创建 HttpClient，
并且可以配置http协议版本（HTTP/1.1或HTTP/2）、代理、cookie等。 HttpClient 创建后不可改变，但是可以发送多个请求。
2. 创建 HttpRequest，通过 `HttpRequest.newBuilder()`创建一个 request，并明确 url、请求方式等参数。
3. 通过 HttpClient 的 `send(HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler)` 发送同步请求，
或者通过`sendAsync(HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler)`发送异步请求。
4. 处理返回数据

##### 2.3 demo

 - http请求：`icu.zheteng.HttpClientTest.main`
 - websocket： `icu.zheteng.WebSocketTest.main`


### 3. `Files`增加`readString()` 和 `writeString()` 两个静态方法

通过这两个方法，我们可以更加便捷的读取和写入字符串。

使用demo在`icu.zheteng.FilesTest.main`

### 4. 集合转对应的数组

以前将集合转成对应的数组要么用迭代循环，要么用`Stream`，现在可以直接通过`Collection`的`toArray`方法直接转化,代码见：`icu.zheteng.CollectionTest.main`

```java
public class CollectionTest {

    public static void main(String[] args) {
        List<Integer> sampleList = Arrays.asList(1111, 2222);
        Integer[] array = sampleList.toArray(Integer[]::new);
        System.out.println(array.length);
    }
}

```

### 5. var 可以修饰 lambda 表达式的入参

在 java 10 中，引入了 var 类型推断关键字，但是不能在 lambda 表达式的入参中使用，
java 11 开始，var 可用于 lambda 的入参上，并且可以给入参加上注解，入非空校验`@NotNull`

```java
public class LambdaTest {


    public static void main(String[] args) {

        // Java 8 中 var 不能修饰lamda表达的是入参
        int x = 10;
        Consumer<Integer> consumer1 = y -> System.out.println(x + y);

        // Java 11 中 va r能修饰 Lambda 表达的是入参
        int z = 10;
        Consumer<Integer> consumer2 = (var y) -> System.out.println(z + y);

    }
}
```
### 6. 可以直接运行 java 文件

java 11 开始，我们可以直接通过`java`命令运行单一的 java 文件，不需要先进行`javac`编译后再运行对应的 class 文件

例如： 进入`icu.zheteng.JavaCommandTest`目录下，直接运行`java JavaCommandTest.java`命令，会直接输出`hello,new java command`


### 7. 可扩展的低延迟垃圾收集器（实验性质）

ZGC 和 G1 类似，也是采用**标记-复制**算法，不过 ZGC 对该算法做了重大改进：在标记、转移和重定位阶段都是并发的

ZGC 只有三个阶段是 STW，**初始标记，再标记，初始转移**。ZGC 几乎所有的暂停都只依赖于 GC Roots 集合的大小，停顿时间不会随着堆的大小或者活跃对象的大小而增加。

在美团技术博客中有详细的 ZGC 实践的说明：[新一代垃圾回收器ZGC的探索与实践](https://tech.meituan.com/2020/08/06/new-zgc-practice-in-meituan.html)

### 8. Flight Recorder(飞行记录器)

##### 8.1 简介

Flight Recorder 源自飞机的黑盒子

Java Flight Recorder简称JFR，OpenJDK从11版本开始支持。它是一个低开销的数据收集框架，可用于在生产环境中分析Java应用和JVM运行状况及性能问题。

Java Flight Recorder(JFR) 以前是商业版的特性，在java11中开源出来，他可以导出时间到文件中，之后可以用 Java Mission Control 来分析。

JFR 是一套集成进入 JDK、JVM 中的内部事件机制框架，通过良好的架构和设计的框架，硬件层面的极致优化，生产环境的广泛验证，他可以做到极致的和低开销。


##### 8.2 引用

[用Java Flight Recorder来调优JVM性能](https://skyscribe.github.io/post/2017/08/22/performance-tuning-with-java-flight-recorder/)




### 引用

- [JDK 11 Release Notes](https://www.oracle.com/java/technologies/javase/11-relnote-issues.html#NewFeature)
