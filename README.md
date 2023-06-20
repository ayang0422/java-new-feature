# java-new-feature

本项目总结java9-17的新特性

### 背景
由于企业有新的项目开发，并准备机遇JDK17作为基础，故调研JDK9-17新增的重要新特性。
对于新增的特性，我都会写一个简单的demo去总结新特性，使自己充分了解新特性，保证印象深刻。

### 新特性

#### java 9

- [模块化](./java9/oop-module-1/README.md)
- [引入新版本字符串格式（New Version-String Scheme）](./java9/README.md#2-新的版本字符串格式)
- [jshell-工具](./java9/README.md#3-jshell-工具)
- [使用G1作为默认垃圾回收器](./java9/README.md#4-使用g1作为默认垃圾回收器)
- [私有接口方法](./java9/README.md#5-私有接口方法)
- [Stream API 的增强](./java9/README.md#6-stream-api-的增强)
- [Optional 类改进](./java9/README.md#7-optional-类改进)
- [多版本兼容Jar包(Multi-Release JAR)](./java9/README.md#8-多版本兼容jar包multi-release-jar)
- [三个新的工厂方法](./java9/README.md#9-三个新的工厂方法)

#### java 10

- [不可变集合的改进](./java10/README.md#1-不可变集合的改进-icuzhetengimmutablecollectiontest)
- [var 关键字](./java10/README.md#2-var-关键字)
- [线程本地握手](./java10/README.md#3-线程本地握手thread-local-handshakes)
- [Optional.orElseThrow()](./java10/README.md#4-optionalorelsethrow)
- [G1的并行 Full GC ](./java10/README.md#5-g1的并行-full-gc-)
- [根证书](./java10/README.md#6-根证书)
- [基于时间的发行版本控制](./java10/README.md#7-基于时间的发行版本控制)

#### java 11

- [增加一些字符串处理方法](./java11/README.md#1-增加一些字符串处理方法)
- [HttpClient 支持HTTP/1.1和HTTP/2 ，也支持 websocket](./java11/README.md#2-httpclient-支持http11和http2-也支持-websocket)
- [Files增加readString() 和 writeString() 两个静态方法](./java11/README.md#3-files增加readstring-和-writestring-两个静态方法)
- [集合转对应的数组](./java11/README.md#4-集合转对应的数组)
- [var 可以修饰 lambda 表达式的入参](./java11/README.md#5-var-可以修饰-lambda-表达式的入参)
- [可以直接运行 java 文件](./java11/README.md#6-可以直接运行-java-文件)
- [可扩展的低延迟垃圾收集器（实验性质）](./java11/README.md#7-可扩展的低延迟垃圾收集器实验性质)
- [Flight Recorder(飞行记录器)](./java11/README.md#8-flight-recorder飞行记录器)

#### java 12

- [支持 Unicode 11](./java12/README.md#1-支持-unicode-11)
- [在 Linux 系统上支持 POSIX_SPAWN](./java12/README.md#2-在-linux-系统上支持-posixspawn)
- [JVM Constants API](./java12/README.md#3-jvm-constants-api)
- [支持压缩数字格式](./java12/README.md#4-支持压缩数字格式)
- [支持日本新年号的方形字符](./java12/README.md#5-支持日本新年号的方形字符)
- [ZGC 并发类卸载](./java12/README.md#6-zgc-并发类卸载)
- [HotSpot Windows 操作系统检测正确识别 Windows Server 2019](./java12/README.md#7-hotspot-windows-操作系统检测正确识别-windows-server-2019)
- [新的 JFR 安全事件](./java12/README.md#8-新的-jfr-安全事件)
- [switch 表达式可以有返回值](./java12/README.md#9-switch-表达式可以有返回值预览版)

#### java 13

- [文本块（预览功能）](./java13/README.md#1-文本块预览功能)
- [Switch 表达式扩展（预览功能）](./java13/README.md#2-switch-表达式扩展预览功能)
- [SocketAPI 重构](./java13/README.md#3-socketapi-重构)
- [ZGC 优化](./java13/README.md#4-zgc-优化)
- [动态 CDS 存档](./java13/README.md#5-动态-cds-存档)
- [杂项](./java13/README.md#6-杂项)
    
### 备注
本项目直接使用JDK17作为基础依赖，其余JDK版本可以在对应子工程的pom中指定，特定方法的编译和运行可以执行特定的JDK版本

### 引用

1. [Java Documentation](https://docs.oracle.com/en/java/)
2. [从JDK8到JDK17的新特性](https://www.zhihu.com/tardis/zm/art/585377119?source_id=1003)
