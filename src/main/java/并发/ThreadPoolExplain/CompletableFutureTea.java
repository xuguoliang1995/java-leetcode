package 并发.ThreadPoolExplain;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 使用CompletableFuture异步编程的优势
 * 烧水泡茶分为3个任务：
 * 任务1:负责洗水壶、烧开水
 * 任务2:洗茶壶、洗茶杯、那茶壶
 * 任务3：负责泡茶
 * 任务3要等待任务1和任务2都完成后才开始
 */
public class CompletableFutureTea {
    public static void main(String[] args) {
        //任务1 runAsync没有返回值
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(
                () -> {
                    System.out.println("T1:洗水壶");
                    sleep(1, TimeUnit.SECONDS);

                    System.out.println("T1:烧开水");
                    sleep(15, TimeUnit.SECONDS);
                }
        );
        //任务2 supplyAsync有返回值。
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2:洗茶壶...");
            sleep(1, TimeUnit.SECONDS);
            System.out.println("T2:洗茶杯...");
            sleep(2, TimeUnit.SECONDS);
            System.out.println("T2:拿茶叶...");
            sleep(1, TimeUnit.SECONDS);
            return "⻰井";

        });
        //任务3
        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("T1：拿到茶叶：" + tf);
            System.out.println("T1:泡茶");
            return "上茶" + tf;
        });
        System.out.println(f3.join());
    }

    static void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
