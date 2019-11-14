package 并发;

/**
 * @Author: 许国亮
 * @Date: 2019/11/6 11:23 AM
 * @Version 1.0
 * 缓存导致可见性实例
 */

public class Count {
    private static long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 100000) {
            count += 1;
        }
    }

    public static long calc() throws InterruptedException {
        final Count test = new Count();
        Thread th1 = new Thread(() -> {
            test.add10K();
        });
        Thread th2 = new Thread(() -> {
            test.add10K();
        });
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        long count = calc();
        System.out.println(count);
    }
}
