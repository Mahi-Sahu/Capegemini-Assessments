package Feb25_InterestCalculator;

public class InterestSlabBelow1cr {
    int max;
    int min;
    double generalRate;
    double seniorRate;
    public InterestSlabBelow1cr(int min, int max, double generalRate, double seniorRate) {

        this.max = max;
        this.min = min;
        this.generalRate = generalRate;
        this.seniorRate = seniorRate;
    }


    public boolean inRange(int value) {
        return value<=max && value>=min;
    }
}