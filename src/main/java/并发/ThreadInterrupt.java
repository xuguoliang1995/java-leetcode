package 并发;


public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread th = Thread.currentThread();
        while (true) {
            if (th.isInterrupted()) {
                break;
            }
            //可能出现无限循环，线程sleep期间被打断，抛出InterruptedException异常
            //try catch捕获这个异常，应该重置一下中断，

//            try {
//                Thread.sleep(200);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }


}
