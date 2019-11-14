package 并发;

import java.util.List;

/**
 * @Author: 许国亮
 * @Date: 2019/11/7 3:23 PM
 * @Version 1.0
 */
public class BestAllocator {
    /**
     * 1、互斥锁：Allocator需要单例的，所以我们可以使用this作为互斥锁
     * 2、线程要求的条件：转出账户和转入账户都没有被分配过
     * 3、何时等待：线程要求的条件不满足等待
     * 4、何时通知：当有线程释放账户时就通知
     */
    private List<Object> als;

    //一次申请所有资源
    synchronized void apply(Object from, Object to) {
        while (!als.contains(from) || !als.contains(to)) {
            try {
                //等待队列是互斥锁的等待队列，所以锁是根据symchronized来确定的
                //如果放在synchronized外面，那么JVM会抛出一个异常java.lang.IllegalMonitorStateException。
                /**
                 *wait和sleep的区别
                 * 1、wait会释放所有锁sleep不会
                 * 2、wait只能在同步方法和同步快中使用，而sleep任何地方都能使用
                 * 3、wait无需捕获异常，sleep需要
                 * 4、sleep是Thread的方法，wait是Object的方法
                 *相同点：都会让CPU执行时间，
                 * */
                wait();
            } catch (Exception e) {

            }
        }
        als.add(from);
        als.add(to);
    }

    //归还地址
    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        //notify()会随机的通知等待队列中的一个线程，
        //会通知等待队列中的所有线程。
        //
        notifyAll();
    }

}
