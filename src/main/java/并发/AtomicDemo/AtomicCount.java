package 并发.AtomicDemo;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 对于简单的原子性问题，使用无锁方案，
 * java SDK并发包中将这种无锁方案封装提炼之后，实现了一系列的原子类
 */
public class AtomicCount {
    AtomicLong count = new AtomicLong(0);
    void add10k() {
        int idx = 0;
        while (idx++ < 10000) {
            count.getAndIncrement();
        }
    }

    public static void main(String[] args) {


    }

}
