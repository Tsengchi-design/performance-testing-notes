package day18;

public class InterruptDemo {

    public static void main(String[] args)
            throws InterruptedException {

        Thread worker = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("工作线程正在执行");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            System.out.println("工作线程退出");
        });

        System.out.println(worker.getState());
        System.out.println(worker.isAlive());
        worker.start(); // 启动线程

        System.out.println(worker.getState());
        System.out.println(worker.isAlive());
        Thread.sleep(2000); // worker线程启动后等待2s

        System.out.println(worker.getState());
        System.out.println(worker.isAlive());
        worker.interrupt(); // 中断worker线程

        System.out.println(worker.getState());
        System.out.println(worker.isAlive());
        worker.join();

        System.out.println(worker.getState());
        System.out.println(worker.isAlive());
        System.out.println("主线程结束");
    }
}
