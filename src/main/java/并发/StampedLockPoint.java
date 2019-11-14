package 并发;


import java.util.concurrent.locks.StampedLock;

/**
 * ReadWriteLock支持多个线程同时读，但是当多个线程同时读的时候，所有写操作都会被阻塞
 * 而StampedLock提供的乐观锁是允许一个线程获取写锁的，也就是说不是所有写操作都被阻塞
 * <p>
 * 如果执行乐观读操作的期间，存在写操作，会把乐观读升级为悲观读 锁。这个做法挺合理的，
 * 否则你就需要在一个循环里反复执行乐观读，直到执行乐观读操作的期 间没有写操作(只有这样才能保证 x 和 y 的正确性和一致性)，
 * 而循环读会浪费大量的 CPU。升级为悲观读锁，代码简练且不易出错，建议你在具体实践时也采用这样的方法。
 */
public class StampedLockPoint {
    private int x, y;
    final StampedLock s1 = new StampedLock();

    //计算到原点的距离
    Double distanceFromOrigin() {
        //乐观锁,没有锁
        long stamp = s1.tryOptimisticRead();
        //读入局部变量
        //读的过程数据可能被修改
        int curX = x, curY = y;
        //判断执行读操作期间
        //是否存在写操作，如果存在则s1.validate返回false
        if (!s1.validate(stamp)) {
            //升级为悲观锁
            stamp = s1.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                //释放悲观读锁
                s1.unlockRead(stamp);
            }
        }
        return Math.sqrt(curX * curX + curY + curY);
    }
}
