package java数据结构.JVMDemo;


import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        List<Data> datas = new ArrayList<Data>();
        for (int i = 0; i < 10000; i++) {
            datas.add(new Data());
        }
        Thread.sleep(1 * 60 * 60 * 1000);
    }
    static class Data {
    }
}
