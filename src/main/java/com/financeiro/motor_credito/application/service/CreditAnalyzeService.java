package com.financeiro.motor_credito.application.service;

import com.financeiro.motor_credito.application.dto.AnalysisRequestDto;
import com.financeiro.motor_credito.application.dto.AnalysisResponseDto;
import com.financeiro.motor_credito.application.usecase.CreditAnalysisUseCases;
import com.financeiro.motor_credito.domain.repository.ScoreRepository;
import com.financeiro.motor_credito.domain.service.CreditServiceBureau;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Analyze Credit Use Case,
 * Responsible for orchestrating the execution of the consultation and processing stages of credit analysis.
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-14
 */
@Service
public class CreditAnalyzeService implements CreditAnalysisUseCases {

    private final CreditServiceBureau creditServiceBureau;
    private final ScoreRepository repository;

    public CreditAnalyzeService(CreditServiceBureau creditServiceBureau, ScoreRepository repository) {
        this.creditServiceBureau = creditServiceBureau;
        this.repository = repository;
    }

    @Override
    public AnalysisResponseDto analyze(AnalysisRequestDto data) {
        return null;
    }

    @Override
    public List<AnalysisResponseDto> getAnalysis(Long clientId) {
        return List.of();
    }
}
