package icu.zheteng;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author yancy
 * @date 2023年04月11日
 */

public class StreamAPITest {


    /**
     * 无限流生成
     */
    public static void unlimitedStreamTest() {
        Stream.generate(() -> new Random().nextInt())
                .limit(10)
                .forEach(System.out::println);
        System.out.println("----------");
        // 生成斐波拉契数列的方法
        Stream.iterate(new int[]{0, 1}, i -> i[0] < 1000, i -> new int[]{i[1], i[0] + i[1]})
                .map(i -> i[0])
                .forEach(System.out::println);
    }

    /**
     * Stream.ofNullable 创建空的流和只包含一个元素的流
     */
    public static void ofNullableTest(){
        Stream<String> stream1 = Stream.ofNullable(null); // 创建一个空 Stream
        Stream<String> stream2 = Stream.ofNullable("hello"); // 创建一个包含一个元素的 Stream
        stream1.forEach(System.out::println); // 没有输出
        System.out.println("----------");
        stream2.forEach(System.out::println);
    }

    /**
     * takeWhile()
     * takeWhile() 方法是一个新的 Stream API，它在遇到不满足指定条件的元素时停止 Stream 的操作
     */
    public static void takeWhileTest(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = list.stream().takeWhile(i -> i < 5);
        stream.forEach(System.out::println); // 输出：1 2 3 4

    }

    /**
     * dropWhile()
     * dropWhile() 方法是另一个新的 Stream API，与 takeWhile() 方法相反，它会删除满足指定条件的元素，直到遇到不满足该条件的元素为止。
     */
    public static void dropWhileTest(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = list.stream().dropWhile(i -> i < 5);
        stream.forEach(System.out::println); // 输出：5 6 7 8 9 10
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        unlimitedStreamTest();
        System.out.println("###");
        ofNullableTest();
        System.out.println("###");
        takeWhileTest();
        System.out.println("###");
        dropWhileTest();
        System.out.println("###");
    }

}
