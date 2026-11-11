package day14;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 练习一
        System.out.println("---------------------练习一---------------------");
        ArrayList<String> apiList = new ArrayList<>();
        apiList.add("/user/login");
        apiList.add("/user/query");
        apiList.add("/order/create");

        // 新增一个/order/query
        apiList.add("/order/query");

        // 获取第二个接口名称
        System.out.println("第二个接口名称：" + apiList.get(1));

        // 修改第一个接口
        apiList.set(0, "/user/logout");

        // 删除第三个接口
        apiList.remove(2);

        // 循环遍历输出剩余接口
        System.out.println("最终接口列表：");
        for (String api : apiList){
            System.out.println(api);
        }
        
        // 练习二、三、四
        System.out.println("---------------------练习二+练习三+练习四---------------------");
        ArrayList<Long> responseTimes = new ArrayList<>();
        responseTimes.add(200L);
        responseTimes.add(300L);
        responseTimes.add(150L);
        responseTimes.add(400L);
        responseTimes.add(500L);
        responseTimes.add(600L);
        responseTimes.add(700L);
        responseTimes.add(800L);
        responseTimes.add(900L);

        // Long[] responseTimeArray = responseTimes.toArray(new Long[0]);

        ApiResult apiResult = new ApiResult(responseTimes);
        apiResult.printResult();        
    }
}
