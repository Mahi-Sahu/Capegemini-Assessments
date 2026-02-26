package Feb25_InterestCalculator;

public class InterestSlabAbove1cr {
    int max;
    int min;
    double interestRate;
    public InterestSlabAbove1cr(int min, int max, double interestRate) {

        this.max = max;
        this.min = min;
        this.interestRate = interestRate;
    }


    public boolean inRange(int value) {
        return value>=min && value<=max;
    }

}