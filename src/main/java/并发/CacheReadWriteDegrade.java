package 并发;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 虽然读写锁的升级不行，但是读写锁的降级是可以的
 */
public class CacheReadWriteDegrade {
    Object Data;
    volatile boolean cacheVaild;
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    //读锁
    final Lock r = rwl.readLock();
    //写锁
    final Lock w = rwl.writeLock();

    void processCacheData() {
        //获取读锁
        r.lock();
        if (!cacheVaild) {
            //释放读锁，因为不允许读锁的升级
            r.unlock();
            //获取写锁
            w.lock();
            try {
                //再次检查状态
                if (!cacheVaild) {
                    Object data = "从数据库中读取数据";
                    cacheVaild = true;
                }
                //在释放写锁之前，降级为读锁
                //降级是可以的。
                r.lock();
            } finally {
                w.unlock();
            }
        }
        //此处任然持有读锁
        try {
            Object data = "使用锁";
        } finally {
            r.unlock();
        }
    }
}
