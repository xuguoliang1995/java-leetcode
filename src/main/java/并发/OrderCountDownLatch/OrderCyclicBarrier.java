package 并发.OrderCountDownLatch;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * getPOrders() 和 getDOrders() 这两个查询操作并行了，但这两个查询操作和对账操 作 check()、save() 之间还是串行的
 * 很显然，这两个查询操作和对账操作也是可以并行的，也就 是说，在执行对账操作的时候，可以同时去执行下一轮的查询操作，
 * 如何实现？
 * 1、套用生产者-消费者模型，生产者是getPOders,getDOders。消费者是check save
 * 2、设置两个队列，单查询操作将订单查询结果插入订单队列，派送单查询操作将派送单插入派送单队
 * 列，这两个队列的元素之间是有一一对应的关系的。两个队列的好处是，对账操作可以每次从订
 * 单队列出一个元素，从派送单队列出一个元素，然后对这两个元素执行对账操作，这样数据一定
 * 不会乱掉。
 * 3、如何使用双队列实现并行？
 * （1）一个线程 T1 执行订单的查 询工作，一个线程 T2 执行派送单的查询工作
 * (2) 当线程 T1 和 T2 都各自生产完 1 条数据的时候， 通知线程 T3 执行对账操作。
 * 4、技术实现的两个难点？
 * （1）一个是线程 T1 和 T2 要做到步调一致？
 * 计数器设置为2，线程T1和线程T2生产完一条数据都将计数器减1，如果计数器大于 0 则线程 T1 或者 T2 等待。
 * （2）另一个是要能够通知到线程 T3。
 * 当计数器为0的时候，通知线程3，并唤醒等待的线程T1和T2，将计数器重置为2
 * 5、并发包里提供了相关的工具类：CyclicBarrier
 * (1)首先创建一个初始值为2的CyclicBarrier，创建 CyclicBarrier 的时候，我们还传入了一个回调函数，当计数器减到 0 的时
 * 候，会调用这个回调函数。
 * （2）现=线程T1负责查询订单，当查出一条时，调用Barrier.await()来将计数器减1
 * 同时等待计数器变成0；
 * （3）当T1和T2都调用 barrier.await() 的时候，计数器会减到0，此时T1和T2就可以执行下一条语句了，同时 会调用 barrier 的回调函数来执行对账操作。
 * (4)CycliBarrier计数器有自动重置的功能，减到0的时候，会自动重置的初始值
 */
public class OrderCyclicBarrier<P, D> implements order {
    //订单队列
    Vector<P> pos;
    Vector<D> dos;
    //为线程3准备的线程池
    Executor executor = Executors.newFixedThreadPool(1);

    //但是每次循环
    final CyclicBarrier barrier = new CyclicBarrier(2, () -> {
        executor.execute(() -> check());
    });


    void check() {
        P p = pos.remove(0);
        D d = dos.remove(0);
        //执行对账操作
        Object diff = check(pos, dos);
        save(diff);
    }

    void chechAll() {
        //循环查询订单库
        Thread T1 = new Thread(() -> {
            //isHaveOrder是否有未对账的账单标记
            Boolean isHaveOrder = true;
            while (isHaveOrder) {
                //查询订单库
                pos.add((P) getDOrders());
                //等待
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        });
        T1.start();
        //循环查询运单库
        Thread T2 = new Thread(() -> {
            //isHaveOrder是否有未对账的账单标记
            Boolean isHaveOrder = true;
            while (isHaveOrder) {
                //查询运单库
                dos.add((D) getDOrders());
                //等待
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        T2.start();
    }

    @Override
    public Object getPOders() {
        return new Object();
    }

    @Override
    public Object getDOrders() {
        return new Object();
    }
    @Override
    public Object check(Object pos, Object dos) {
        return new Object();
    }

    @Override
    public void save(Object diff) {

    }
}
