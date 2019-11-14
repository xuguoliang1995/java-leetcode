package 并发;

import java.util.concurrent.Semaphore;

/**
 * @Author: 许国亮
 * @Date: 2019/11/11 10:10 AM
 * @Version 1.0
 */
public class SemaphoreAddOne {
    static int count;
    //设置计数器初始化的值
    static final Semaphore s = new Semaphore(1);

    static void addOne() throws InterruptedException {
        //对应信号量里面的Down
        s.acquire();
        try {
            count += 1;
        } finally {
            //对应信号量里面的up.
            s.release();
        }
    }
    public static void main(String[] args) {
        SemaphoreAddOne sem = new SemaphoreAddOne();
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                try {
                    sem.addOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                try {
                    sem.addOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();
    }
}
