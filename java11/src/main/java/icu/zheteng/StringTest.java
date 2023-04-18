package icu.zheteng;

import java.util.stream.Collectors;

/**
 * @author yancy
 * @date 2023年04月13日
 */

public class StringTest {


    public static void main(String[] args) {

        // 判断一个字符串是否为空白（即只包含空格、制表符等不可见字符）。
        System.out.println("".isBlank());
        System.out.println("  ".isBlank());
        System.out.println("\n".isBlank());
        System.out.println("\t".isBlank());
        System.out.println("A".isBlank());

        System.out.println("------------------");

        // 将一个字符串分割成多行
        System.out.println("fist line\nsecodn line".lines().collect(Collectors.toList()));

        System.out.println("------------------");

        // 字符串重复n次
        System.out.println("a".repeat(5));


    }
}
