package 并发.SafeContainer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: 许国亮
 * @Date: 2019/11/12 4:42 PM
 * @Version 1.0
 */
public class ListDemo<T> {
    public static void main(String[] args) {
        /**
         * list类型
         1、CopyOnWriteArrayList 仅适用于写操作非常少的场景，而且能够容忍读写的短暂不一致。例如上 面的例子中，
         写入的新元素并不能立刻被遍历到。
         2、CopyOnWriteArrayList 迭代器是只读的，不支持增删改。因为迭代器遍历的仅仅是一个快照，而对快照进行增删改是没 有意义的。*
         *CopyWriteArrayList线程安全
         * ArrayList 线程不安全
         */
        List<Object> list = new CopyOnWriteArrayList<>();
        /**
         * Map类型
         * ConcurrentHashMap的key是无序的，
         * ConcurrentSkipListMap的key是有序的，ConcurrentSkipListMap 里面的 SkipList 本身就是一种数据结构，中文一般都翻译为“跳表”。 跳表插入、删除、查询操作平均的时间复杂度是 O(log n)，理论上和并发线程数没有关系，所以 在并发度非常高的情况下，
         * 若你对 ConcurrentHashMap 的性能还不满意，可以尝试一下 ConcurrentSkipListMap。
         */
        /**
         * Set类型
         * 也实现了CopyOnWriteArraySet
         * ConcurrentSkipListSet
         * */
        /**
         * Queue类型
         * 1、单端阻塞队列：
         *    (1)ArrayBlockingQueue 队列是数组
         *    (2)LinkedBlockingQueue 链表
         *    (3)SynchronousQueue 不持有队列 生产者线程的入队操作必须等待消费者线程的出队操作
         *    (4)linkedTransferQueue 融合了LinkedBlockingQueue和SynchronousQueue的工鞥呢，性能比LinkedBlockingQueue更好
         *    (5)PriorityBlockingQueue 支持按照优先级出队
         *    (6)DelayQueue 支持延时队列
         *
         *2、双端阻塞队列 linkedBlockingDeque
         *3、单端给阻塞队列 ConcurrentLinkedQueue
         *4、双端非阻塞队列：ConcurrentLinkedDeque
         *
         * */


    }


}
