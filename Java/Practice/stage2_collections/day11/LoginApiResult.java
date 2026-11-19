package day11;

public class LoginApiResult extends ApiResult {
    private String username;

    public LoginApiResult(int responseTime, int statusCode, String username) {
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
        super.showResult();
    }

}
