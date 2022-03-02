package lwg.creditcalc.application;

import lombok.Data;

@Data
public class InputData {
    private int creditAmount;
    private int installmentsPerYear = 12;
    private int years = 30;
    private float fixedInterest;
    private float variableInterest;
}
