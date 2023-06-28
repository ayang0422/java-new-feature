package icu.zheteng;

/**
 * @author yancy
 */

public class SealedTest {

    public static void main(String[] args) {

    }

    // sealed 修饰Person，只能被 Teacher Worker 和 Student继承
    public sealed class Person permits Teacher, Worker, Student{}

    // 子类可以被修饰为 final
    final class Teacher extends Person{}

    // 子类可以被修饰为 non-sealed ,此时Worker就成了普通类，谁都可以继承它
    non-sealed class Worker extends Person{}

    // 继承Worker
    class ItWorker extends Worker{}

    // 子类可以被修饰为 sealed
    sealed class Student extends Person permits MiddleSchoolStudent,GraduateStudent{}

    final class MiddleSchoolStudent extends Student{}

    final class GraduateStudent extends Student{}
}
