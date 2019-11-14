package 并发;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 许国亮
 * @Date: 2019/11/10 9:39 AM
 * @Version 1.0
 */
public class TryLockAccount {
    private int balance;
    private final Lock lock = new ReentrantLock();

    void transfer(TryLockAccount target, int amt) throws InterruptedException {
        while (true) {
            //破坏不可抢占条件,如果没有抢占成功
            if (this.lock.tryLock()) {
                try {
                    if (target.lock.tryLock()) {
                        try {
                            this.balance -= amt;
                            target.balance += amt;
                            //转账成功之后跳出循环
                            break;
                        } finally {
                            target.lock.unlock();
                        }
                    }
                } finally {
                    this.lock.unlock();
                }
            }
            //增减一个随机事件避免活锁
            Thread.sleep((long) 0.1);
        }
    }
}
