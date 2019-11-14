package 并发.MyThreadPool;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyFixedSizeThreadPool {
    //仓库
    private BlockingQueue<Runnable> taskQueue;
    //放线程的集合
    private List<Worker> workers;

    //线程池是否在工作状态
    private volatile boolean working = true;

    public MyFixedSizeThreadPool(int poolSize, int taskQueueSize) {
        if (poolSize <= 0 || taskQueueSize <= 0) {
            throw new IllegalArgumentException();
        }
        //初始化任务队列
        this.taskQueue = new LinkedBlockingQueue<>(taskQueueSize);
        //创建放线程的集合
        this.workers = new ArrayList<>();
        //初始化工作线程
        for (int i = 0; i < poolSize; i++) {
            Worker w = new Worker(this);
            this.workers.add(w);
            w.start();
        }
    }

    public void shutdown() {
        if (this.working) {
            this.working = false;
            //如果工作线程处于阻塞状态，唤醒
            for (Thread t : this.workers) {
                //此时工作线程列表为空，当前的线程处于阻塞或者等待状态，
                if (t.getState().equals(Thread.State.BLOCKED) || t.getState().equals(Thread.State.WAITING)) {
                    //中断阻塞状态
                    t.interrupt();
                }
            }
        }
    }

    public boolean submit(Runnable task) {
        //队列满了之后返回false，不满返回true
        return this.taskQueue.offer(task);
    }

    //工作线程
    private class Worker extends Thread {
        private MyFixedSizeThreadPool pool;

        public Worker(MyFixedSizeThreadPool pool) {
            super();
            this.pool = pool;
        }

        public void run() {
            //方便看效果加个计数
            int taskCount = 0;
            //从仓库去任务执行  如果working被置为了false，任务队列taskQueue里面还有任务还是会继续执行
            while (this.pool.working || this.pool.taskQueue.size() > 0) {
                Runnable task = null;
                try {
                    if (this.pool.working) {
                        //移除并且阻塞队列
                        task = this.pool.taskQueue.take();
                    } else {
                        //如果有就返回,如果没有返回null
                        task = this.pool.taskQueue.poll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (task != null) {
                    try {
                        task.run();
                        System.out.println(Thread.currentThread().getName() + "执行完成");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {
        MyFixedSizeThreadPool pool = new MyFixedSizeThreadPool(3, 5);
        for (int i = 0; i < 5; i++) {
            pool.submit(() -> {
                System.out.println("任务开始.....");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
    }
}
