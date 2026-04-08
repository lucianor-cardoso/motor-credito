package com.financeiro.motor_credito.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponseDto {
    private Integer scorePoints;
    private boolean isRestrict;
    private String result;
    private String description;
}
