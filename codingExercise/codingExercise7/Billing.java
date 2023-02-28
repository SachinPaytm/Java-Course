package codingExercise.codingExercise7;

import java.util.Arrays;

public class Billing {

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        // your logic
        double insuredAmount = 0;

        //$20 for people who dont have insurance
        double discount  = 20;
        if(patientInsurancePlan instanceof PlatinumPlan){
            System.out.println(((PlatinumPlan)(patient.getInsurancePlan())).getCoverage());
            System.out.println(((PlatinumPlan)(patient.getInsurancePlan())).getDiscount());
            insuredAmount = amount*((PlatinumPlan)(patient.getInsurancePlan())).getCoverage();
            discount = ((PlatinumPlan)(patient.getInsurancePlan())).getDiscount();
        }
        else if(patientInsurancePlan instanceof GoldPlan){
            insuredAmount = amount*((GoldPlan)(patient.getInsurancePlan())).getCoverage();
            discount = ((GoldPlan)(patient.getInsurancePlan())).getDiscount();
        }
        else if(patientInsurancePlan instanceof SilverPlan){
            insuredAmount = amount*((SilverPlan)(patient.getInsurancePlan())).getCoverage();
            discount = ((SilverPlan)(patient.getInsurancePlan())).getDiscount();
        }
        else if(patientInsurancePlan instanceof BronzePlan){
            insuredAmount = amount*((BronzePlan)(patient.getInsurancePlan())).getCoverage();
            discount = ((BronzePlan)(patient.getInsurancePlan())).getDiscount();
        }
        double amountToBePaidByPatient = amount-(insuredAmount+discount);
        System.out.println(insuredAmount);
        System.out.println(discount);
        System.out.println(amountToBePaidByPatient);


        payments[0] = insuredAmount;
        payments[1] = amountToBePaidByPatient;
        return payments;
    }

    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Patient patient = new Patient();
        patient.setInsurancePlan(insurancePlan);

        double[] payments = Billing.computePaymentAmount(patient, 1000.0);
        System.out.println(payments[0]+" "+payments[1]);
    }

}