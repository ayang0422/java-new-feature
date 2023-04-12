package icu.zheteng;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * @author yancy
 * @date 2023年04月11日
 */

public class PrivateInterfaceMethodTest {

    interface MyPrivateInterface {

        /**
         * 偶数相加
         *
         * @param nums
         * @return
         */
        default int addEvenNumbers(int... nums) {
            return doAdd(n -> n % 2 == 0, nums);
        }

        /**
         * 奇数相加
         *
         * @param nums
         * @return
         */
        default int addOddNumbers(int... nums) {
            return doAdd(n -> n % 2 != 0, nums);
        }

        /**
         * 接口私有方法
         */
        private int doAdd(IntPredicate predicate, int... nums) {
            return IntStream.of(nums)   //java8 Stream流
                    .filter(predicate)   //java8 predicate及过滤器
                    .sum();  //sum求和
        }

        /**
         * 普通接口
         */
        void doSomething();
    }

    private static class MyPrivateClass implements MyPrivateInterface {
        @Override
        public void doSomething() {
            System.out.println("done~~~");
            // doPrivate(); 不能在实现类中使用
            System.out.println(addEvenNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9));
            System.out.println(addOddNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9));
        }

        public static void main(String[] args) {
            MyPrivateInterface instance = new MyPrivateClass();
            instance.doSomething();
        }
    }
}
