package codingExercise.codingExercise7;

public class PlatinumPlan extends HealthInsurancePlan{
    private final static double COVERAGE = 0.9;
    private final static double DISCOUNT= 50;
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
}
