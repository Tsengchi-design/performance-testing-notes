package day8;

public class HttpResult {
    private int responseTime; // 响应时间
    private int statusCode; // 状态代码

    // 无参构造方法
    HttpResult() {
        this(0, 0);
    }

    // 有参构造方法，只传入响应时间，状态代码默认为200
    HttpResult(int responseTime) {
        this(responseTime, 200);
    }

    // 有参构造方法，同时传入响应时间和状态代码
    HttpResult(int responseTime, int statusCode) {
        setResponseTime(responseTime);
        setStatusCode(statusCode);
    }

    public int getResponseTime() {
        return responseTime;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setResponseTime(int responseTime) {
        if (responseTime < 0) {
            // throw new IllegalArgumentException("响应时间不能为负数");
            System.out.println("响应时间不能为负数");
            return;
        }

        this.responseTime = responseTime;
    }

    public void setStatusCode(int statusCode) {
        if (statusCode < 100 || statusCode > 599) {
            // throw new IllegalArgumentException("状态代码必须在100到599之间");
            System.out.println("状态代码必须在100到599之间");
            return;
        }

        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return statusCode >= 200 && statusCode < 300; // 判断状态码是否在200到299之间
    }

    public boolean isSlow() {
        return responseTime > 500;
    }

    public void showResult() {
        System.out.println("响应时间: " + responseTime + "ms");
        System.out.println("状态代码: " + statusCode);
        System.out.println("是否成功: " + isSuccess());
        System.out.println("是否慢请求: " + isSlow());
        System.out.println();
    }
}
