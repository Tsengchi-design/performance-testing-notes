package day18;

public class SleepDemo {

    public static void main(String[] args)
            throws InterruptedException {

        for (int i = 1; i < 6; i++) {
            System.out.println("请求任务：" + i);
            Thread.sleep(500);
        }
    }
}
