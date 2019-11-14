package 并发.SafeContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 将非线程安全的容器包装在对象内部，然后控制好访问路径就可以了
 */
public class SafeArrayList<T> {
    //封装ArrayList
    List<T> c = new ArrayList<>();

    //控制访问路径
    synchronized T get(int index) {
        return c.get(index);
    }

    synchronized void add(int idx, T t) {
        c.add(idx, t);
    }

    //保证原子性
    synchronized boolean addIfNotExist(T t) {
        if (!c.contains(t)) {
            c.add(t);
            return true;
        }
        return false;
    }

    public void getSafeIterator() {
        List list = Collections.synchronizedList(new ArrayList());
        //迭代器迭代的时候也要保证线程安全
        synchronized (list) {
            Iterator i = list.iterator();
            while (i.hasNext()) {
                System.out.println(i.next());
            }
        }
    }
}
