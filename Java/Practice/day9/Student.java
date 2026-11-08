package day9;

public class Student {
    private String name;
    private int age;
    private static int studentCount = 0;

    public Student() {
        this("未知", 0);
    }

    public Student(String name) {
        this(name, 0);
    }

    public Student(int age) {
        this("未知", age);
    }

    public Student(String name, int age) {
        setName(name);
        setAge(age);
        studentCount++;
    }

    public static void showStudentCount() {
        System.out.println("学生总数: " + studentCount);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if (name == null) {
            System.out.println("名字不能为空");
            return;
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("年龄不能为负数");
            return;
        }
        this.age = age;
    }

    public void showStudentInfo() {
        System.out.println("姓名: " + name + ", 年龄: " + age);
    }
}
