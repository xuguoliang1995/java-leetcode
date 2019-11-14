package java_know;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
//        ensureCapacityDemo();
//        tirmToSizeDemo();
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.put("hello");
        Iterator itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
//        System.out.println(queue.poll());
    }

    // 将数组中多余的空间释放，节省内存
    private static void tirmToSizeDemo() {
        ArrayList list1 = new ArrayList(10);
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        System.out.println(list1.iterator());
        System.out.println(list1.size());
        list1.add(1);
        list1.trimToSize();
        System.out.println(list1.size());
    }

    // 手动指定容量大小
    private static void ensureCapacityDemo() {
        long starttime = System.currentTimeMillis();
        ArrayList<Object> list1 = new ArrayList<Object>();
        for (int i = 0; i < 1000000; i++) {
            list1.add(new Object());
        }
        System.out.println(System.currentTimeMillis() - starttime);
        long starttime2 = System.currentTimeMillis();
        ArrayList<Object> list2 = new ArrayList<Object>();
        // 直手动指定动态数组大小
        list2.ensureCapacity(1000000);
        for (int i = 0; i < 1000000; i++) {
            list2.add(new Object());
        }
        System.out.println(System.currentTimeMillis() - starttime2);
    }
}
