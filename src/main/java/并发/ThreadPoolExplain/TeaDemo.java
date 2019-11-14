package 并发.ThreadPoolExplain;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 许国亮
 * <p>
 * 使用Future特性来实现烧水泡茶,创建两个FutureTask
 * ft1表示洗水壶、烧开水，泡茶
 * ft2表示洗茶壶、洗茶杯、拿茶叶
 * 这里需要注意的是ft1 这个任务在执行泡茶任务前，需要等待ft2把茶叶拿来，
 * 所以ft1内部需要引用ft2，并在执行泡茶之前，调用 ft2的get()方法实现等待。
 */
public class TeaDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建任务T2的FutureTask
        FutureTask<String> ft2 = new FutureTask<>(new T2Task());
        //创建任务T1的FutureTask
        FutureTask<String> ft1 = new FutureTask<>(new T1Task(ft2));
        Thread T1 = new Thread(ft1);
        T1.start();
        Thread T2 = new Thread(ft2);
        T2.start();
        //等待线程T1执行结束
        System.out.println(ft1.get());
    }

    // T1Task需要执行的任务:
    // 洗水壶、烧开水、泡茶
    private static class T1Task implements Callable<String> {
        FutureTask<String> ft2;

        //T1任务需要T2任务的FutureTask
        T1Task(FutureTask<String> ft2) {
            this.ft2 = ft2;
        }

        @Override
        public String call() throws Exception {
            System.out.println("T1:..洗水壶");
            TimeUnit.SECONDS.sleep(1);
            //获取线程2的茶叶
            String tf = ft2.get();
            System.out.println("T1:拿到茶叶：" + tf);
            System.out.println("T1:泡茶");
            return "上茶" + tf;
        }
    }

    // T2Task需要执行的任务:
    // 洗茶壶、洗茶杯、拿茶叶
    private static class T2Task implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("T2...洗茶壶");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("T2....洗茶杯");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("T2...拿茶叶");
            TimeUnit.SECONDS.sleep(1);
            return "龙井";
        }
    }
}
