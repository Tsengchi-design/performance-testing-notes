package day23;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                if (lock.tryLock()) {
                    try {
                        System.out.println("获取锁成功，执行临界区代码");
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("获取锁失败，执行其他代码");
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("所有线程执行完毕");

        /* if (lock.tryLock()) {
            try {
                System.out.println("获取锁成功，执行临界区代码");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("获取锁失败，执行其他代码");
        } */
    }
}
