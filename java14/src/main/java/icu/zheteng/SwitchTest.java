package icu.zheteng;

import java.util.Scanner;

/**
 * @author yancy
 */

public class SwitchTest {

    public static void main(String[] args) {
        // testSwitch1()
        System.out.println(testSwitch2(2));
    }

    public static void testSwitch1() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int a = scan.nextInt();
            var res = switch (a) {
                case 0 -> a + 2;
                case 1 -> a + 1;
                default -> a;
            };
            System.out.println(res);
        }
        scan.close();
    }

    /**
     * test how to use yield in switch
     *
     * @param i
     * @return
     */
    public static String testSwitch2(int i) {
        return switch (i) {
            case 0:
                yield "aa";
            case 1:
                yield "bb";
            case 2:
                yield "cc";
            default:
                yield "unknown";
        };
    }
}
