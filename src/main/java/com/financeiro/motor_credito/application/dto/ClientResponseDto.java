package com.financeiro.motor_credito.application.dto;

import java.time.LocalDate;

/**
 * Client Response DTO
 *
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
public record ClientResponseDto(
        Long id,
        String name,
        String cpf,
        LocalDate birthDate) {
}
