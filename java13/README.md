# java 13 新特性总结

### 1. 文本块（预览功能）

一直以来 Java 语言在字符串中都不能直接多行使用，需要通过连接符支持多行，导致代码难以阅读、难以维护。

通过一对三重引号来表达多行字符串，不需要通过额外的连接符来处理多行字符串

代码：`java15/src/main/java/icu/zheteng/TextBlockTest.java`

### 2. Switch 表达式扩展（预览功能）

在 Java 12 中引入了 Switch 表达式作为预览特性，而在 Java 13 中对 Switch 表达式做了增强改进，
在块中引入了 yield 语句来返回值，而不是使用 break。
这意味着，Switch 表达式（返回值）应该使用 yield，而 Switch 语句（不返回值）应该使用 break，
而在此之前，想要在 Switch 中返回内容，还是比较麻烦的，只不过目前还处于预览状态。

在 Java 13 之后，Switch 表达式中就多了一个关键字用于跳出 Switch 块的关键字 yield，主要用于返回一个值，
它和 return 的区别在于：return 会直接跳出当前循环或者方法，而 yield 只会跳出当前 Switch块，同时在使用 yield 时，需要有 default 条件。

### 3. SocketAPI 重构

Java 13 重新实现了 Java Socket API。 `java.net.Socket` 和 `java.net.ServerSocket` 等旧套接字 API 已被替换。

- `PlainSocketImpl` 不再使用，现在 Socket API 提供者指向 `NioSocketImpl`。
- 新的实现利用 `java.nio` 基础设施来实现更好的并发性和 I/O 控制。
- 新实现向后兼容使用旧实现的代码。
- 旧实现和用于选择旧实现的系统属性可能在将来版本中移除
- 可以通过多种方式使用旧实现：
  1. 设置系统属性`jdk.net.usePlainSockteImpl`为`true`
  2. 使用 `-Djdk.net.usePlainSocketImpl` 选项运行 Java。
  3. 更新 `${java.home}/conf/net.properties` 中可用的 JDK 网络配置文件。

### 4. ZGC 优化

在 Java 11 中是实验性的引入的 ZGC 在实际的使用中存在未能主动将未使用的内存释放给操作系统的问题。
ZGC 堆由一组称为 ZPages 的堆区域组成。在 GC 周期中清空 ZPages 区域时，
它们将被释放并返回到页面缓存 ZPageCache 中，此缓存中的 ZPages 按最近最少使用（LRU）的顺序，并按照大小进行组织。
在 Java 13 中，ZGC 将向操作系统返回被标识为长时间未使用的页面，这样它们将可以被其他进程重用。

如果我们不想使用该特性，可以通过以下方式返回 Java 11 : 

- 使用`-XX:-ZUncommit`
- 将`-Xms`和`Xmx`的值设置相同

### 5. 动态 CDS 存档

一段时间以来，类数据共享 (CDS) 一直是 Java HotSpot VM 的一个突出特性。
它允许在不同的 JVM 之间共享类元数据，以减少启动时间和内存占用。 
JDK 10 通过添加应用程序 CDS (AppCDS) 扩展了这种能力——让开发人员能够将应用程序类包含在共享存档中。 JDK 12 进一步增强了此功能，默认包含 CDS 存档。

然而，归档应用程序类的过程是乏味的。要生成存档文件，开发人员必须先试运行他们的应用程序以创建类列表，
然后将其转储到存档中。之后，这个存档可用于在 JVM 之间共享元数据。

通过动态归档，JDK 13 简化了这个过程。现在我们可以在应用程序退出时生成共享存档。

这消除了试运行的需要。 为了使应用程序能够在默认系统存档之上创建动态共享存档，
我们需要添加一个选项 -XX:ArchiveClassesAtExit 并将存档名称指定为参数：

```
java -XX:ArchiveClassesAtExit=<archive filename> -cp <app jar> AppName
```

然后我们可以使用新创建的存档来运行带有 -XX:SharedArchiveFile 选项的相同应用程序：

```
java -XX:SharedArchiveFile=<archive filename> -cp <app jar> AppName
```

### 6. 杂项

- java.nio: 方法`FileSystems.newFileSystem(Path, Map<String, ?>) `添加
- java.time: 添加了新的日本官方年号
- javax.crypto: 支持 MS 下一代密码术 (CNG)
- javax.security: 添加属性 `jdk.sasl.disabledMechanisms` 以禁用 SASL 机制
- javax.xml.crypto: 引入了新的字符串常量来表示 Canonical XML 1.1 URI
- javax.xml.parsers: 添加了新方法以实例化具有命名空间支持的 DOM 和 SAX 工厂
- Unicode 支持升级到版本 12.1
- 添加了对 Kerberos 主体名称规范化和跨领域引用的支持

### 7. 引用

[JDK 13 Release Notes](https://www.oracle.com/java/technologies/javase/13-relnote-issues.html)
[New Features in Java 13](https://www.baeldung.com/java-13-new-features)
