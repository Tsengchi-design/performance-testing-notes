package Day5;

import java.util.Arrays;

public class PerformanceAnalysis {
    // 求和方法
    public static int sum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("The array is empty");
        }

        int total = 0;
        for (int num : numbers) {
            total += num;
        }

        return total;
    }

    // 求均值
    public static double average(int[] times) {
        if (times == null || times.length == 0) {
            throw new IllegalArgumentException("The array is empty");
        }

        int totalTime = sum(times);
        return totalTime * 1.0 / times.length;
    }

    // 数组最大值
    public static int max(int[] times) {
        if (times == null || times.length == 0) {
            throw new IllegalArgumentException("The array is empty");
        }

        /*
         * int[] temp = Arrays.copyOf(times, times.length);
         * Arrays.sort(temp);
         * 
         * int maxTime = temp[temp.length - 1];
         */

        // 排序需要额外的计算开销，使用遍历方式求最值可以降低时间复杂度
        int maxTime = times[0];
        for (int time : times) {
            if (time > maxTime) {
                maxTime = time;
            }
        }

        return maxTime;
    }

    // 数组最小值
    public static int min(int[] times) {
        if (times == null || times.length == 0) {
            throw new IllegalArgumentException("The array is empty");
        }

        // 排序需要额外的计算开销，使用遍历方式求最值可以降低时间复杂度
        int minTime = times[0];
        for (int time : times) {
            if (time < minTime) {
                minTime = time;
            }
        }

        return minTime;
    }

    // nearest-rank百分位数
    public static int percentileNearestRank(int[] times, int percentile) {
        if (times == null || times.length == 0) {
            throw new IllegalArgumentException("The array is empty");
        } else if (percentile < 1 || percentile > 100) {
            throw new IllegalArgumentException("Percentile must be between 1 and 100");
        } else {
            int[] temp = Arrays.copyOf(times, times.length);
            Arrays.sort(temp);

            int key = (int) Math.ceil(percentile * 1.0 / 100 * temp.length);
            return temp[key - 1];
        }
    }

    // printReport方法
    public static void printReport(int[] times) {
        System.out.println("---------Performance Analysis Report---------");
        System.out.println("Response Times: " + Arrays.toString(times));
        System.out.println("Total Response Time: " + sum(times));
        System.out.println("Average Response Time: " + average(times));
        System.out.println("Maximum Response Time: " + max(times));
        System.out.println("Minimum Response Time: " + min(times));

        int percentile = 95;
        double percentileTime = percentileNearestRank(times, percentile);
        System.out.println(percentile + "th Percentile Response Time: " + percentileTime);
    }

    public static void main(String[] args) {
        int[] responseTimes = { 350, 120, 280, 90, 500, 210, 160 };

        printReport(responseTimes);
    }

}
