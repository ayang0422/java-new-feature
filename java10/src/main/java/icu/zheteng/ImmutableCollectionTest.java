package icu.zheteng;

import java.util.ArrayList;
import java.util.List;

/**
 * 不可变集合
 *
 * @author yancy
 * @date 2023年04月12日
 */

public class ImmutableCollectionTest {

    /**
     * copyOf创造的是一个不可变集合，不能对其增加、删除和修改
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        List<Integer> copyOf = List.copyOf(list);
        list.add(2);
        System.out.println(copyOf);
        System.out.println(list);
    }
}
