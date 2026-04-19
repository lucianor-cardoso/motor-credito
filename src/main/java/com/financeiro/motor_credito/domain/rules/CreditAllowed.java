package com.financeiro.motor_credito.domain.rules;

import com.financeiro.motor_credito.domain.model.Client;
import com.financeiro.motor_credito.domain.model.Score;

/**
 * Credit Allowed
 * If all validations passes, this class mark the analysis as allowed.
 * @author Luciano R. Cardoso
 * @since 2026-04-19
 */
public class CreditAllowed extends AbstractValidator{
    @Override
    public void validate(Client client, Score score) {
        score.setResult("Positive");
        score.setDescription("Client has no restrictions.");
        System.out.println("credit allowed: " + client + " " + score);
        executeNextValidator(client, score);
    }
}
