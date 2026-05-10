public class OnlineCoachingPlan extends MembershipPlan implements RemoteAccess {

    private int videoConsultations;
    private boolean mealPlanIncluded;
    private boolean recordedLibraryAccess;

    public OnlineCoachingPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew, int videoConsultations, boolean mealPlanIncluded, boolean recordedLibraryAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.videoConsultations = videoConsultations;
        this.mealPlanIncluded = mealPlanIncluded;
        this.recordedLibraryAccess = recordedLibraryAccess;
    }

    @Override
    public String getPlanType() {
        return "Online Coaching Plan";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double monthlyNetPrice = getBaseMonthlyFee();
        monthlyNetPrice += videoConsultations * 45;
        if (mealPlanIncluded == true) {
            monthlyNetPrice += 60;
        }
        if (recordedLibraryAccess == true) {
            monthlyNetPrice += 20;
        }
        if (isAutoRenew() == true) {
            monthlyNetPrice -= 12;
        }
        return monthlyNetPrice;
    }

    @Override
    public boolean hasOnlineAccess() {
        return true;
    }

}
