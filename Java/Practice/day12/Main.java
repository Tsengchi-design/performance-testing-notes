package day12;

public class Main {
    public static void main(String[] args) {
        PerformanceResult[] apiResult = {new LoginResult(900, 500, "Alice"),
                new QueryResult(200, 200, 20)};

        for (PerformanceResult result : apiResult) {
            result.showResult();
            
            // 判断 result 是否是 Exportable 的实例
            if (result instanceof Exportable exportable) {
                exportable.exportData();
            }

            System.out.println("-------------------");
        }
    }
}
