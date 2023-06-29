# java 17 新特性总结

Java 17 是一个长期支持版本，提供了数千个性能、稳定性和安全性更新，以及14个 JEP (JDK 增强提案)，进一步改进了 Java 语言和平台，以帮助开发人员提高工作效率。

### 1. 密封的类和接口（正式版）

封闭类可以是封闭类和或者封闭接口，用来增强 Java 编程语言，防止其他类或接口扩展或实现它们。这个特性由Java 15的预览版本晋升为正式版本。

[密封类](../java15/README.md#11-密封的类和接口预览)

### 2. 恢复始终严格的浮点语义

Java 编程语言和 Java 虚拟机最初只有严格的浮点语义。从 Java 1.2 开始，默认情况下允许在这些严格语义中进行微小的变化，以适应当时硬件架构的限制。这些差异不再有帮助或必要，因此已被 JEP 306 删除。#

### 3. 增强的伪随机数生成器

伪随机数生成器（pseudo random number generator，PRNG），又被称为确定性随机比特生成器（deterministic random bit generator，DRBG），
是一个生成数字序列的算法，其特性近似于随机数序列。伪随机数生成器生成的序列并不是真随机，因此它的每一个数完全由一个初始值决定，
这个初始值被称为随机种子（seed种子有时使用接近于真随机的硬件随机数生成器生成）。
尽管接近于真随机的序列可以通过硬件随机数生成器生成，但伪随机数生成器因为其生成速度和可再现的优势，在实践中显得尤为重要。

- 提供了一个新接口 RandomGenerator
它为所有现有的和新的 PRNG 提供了一个统一的 API。 RandomGenerators 提供名为 
ints、longs、doubles、nextBoolean、nextInt、nextLong、nextDouble 和 nextFloat 的方法，以及它们当前的所有参数的变化。
从而更容易在应用程序中互换使用各种 PRNG 算法。

- 提供了一个新类 RandomGeneratorFactory 。它用于定位和构造 RandomGenerator 实现的实例。

### 4. 新的macOS渲染管道

使用 Apple Metal API 为 macOS 实现 Java 2D 管道。新管道将减少 JDK 对已弃用的 Apple OpenGL API 的依赖。

目前默认情况下，这是禁用的，因此渲染仍然使用OpenGL API；要启用metal，应用程序应通过设置系统属性指定其使用：

`-Dsun.java2d.metal=true`

Metal或OpenGL的使用对应用程序是透明的，因为这是内部实现的区别，对Java API没有影响。Metal管道需要macOS 10.14.x或更高版本。在早期版本上设置它的尝试将被忽略。

### 5. 支持macOS AArch64

将 JDK 移植到 macOS/AArch64 平台。该端口将允许 Java 应用程序在新的基于 Arm 64 的 Apple Silicon 计算机上本地运行。

### 6. 弃用 Applet API

所有网络浏览器供应商要么已取消对 Java 浏览器插件的支持，要么已宣布计划这样做。 Applet API 已于 2017 年 9 月在 Java 9 中弃用，但并未移除。

### 7. 删除 RMI 激活

删除远程方法调用 (RMI) 激活机制，同时保留 RMI 的其余部分。

### 8. 删除实验性 AOT 和 JIT 编译器

实验性的基于 Java 的提前 (AOT) 和即时 (JIT) 编译器是实验性功能，并未得到广泛采用。作为可选，它们已经从 JDK 16 中删除。这个 JEP 从 JDK 源代码中删除了这些组件。

### 9. 弃用安全管理器以进行删除

安全管理器可以追溯到 Java 1.0 多年来，它一直不是保护客户端 Java 代码的主要方法，也很少用于保护服务器端代码。
在未来的版本中将其删除将消除重大的维护负担，并使 Java 平台能够向前发展。

### 10. 新增switch模式匹配（预览版）

和 instanceof 一样，switch 也紧跟着增加了类型匹配自动转换功能，并且 null 值的判断也进行了优化。

[switch 模式匹配](./src/main/java/icu/zheteng/SwitchTest.java)
![img.png](img.png)
### 11. 外部函数和内存api （第一轮孵化）

Java 程序可以通过该 API 与 Java 运行时之外的代码和数据进行互操作。通过高效地调用外部函数（即 JVM 之外的代码）和安全地访问外部内存（即不受 JVM 管理的内存），
该 API 使 Java 程序能够调用本机库并处理本机数据，而不会像 JNI 那样危险和脆弱。

### 12. 向量 API （第二次孵化）

[向量 API](../java16/README.md#9-向量-api-孵化器)

### 13. 外部链接器 API（孵化器）

[外部链接器 API（孵化器）](../java16/README.md#10-外部链接器-api孵化器)

### 14. 外部存储器访问 API（第三次孵化）

[外部链接器 API（孵化器）](../java14/README.md#11-外部存储器访问孵化器版本)



