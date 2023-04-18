package icu.zheteng;

import java.util.function.Consumer;

/**
 * @author yancy
 * @date 2023年04月13日
 */

public class LambdaTest {


    public static void main(String[] args) {

        // Java 8 中 var 不能修饰lamda表达的是入参
        int x = 10;
        Consumer<Integer> consumer1 = y -> System.out.println(x + y);

        // Java 11 中 va r能修饰lamda表达的是入参
        int z = 10;
        Consumer<Integer> consumer2 = (var y) -> System.out.println(z + y);

    }
}
