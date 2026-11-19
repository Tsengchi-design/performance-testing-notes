package day10;

public class ApiResult {
    private int responseTime;
    private int statusCode;

    public ApiResult(int responseTime, int statusCode) {
        setResponseTime(responseTime);
        setStatusCode(statusCode);
    }

    public ApiResult() {
        this(0, 0);
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
            System.out.println("状态代码必须在100到599之间");
            return;
        }
        this.statusCode = statusCode;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public boolean isSuccess() {
        return statusCode >= 200 && statusCode < 300;
    }

    public boolean isSlow() {
        return responseTime > 500;
    }

    public void showResult() {
        System.out.println("响应时间: " + responseTime + "ms");
        System.out.println("状态代码: " + statusCode);
        System.out.println("是否成功：" + isSuccess());
        System.out.println("是否慢请求：" + isSlow());
    }
}
