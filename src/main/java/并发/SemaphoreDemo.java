package 并发;

import java.util.Queue;

/**
 * 信号量模型：一个计数器 一个等待方法 三个方法
 * 计数器和等待队列对外是透明的，只能通过型号量模型提供的三个
 * 方法来访问它分别是init() 设置计数器的初始值
 * down() 计数器的值减1，计数器的值小于0，当前线程阻塞，否则可以继续执行
 * up() 计数器的值加1 此时计数器的小于或者等于0，则唤醒等待队列中的一个线程，
 * 并将其从等待队列中移除
 */
public class SemaphoreDemo {
    //计数器
    int count;
    // 等待队列
    Queue queue;

    // 初始化操作
    SemaphoreDemo(int c) {
        this.count = c;
    }
//  java SDK并发包里，down()和up()对应的则是acquire()和release()
    void down() {
        this.count--;
        if (this.count < 0) {
            //将当前线程插入等待队列
            //阻塞当前线程
        }
    }
    void up() {
        this.count++;
        if (this.count <= 0) {
            // 移除等待队列中的某个线程T
            // 唤醒线程T
        }
    }
}
