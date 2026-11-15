package day18;

public class TestDemo {

    static class RepeatTest extends Thread {

        @Override
        public void run() {
            System.out.println("线程执行成功");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new RepeatTest();

        worker.start();

        worker.join();

        try {
            worker.start();
        } catch (IllegalThreadStateException e) {
            System.out.println("捕获到预期异常：" + e);
        }
    }
}
