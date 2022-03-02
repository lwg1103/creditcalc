package lwg.creditcalc.domain;

public class CreditParameters {
    int creditAmount;
    int installmentsPerYear;
    int years;
    double interest;

    public CreditParameters(int creditAmount, int installmentsPerYear, int years, double interest) {
        this.creditAmount = creditAmount;
        this.installmentsPerYear = installmentsPerYear;
        this.years = years;
        this.interest = interest;
    }
}
