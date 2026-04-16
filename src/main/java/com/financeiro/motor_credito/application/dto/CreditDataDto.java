package com.financeiro.motor_credito.application.dto;

import lombok.Builder;

import java.time.LocalDateTime;

/**
 * Credit Data DTO
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-16
 */

@Builder
public record CreditDataDto(Integer score, Boolean isRestrict, LocalDateTime searchDate) {
    public static CreditDataDtoBuilder builder() {
        return new CreditDataDtoBuilder();
    }
}
