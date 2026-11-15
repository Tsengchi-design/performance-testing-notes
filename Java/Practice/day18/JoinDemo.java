package day18;

import java.util.ArrayList;
import java.util.List;

public class JoinDemo {

    static class Worker implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i < 4; i++) {
                System.out.println(Thread.currentThread().getName() + "工作线程开始执行第" + i + "次任务");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                    Thread.currentThread().interrupt();
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "工作线程第" + i + "次任务执行结束");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
            throws InterruptedException {
        /*
         * List<Runnable> worksList = new ArrayList<>();
         * worksList.add(new Thread(new Worker(), "Thread-1"));
         * worksList.add(new Thread(new Worker(), "Thread-2"));
         */

        List<Thread> threadList = new ArrayList<>();
        threadList.add(new Thread(new Worker(), "Thread-1"));
        threadList.add(new Thread(new Worker(), "Thread-2"));

        /*
         * for (Runnable work : worksList) {
         * if (work instanceof Thread) {
         * threadList.add((Thread) work);
         * }
         * }
         */

        for (Thread thread : threadList) {
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println("所有请求任务执行完成。");
    }
}
