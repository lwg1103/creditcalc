package lwg.creditcalc.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InstallmentCalculatorTest {
    private InstallmentCalculator calculator;

    @Test
    public void itCalculatesInstallmentWithNoInterests() {
        CreditParameters parameters = new CreditParameters(1000, 4, 10, 0.0);
        double result = calculator.calculate(parameters);

        assertEquals(1000 / (4*10), result);
    }

    @Test
    public void itCalculatesInstallment() {
        CreditParameters parameters = new CreditParameters(1000, 4, 10, 0.02);
        double result = calculator.calculate(parameters);

        assertEquals(28.0, result);
    }

    @BeforeEach
    void setUp() {
        calculator = new InstallmentCalculator();
    }
}