package day11;

public class Main {
    public static void main(String[] args) {
        ApiResult[] apiResult = { new ApiResult(300, 200),
                new LoginApiResult(900, 500, "Alice"),
                new QueryApiResult(200, 200, 20),
                new LoginApiResult(150, 200, "Bob"),
                new QueryApiResult(800, 200, 100) };

        for (ApiResult result : apiResult) {
            result.showResult();
            System.out.println("-------------------");
        }
    }
}
