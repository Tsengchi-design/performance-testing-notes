package day14;

import java.util.ArrayList;

public class ApiResult {
    private ArrayList<Long> responseTimes;


    public ApiResult(ArrayList<Long> responseTimes) {
        setResponseTimes(responseTimes);
    }

    public void setResponseTimes(ArrayList<Long> responseTimes) {
        if (responseTimes == null) {
            this.responseTimes = new ArrayList<Long>();
            return;
        }
        this.responseTimes = new ArrayList<Long>(responseTimes);
    }

    public int getCount() {
        int count = responseTimes.size();
        return count;
    }

    public long getTotalTime() {
        long totalTime = 0;
        for (Long time : responseTimes) {
            totalTime += time;
        }

        return totalTime;
    }

    public double getAvgTime() {
        if (getCount() > 0) {
            return (double)getTotalTime() / getCount(); 
        }
        return 0;
    }

    public long getMinTime() {
        if (getCount() > 0) {
            long minTime = responseTimes.get(0);
            for (Long time : responseTimes) {
                if (time < minTime) {
                    minTime = time;
                }
            }
            return minTime;
        }
        return 0;
    }

    public long getMaxTime() {
        if (getCount() > 0) {
            long maxTime = responseTimes.get(0);
            for (Long time : responseTimes) {
                if (time > maxTime) {
                    maxTime = time;
                }
            }
            return maxTime;
        }
        return 0;
    }

    public void printResult() {
        int count = getCount();
        if (count > 0) {
            long totalTime = getTotalTime();
            double avgTime = getAvgTime();
            long minTime = getMinTime();
            long maxTime = getMaxTime();

            StringBuilder report = new StringBuilder();
            report.append("Performance Test Report\n\n");
            report.append("Request Count: ").append(count).append("\n");
            report.append("Total Response Time: ").append(totalTime).append("ms\n");
            report.append("Average Response Time: ").append(avgTime).append("ms\n");
            report.append("Minimum Response Time: ").append(minTime).append("ms\n");
            report.append("Maximum Response Time: ").append(maxTime).append("ms\n");
            System.out.println(report.toString());
        }else {
            System.out.println("No response time data!");
        }
    }
}
