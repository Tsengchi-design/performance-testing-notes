package day11;

public class QueryApiResult extends ApiResult {
    private int recordCount;

    public QueryApiResult(int responseTime, int statusCode, int recordCount) {
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
        System.out.println("查询记录数: " + recordCount);
        super.showResult();
    }
}
