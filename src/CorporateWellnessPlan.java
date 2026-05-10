public class CorporateWellnessPlan extends MembershipPlan implements RemoteAccess, Freezable {

    private int employeeCount;
    private int workshopsPerMonth;
    private boolean onlineDashboard;

    public CorporateWellnessPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew, int employeeCount, int workshopsPerMonth, boolean onlineDashboard) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.employeeCount = employeeCount;
        this.workshopsPerMonth = workshopsPerMonth;
        this.onlineDashboard = onlineDashboard;
    }

    @Override
    public String getPlanType() {
        return "Corporate Wellness Plan";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double monthlyNetPrice = getBaseMonthlyFee();
        monthlyNetPrice += employeeCount * 18;
        monthlyNetPrice += workshopsPerMonth * 220;
        if (employeeCount >= 20) {
            monthlyNetPrice -= monthlyNetPrice * 0.12;
        }
        if (onlineDashboard == true) {
            monthlyNetPrice += 80;
        }
        return monthlyNetPrice;
    }

    @Override
    public boolean hasOnlineAccess() {
        return onlineDashboard;
    }

    @Override
    public boolean canFreeze() {
        boolean canFreeze = false;
        if (getMonths() >= 6 && workshopsPerMonth == 0) {
            canFreeze = true;
        }
        return canFreeze;
    }

}
