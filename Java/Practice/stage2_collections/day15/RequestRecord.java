package day15;

public class RequestRecord {
    private String apiName;
    private int responseTime;
    private int statusCode;

    public RequestRecord(String apiName, int responseTime, int statusCode) {
        setApiName(apiName);
        setResponseTimes(responseTime);
        setStatusCode(statusCode);
    }

    public void setApiName(String apiName) {
        if (apiName == null || apiName.trim().isEmpty()) {
            // throw new IllegalArgumentException("apiName cannot be null");
            System.out.println("apiName cannot be null or empty");
            return;
        }
        this.apiName = apiName.trim();
    }

    public void setResponseTimes(int responseTime) {
        if (responseTime < 0) {
            throw new IllegalArgumentException("responseTime cannot be negative");
        }
        this.responseTime = responseTime;
    }

    public void setStatusCode(int statusCode) {
        if (statusCode < 100 || statusCode > 599) {
            throw new IllegalArgumentException("statusCode cannot be less than 100 or greater than 599");
        }
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return statusCode >= 200 && statusCode < 300;
    }

    public String getApiName() {
        return apiName;
    }

    public int getResponseTime() {
        return responseTime;
    }
}
