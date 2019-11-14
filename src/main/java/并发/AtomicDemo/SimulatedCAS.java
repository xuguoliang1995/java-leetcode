package 并发.AtomicDemo;

/**
 * @Author: 许国亮
 * @Date: 2019/11/12 5:41 PM
 * @Version 1.0
 */
public class SimulatedCAS {
    /**
     * 无锁方案实现的原理：硬件的支持，CPU为了解决并发问题，
     * 提供了CAS指令。CAS包含了三个参数：共享变量的内存地址A，用于比较的值B和共享变量新值C
     * 只有当内存中地址 A 处的值等于 B 时，才能将内存中地址 A 处的值更新为新值 C。
     * 作为一条 CPU 指令，CAS 指令本身是能够保证原子性的。
     * <p>
     */
    int Acount;

    synchronized int cas(int expect, int newValue) {
        //读取当前的值
        int curValue = Acount;
        //比较目前的count 是否和 == 期待值
        if (expect == Acount) {
            //如果是，则更新count的值
            Acount = newValue;
        }
        //返回写入之前的值
        return curValue;
    }

    /**
     * "CAS + 自旋" 解决并发 自旋就是循环尝试
     * 1、首先计算newValue = count + 1
     * 2、如果cas(count, newValue)返回的值不等于count，则意味count的值被其他线程修改过
     * 3、被其他线程修改之后可以重新读count最新的值来计算newValue并尝试再次更新
     */
    volatile int count;

    //实现count + 1
    /**
    addOne(){
        do {
            int newValue = count + 1;     1
        } while (count != cas1(except, newValue));    2
    }
     优点：CAS这种无锁方案，完全没有加锁，解锁操作，即便两个线程
     完全同时执行addOne()方法，也不会有线程阻塞
     缺点：会遇到ABA问题
     1、如果cas返回的值不等于count,意味着线程在执行完1处之后，
     执行在代码2之前，
     2、是不是认为count一定被其他线程更新过
      显然不是的，有可能被其他两个线程分别执行了+1和-1操作，这时候
     值变成了原来的值。
     数值型的可能不会在乎原子性额操作
     所以CAS方案的时候，一定要先check一下。
     */




}
