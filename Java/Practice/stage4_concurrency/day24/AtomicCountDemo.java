package day24;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCountDemo {
    static class Counter {
        private final AtomicInteger count = new AtomicInteger(0);

        public void increment() {
            count.incrementAndGet();
        }

        public int getCount() {
            return count.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        int threadCount = 4;
        int times = 100000;
        Thread[] threads = new Thread[threadCount];

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

        int expected = threadCount * times;
        int actual = counter.getCount();

        System.out.println("期望次数: " + expected);
        System.out.println("实际次数: " + actual);
        System.out.println("差值 " + (expected - actual));
    }
}
