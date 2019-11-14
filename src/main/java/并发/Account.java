package 并发;

/**
 * @Author: 许国亮
 * @Date: 2019/11/6 6:02 PM
 * @Version 1.0
 */
public class Account {
    //锁：保护账户余额
    private final Object ballLock = new Object();
    // 账户余额
    private Integer balance;
    // 锁:保护账户密码
    private final Object pwLock = new Object();
    // 账户密码
    private String password;

    // 取款
    void withdraw(Integer amt) {
        synchronized (ballLock) {
            if (this.balance > amt) {
                this.balance -= amt;
            }
        }
    }

    // 查询余额
    Integer getBalance() {
        synchronized (ballLock) {
            return balance;
        }
    }
    // 更改密码
    void updatePassword(String pw) {
        synchronized (pwLock) {
            this.password = pw;
        }
    }
    // 查看密码
    String getPassword() {
        synchronized (pwLock) {
            return password;
        }
    }
    //转账
    //实现全局锁的第一种方法：
//    private Object lock;
//    private Account() {
//    }
//    //创建Account时传入同一个lock对象。
//    public Account(Object lock) {
//        this.lock = lock;
//    }
//    void tranfer(Account target, int amt) {
//        synchronized (lock) {
//            if (this.balance > amt) {
//                this.balance -= amt;
//                target.balance += amt;
//            }
//        }
//    }
    //第二种方法：
    void tranfer(Account target, int amt){
        synchronized (Account.class){
            if(this.balance > amt){
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }




}
