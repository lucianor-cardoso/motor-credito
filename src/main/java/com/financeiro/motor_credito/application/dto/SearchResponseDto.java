package com.financeiro.motor_credito.application.dto;

/**
 * Search Response Dto
 * The response returned to requests for loan,
 * the response will be composed of last score point,
 * the restriction if exists and the result, positive
 * or negative for loan, in the first step.
 * In the future, can be returned the range of loan enabled.
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-07
 */
public record SearchResponseDto(
        Integer scorePoints,
        boolean isRestrict,
        String result,
        String description) {
}
