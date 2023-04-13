package icu.zheteng;

import java.util.Optional;

/**
 * @author yancy
 * @date 2023年04月13日
 */

public class OptionalTest {

    public static void main(String[] args) {
        Integer i = Optional.of(8).orElseThrow();
        System.out.println(i);

        Optional<Object> empty = Optional.empty();
        System.out.println(empty.orElseThrow());
    }
}
