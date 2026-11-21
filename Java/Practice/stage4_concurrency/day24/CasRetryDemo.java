package day24;

import java.util.concurrent.atomic.AtomicInteger;

public class CasRetryDemo {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(100);

        boolean first = count.compareAndSet(100, 101);  // true
        boolean second = count.compareAndSet(100, 102); // false

        System.out.println("First: " + first);
        System.out.println("Second: " + second);
        System.out.println("Count: " + count.get());

        int oldValue;
        int newValue;

        do {
            oldValue = count.get();
            newValue = oldValue + 1;
        } while (!count.compareAndSet(oldValue, newValue)) ;

        System.out.println("Final count: " + count.get());
    }
}
