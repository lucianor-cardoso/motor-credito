package com.financeiro.motor_credito.aplicacao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Cliente DTO
 *
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    private Integer id;
    private String nome;
    private Integer idade;
    private String cpf;
    private BigDecimal salario;
}
