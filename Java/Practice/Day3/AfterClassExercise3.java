public class AfterClassExercise3 {
    public static void main(String[] args) {
        System.out.println("------------练习1------------");
        int[] numbers = {12, 25, 8, 36, 19, 42, 7, 31, 16, 28};
        
        System.out.println("numbers数组长度="+numbers.length);
        System.out.print("numbers数组包含元素：");

        for (int i = 0; i < numbers.length ; i++) {
            if (i == (numbers.length - 1)) {
                System.out.println(numbers[i]);
            } else {
                System.out.print(numbers[i] + ", ");
            }
        }

        System.out.println("------------练习2------------");
        double[] responseTimes = {
            135, 180, 220, 160, 310, 
            275, 190, 420, 155, 205
        };

        int length = responseTimes.length;
        double sumTime = 0;
        double avgTime = 0;
        double maxTime = responseTimes[0];
        double minTime = responseTimes[0];
        
        //计算响应时间总和
        for (int i = 0; i < responseTimes.length; i++) {
            sumTime += responseTimes[i];
        }

        //计算响应时间平均值
        avgTime = sumTime / length;

        //计算响应时间最大值
        for (int i = 0; i < responseTimes.length; i++) {
            if (responseTimes[i] > maxTime) {
                maxTime = responseTimes[i];
            } else if (responseTimes[i] < minTime) {
                minTime = responseTimes[i];
            }
        }

        System.out.println("样本数：" + length);
        System.out.println("响应时间总和：" + sumTime + "ms");
        System.out.println("平均响应时间：" + avgTime + "ms");
        System.out.println("最大响应时间：" + maxTime + "ms");
        System.out.println("最小响应时间：" + minTime + "ms");

        System.out.println("------------练习3------------");
        String line = "order,200,245";
        String[] parts = line.split(",");  //拆分字符串
        int statusCode = Integer.parseInt(parts[1]);  //将字符串转换为整数

        System.out.println("接口名称："+ parts[0]);
        System.out.println("状态码："+ statusCode);
        System.out.println("响应时间："+ parts[2] + "ms");

        System.out.println("------------练习4------------");
        double[] responseTimes2 = {
            100, 120, 150, 180, 
            200, 220, 250, 300
        };

        double sumTime2 = 0;

        for (int i = 0;i<responseTimes2.length;i++) {
            sumTime2 += responseTimes2[i];
        }

        double avgTime2 = sumTime2 / responseTimes2.length;

        boolean isResponseTimePass = avgTime2 <= 200;

        System.out.println("平均响应时间：" + avgTime2 + "ms");

        if (isResponseTimePass) {
            System.out.println("平均响应时间达标");
        } else {
            System.out.println("平均响应时间不达标");
        }

    }
}
