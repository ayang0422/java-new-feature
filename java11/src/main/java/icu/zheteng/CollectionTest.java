package icu.zheteng;

import java.util.Arrays;
import java.util.List;

/**
 * @author yangpeng
 * @date 2023年04月18日
 */

public class CollectionTest {

    public static void main(String[] args) {
        List<Integer> sampleList = Arrays.asList(1111, 2222);
        Integer[] array = sampleList.toArray(Integer[]::new);
        System.out.println(array.length);
    }
}
