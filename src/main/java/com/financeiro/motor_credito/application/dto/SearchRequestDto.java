package com.financeiro.motor_credito.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequestDto {
    private Long clientId;
    private BigDecimal actualIncome;
}
