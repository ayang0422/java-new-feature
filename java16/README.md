# java 16 新特性总结

### 1. instanceof 模式匹配（正式版）

[instanceof 模式匹配](../java14/README.md#7-instanceof-模式匹配-预览阶段)

### 2. Records (正式版)

[instanceof 模式匹配](../java14/README.md#8-record-类型预览功能)

### 3. Unix-Domain 套接字通道

Unix-domain 套接字一直是大多数 Unix 平台的一个特性，现在在 Windows 10 和 Windows Server 2019 也提供了支持。
此特性为 java.nio.channels 包的套接字通道和服务器套接字通道 API 添加了 Unix-domain（AF_UNIX）套接字支持。
它扩展了继承的通道机制以支持 Unix-domain 套接字通道和服务器套接字通道。Unix-domain 套接字用于同一主机上的进程间通信（IPC）。
它们在很大程度上类似于 TCP/IP，区别在于套接字是通过文件系统路径名而不是 Internet 协议（IP）地址和端口号寻址的。
对于本地进程间通信，Unix-domain 套接字比 TCP/IP 环回连接更安全、更有效。

### 4. 对基于值的类发出警告

此特性将原始包装器类（java.lang.Integer、java.lang.Double 等）指定为基于值的（类似于 java.util.Optional 和 java.time.LocalDateTime），
并在其构造器中添加 forRemoval（自 JDK 9 开始被弃用），这样会提示新的警告。在 Java 平台中尝试在任何基于值的类的实例上进行不正确的同步时，它会发出警告。

许多流行的开源项目已经在其源中删除了包装构造器调用来响应 Java 9 的弃用警告，并且鉴于“弃用移除”警告的紧迫性，我们可以期望更多开源项目跟上这一步伐。

### 5. 打包工具（正式版）

在 Java 14 中 的一个孵化器模块引入的，该工具允许打包自包含的 Java 应用程序。 
[打包工具](../java14/README.md#10-打包工具孵化器版本)

### 6. 默认强封装 JDK 内部元素

此特性会默认强封装 JDK 的所有内部元素，但关键内部 API（例如 sun.misc.Unsafe）除外。
默认情况下，使用早期版本成功编译的访问 JDK 内部 API 的代码可能不再起作用。鼓励开发人员从使用内部元素迁移到使用标准 API 的方法上，
以便他们及其用户都可以无缝升级到将来的 Java 版本。强封装由 JDK 9 的启动器选项–illegal-access 控制，到 JDK 15 默认改为 warning，从 JDK 16 开始默认为 deny。
（目前）仍然可以使用单个命令行选项放宽对所有软件包的封装，将来只有使用–add-opens 打开特定的软件包才行。

### 7. ZGC 并发线程处理

将 ZGC 线程栈处理从安全点转移到一个并发阶段，甚至在大堆上也允许在毫秒内暂停 GC 安全点。消除 ZGC 垃圾收集器中最后一个延迟源可以极大地提高应用程序的性能和效率。

### 8. 弹性元空间

此特性可将未使用的 HotSpot 类元数据（即元空间，metaspace）内存更快速地返回到操作系统，从而减少元空间的占用空间。
具有大量类加载和卸载活动的应用程序可能会占用大量未使用的空间。新方案将元空间内存按较小的块分配，它将未使用的元空间内存返回给操作系统来提高弹性，从而提高应用程序性能并降低内存占用。

### 9. 向量 API （孵化器）

该孵化器 API 提供了一个 API 的初始迭代以表达一些向量计算，这些计算在运行时可靠地编译为支持的 CPU 架构上的最佳向量硬件指令，从而获得优于同等标量计算的性能，充分利用单指令多数据（SIMD）技术（大多数现代 CPU 上都可以使用的一种指令）。
尽管 HotSpot 支持自动向量化，但是可转换的标量操作集有限且易受代码更改的影响。该 API 将使开发人员能够轻松地用 Java 编写可移植的高性能向量算法。

### 10. 外部链接器 API（孵化器）

该孵化器 API 提供了静态类型、纯 Java 访问原生代码的特性，该 API 将大大简化绑定原生库的原本复杂且容易出错的过程。
Java 1.1 就已通过 Java 原生接口（JNI）支持了原生方法调用，但并不好用。Java 开发人员应该能够为特定任务绑定特定的原生库。
它还提供了外来函数支持，而无需任何中间的 JNI 粘合代码。

### 11. 外部存储器访问 API（第三次孵化）

[外部存储器访问](../java14/README.md#11-外部存储器访问孵化器版本)

### 12. 密封类（第二预览）

[外部存储器访问](../java15/README.md#11-密封的类和接口预览)

### 13. 启用 C++14 语言特性（在 JDK 源代码中）

它允许在 JDK C++ 源代码中使用 C++14 语言特性，并提供在 HotSpot 代码中可以使用哪些特性的具体指导。在 JDK 15 中，JDK 中 C++ 代码使用的语言特性仅限于 C++98/03 语言标准。它要求更新各种平台编译器的最低可接受版本

### 14. 从 Mercurial 迁移到 Git & JEP 369，迁移到 GitHub

这些 JEP 将 OpenJDK 社区的源代码存储库从 Mercurial（hg）迁移到 Git，并将它们托管在 GitHub 上以供 JDK 11 及更高版本使用，
其中包括将 jcheck、webrev 和 defpath 工具等工具更新到 Git。Git 减小了元数据的大小（约 1/4），可节省本地磁盘空间并减少克隆时间。

与 Mercurial 相比，现代工具链可以更好地与 Git 集成。Open JDK Git 存储库现在位于 https://github.com/openjdk/jdk

### 15. AlpineLinux 移植 & JEP 388：Windows/AArch64 移植

这些 JEP 的重点不是移植工作本身，而是将它们集成到 JDK 主线存储库中；JEP 386 将 JDK 移植到 Alpine Linux 和其他使用 musl 作为 x64 上主要 C 库的发行版上。此外，JEP 388 将 JDK 移植到 Windows AArch64（ARM64）。#


