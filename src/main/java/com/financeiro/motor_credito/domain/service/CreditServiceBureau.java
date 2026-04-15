package com.financeiro.motor_credito.domain.service;

import com.financeiro.motor_credito.domain.model.CreditData;

/**
 * Credit Service Bureau
 * - Outbound Port
 * @author Luciano R. Cardoso
 * @since 2026-04-14
 */
public interface CreditServiceBureau {

    CreditData scoreSearch(String cpf);

}
