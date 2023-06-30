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

### java 14

- [switch-表达式从早期版本继承](./java14/README.md#1-switch-表达式从早期版本继承)
- [改进-nullpointerexceptions-提示信息](./java14/README.md#2-改进-nullpointerexceptions-提示信息)
- [g1-的-numa-可识别内存分配](./java14/README.md#3-g1-的-numa-可识别内存分配)
- [删除-cms-垃圾回收期](./java14/README.md#4-删除-cms-垃圾回收期)
- [zgc-支持-macos-和-windows-系统-实验阶段](./java14/README.md#5-zgc-支持-macos-和-windows-系统-实验阶段)
- [弃用-parallelscavenge-和-serialold-gc-的组合使用](./java14/README.md#6-弃用-parallelscavenge-和-serialold-gc-的组合使用)
- [instanceof-模式匹配-预览阶段](./java14/README.md#7-instanceof-模式匹配-预览阶段)
- [record-类型预览功能](./java14/README.md#8-record-类型预览功能)
- [文本块第二预览版本](./java14/README.md#9-文本块第二预览版本)
- [打包工具孵化器版本](./java14/README.md#10-打包工具孵化器版本)
- [外部存储器访问孵化器版本](./java14/README.md#11-外部存储器访问孵化器版本)

### java 15

- [文本块](./java15/README.md#1-文本块)
- [edwards-curve-数字签名算法-eddsa](./java15/README.md#2-edwards-curve-数字签名算法-eddsa)
- [隐藏类-hidden-classes](./java15/README.md#3-隐藏类-hidden-classes)
- [重新实现-datagramsocket-api](./java15/README.md#4-重新实现-datagramsocket-api)
- [zgc-可伸缩低延迟垃圾收集器](./java15/README.md#5-zgc-可伸缩低延迟垃圾收集器)
- [禁用偏向锁定](./java15/README.md#6-禁用偏向锁定)
- [shenandoah低暂停时间垃圾收集器转正](./java15/README.md#7-shenandoah低暂停时间垃圾收集器转正)
- [移除nashorn-javascript引擎](./java15/README.md#8-移除nashorn-javascript引擎)
- [instanceof-自动匹配模式第二次预览](./java15/README.md#9-instanceof-自动匹配模式第二次预览)
- [密封的类和接口预览](./java15/README.md#10-密封的类和接口预览)
- [外部存储器访问-api二次孵化器版](./java15/README.md#11-外部存储器访问-api二次孵化器版)
- [records-二次预览](./java15/README.md#12-records-二次预览)

### java 16

- [instanceof-模式匹配正式版](./java16/README.md#1-instanceof-模式匹配正式版)
- [records-正式版](./java16/README.md#2-records-正式版)
- [unix-domain-套接字通道](./java16/README.md#3-unix-domain-套接字通道)
- [对基于值的类发出警告](./java16/README.md#4-对基于值的类发出警告)
- [打包工具正式版](./java16/README.md#5-打包工具正式版)
- [默认强封装-jdk-内部元素](./java16/README.md#6-默认强封装-jdk-内部元素)
- [zgc-并发线程处理](./java16/README.md#7-zgc-并发线程处理)
- [弹性元空间](./java16/README.md#8-弹性元空间)
- [向量-api-孵化器](./java16/README.md#9-向量-api-孵化器)
- [外部链接器-api孵化器](./java16/README.md#10-外部链接器-api孵化器)
- [外部存储器访问-api第三次孵化](./java16/README.md#11-外部存储器访问-api第三次孵化)
- [密封类第二预览](./java16/README.md#12-密封类第二预览)
- [启用-c14-语言特性在-jdk-源代码中](./java16/README.md#13-启用-c14-语言特性在-jdk-源代码中)
- [从-mercurial-迁移到-git--jep-369迁移到-github](./java16/README.md#14-从-mercurial-迁移到-git--jep-369迁移到-github)


### java 17

- [密封的类和接口正式版](./java17/README.md#1-密封的类和接口正式版)
- [恢复始终严格的浮点语义](./java17/README.md#2-恢复始终严格的浮点语义)
- [增强的伪随机数生成器](./java17/README.md#3-增强的伪随机数生成器)
- [新的macos渲染管道](./java17/README.md#4-新的macos渲染管道)
- [支持macos-aarch64](./java17/README.md#5-支持macos-aarch64)
- [弃用-applet-api](./java17/README.md#6-弃用-applet-api)
- [删除-rmi-激活](./java17/README.md#7-删除-rmi-激活)
- [删除实验性-aot-和-jit-编译器](./java17/README.md#8-删除实验性-aot-和-jit-编译器)
- [弃用安全管理器以进行删除](./java17/README.md#9-弃用安全管理器以进行删除)
- [新增switch模式匹配预览版](./java17/README.md#10-新增switch模式匹配预览版)
- [外部函数和内存api-第一轮孵化](./java17/README.md#11-外部函数和内存api-第一轮孵化)
- [向量-api-第二次孵化](./java17/README.md#12-向量-api-第二次孵化)
- [外部链接器-api孵化器](./java17/README.md#13-外部链接器-api孵化器)
- [外部存储器访问-api第三次孵化](./java17/README.md#14-外部存储器访问-api第三次孵化)

    
### 备注
本项目直接使用JDK17作为基础依赖，其余JDK版本可以在对应子工程的pom中指定，特定方法的编译和运行可以执行特定的JDK版本

### 引用

1. [Java Documentation](https://docs.oracle.com/en/java/)
2. [从JDK8到JDK17的新特性](https://www.zhihu.com/tardis/zm/art/585377119?source_id=1003)
