package day12;

public class QueryResult extends PerformanceResult implements Exportable {
    private int recordCount;

    public QueryResult(int responseTime, int statusCode, int recordCount) {
        super(responseTime, statusCode);
        setRecordCount(recordCount);
    }

    public void setRecordCount(int recordCount) {
        if (recordCount < 0) {
            System.out.println("记录数不能为负数");
            return;
        }
        this.recordCount = recordCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

    @Override
    public void showResult() {
        System.out.println("查询请求");
        System.out.println("响应时间: " + responseTime + "ms");
        System.out.println("状态码: " + statusCode);
        System.out.println("是否成功: " + isSuccess());
        System.out.println("记录数: " + recordCount);
    }

    @Override
    public void exportData() {
        System.out.println("导出查询结果数据");
    }
}
