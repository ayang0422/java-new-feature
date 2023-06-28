package icu.zheteng;

/**
 * @author yancy
 */

public class InstanceOfDemo {

    public static void main(String[] args) {
        Person person = new Student();
        if (person instanceof Student student) {
            System.out.println(student.getClass().getName() + "is class of Student");
        }
    }


    static class Person{

    }

    static class Student extends Person{

    }
}
