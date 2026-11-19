package day16;

public class ThreadPractice {
    class RequestThread extends Thread {

        public RequestThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("当前线程名称：" + Thread.currentThread().getName());
            System.out.println("login请求处理");
        }
    }

    public static void main(String[] args) {

        RequestThread requestThread = new ThreadPractice().new RequestThread("request-1");
        RequestThread requestThread2 = new ThreadPractice().new RequestThread("request-2");
        RequestThread requestThread3 = new ThreadPractice().new RequestThread("request-3");

        requestThread.start();
        requestThread2.start();
        requestThread3.start();

        System.out.println("当前线程名称：" + Thread.currentThread().getName());

        // 练习四

        RequestThread requestThread4 = new ThreadPractice().new RequestThread("request-4");
        RequestThread requestThread5 = new ThreadPractice().new RequestThread("request-5");
        requestThread4.start();
        requestThread5.run();
    }
}
