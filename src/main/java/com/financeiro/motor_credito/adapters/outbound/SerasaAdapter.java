package com.financeiro.motor_credito.adapters.outbound;

import com.financeiro.motor_credito.application.dto.CreditDataDto;
import com.financeiro.motor_credito.domain.service.CreditServiceBureau;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Serasa Adapter
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-14
 */
@Component
public class SerasaAdapter implements CreditServiceBureau {

    @Override
    public CreditDataDto scoreSearch(String cpf) {
        Random random = new Random();
        Integer score = random.nextInt(1000);
        boolean isRestrict = random.nextBoolean();
        return CreditDataDto.builder()
                .score(score)
                .isRestrict(isRestrict)
                .searchDate(LocalDateTime.now())
                .build();
    }

}
