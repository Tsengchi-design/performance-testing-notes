public class Day2 {
    public static void main(String[] args) {
        // 练习1、2
        int total = 5000;
        int success = 4980;

        int failed = total - success;
        double successRate = success * 100.0 / total;

        double p95 = 250;

        double minSuccessRate = 99.5;
        double maxP95 = 300;

        System.out.println("失败请求数：" + failed);
        System.out.println("成功率：" + successRate + "%");

        if (successRate >= minSuccessRate && p95 <= maxP95) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试未通过");
        }

        // 练习3
        System.out.print("1到10之间的所有偶数：");
        for (int i = 1; i <= 10; i++) {
            double temp = i / 2.0;
            int temp2 = i / 2;
            // System.out.println("temp=" + temp);
            // System.out.println("temp2=" + temp2);
            if (temp == temp2) {
                if (i < 10) {
                    System.out.print(i + " ");
                } else {
                    System.out.println(i);
                }
            }
        }

        // 练习4
        int checkTime = 1;
        while (checkTime <= 5) {
            System.out.println("检查次数：" + checkTime);
            checkTime++;
        }
    }
}