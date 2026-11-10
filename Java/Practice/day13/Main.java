package day13;

import day13.PerformanceTestPlan.TestCase;

public class Main {
    public static void main(String[] args) {
        // 练习一
        System.out.println("---------------------练习一---------------------");
        PerformanceTestPlan performanceTestPlan = new PerformanceTestPlan("Performance Test Plan");
        TestCase testCase = performanceTestPlan.new TestCase();
        testCase.execute();
        
        // 练习二
        System.out.println("---------------------练习二---------------------");
        PerformanceTestPlan.ReportConfig reportConfig = new PerformanceTestPlan.ReportConfig();
        reportConfig.printFormat();

        // 练习三
        System.out.println("---------------------练习三---------------------");
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
                System.out.println("性能测试任务完成");
            }
        };
        endTask.execute();

        // 练习四
        System.out.println("---------------------练习四---------------------");
        TestTask loginTest = new TestTask() {
            private int responseTime = 200;
            private int statusCode = 200;

            public boolean isSuccess() {
                return statusCode >= 200 && statusCode < 300;
            }

            @Override
            public void execute() {
                System.out.println("登录接口响应时间：" + responseTime + "ms");
                System.out.println("登录接口状态码：" + statusCode);
                System.out.println("登录接口是否成功：" + isSuccess());
            }
        };

        TestTask queryTest = new TestTask() {
            private int responseTime = 100;
            private int statusCode = 350;

            @Override
            public void execute() {
                System.out.println("查询接口响应时间：" + responseTime + "ms");
                System.out.println("查询接口状态码：" + statusCode);
                System.out.println("查询接口是否成功：" + isSuccess());
            }

            public boolean isSuccess() {
                return statusCode >= 200 && statusCode < 300;
            }
        };

        loginTest.execute();
        System.out.println();
        queryTest.execute();
    }
}
