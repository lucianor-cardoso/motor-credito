package com.financeiro.motor_credito.domain.rules;

import com.financeiro.motor_credito.domain.model.Client;
import com.financeiro.motor_credito.domain.model.Score;

import java.time.LocalDate;
import java.time.Period;

/**
 * Age Validator
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-16
 */
public class AgeValidator extends AbstractValidator {

    /**
     * Validates age
     * @param client Client data
     * @param score  Score data
     */
    @Override
    public void validate(Client client, Score score) {
        System.out.println("age validator: " + client + " " + score);
        if (Period.between(client.getBirthDate(), LocalDate.now()).getYears() <= 18) {
            score.setResult("Negative");
            score.setDescription("Under age not allowed.");
            return;
        }
        executeNextValidator(client, score);
    }

}
