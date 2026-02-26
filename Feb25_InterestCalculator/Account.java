package Feb25_InterestCalculator;

public abstract class Account {
    double amount;
    double interestRate;
    abstract double calculateInterest();
}