package icu.zheteng;

/**
 * @author yancy
 */

public class SwitchTest {

    public static void main(String[] args) {
        Object o = "123";
        String test = testClassType(o);
        System.out.println(test);

        testNull("123");
        testNull(null);
    }


    private static String testClassType(Object o){
        return switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l    -> String.format("long %d", l);
            case Double d  -> String.format("double %f", d);
            case String s  -> String.format("String %s", s);
            default        -> o.toString();
        };
    }


    private static void testNull(String s){
        switch (s) {
            case null         -> System.out.println("this is null ~~~~");
            case "Foo", "Bar" -> System.out.println("Great");
            default           -> System.out.println("Ok");
        }
    }
}
