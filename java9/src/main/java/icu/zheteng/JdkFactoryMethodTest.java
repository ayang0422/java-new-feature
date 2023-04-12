package icu.zheteng;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yancy
 * @date 2023年04月12日
 */

public class JdkFactoryMethodTest {

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        System.out.println(integers);
        System.out.println("++++++");
        Set<String> set = Set.of("apple", "banana", "orange");
        System.out.println(set);
        System.out.println("++++++");
        Map<String, Integer> map = Map.of("apple", 1, "banana", 2, "orange", 3);
        System.out.println(map);
    }
}
