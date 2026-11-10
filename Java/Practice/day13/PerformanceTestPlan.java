package day13;

public class PerformanceTestPlan {
    private String planName;

    public void setPlanName(String planName) {
        if (planName == null || planName.isEmpty()) {
            System.out.println("Plan name cannot be null or empty");
            return;
        }
        this.planName = planName;
    }

    public String getPlanName() {
        return planName;
    }

    public PerformanceTestPlan(String planName) {
        setPlanName(planName);
    }

    class TestCase {
        public void execute() {
            System.out.println("Executing test case in plan: " + planName);
        }
    }

    static class ReportConfig {
        public void printFormat() {
            System.out.println("Generating report format: HTML");
        }
    }
}