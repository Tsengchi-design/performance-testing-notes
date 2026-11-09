package day13;

public class PerformanceTestPlan {
    private String planName;

    class TestCase {
        public void execute() {
            System.out.println("Executing test case in plan: " + planName);
        }
    }

    static class ReportConfig {
        public void printFormat() {
            System.out.println("Generating report for plan: " + planName);
        }
    }
}