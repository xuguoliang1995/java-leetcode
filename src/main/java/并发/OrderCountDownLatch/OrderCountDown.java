package 并发.OrderCountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 前面主线程调用T1和T2的join()方法来等待线程T1和T2的退出
 * 但是线程池虽然可以创建两个线程，但是线程是不会退出的.join(）方法失效了。
 * 如何解决上面说的问题？
 * 最直接的方法就是弄一个计数器，初始值设置成2，当职工往pos = getPorders（）
 * 减一，在主线程里面等待计数器等于0，等待计数器等于0相当于一个条件变量
 * 在java并发暴力提供了类似的功能的工具类:CountDownLatch
 * 在 while 循环里 面，我们首先创建了一个CountDownLatch，计数器的初始值等于2，之后在pos = getPOrders();
 * 和dos = getDOrders(); 两条语句的后面对计数器执行减1操作，这个对计数器减1的操作 是通过调用latch.countDown();
 * 来实现的。在主线程中，我们通过调用latch.await() 来实现对计数器等于 0 的等待。
 */
public class OrderCountDown implements order {
    Object pos;
    Object dos;

    //但是每次循环
    private void RunCheck() throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(2);
        //isHaveOrder是否有未对账的账单标记
        Boolean isHaveOrder = true;
        while (isHaveOrder) {
            //计数器初始化为2
            CountDownLatch latch = new CountDownLatch(2);
            //查询未对账的账单
            executor.execute(() -> {
                pos = getPOders();
                latch.countDown();
            });
            //查询派送单
            executor.execute(() -> {
                dos = getPOders();
                latch.countDown();
            });
            //等待两个查询结果操作结束
            latch.await();
            Object diff = check(pos, dos);
            save(diff);
        }
    }

    @Override
    public Object getPOders() {
        return new Object();
    }

    @Override
    public Object getDOrders() {
        return new Object();
    }

    @Override
    public Object check(Object pos, Object dos) {
        return new Object();
    }

    @Override
    public void save(Object diff) {

    }
}
