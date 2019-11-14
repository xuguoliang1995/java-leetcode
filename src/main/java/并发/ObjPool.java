package 并发;

import scala.Int;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @Author: 许国亮
 * @Date: 2019/11/11 10:25 AM
 * @Version 1.0
 * Semaphore有一个功能是Lock不容易实现的，Semaphore可以允许多个线程访问一个临界区
 * 常用的场景是各种资源池，例如连接池，对象池和线程池等。
 * 限流器的使用
 */
public class ObjPool<T, R> {
    //不允许大于N个线程同时进入临界区，当线程拿到资源之后，未被释放之前
    //是不允许别的线程占有的。
    final List<T> pool;
    //用信号量实现限流器
    final Semaphore sem;

    //构造函数
    ObjPool(int size, T t) {
        //放在了线程安全的容器里面。
        pool = new Vector<T>();
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    //利用对象池的对象调用,func
    R exec(Function<T, R> func) {
        T t = null;
        try {
            t = pool.remove(0);
            return func.apply(t);

        } finally {
            pool.add(t);
            sem.release();
        }
    }

    public static void main(String[] args) {
        //创建对象池
        ObjPool<Integer, String> pool = new ObjPool<Integer, String>(10, 2);
        //通过线程池获取t,之后执行
        pool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });

    }

}
