package day24;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    static class Counter {
        private final AtomicInteger successCount = new AtomicInteger(0);

        public void increment() {
            successCount.incrementAndGet();
        }

        public int getCount() {
            return successCount.get();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 5;
        int times = 10000;
        Thread[] threads = new Thread[threadCount];

        Counter counter = new Counter();

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    counter.increment();
                }
            }, "worker-" + (i + 1));
        }

        for (Thread thread : threads) {
            thread.start();
        }
        
        for (Thread thread : threads) {
            thread.join();
        }

        int result = counter.getCount();

        System.out.println("成功请求数: " + result);
    }
}
