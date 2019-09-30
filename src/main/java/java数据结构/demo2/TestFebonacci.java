package java数据结构.demo2;

/**
 * @Author: 许国亮
 * @Date: 2019/9/19 10:28 AM
 * @Version 1.0
 */
public class TestFebonacci {
    public static void main(String[] args) {
        bebonacci(9);
    }

    public static void bebonacci(int len) {
        //定义第一个加数a，初始值为1；定义第二个加数b，初始值为1；定义两个加数之和为c，初始值为0
        int a = 1;
        int b = 1;
        int c = 0;
        //首先在控制台打印出数列中第一个数和第二个数的值
        System.out.print(a + "\t" + b + "\t");
        //建立一个for循环，用于循环输出数列中第三位至第十位的数字
        for (int i = 0; i <= len; i++) {
            //第三个数即为c，a+b等于c的值
            c = a + b;
            //将第一个加数a赋值为数列中的第二个数b的值
            a = b;
            //将第二个加数b赋值为数列中的第三个数c的值
            b = c;
            //在第二次循环打印时，将打印数列中的第四个数为：b + c = b + (a + b)
            System.out.print(c + "\t");

        }
    }

    //打印第n项斐波那契数列
    public static int febonacci1(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return febonacci1(i - 1) + febonacci1(i - 2);
        }
    }
}