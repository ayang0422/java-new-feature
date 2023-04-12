package icu.zheteng;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author yancy
 * @date 2023年04月11日
 */

public class OptionalTest {

    /**
     * ifPresentOrElse
     * 如果存在就执行第一个操作，如果不存在就执行第二个操作
     */
    public static void ifPresentOrElseTest() {
        Optional<String> optional = Optional.of("Hello");
        optional.ifPresentOrElse(System.out::println, () -> System.out.println("Value not present"));// --> Value not present
    }

    /**
     * or
     * Java 9中的Optional类增加了一个新的or方法，该方法允许我们在Optional对象为空的情况下返回一个默认值
     */
    public static void orTest() {
        Optional<String> optional = Optional.empty();
        String value = optional.or(() -> Optional.of("Default")).get();
        System.out.println(value);// --> Default
    }

    /**
     * stream
     * Java 9中的Optional类增加了一个新的stream方法，该方法允许我们将Optional对象转换成一个Stream对象。
     * 如果Optional对象中存在值，则转换成包含这个值的Stream对象，否则返回一个空的Stream对象。
     */
    public static void streamTest() {
        Optional<String> optional = Optional.of("Hello");
        Stream<String> stream = optional.stream();
        stream.forEach(System.out::println);

    }

    public static void main(String[] args) {
        ifPresentOrElseTest();
        orTest();
        streamTest();
    }
}
