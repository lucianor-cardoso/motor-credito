package com.financeiro.motor_credito.application.service;

import com.financeiro.motor_credito.application.dto.AnalysisRequestDto;
import com.financeiro.motor_credito.application.dto.AnalysisResponseDto;
import com.financeiro.motor_credito.application.dto.CreditDataDto;
import com.financeiro.motor_credito.application.usecase.CreditAnalysisUseCases;
import com.financeiro.motor_credito.domain.model.Client;
import com.financeiro.motor_credito.domain.model.Score;
import com.financeiro.motor_credito.domain.repository.ClientRepository;
import com.financeiro.motor_credito.domain.repository.ScoreRepository;
import com.financeiro.motor_credito.domain.service.CreditAnalyzeDomainService;
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
public class CreditAnalyzeApplicationService implements CreditAnalysisUseCases {

    private final CreditServiceBureau creditServiceBureau;
    private final ScoreRepository scoreRepository;
    private final ClientRepository clientRepository;
    private final CreditAnalyzeDomainService creditAnalyzeDomainService;

    public CreditAnalyzeApplicationService(CreditServiceBureau creditServiceBureau,
                                           ScoreRepository repository,
                                           ClientRepository clientRepository,
                                           CreditAnalyzeDomainService creditAnalyzeDomainService) {
        this.creditServiceBureau = creditServiceBureau;
        this.scoreRepository = repository;
        this.clientRepository = clientRepository;
        this.creditAnalyzeDomainService = creditAnalyzeDomainService;
    }

    @Override
    public AnalysisResponseDto analyze(AnalysisRequestDto data) {
        // get client information
        Client client = clientRepository
                .findById(data.clientId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));

        // get score and restriction data from credit bureau
        CreditDataDto creditDataDto = creditServiceBureau.scoreSearch(client.getCpf());

        // generate score object
        Score score = new Score();
        score.setClient(client);
        score.setActualIncome(data.actualIncome());
        score.setScorePoints(creditDataDto.score());
        score.setRestrict(creditDataDto.isRestrict());
        score.setSearchDate(creditDataDto.searchDate());

        // analyze credit
        creditAnalyzeDomainService.analyze(client, score);

        // save score
        scoreRepository.save(score);

        // return analysis result
        return new AnalysisResponseDto(score.getScorePoints(),
                score.getRestrict(),
                score.getResult(),
                score.getDescription());

    }

    @Override
    public List<AnalysisResponseDto> getAnalysis(Long clientId) {
        return List.of();
    }
}
