package java数据结构.JVMDemo;


public class Demo1 {
    public static void main(String[] args) {
        try {
            Thread.sleep(30000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadData();
    }

    private static void loadData() {
        byte[] data = null;
        while (true) {
            for (int i = 0; i < 50; i++) {
                data = new byte[100 * 1024];
            }
            data = null;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
