package lwg.creditcalc.domain;

import org.springframework.stereotype.Component;

@Component
public class InstallmentCalculator {
    public double calculate(CreditParameters parameters) {
        int totalInstallments = parameters.installmentsPerYear * parameters.years;

        double interestFactor = 0;
        for (int i = 1; i<= totalInstallments; i++) {
            interestFactor += Math.pow(1 + parameters.interest / parameters.installmentsPerYear, -i);
        }

        return Math.round(parameters.creditAmount / interestFactor);
    }
}
