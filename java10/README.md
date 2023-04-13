# java 10 新特性总结

### 1. 不可变集合的改进 `icu.zheteng.ImmutableCollectionTest`

- `Arrays` 增加了静态方法`CopyOf()`，用于将现有的集合转化成为不可变集合。 这个方法适合所有的类型的，包括 List、Set 和 Map

- `ToUnmodifiable()` : Stream API中增加的一个新方法，`Collectors.toUnmodifiableList()`，用于将Stream转化成不可变集合

### 2. var 关键字

##### 2.1 简介

它是一种类型推断机制，可以通过申明局部变量，代替显示指定变量类型的方式

##### 2.2 注意

1. var只能用于局部变量，不能用于成员变量、方法参数、方法返回值等
2. var声明的变量必须要有初始化值
3. var声明的变量会根据右边初始化值的类型进行类型推断，推断出来的类型是确定的，不能改变
4. var关键字不能单独使用，必须和初始化语句一起使用

### 3. 线程本地握手（Thread-Local Handshakes）

通过使用无需执行全局VM安全点就可以在应用程序线程上执行回调的可能，该JEP为提高VM性能奠定了基础。
这意味着JVM可以停止单个线程，而不仅仅是所有线程。

##### 引用
- [JEP 312: Thread-Local Handshakes](https://openjdk.org/jeps/312)


### 4.  Optional.orElseThrow()

`Optional`类的一个新方法，它现在是`get()`的首选替代方法。

方法说明：如果存在值，则返回该值，否则抛出 NoSuchElementException.

详见代码：`icu.zheteng.OptionalTest.main`

### 5. G1的并行 Full GC 

通过并行 Full GC 减少 Full GC 的时间。G1垃圾回收器是被设计用来避免Full GC，但是并发收集不能足够快速的回收内存时，将发生Full GC。
旧版本的Full GC使用的是单线程标记-清除-打包算法，新版本的Full GC 已经并行化。

### 6. 根证书

在 JDK 中提供一组默认的根证书颁发机构 (CA) 证书。

### 7. 基于时间的发行版本控制

从 Java 10 开始，Oracle 调整了基于时间的版本字符串方案。 版本号的新格式为：

`$FEATURE.$INTERIM.$UPDATE.$PATCH`




