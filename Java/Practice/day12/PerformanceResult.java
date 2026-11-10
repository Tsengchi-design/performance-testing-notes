package day12;

abstract class PerformanceResult {
    protected int responseTime;
    protected int statusCode;

    public PerformanceResult(int responseTime, int statusCode) {
        setResponseTime(responseTime);
        setStatusCode(statusCode);
    }

    public void setResponseTime(int responseTime) {
        if (responseTime < 0) {
            System.out.println("响应时间不能为负数");
            return;
        }
        this.responseTime = responseTime;
    }

    public void setStatusCode(int statusCode) {
        if (statusCode < 100 || statusCode > 599) {
            System.out.println("状态码不能小于100或大于599");
            return;
        }
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return statusCode >= 200 && statusCode < 300;
    }

    public abstract void showResult();
}
