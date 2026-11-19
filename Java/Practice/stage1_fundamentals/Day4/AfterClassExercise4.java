import java.util.Arrays;

public class AfterClassExercise4 {
    public static double percentileNearestRank(int[] responseTimes, int percentile) {
        double responseTime = 0;
 
        if (responseTimes.length == 0 || responseTimes == null) {
            System.out.println("The array is empty");
            return responseTime; // If the array is empty, return 0
        } else if (percentile < 1 || percentile > 100) {
            System.out.println("Percentile must be between 1 and 100");
            return responseTime; // If the percentile is out of range, return 0
        } else {
            int[] temp = Arrays.copyOf(responseTimes, responseTimes.length);    //复制数组
            Arrays.sort(temp); //数组排序

            int key = (int) Math.ceil(percentile * 1.0 / 100 * temp.length);
            responseTime = temp[key - 1];

            return responseTime;
        } 
    }

    public static void main(String[] args) {
        System.out.println("---------练习1---------");
        int[] responseTimes = { 350, 120, 280, 90, 500, 210, 160 };

        Arrays.sort(responseTimes);

        System.out.println(Arrays.toString(responseTimes));

        System.out.println("---------练习2---------");

        int totalTime = 0;
        for (int time : responseTimes) {
            totalTime += time;
        }

        double avgTime = totalTime * 1.0 / responseTimes.length; // 平均响应时间
        
        // double maxTime = responseTimes[responseTimes.length - 1]; // 最大值
        // double minTime = responseTimes[0]; // 最小值

        double maxTime = responseTimes[0];
        double minTime = responseTimes[0];

        for (int time : responseTimes) {
            if (time > maxTime) {
                maxTime = time;
            }
            if (time < minTime) {
                minTime = time;
            }
        }

        System.out.println("平均响应时间：" + avgTime);
        System.out.println("最大响应时间：" + maxTime);
        System.out.println("最小响应时间：" + minTime);

        System.out.println("---------练习3---------");
        // 编写percentileNearestRank()计算P90、P95、P99
        double P90 = percentileNearestRank(responseTimes, 90);
        double P95 = percentileNearestRank(responseTimes, 95);
        double P99 = percentileNearestRank(responseTimes, 99);

        System.out.println("90%响应时间：" + P90);
        System.out.println("95%响应时间：" + P95);
        System.out.println("99%响应时间：" + P99);
    }
}
