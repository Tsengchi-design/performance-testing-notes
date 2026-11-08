package day9;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------Student练习----------------------");
        Student student1 = new Student("Alice", 20);
        Student student2 = new Student("Bob", 22);
        Student student3 = new Student("Charlie", 19);

        Student.showStudentCount(); // 输出学生总数

        student1.showStudentInfo(); // 输出学生1的信息
        student2.showStudentInfo(); // 输出学生2的信息
        student3.showStudentInfo(); // 输出学生3的信息

        System.out.println("-------------------HttpResult练习----------------------");
        HttpResult result1 = new HttpResult(200, 200);
        HttpResult result2 = new HttpResult(800, 500);
        HttpResult result3 = new HttpResult(300, 200);
        HttpResult result4 = new HttpResult(900, 200);
        HttpResult result5 = new HttpResult(100, 404);

        HttpResult.showStatistics();
    }
}
