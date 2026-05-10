public class PersonalTrainingPlan extends MembershipPlan {

    private int sessionsPerMonth;
    private int trainerLevel;
    private boolean dietConsultationIncluded;

    public PersonalTrainingPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew, int sessionsPerMonth, int trainerLevel, boolean dietConsultationIncluded) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.sessionsPerMonth = sessionsPerMonth;
        this.trainerLevel = trainerLevel;
        this.dietConsultationIncluded = dietConsultationIncluded;
    }

    @Override
    public String getPlanType() {
        return "Personal Training Plan";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double monthlyNetPrice = getBaseMonthlyFee();
        monthlyNetPrice += sessionsPerMonth * 70;
        if (trainerLevel == 2) {
            monthlyNetPrice += 90;
        }
        if (trainerLevel == 3) {
            monthlyNetPrice += 180;
        }
        if (dietConsultationIncluded == true) {
            monthlyNetPrice += 50;
        }
        if (isAutoRenew() == true) {
            monthlyNetPrice -= 15;
        }
        return monthlyNetPrice;
    }

}
