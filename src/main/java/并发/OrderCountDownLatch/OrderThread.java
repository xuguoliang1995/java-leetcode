package 并发.OrderCountDownLatch;

/**
 * 第一种方法
 * 查询未对账订单 getPOrders() 和查询派送单 getDOrders()可以并行处理
 * 等上面两个执行完之后主线程执行对账和入库操作。
 */
public class OrderThread<O> implements order {
    Object pos;
    Object dos;
    //但是每次循环
    private void RunCheck() throws InterruptedException {
        //当查到未对账的账单的时候每次都会创建两个线程，损耗资源
        Boolean isHaveOrder = true;

        while (isHaveOrder) {

            Thread T1 = new Thread(() -> {
                Object pos = getPOders();
            });
            Thread T2 = new Thread(() -> {
                Object dos = getDOrders();
            });
            T1.start();
            T2.start();
            //等待T1和T2执行完毕
            T1.join();
            T2.join();
            //执行队长操作
            Object diff = check(pos, dos);
            //差异写入数据库
            save(diff);
            break;

        }
    }

    @Override
    public Object getPOders() {
        return new Object();
    }

    @Override
    public Object getDOrders() {
        return new Object();
    }

    @Override
    public Object check(Object pos, Object dos) {
        return new Object();
    }

    @Override
    public void save(Object diff) {

    }
}
