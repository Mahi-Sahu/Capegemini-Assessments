package Feb25_InterestCalculator;

import java.util.HashMap;
import java.util.Map;

public  class RDAccount extends Account{
    double interestRate;
    double amount;
    int noOfMonths;
    double monthlyAmount;
    int ageOfACHolder;
    static Map<Integer,double[]> rateMap= new HashMap<>();

    static {
        rateMap.put(6,new double[]{7.5,8.0});
        rateMap.put(9,new double[] {7.75,8.25});
        rateMap.put(12,new double[] {8.0,8.50});
        rateMap.put(15,new double[] {8.25,8.75});
        rateMap.put(18,new double[] {8.50,9.0});
        rateMap.put(21,new double[] {8.75,9.25});
    }

    public RDAccount(double monthlyAmount,int noOfMonths, int ageOfACHolder) {

        this.noOfMonths = noOfMonths;
        this.monthlyAmount = monthlyAmount;
        this.ageOfACHolder=ageOfACHolder;
    }

    public double calculateInterest() {
        double[] rates = rateMap.get(noOfMonths);
        if (rates == null) {
            throw new IllegalArgumentException(
                    "Invalid tenure. Allowed months are: " + rateMap.keySet()
            );
        }

        if (ageOfACHolder < 60) {
            interestRate = rates[0];
        } else {
            interestRate = rates[1];
        }

        return (monthlyAmount * noOfMonths * interestRate) / 100;
    }

}