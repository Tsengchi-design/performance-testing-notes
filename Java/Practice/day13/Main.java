package day13;

public class Main {
    public static void main(String[] args) {
        Task startTask = new Task() {
            @Override
            public void execute() {
                System.out.println("开始性能测试任务");
            }
        };
        startTask.execute();

        Task endTask = new Task() {
            @Override
            public void execute() {
                System.out.println("结束性能测试任务");
            }
        };
        endTask.execute();
    }
}
