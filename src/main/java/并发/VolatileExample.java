package 并发;

/**
 * @Author: 许国亮
 * @Date: 2019/11/6 11:40 AM
 * @Version 1.0
 */
public class VolatileExample {
    int x = 0;
    volatile boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v == true) {
            /**
             * 这里x会是多少呢？
             * ，变量 x 可能被 CPU 缓存而导致可见性问题。这个问题在 1.5 版本已经被圆满解决了。Java 内存 模型在 1.5 版本
             * 对 volatile 语义进行了增强。怎么增强的呢?答案是一项 Happens- Before 规则。
             * */
        }
    }

    public static void main(String[] args) {

    }
}
