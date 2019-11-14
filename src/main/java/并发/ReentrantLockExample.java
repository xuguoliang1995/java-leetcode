package 并发;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLockExample {
    //可重入锁：线程可以重复获取的同一把锁
    // 传入参数boolean = true,则为公平锁，锁都对应了一个等待队列
    //如果一个线程没有获得锁，就会进入等待队列，当有线程释放锁的时候，
    //就需要从等待队列中唤醒一个等待的线程，如果是公平锁，唤醒的策略是谁等待的时间长，
    //就唤醒谁，如果不是公平锁，则不提供这个公平保证，有可能等待时间短的
    //线程反而先被唤醒。
    private final Lock rt1 = new ReentrantLock();
    int value;

    public int get() {
        rt1.lock();
        try {
            return value;
        } finally {
            rt1.unlock();
        }
    }

    public void addOne() {
        rt1.lock();
        try {
            value = 1 + get();

        } finally {
            rt1.unlock();
        }
    }
}
