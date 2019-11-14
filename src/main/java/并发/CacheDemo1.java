package 并发;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: 许国亮
 * @Date: 2019/11/11 5:24 PM
 * @Version 1.0
 * 1、缓存数据量小的时候直接从数据中一次性加载进来
 * 2、数据量大的话按需加载，懒加载
 */
public class CacheDemo1<K, V> {
    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    final Lock r = rwl.readLock();
    final Lock w = rwl.writeLock();

    V get(K key) {
        V v = null;
        r.lock();
        try {
            v = m.get(key);
        } finally {
            r.unlock();
        }
        if (v != null) {
            return v;
        }
        //缓存不存在,查询数据库
        w.lock();
        try {
            //再次验证 防止后面的线程重读读取更新缓存
            v = m.get(key);
            if (v == null) {

            }
        } finally {
            w.unlock();
        }
        return v;
    }
}
