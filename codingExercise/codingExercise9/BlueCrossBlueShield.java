package codingExercise.codingExercise9;
public class BlueCrossBlueShield implements InsuranceBrand{
    private long id;
    private String name;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {

        double agePremium  = 0,smokePremium = 0;
        if(insurancePlan instanceof PlatinumPlan){
            agePremium = age>55?200:0;
            smokePremium = smoking==true?100:0;
        }
        else if(insurancePlan instanceof GoldPlan){
            agePremium = age>55?150:0;
            smokePremium = smoking==true?90:0;
        }
        else if(insurancePlan instanceof SilverPlan){
            agePremium = age>55?100:0;
            smokePremium = smoking==true?80:0;
        }
        else if(insurancePlan instanceof BronzePlan){
            agePremium = age>55?50:0;
            smokePremium = smoking==true?70:0;
        }
        double premium = agePremium+smokePremium;
        return premium;
    }
}
