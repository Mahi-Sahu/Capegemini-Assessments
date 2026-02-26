package Feb25_InterestCalculator;

import java.util.ArrayList;
import java.util.List;

public  class FDAccount extends Account {
    double amount;
    int noOfDays;
    int ageOfACHolder;
    static List<InterestSlabBelow1cr> isblw1cr = new ArrayList<>();

    static {
        isblw1cr.add(new InterestSlabBelow1cr(7, 14, 4.5, 5.0));
        isblw1cr.add(new InterestSlabBelow1cr(15, 29, 4.75, 5.25));
        isblw1cr.add(new InterestSlabBelow1cr(30, 45, 5.50, 6.0));
        isblw1cr.add(new InterestSlabBelow1cr(45, 60, 7, 7.50));
        isblw1cr.add(new InterestSlabBelow1cr(61, 184, 7.5, 8.0));
        isblw1cr.add(new InterestSlabBelow1cr(185, 365, 8.0, 8.50));
    }

    static List<InterestSlabAbove1cr> isabv1cr = new ArrayList<>();

    static {
        isabv1cr.add(new InterestSlabAbove1cr(7, 14, 6.5));
        isabv1cr.add(new InterestSlabAbove1cr(15, 29, 6.75));
        isabv1cr.add(new InterestSlabAbove1cr(30, 45, 6.75));
        isabv1cr.add(new InterestSlabAbove1cr(45, 60, 8));
        isabv1cr.add(new InterestSlabAbove1cr(61, 184, 8.5));
        isabv1cr.add(new InterestSlabAbove1cr(185, 365, 10.0));

    }

    public FDAccount(double amount, int noOfDays, int ageOfACHolder) {
        this.amount = amount;
        this.noOfDays = noOfDays;
        this.ageOfACHolder = ageOfACHolder;
    }

    public double calculateInterest() {
        interestRate=0;
        if (amount <= 10000000) {
            for (InterestSlabBelow1cr i : isblw1cr) {
                if (i.inRange(noOfDays)) {
                    if (ageOfACHolder < 60) {
                        interestRate = i.generalRate;
                        break;

                    } else {
                        interestRate = i.seniorRate;
                        break;
                    }
                }
            }
            System.out.println("Amount = " + amount);
            return amount * interestRate * noOfDays /(365*100);

        }
        else {
            for (InterestSlabAbove1cr i : isabv1cr) {
                if (i.inRange(noOfDays)) {
                    interestRate=i.interestRate;
                    break;
                }
            }
            return amount * interestRate * noOfDays /(365*100);
        }

    }
}
