# java 12 新特性总结

### 1. 支持 Unicode 11

新增加 684 个字符，11 个块，7 个脚本。

### 2. 在 Linux 系统上支持 POSIX_SPAWN

作为在 Linux 上启动进程的一种方式，可以将`jdk.lang.Process.launchMechanism`设置成`POSIX_SPAWN`
这个选项在其他`*nix`平台上可用已经很久了。Linux 上的默认启动机制(VFORK)未更改，因此，此附加选项不会影响现有安装。

在生产环境建议谨慎使用！

### 3. JVM Constants API

引入新的 API 来对字节码文件和运行时工件的名义描述（nominal descriptions）进行建模，特别是可从（字码码文件）常量池加载的常量。

每一个字节码文件都有一个常量池，用来存储字节码指令的操作数。常量池中的条目要么描述类和方法等运行时工件，要么描述字符串和整数等简单值。
这些条目被称为可加载常量，因为它们可以作为“ldc”指令的操作数。

新增加的类：ConstantDesc、ClassDesc,MethodTypeDesc,MethodHandleDesc, 和DynamicConstantDesc 。
这套 API 的添加旨在提供一个标准的模型，可供一些底层库使用，例如字节码解析和生成的库 ASM、反射库等。大多数 Java 开发人员不需要使用它。

### 4. 支持压缩数字格式

`NumberFormat`添加支持压缩格式数字。压缩数字格式旨在用简短的、人类可读的方式代表一个数字，例如：`1000` 可以格式化成 `1k`

代码可见`zheteng.CompactNumberFormatsTest.main`

### 5. 支持日本新年号的方形字符

>2019年4月1日，日本官房长官菅义伟宣布，“令和”被选为日本新年号，是日本第126代天皇的年号。
2019年4月3日，日本外务省就新年号“令和”向外国媒体公布了官方英文翻译：“Beautiful Harmony”，为“美丽和谐”之意。
2019年5月1日零时（日本东京时间），日本正式启用“令和”为年号。

unicode 代码 U+32FF 用于表示 ㋿ ，这次 jdk 也做了支持。

详细可见代码：`zheteng.JapanNewEraTest`

### 6. ZGC 并发类卸载

ZGC 现在支持并发类卸载，通过卸载未使用的类，可以释放与这些类相关的数据结构，从而降低应用程序的整体占用空间。
ZGC 中的类卸载是并发的，不会停止 Java 应用程序的线程的执行，因此对 GC STW 时间的影响为零。
这个属性默认是开启的，但是可以通过` -XX:-ClassUnloading`禁用

### 7. HotSpot Windows 操作系统检测正确识别 Windows Server 2019

在此修复之前，`Windows Server 2019` 被识别为`Windows Server 2016`，它在 `os.name` 系统属性和 `hs_err_pid` 文件中产生了不正确的值。

### 8. 新的 JFR 安全事件

四个新的 JFR 事件已添加到安全库区域。默认情况下禁用这些事件，可以通过 JFR 配置文件或标准 JFR 选项启用。

- jdk.SecurityPropertyModification
- jdk.TLSHandshake
- jdk.X509Validation
- jdk.X509Certificate

### 9. switch 表达式可以有返回值（预览版）

case 后的 `：`可以写成`->`跟上简短的表达式，并且新的语法不会出现下落的情况，也就是意味着不需要写`break;`

在 java 12 中还是预览版本，但是可以在 java 14 中直接体验，
详细代码可见：`java14/src/main/java/icu/zheteng/SwitchTest.java`



### 备注

文档中还有很多新的特性没有列举完全，其他新功能可以移步引用中的第一条（官方文档）阅读


### 引用

[JDK 12 Release Notes](https://www.oracle.com/java/technologies/javase/12-relnote-issues.html#JDK-8203252)
