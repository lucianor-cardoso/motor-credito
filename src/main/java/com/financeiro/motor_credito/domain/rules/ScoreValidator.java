package com.financeiro.motor_credito.domain.rules;

import com.financeiro.motor_credito.domain.model.Client;
import com.financeiro.motor_credito.domain.model.Score;

import java.time.LocalDate;
import java.time.Period;

/**
 * Score Validator
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-16
 */
public class ScoreValidator extends AbstractValidator {

    /**
     * Validates score
     * @param client Client data
     * @param score  Score data
     */
    @Override
    public void validate(Client client, Score score) {
        System.out.println("score validator: " + client + " " + score);
        if (score.getScorePoints() <= 300) {
            score.setResult("Negative");
            score.setDescription("Low score point.");
            return;
        }
        executeNextValidator(client, score);
    }

}
