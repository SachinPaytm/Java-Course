package codingExercise.codingExercise9;

public class GoldPlan extends HealthInsurancePlan {
    private final static double COVERAGE = 0.8;
    private final static double DISCOUNT= 40;
    private final static double PREMIUM = 0.07;
    @Override
    public void setCoverage(double coverage) {
        super.setCoverage(COVERAGE);
    }

    @Override
    public void setDiscount(double discount) {
        super.setDiscount(DISCOUNT);
    }

    @Override
    public double getCoverage() {
        return COVERAGE;
    }

    @Override
    public double getDiscount() {
        return DISCOUNT;
    }
    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return PREMIUM*salary + getOfferedBy().computeMonthlyPremium(this,age,smoking);
    }
}
