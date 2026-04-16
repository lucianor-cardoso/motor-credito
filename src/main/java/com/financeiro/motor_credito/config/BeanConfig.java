package com.financeiro.motor_credito.config;

import com.financeiro.motor_credito.application.service.CreditAnalyzeApplicationService;
import com.financeiro.motor_credito.domain.repository.ClientRepository;
import com.financeiro.motor_credito.domain.repository.ScoreRepository;
import com.financeiro.motor_credito.domain.service.CreditAnalyzeDomainService;
import com.financeiro.motor_credito.domain.service.CreditServiceBureau;
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
            ScoreRepository scoreRepository,
            ClientRepository clientRepository) {
        CreditAnalyzeDomainService creditAnalyzeDomainService = new CreditAnalyzeDomainService();
        return new CreditAnalyzeApplicationService(creditServiceBureau, scoreRepository,
                clientRepository, creditAnalyzeDomainService);
    }

}
