package lwg.creditcalc.application;

import lwg.creditcalc.domain.CreditParameters;
import lwg.creditcalc.domain.InstallmentCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    InstallmentCalculator calculator;

    @GetMapping(path = "/index")
    public String handle(Model model) {
        model.addAttribute("input", new InputData());

        return "inputForm";
    }

    @PostMapping(path = "/index")
    public String handleSubmit(@ModelAttribute InputData input, Model model) {
        model.addAttribute("input", input);

        double installment = calculator.calculate(new CreditParameters(
                input.getCreditAmount(),
                input.getInstallmentsPerYear(),
                input.getYears(),
                input.getFixedInterest()/100 + input.getVariableInterest()/100
        ));
        model.addAttribute("installment", installment);

        return "inputForm";
    }
}
