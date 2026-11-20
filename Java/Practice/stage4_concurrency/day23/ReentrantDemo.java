package day23;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();

        try {
            lock.lock();
            try {
                System.out.println(lock.getHoldCount());
            } finally {
                lock.unlock();
            }
            System.out.println(lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }
}
