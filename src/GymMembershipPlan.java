public class GymMembershipPlan extends MembershipPlan implements Freezable {

    private int entriesPerMonth;
    private boolean saunaAccess;

    public GymMembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew, int entriesPerMonth, boolean saunaAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.entriesPerMonth = entriesPerMonth;
        this.saunaAccess = saunaAccess;
    }

    @Override
    public String getPlanType() {
        return "Gym Membership Plan";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double monthlyNetPrice = getBaseMonthlyFee();
        monthlyNetPrice += entriesPerMonth * 4;
        if (saunaAccess == true) {
            monthlyNetPrice += 25;
        }
        if (isAutoRenew()) {
            monthlyNetPrice -= 10;
        }
        return monthlyNetPrice;
    }

    @Override
    public boolean canFreeze() {
        boolean canFreeze = false;
        if (getMonths() >= 3) {
            canFreeze = true;
        }
        return canFreeze;
    }

}
