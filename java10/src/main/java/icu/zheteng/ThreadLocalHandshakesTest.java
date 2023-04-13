package icu.zheteng;

/**
 * @author yancy
 * @date 2023年04月12日
 */

public class ThreadLocalHandshakesTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("Thread 1 is running...");
                Thread.currentThread().suspend(); // 暂停线程
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("Thread 2 is running...");
                Thread.currentThread().suspend(); // 暂停线程
            }
        });
        t2.start();

        while (true) {
            Thread.sleep(1000); // 主线程休眠1秒钟
            t1.resume(); // 恢复t1线程
            Thread.sleep(1000); // 主线程休眠1秒钟
            t1.suspend(); // 暂停t1线程
            Thread.sleep(1000); // 主线程休眠1秒钟
            t2.resume(); // 恢复t2线程
            Thread.sleep(1000); // 主线程休眠1秒钟
            t2.suspend(); // 暂停t2线程
        }
    }
}
