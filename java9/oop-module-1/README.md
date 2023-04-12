# JDK9新特性-模块化 Module

### 大白话简介（摘自廖雪峰官网）

在Java 9之前，一个大型Java程序会生成自己的jar文件，同时引用依赖的第三方jar文件，而JVM自带的Java标准库，实际上也是以jar文件形式存放的，这个文件叫rt.jar，一共有60多M。

jar只是存放class 的容器，它并不关心class之间的依赖

如果是自己开发的程序，除了一个自己的app.jar以外，还需要一堆第三方的jar包，运行一个Java程序，一般来说，命令行写这样：

`java -cp app.jar:a.jar:b.jar:c.jar com.liaoxuefeng.sample.Main`

在Java 9开始，引入了模块，主要是解决"依赖这个问题"。如果`a.jar`必须依赖`b.jar`才能运行，
那应该在`a.jar`中添加说明内容，保证在编译的时候能定位到`b.jar`，这种自带"依赖关系"的class容器就是模块。

从Java 9开始，原有的Java标准库已经由`rt.jar`拆分成几十个模块,在`$JAVA_HOME/jmods`目录下可以看到很以`.jmod`扩展标识的文件

```tree
Home/jmods
├── java.base.jmod
├── java.compiler.jmod
├── java.datatransfer.jmod
├── java.desktop.jmod
├── ...
```

### demo

#####  1. 新建目录如下
```tree
oop-module-1
├── bin # 编译后存放class文件
└── src # 源码目录
    ├── icu
    │   └── zheteng
    │       └── main
    │           └── Main.java
    └── module-info.java # 模块描述文件
```

##### 2. code

module-info.java

```java
module oop.module {
    requires java.base; // 可不写，任何模块都会自动引入java.base
    requires java.xml; // 引入java.xml模块
}
```

`module`是关键字，后面的`oop.module`是模块名称，命名规范与包一致。

`{}`内描述引用其他模块，格式：`requires xxx;`。案例中除了基础模块，还引入了`java.xml`

当声明了引用关系后，才能引入模块内的类，如`Main.java`代码如下：

```java
package icu.zheteng.main;

import javax.xml.XMLConstants;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(XMLConstants.XML_NS_PREFIX);
    }
}
```
如果把`module-info.java`的`java.xml`去除，那`System.out.println(XMLConstants.XML_NS_PREFIX);`编译不能通过

##### 3. 编译和执行

1. 进入`oop-module-1`，编译：`javac -d bin src/module-info.java src/icu/zheteng/main/*.java`
2. 打包成jar：`jar --create --file hello.jar --main-class icu.zheteng.main.Main -C bin .`
3. 打包成模块：
```
jmod create --class-path hello.jar hello.jmod
# 如果jmod命令不存在，直接运行JDK17下的jmod命令
```
4. 运行模块: `java --module-path hello.jar --module oop.module`
5. 打包成JRE：
```
jlink --module-path hello.jmod --add-modules java.base,java.xml,oop.module --output jre/
# 如果jlink命令不存在，直接运行JDK17下的jlink命令
```
6. 打包完成之后，当前目录下会有`jre`这个目录，后续运行可以直接将这个包分发给用户执行，不用安装JDK也可以执行
```
$ jre/bin/java --module oop.module

Hello world!
xml
 ```

### 访问权限

Java的访问权限分别为public、protected、private和默认的包访问权限，但是在JDK 9引入模块以后，
class访问权限只能在一个模块内有效，模块和模块之间必须要被引用模块明确申明导出的包，才可以被其他模块引用。

例如：`oop.module`模块引入了`java.xml`模块中的`javax.xml.XMLConstants`类，这是因为在`java.xml`模块的`module-info.java`申明了若干导出。
```
module java.xml {
    exports java.xml;
    exports javax.xml.catalog;
    exports javax.xml.datatype;
    ...
}
```
只有申明后的包，才可以被其他模块访问。

如果想我们的`oop-module`中的类被其他模块引用，也需要要在`module-info.java`中申明。

### 个人思考

1. 模块这一特性在服务端开发中不会经常用到，但是在客户端开发过程中应用应当更明显，保证功能的同时能够精简可执行包的大小
2. 模块这一特性对JRE的伸缩有很大的作用，但是对于我们实际开发可能还是`maven`或者`gradle`具有版本控制的包管理更适合

### 参考

- [模块-廖雪峰的官方网站](https://www.liaoxuefeng.com/wiki/1252599548343744/1281795926523938)