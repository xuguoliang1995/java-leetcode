package 并发;

/**
 * @Author: 许国亮
 * @Date: 2019/11/7 2:41 PM
 * @Version 1.0
 */
public class AccountBreakCycle {
    private int id;
    private int balance;
    void transfer(AccountBreakCycle target, int amt){
        AccountBreakCycle left = this;
        AccountBreakCycle right = target;
        if(this.id > target.id){
            left = target;
            right = this;
        }
        //锁定序号小的账户
        synchronized (left){
            //锁定序号大的账户 测试
            synchronized (right) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
