package com.financeiro.motor_credito.domain.rules;

import com.financeiro.motor_credito.domain.model.Client;
import com.financeiro.motor_credito.domain.model.Score;

import java.io.Serializable;

/**
 * Validator Rule
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-14
 */
public interface ValidatorRule extends Serializable {

    /**
     * Validate rules
     *
     * @param client Client data
     * @param score  Score data
     */
    void validate(Client client, Score score);

}
