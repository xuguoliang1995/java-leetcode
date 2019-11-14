package 并发;

/**
 * 编译器优化带来的有序性问题
 */
public class Singleton {
    volatile static Singleton instance;

    static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }



}
