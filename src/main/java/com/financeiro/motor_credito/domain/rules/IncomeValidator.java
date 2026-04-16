package com.financeiro.motor_credito.domain.rules;

import com.financeiro.motor_credito.domain.model.Client;
import com.financeiro.motor_credito.domain.model.Score;

import java.math.BigDecimal;

/**
 * Income Validator
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-16
 */
public class IncomeValidator extends AbstractValidator {

    @Override
    public void validate(Client client, Score score) {
        System.out.println("income validator: " + client + " " + score);
        if (score.getActualIncome().compareTo(BigDecimal.valueOf(1600.0)) < 0) {
            score.setResult("Negative");
            score.setDescription("Actual Income less then allowed.");
            return;
        }
        executeNextValidator(client, score);
    }

}
