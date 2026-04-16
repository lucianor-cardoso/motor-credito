package com.financeiro.motor_credito.domain.rules;

import com.financeiro.motor_credito.domain.model.Client;
import com.financeiro.motor_credito.domain.model.Score;

/**
 * Restriction Validator
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-16
 */
public class RestrictionValidator extends AbstractValidator {

    /**
     * Validates restrictions
     * @param client Client data
     * @param score  Score data
     */
    @Override
    public void validate(Client client, Score score) {
        System.out.println("restriction validator: " + client + " " + score);
        if (score.getRestrict().equals(true)) {
            score.setResult("Negative");
            score.setDescription("Account has restrictions.");
            return;
        }
        executeNextValidator(client, score);
    }

}
