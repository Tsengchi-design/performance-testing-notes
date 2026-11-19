package day19;

import java.util.ArrayList;
import java.util.List;

public class PracticeTwo {
    static class WorkerThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i < 11; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }

    public static void main(String[] args) {
        List<Thread> workersList = new ArrayList<>();

        for (int i = 1; i < 6; i++) {
            workersList.add(new Thread(new WorkerThread(), "Worker-" + i));
        }

        for (Thread worker : workersList) {
            worker.start();
        }
    }
}
