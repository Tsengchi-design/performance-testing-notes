package day17;

import java.util.ArrayList;
import java.util.List;

public class RunnablePractice {

    class RequestTask implements Runnable {
        private String name;

        @Override
        public void run() {
            System.out.println("当前线程名称：" + Thread.currentThread().getName());
            System.out.println(this.name + "请求处理");
        }

        public RequestTask(String name) {
            this.name = name;
        }
    }

    class RequestTaskByThread extends Thread {
        private String name;

        @Override
        public void run() {
            System.out.println("当前线程名称：" + Thread.currentThread().getName());
            System.out.println(this.name + "请求处理");
        }

        public RequestTaskByThread(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Runnable> requestTasks = new ArrayList<>();
        requestTasks.add(new RunnablePractice().new RequestTask("login"));
        requestTasks.add(new RunnablePractice().new RequestTask("queryOrder"));
        requestTasks.add(new RunnablePractice().new RequestTask("pay"));

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < requestTasks.size(); i++) {
            threads.add(new Thread(requestTasks.get(i), "request-" + (i + 1)));
        }

        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
        }

        Runnable practice = new RunnablePractice().new RequestTask("test-4");
        new Thread(practice, "request-4").start();
        new Thread(practice, "request-5").start();
        new Thread(practice, "request-6").start();

        RequestTaskByThread requestTaskByThread = new RunnablePractice().new RequestTaskByThread("logout");
        requestTaskByThread.start();

        Runnable practice2 = new RunnablePractice().new RequestTask("logout");
        new Thread(practice2, "request-8").start();
    }
}
