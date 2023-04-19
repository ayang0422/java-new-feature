package icu.zheteng;

import java.util.Scanner;

/**
 * @author yancy
 */

public class SwitchTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int a = scan.nextInt();
            var res = switch (a){
                case 0 -> a+2;
                case 1 -> a+1;
                default -> a;
            };
            System.out.println(res);
        }
        scan.close();
    }
}
