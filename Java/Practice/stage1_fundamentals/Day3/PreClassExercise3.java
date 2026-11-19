public class PreClassExercise3 {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        int total = 10000;
        int success = 9850;
        double p95 = 280;
        double max95 = 300;
        double minSuccessRate = 99.5;

        int failure = total - success;
        double successRate = success * 100.0 / total ;

        System.out.println("失败请求数：" + failure);
        System.out.println("成功率标准值：" + minSuccessRate + "%," + "当前成功率：" + successRate + "%");
        System.out.println("95%响应时间标准值：" + max95 + "ms," + "当前95%响应时间：" + p95 + "ms");

        if (successRate >= minSuccessRate && p95 <= max95) {
            System.out.println("性能测试通过");
        } else if (successRate < minSuccessRate && p95 > max95) {
            System.out.println("成功率和响应时间都不达标");
        } else if (successRate < minSuccessRate) {
            System.out.println("成功率不达标");
        } else if (p95 > max95) {
            System.out.println("响应时间不达标");
        }
    }
}
