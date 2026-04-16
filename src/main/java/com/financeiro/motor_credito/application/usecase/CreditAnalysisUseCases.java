package com.financeiro.motor_credito.application.usecase;

import com.financeiro.motor_credito.application.dto.AnalysisRequestDto;
import com.financeiro.motor_credito.application.dto.AnalysisResponseDto;

import java.util.List;

/**
 * Search Use Cases
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-07
 */
public interface CreditAnalysisUseCases {

    public AnalysisResponseDto analyze(AnalysisRequestDto data);

    public List<AnalysisResponseDto> getAnalysis(Long clientId);

}
