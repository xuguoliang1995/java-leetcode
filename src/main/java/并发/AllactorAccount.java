package 并发;

/**
 * @Author: 许国亮
 * @Date: 2019/11/7 12:17 PM
 * @Version 1.0
 */
public class AllactorAccount {
    //act应该为单例
    private Allocator actr;
    private int balance;
    // 一次性申请转出账户和转入账户，直到成功
    void transfer(AllactorAccount target, int amt){
        while (!actr.apply(this,target)){
                try{
                    synchronized (this){
                        synchronized (target){
                            if (this.balance > amt){
                                this.balance -= amt;
                                target.balance += amt;
                            }
                        }
                    }
                }finally {
                    actr.free(this,target);
                }
        }
    }
}
