package com.financeiro.motor_credito.config;

import com.financeiro.motor_credito.application.service.CreditAnalyzeService;
import com.financeiro.motor_credito.domain.repository.ScoreRepository;
import com.financeiro.motor_credito.domain.service.CreditServiceBureau;
import org.springframework.stereotype.Component;

/**
 * Bean config
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-14
 */
@Component
public class BeanConfig {

    public CreditAnalyzeService analyzeCreditUseCase(
            CreditServiceBureau creditServiceBureau,
            ScoreRepository repository) {
        return new CreditAnalyzeService(creditServiceBureau, repository);
    }

}
