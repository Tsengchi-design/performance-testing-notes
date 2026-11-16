
package day20;

public class RaceCounterDemo {

    static class Counter {
        int count = 0;

        void increase() {
            count++;
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

        System.out.println("期望请求数：" + expected);
        System.out.println("实际统计数：" + counter.count);
        System.out.println("差值：" + (expected - counter.count));
    }
}
