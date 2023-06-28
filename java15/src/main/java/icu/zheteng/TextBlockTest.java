package icu.zheteng;

/**
 * @author yancy
 */

public class TextBlockTest {

    public static void main(String[] args) {
        String s = """
                122
                1221
                """;
        System.out.println(s);
        testInJava13();
    }


    /**
     *
     */
    public static void testInJava13() {
        String text = """
              Lorem ipsum dolor sit amet, consectetur adipiscing 
              elit, sed do eiusmod tempor incididunt ut labore 
              et dolore magna aliqua.
              """;
        System.out.println(text);

        String text1 = """
              Lorem ipsum dolor sit amet, consectetur adipiscing \
              elit, sed do eiusmod tempor incididunt ut labore \
              et dolore magna aliqua.
              """;
        System.out.println(text1);
    }
}
