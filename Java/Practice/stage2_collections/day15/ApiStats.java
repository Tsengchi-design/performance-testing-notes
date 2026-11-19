package day15;

public class ApiStats {
    private long total;
    private long success;
    private long failed;
    private long totalResponseTime;

    // 统计总请求次数、成功数、失败数、总响应时间
    public void addRecord(RequestRecord record) {
        if (record.getApiName() == null) {
            return;
        }

        total++;

        if (record.isSuccess()) {
            success++;
        } else {
            failed++;
        }

        totalResponseTime += record.getResponseTime();
    }

    // 计算平均响应时间（毫秒）
    public double getAverageResponseTime() {
        if (total == 0) {
            return 0;
        }
        return totalResponseTime / (double) total;
    }

    public long getTotal() {
        return total;
    }

    public long getSuccess() {
        return success;
    }

    public long getFailed() {
        return failed;
    }

    public long getTotalResponseTime() {
        return totalResponseTime;
    }
}
