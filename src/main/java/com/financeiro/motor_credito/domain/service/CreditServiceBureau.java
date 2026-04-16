package com.financeiro.motor_credito.domain.service;

import com.financeiro.motor_credito.application.dto.CreditDataDto;

/**
 * Credit Service Bureau
 * - Outbound Port
 * @author Luciano R. Cardoso
 * @since 2026-04-14
 */
public interface CreditServiceBureau {

    CreditDataDto scoreSearch(String cpf);

}
