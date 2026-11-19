package day10;

public class LoginApiResult extends ApiResult {
    private String username;

    public LoginApiResult(int responseTime, int statusCode, String username) {
        super(responseTime, statusCode);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void showResult() {
        System.out.println("用户名: " + username);
        super.showResult();
    }

}
