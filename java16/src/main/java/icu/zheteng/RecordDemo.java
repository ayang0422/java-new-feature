package icu.zheteng;

/**
 * @author yancy
 */

public class RecordDemo {

    public static void main(String[] args) {
        User user = new User("zhangsan", 18);
        System.out.println(user.age);
        System.out.println(user.name);
        System.out.println(user.address);
    }

    public record User(String name, int age) {
        public static String address;
    }
}
