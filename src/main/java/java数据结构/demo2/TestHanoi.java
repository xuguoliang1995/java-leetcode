package java数据结构.demo2;

/**
 * @Author: 许国亮
 * @Date: 2019/9/19 10:43 AM
 * @Version 1.0
 */
public class TestHanoi {
    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');
    }

    /**
     * @param n
     * @param from
     * @param in
     * @to
     */
    public static void hanoi(int n, char from, char in, char to) {
        if (n == 1) {
            System.out.println("第一个盘子从" + from + "移到" + to);
        } else {
            hanoi(n - 1, from, to, in);
            System.out.println("第" + n + "个盘子从" + from + "移到" + to);
            hanoi(n - 1, in, from, to);
        }
    }

}
