package icu.zheteng;

import java.util.List;

/**
 * var 关键字
 *
 * @author yancy
 * @date 2023年04月12日
 */

public class VarTest {

    public static void main(String[] args) {
        var str = "111";
        System.out.println(str);
        var i = 123;
        System.out.println(i);
        var f = 11.22;
        System.out.println(f);
        System.out.println("-----------------");
        var list = List.of(2,1,0);
        for (var item : list){
            System.out.println(item);
        }
    }
}
