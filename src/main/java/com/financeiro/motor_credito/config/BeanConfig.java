package com.financeiro.motor_credito.config;

import com.financeiro.motor_credito.adapters.outbound.repositories.JpaClientRepository;
import com.financeiro.motor_credito.adapters.outbound.repositories.JpaScoreRepository;
import com.financeiro.motor_credito.application.service.CreditAnalyzeApplicationService;
import com.financeiro.motor_credito.domain.service.CreditAnalyzeDomainService;
import com.financeiro.motor_credito.domain.service.CreditServiceBureau;
import com.financeiro.motor_credito.utils.mappers.ClientMapper;
import com.financeiro.motor_credito.utils.mappers.ScoreMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Bean config
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-14
 */
@Component
public class BeanConfig {

    @Bean
    public CreditAnalyzeApplicationService creditAnalyzeApplicationService(
            CreditServiceBureau creditServiceBureau,
            JpaScoreRepository scoreRepository,
            JpaClientRepository clientRepository,
            ClientMapper clientMapper,
            ScoreMapper scoreMapper) {
        CreditAnalyzeDomainService creditAnalyzeDomainService = new CreditAnalyzeDomainService();
        return new CreditAnalyzeApplicationService(creditServiceBureau, scoreRepository,
                clientRepository, creditAnalyzeDomainService, clientMapper, scoreMapper);
    }
}
