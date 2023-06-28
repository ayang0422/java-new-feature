package icu.zheteng;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * @author yancy
 */

public class HiddenClassTest {


    public static void main(String[] args) throws Throwable {

        String filePath = "/Users/yangpeng/IdeaProjects/mine/java-new-feature/java-new-feature/java15/src/main/java/icu/zheteng/JEP371HiddenClasses.class";
        byte[] b = Files.readAllBytes(Paths.get(filePath));
        String s = Base64.getEncoder().encodeToString(b);
        System.out.println(s);
        System.out.println("#########");

        // 1. 加载encode之后的隐藏类
        String CLASS_INFO = s;
        byte[] classInBytes = Base64.getDecoder().decode(CLASS_INFO);

        Class<?> proxy = MethodHandles.lookup()
                .defineHiddenClass(classInBytes, true, MethodHandles.Lookup.ClassOption.NESTMATE)
                .lookupClass();

        // 输出类名
        System.out.println(proxy.getName());
        // 输出类有哪些函数
        for(Method method : proxy.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
        // 2. 调用hello函数
        MethodHandle mh = MethodHandles.lookup().findStatic(proxy, "hello", MethodType.methodType(String.class));
        String result = (String) mh.invokeExact();
        System.out.println(result);
    }
}
