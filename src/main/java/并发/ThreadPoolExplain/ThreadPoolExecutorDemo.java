package 并发.ThreadPoolExplain;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *ThreadPoolExecutor提供了3个submit方法和1个FutureTask工具类来支持获得任务执行结果的需求
 * 1、提交Runnable任务
 * Future<?> submit(Runnable task)
 * 2、提交Callable任务
 * <T> Future<T> submit(Callable<T> task)
 * 3、提交Runnable任务及结果引用
 *<T>Future<T>submit(Runnable task, T result)
 *Future是一个接口，而FutureTask是一个实实在在的 工具类，这个工具类有两个构造函数，
 *FutureTask(Callable<V> callable)
 * FutureTask(Runnable runnable, V result);
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //创建Result 对象r
        Result r = new Result();
        r.setAAA("a");
        //提交任务 这时候
        Future<Result> future = executor.submit(new Task(r), r);
        Result fr = future.get();
        System.out.println(fr == r);
        System.out.println(fr.getAAA() == "b");

    }
    static class Task implements Runnable {
        Result r;
        Task(Result r) {
            this.r = r;
        }
        @Override
        public void run() {
            //可以操作Result，获取到主线程传过来的参数值
            String a = r.getAAA();
            System.out.println(a);
        }
    }
    static private class Result {
        String a;
        void Result() {
        }
        public void setAAA(String a) {
            this.a = a;
        }
        public String getAAA() {
            return a;
        }
    }
}
