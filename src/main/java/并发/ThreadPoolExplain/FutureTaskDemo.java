package 并发.ThreadPoolExplain;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * FutureTask实现了Runnable和Future接口
 * 由于实现了Runnable接口，所以可以将FutureTask对象作为任务提交给ThreadPoolExecutor去执行
 * 也可以直接被Thread执行
 * 又因为实现了Future接口，所以也能用来获得任务的执行结果
 */
public class FutureTaskDemo {
    public static void futureTaskmethod1() throws ExecutionException, InterruptedException {
        //创建FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 1 + 2);
        //创建线程池
        ExecutorService es = Executors.newCachedThreadPool();
        //提交FutureTask
        es.submit(futureTask);
        //获取计算结果
        Integer result = futureTask.get();
        System.out.println(result);
    }

    public static void futureTaskmethod2() throws ExecutionException, InterruptedException {
        //创建FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 1 + 2);
        //创建并启动线程
        Thread T1 = new Thread(futureTask);
        T1.start();
        //获得计算结果
        Integer result = futureTask.get();
        System.out.println(result);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        futureTaskmethod1();
        futureTaskmethod2();
    }
}
