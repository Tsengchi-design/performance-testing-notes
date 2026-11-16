package day19;

public class PracticeOne {

    static class WorkerThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + " is working: " + i);
            }
        }
    }

    public static void main(String[] args) {
        Thread workerA = new Thread(new WorkerThread(), "Worker A");
        Thread workerB = new Thread(new WorkerThread(), "Worker B");

        workerA.start();
        workerB.start();
    }
}
