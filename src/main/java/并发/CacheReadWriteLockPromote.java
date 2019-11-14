package 并发;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: 许国亮
 * @Date: 2019/11/11 5:39 PM
 * @Version 1.0
 * 读写锁的升级是不允许的
 * 升级：先获取读锁，然后升级为写锁
 */
public class CacheReadWriteLockPromote<K, V> {
    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    final Lock r = rwl.readLock();
    final Lock w = rwl.writeLock();

    V get(K key) {
        V v = null;
        r.lock();
        try {
            v = m.get(key);
            if (v == null) {
                //发生了锁的升级
                w.lock();
                try {
                    v = m.get(key);
                    if (v == null) {
                        //v 是从数据库中取出来的值
                        m.put(key, v);
                    }
                } finally {
                    w.unlock();
                }
            }
        } finally {
            r.unlock();
        }
        return v;
    }
}
