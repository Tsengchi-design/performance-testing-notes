package Day6;

public class Main {
    public static void main(String[] args) {
        // 创建第一个对象并打印结果
        System.out.println("----------------第一个请求--------------");
        HttpResult result1 = new HttpResult();
        result1.setResult(200, 200);
        result1.showResult();

        // 创建第二个对象并打印结果
        System.out.println("----------------第二个请求--------------");
        HttpResult result2 = new HttpResult();
        result2.setResult(500, 201);
        result2.showResult();

        // 创建第三个对象并打印结果
        System.out.println("----------------第三个请求--------------");
        HttpResult result3 = new HttpResult();
        result3.setResult(850, 500);
        result3.showResult();
    }
}
