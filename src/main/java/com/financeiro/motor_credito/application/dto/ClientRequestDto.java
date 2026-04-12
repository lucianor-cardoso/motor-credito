package com.financeiro.motor_credito.application.dto;

import java.time.LocalDate;

/**
 * Client Request DTO
 *
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
public record ClientRequestDto(
        String name,
        String cpf,
        LocalDate birthDate) {
}
