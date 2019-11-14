package 并发;


import java.util.concurrent.atomic.AtomicLong;

public class SafeWM {
    //原子类时线程安全的
    private final AtomicLong upper = new AtomicLong(0);
    private final AtomicLong lower = new AtomicLong(0);
    //设置库存伤上限
    void setUpper(long v) {
        //存在竞态条件
        if (v < lower.get()) {
            throw new IllegalArgumentException();
        }
        upper.set(v);
    }
    void setLower(long v) {
        if (v > upper.get()) {
            throw new IllegalArgumentException();
        }
        lower.set(v);
    }
}
