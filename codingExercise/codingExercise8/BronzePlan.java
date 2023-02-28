package codingExercise.codingExercise8;

public class BronzePlan extends HealthInsurancePlan {
    private final static double COVERAGE = 0.6;
    private final static double DISCOUNT= 25;

    private final static double PREMIUM = 0.05;
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
    public double computeMonthlyPremium(double salary) {
        return PREMIUM*salary;
    }
}
