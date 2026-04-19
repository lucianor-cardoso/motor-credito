package com.financeiro.motor_credito.application.service;

import com.financeiro.motor_credito.adapters.outbound.entities.JpaClientEntity;
import com.financeiro.motor_credito.adapters.outbound.repositories.JpaClientRepository;
import com.financeiro.motor_credito.adapters.outbound.repositories.JpaScoreRepository;
import com.financeiro.motor_credito.application.dto.AnalysisRequestDto;
import com.financeiro.motor_credito.application.dto.AnalysisResponseDto;
import com.financeiro.motor_credito.application.dto.CreditDataDto;
import com.financeiro.motor_credito.application.usecase.CreditAnalysisUseCases;
import com.financeiro.motor_credito.domain.model.Client;
import com.financeiro.motor_credito.domain.model.Score;
import com.financeiro.motor_credito.domain.service.CreditAnalyzeDomainService;
import com.financeiro.motor_credito.domain.service.CreditServiceBureau;
import com.financeiro.motor_credito.utils.mappers.ClientMapper;
import com.financeiro.motor_credito.utils.mappers.ScoreMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    private final JpaScoreRepository scoreRepository;
    private final JpaClientRepository clientRepository;
    private final CreditAnalyzeDomainService creditAnalyzeDomainService;
    private final ClientMapper clientMapper;
    private final ScoreMapper scoreMapper;

    public CreditAnalyzeApplicationService(CreditServiceBureau creditServiceBureau,
                                           JpaScoreRepository repository,
                                           JpaClientRepository clientRepository,
                                           CreditAnalyzeDomainService creditAnalyzeDomainService,
                                           ClientMapper mapper,
                                           ScoreMapper scoreMapper) {
        this.creditServiceBureau = creditServiceBureau;
        this.scoreRepository = repository;
        this.clientRepository = clientRepository;
        this.creditAnalyzeDomainService = creditAnalyzeDomainService;
        this.clientMapper = mapper;
        this.scoreMapper = scoreMapper;
    }

    @Override
    public AnalysisResponseDto analyze(AnalysisRequestDto data) {
        // get client information
        Optional<JpaClientEntity> jpaClient = clientRepository.findById(data.clientId());
        if (jpaClient.isEmpty()) {
            // todo: gerar exceção.
            return null;
        }
        Client client = clientMapper.jpaToClient(jpaClient.get());

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
        scoreRepository.save(scoreMapper.scoreToJpaScore(score));

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
