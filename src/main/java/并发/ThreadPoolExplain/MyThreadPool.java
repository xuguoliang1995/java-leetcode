package 并发.ThreadPoolExplain;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 线程池使用的是生产者-消费者模式
 * 线程池的使用方式生产者，线程池本身是消费者
 */
public class MyThreadPool {
    //利用阻塞队列实现生产者-消费者模式
    BlockingQueue<Runnable> workQueue;
    //保存内部工作线程
    List<WorkerThread> threads = new ArrayList<>();

    //构造方法
    MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        //创建工作线程
        for (int i = 0; i < poolSize; i++) {
            WorkerThread work = new WorkerThread();
            work.start();
            threads.add(work);
        }
    }

    //工作线程负责消费任务，并执行任务
    class WorkerThread extends Thread {
        public void run() {
            //循环取任务并执行
            while (true) {
                try {
                    //工作队列没有线程的时候会阻塞住。这是阻塞队列决定的
                    Runnable task = workQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //提交任务
    void execute(Runnable command) throws InterruptedException {
        workQueue.put(command);
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2);
        //创建线程池
        MyThreadPool pool = new MyThreadPool(10, workQueue);
        //提交任务
        pool.execute(() -> {
            System.out.println("hello");
        });
    }
}
