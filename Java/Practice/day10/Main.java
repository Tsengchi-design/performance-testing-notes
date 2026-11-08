package day10;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------ApiResult练习----------------------");
        ApiResult apiResult = new ApiResult(180, 200);
        apiResult.showResult();

        System.out.println("-------------------LoginApiResult练习----------------------");
        LoginApiResult loginApiResult = new LoginApiResult(900, 500, "Alice");
        loginApiResult.showResult();
    }
}
