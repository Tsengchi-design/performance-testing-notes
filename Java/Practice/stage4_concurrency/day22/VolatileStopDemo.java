package day22;

public class VolatileStopDemo {

    static class Worker implements Runnable {
        private volatile boolean running = true;

        public void stopWork() {
            running = false;
        }

        @Override
        public void run() {
            long count = 0;

            while (running) {
                count++;
            }

            System.out.println("工作线程已退出，循环次数：" + count);
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        Worker worker = new Worker();

        Thread thread = new Thread(worker, "worker");

        thread.start();

        Thread.sleep(500);

        worker.stopWork();

        thread.join();

        System.out.println("主线程结束");
    }
}
