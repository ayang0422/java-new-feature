package icu.zheteng;

/**
 * @author yancy
 *
 */

// -XX:+ShowCodeDetailsInExceptionMessages
public class NullDemo {

    public static void main(String[] args) {
        new A().b.c.doC();
    }

    static class A {
        B b = new B();
    }

    static class B {
        C c;
    }

    static class C {
        public void doC() {
            System.out.println("cccccccccc");
        }
    }


}
