package 并发;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock支持三种模式，分别是写锁、悲观读锁和乐观锁
 * StampedLock里的写锁和悲观锁加锁成功之后，都会返回一个stamp
 * 然后解锁的时候，需要传入这个stamp
 */
public class StampLockExample {
    public static void main(String[] args) {

        final StampedLock s1 = new StampedLock();
        //获取 释放悲观锁示意代码
        long stamp = s1.readLock();
        try {
            //省略业务代码

        } finally {
            s1.unlock(stamp);

        }

    }


}
