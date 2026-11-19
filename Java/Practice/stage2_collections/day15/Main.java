package day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // 练习一
        System.out.println("---------------------------练习一---------------------------");
        HashSet<String> apiNames = new HashSet<String>();
        apiNames.add("login");
        apiNames.add("queryOrder");
        apiNames.add("login");
        apiNames.add("createOrder");
        apiNames.add("queryOrder");

        System.out.println("apiNames合集大小：" + apiNames.size()); //合集大小为3，因为HashSet中元素不能重复
        System.out.println("apiNames合集是否包含 login ：" + apiNames.contains("login"));

        System.out.println("apiNames合集元素：");
        for (String apiName : apiNames) {
            System.out.println(apiName);
        }

        // 练习二
        System.out.println("---------------------------练习二---------------------------");
        ArrayList<String> apiList = new ArrayList<String>();
        apiList.add("login");
        apiList.add("queryOrder");
        apiList.add("login");
        apiList.add("pay");
        apiList.add("login");
        apiList.add("pay");

        HashMap<String, Integer> apiCount = new HashMap<String, Integer>();

        for (String apiName : apiList) {
            apiCount.put(apiName, apiCount.getOrDefault(apiName, 0) + 1);
        }

        System.out.println("所有接口调用次数：");
        for (String apiName : apiCount.keySet()) {
            System.out.println(apiName + " : " + apiCount.get(apiName) + "次");
        }

        // 练习三
        System.out.println("---------------------------练习三---------------------------");
        ArrayList<RequestRecord> requestRecords = new ArrayList<RequestRecord>();
        requestRecords.add(new RequestRecord("login", 100, 200));
        requestRecords.add(new RequestRecord("createOrder", 200, 201));
        requestRecords.add(new RequestRecord("login", 100, 200));
        requestRecords.add(new RequestRecord("pay", 300, 400));
        requestRecords.add(new RequestRecord("login", 100, 200));
        requestRecords.add(new RequestRecord("pay", 300, 500));
        requestRecords.add(new RequestRecord("queryOrder", 200, 200));
        requestRecords.add(new RequestRecord("logout", 500, 401));
        requestRecords.add(new RequestRecord("createOrder", 600, 201));
        requestRecords.add(new RequestRecord("logout", 200, 401));
        requestRecords.add(new RequestRecord("", 400, 404));
        requestRecords.add(new RequestRecord(null, 600, 201));

        HashMap<String, ApiStats> apiStats = new HashMap<String, ApiStats>();
        for (RequestRecord record : requestRecords) {
            if (record == null || record.getApiName() == null) {
                continue;
            }

            apiStats.put(record.getApiName(), apiStats.getOrDefault(record.getApiName(), new ApiStats()));

            apiStats.get(record.getApiName()).addRecord(record);
        }

        for (String apiName : apiStats.keySet()) {
            System.out.println("API Name: " + apiName);
            System.out.println("Total Requests: " + apiStats.get(apiName).getTotal());
            System.out.println("Success Requests: " + apiStats.get(apiName).getSuccess());
            System.out.println("Failed Requests: " + apiStats.get(apiName).getFailed());
            System.out.println("Average Response Time: " + apiStats.get(apiName).getAverageResponseTime() + "ms");
            System.out.println();
        }
    }
}
