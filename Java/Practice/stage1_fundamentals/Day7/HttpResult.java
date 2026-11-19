package Day7;

public class HttpResult {
    int responseTime; // 响应时间
    int statusCode; // 状态代码

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
        this.responseTime = responseTime;
        this.statusCode = statusCode;
    }

    boolean isSuccess() {
        return statusCode >= 200 && statusCode < 300; // 判断状态码是否在200到299之间
    }

    boolean isSlow() {
        return responseTime > 500;
    }

    void showResult() {
        System.out.println("响应时间: " + responseTime + "ms");
        System.out.println("状态代码: " + statusCode);
        System.out.println("是否成功: " + isSuccess());
        System.out.println("是否慢请求: " + isSlow());
        System.out.println();
    }
}
