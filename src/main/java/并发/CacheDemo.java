package 并发;


import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: 许国亮
 * @Date: 2019/11/11 4:55 PM
 * @Version 1.0
 * 使用读写锁实现一个Cache
 * 读写锁的三个特点：
 * 1、允许多个线程同时读取共享变量
 * 2、只允许1个线程写共享变量
 * 3、如果一个写线程正在执行写操作，此时禁止线程读共享变量的。
 */
public class CacheDemo<K, V> {
    //不是写成安全的
    final Map<K, V> m = new HashMap<>();

    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    //读锁
    final Lock r = rwl.readLock();
    //写锁
    final Lock w = rwl.writeLock();

    //读缓存
    V get(K key) {
        r.lock();
        try {
            return m.get(key);
        } finally {
            r.unlock();
        }
    }

    //写缓存
    V put(K key, V v) {
        w.lock();
        try {

            return m.put(key, v);
        } finally {
            w.unlock();
        }
    }
}
