package java数据结构.JVMDemo;


public class Demo5 {
    public static long counter = 0;
    public static void main(String[] args) {
        work();
    }
    private static void work() {
        System.out.println("目前是第" + (++counter) + "次调用方法");
        work();
    }
}
