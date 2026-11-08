package day8;

public class Main {
    public static void main(String[] args) {
        HttpResult result = new HttpResult(300, 200);

        result.setResponseTime(800);
        result.setResponseTime(-100);
        result.setStatusCode(999);
        result.showResult();
    }
}
