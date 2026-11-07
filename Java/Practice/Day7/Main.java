package Day7;

public class Main {
    public static void main(String[] args) {
        // 创建第一个对象并打印结果
        System.out.println("----------------第一个请求--------------");
        HttpResult result1 = new HttpResult();
        result1.showResult();

        // 创建第二个对象并打印结果
        System.out.println("----------------第二个请求--------------");
        HttpResult result2 = new HttpResult(500);
        result2.showResult();

        // 创建第三个对象并打印结果
        System.out.println("----------------第三个请求--------------");
        HttpResult result3 = new HttpResult(850, 500);
        result3.showResult();

        // 验证状态代码300是否属于成功请求
        HttpResult result4 = new HttpResult(300, 300);
        System.out.println("状态代码300属于成功请求: " + result4.isSuccess());
    }
}
