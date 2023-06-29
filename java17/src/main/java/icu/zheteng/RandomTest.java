package icu.zheteng;

import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

/**
 * @author yancy
 */

public class RandomTest {

    static void testRandomGenerator (RandomGenerator randomGenerator){
        IntStream ints = randomGenerator.ints(50,0,10);
        int[] randoms = ints.toArray();
        for (int i:randoms) {
            System.out.println(i);
        }
        System.out.println("random count = "+randoms.length);
    }
    public static void main(String[] args) {
        testRandomGenerator(new Random());
        testRandomGenerator(new SplittableRandom());
        testRandomGenerator(ThreadLocalRandom.current());
    }
}
