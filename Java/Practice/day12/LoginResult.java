package day12;

public class LoginResult extends PerformanceResult implements Exportable {
    private String username;

    public LoginResult(int responseTime, int statusCode, String username) {
        super(responseTime, statusCode);
        setUsername(username);
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            System.out.println("用户名不能为空");
            return;
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void showResult() {
        System.out.println("登录请求");
        System.out.println("用户名: " + username);
        System.out.println("响应时间: " + responseTime + "ms");
        System.out.println("状态码: " + statusCode);
        System.out.println("是否成功: " + isSuccess());
    }

    @Override
    public void exportData() {
        System.out.println("导出登录结果数据");
    }
}
