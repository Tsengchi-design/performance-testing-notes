
package day20;

public class LocalCounterDemo {
    public static void main(String[] args)
            throws InterruptedException {

        int threadCount = 4;
        int times = 100000;

        int[] results = new int[threadCount];
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            final int index = i;

            threads[i] = new Thread(() -> {
                int local = 0;

                for (int j = 0; j < times; j++) {
                    local++;
                }

                results[index] = local;
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        int total = 0;
        for (int value : results) {
            total += value;
        }

        System.out.println("汇总结果：" + total);
    }
}
