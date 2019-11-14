package 并发;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 许国亮
 * @Date: 2019/11/7 8:45 PM
 * @Version 1.0
 */
public class BlockedQueue<T> {
    final Lock lock = new ReentrantLock();
    //条件变量：队列不满
    final Condition notFull = lock.newCondition();
    //条件变量
    final Condition notEmpty = lock.newCondition();
    /**
    //入队
    void enq(T x){
        lock.lock();
        try {
            //队列已满
            while (队列满){
                //等待队列不满
                notFull.await();
                //入队操作 省略
                //入队后，通知可出队
                notEmpty.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    void deq(){
        lock.lock();
        try {
            while ()队列空{
                notEmpty.await();
                //出队操作
                //出队后，通知可入队
                notFull.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
   */
}
