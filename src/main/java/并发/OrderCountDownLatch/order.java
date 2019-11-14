package 并发.OrderCountDownLatch;

/**
 * @Author: 许国亮
 * @Date: 2019/11/12 11:22 AM
 * @Version 1.0
 */
public abstract interface order<O> {
    //查询未对账的订单
    public  O getPOders();

    //查询派送订单
    public O getDOrders();

    //执行队长操作
    public O check(O pos, O dos);

    //将差异保存
    public void save(O diff);
}
