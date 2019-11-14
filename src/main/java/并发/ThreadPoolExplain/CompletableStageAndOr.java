package 并发.ThreadPoolExplain;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @Author: 许国亮
 * @Date: 2019/11/13 4:18 PM
 * @Version 1.0
 */
public class CompletableStageAndOr {
    public static void main(String[] args) {
        //同步关系
       CompletableFuture<String> f0 = CompletableFuture.supplyAsync(()->
                "hello World").thenApply(s -> s + "QQ")
                .thenApply(String::toUpperCase);
        System.out.println(f0.join());

       //异常处理
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(()-> 7/0)
                .thenApply(r -> r * 10)
                .exceptionally(e -> 0);
        System.out.println(f1.join());
    }
}
