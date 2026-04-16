package com.financeiro.motor_credito.domain.rules;

import com.financeiro.motor_credito.domain.model.Client;
import com.financeiro.motor_credito.domain.model.Score;

/**
 * Abstract Validator Rule
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-16
 */
public abstract class AbstractValidator implements ValidatorRule {

    private AbstractValidator nextValidator;

    public AbstractValidator setNextValidator(AbstractValidator nextValidator) {
        this.nextValidator = nextValidator;
        return this.nextValidator;
    }

    protected void executeNextValidator(Client client, Score score) {
        if (nextValidator != null) {
            nextValidator.validate(client, score);
        }
    }

}
