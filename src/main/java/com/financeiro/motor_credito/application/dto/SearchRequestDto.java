package com.financeiro.motor_credito.application.dto;

import java.math.BigDecimal;

/**
 * Search Request Dto
 * Every new request for loan, the client must provide
 * the last income, this will be stored at score table
 * with the last score point retrieved from Serasa
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-07
 */
public record SearchRequestDto(
        Long clientId,
        BigDecimal actualIncome) {
}
