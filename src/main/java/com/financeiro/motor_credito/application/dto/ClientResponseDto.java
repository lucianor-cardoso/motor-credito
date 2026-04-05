package com.financeiro.motor_credito.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Client Response DTO
 *
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {
    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
}
