package com.financeiro.motor_credito.domain.service;

import com.financeiro.motor_credito.domain.model.Client;
import com.financeiro.motor_credito.domain.model.Score;
import com.financeiro.motor_credito.domain.rules.*;

/**
 * Credit Analyze Domain Service
 * Validate the rules of the credit and then return the result.
 * CreditAllowed rule is the finish line.
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-16
 */
public class CreditAnalyzeDomainService {

    public Score analyze(Client client, Score score) {
        AbstractValidator validator = new AgeValidator();
        validator.setNextValidator(new RestrictionValidator())
                .setNextValidator(new IncomeValidator())
                .setNextValidator(new ScoreValidator())
                .setNextValidator(new CreditAllowed()); // always keep last
        validator.validate(client, score);
        System.out.println("validator result: " + client + " " + score);
        return score;
    }

}
