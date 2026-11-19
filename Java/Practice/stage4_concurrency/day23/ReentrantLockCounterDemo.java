
package day23;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounterDemo {

    static class Counter {
        private int count = 0;
        private final Lock lock = new ReentrantLock();

        public void increase() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }

        public int getCount() {
            lock.lock();
            try {
                return count;
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        Counter counter = new Counter();
        int threadCount = 4;
        int times = 100000;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    counter.increase();
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

        System.out.println("期望请求数：" + expected);
        System.out.println("实际统计数：" + actual);
        System.out.println("差值：" + (expected - actual));
    }
}
