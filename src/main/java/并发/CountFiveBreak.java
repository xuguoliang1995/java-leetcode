package 并发;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 许国亮
 * @Date: 2019/11/9 8:04 PM
 * @Version 1.0
 * 两个线程，线程1给里面添加元素，添加10次，线程2计数，到5之后结束两个线程
 */
public class CountFiveBreak {
    List<Object> list = new ArrayList<>();

    private void addList(Object o) {
        list.add(o);
    }

    private int getSize() {
        return list.size();
    }


    public static void main(String[] args) {
        CountFiveBreak c = new CountFiveBreak();
        final Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("线程T2启动");
                if (c.getSize() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("结束线程T2");
                lock.notify();
            }

        }, "t2").start();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("线程T1启动");
                for (int i = 0; i < 10; i++) {
                    c.addList(new Object());
                    System.out.println("add" + i);
                    if (c.getSize() == 5) {
                        //这里不会释放线程
                        lock.notify();
                        try {
                            //释放T1拥有的锁
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                }
            }
        }, "t1").start();
    }


}
