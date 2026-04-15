package com.financeiro.motor_credito.adapters.outbound;

import com.financeiro.motor_credito.domain.model.CreditData;
import com.financeiro.motor_credito.domain.service.CreditServiceBureau;
import org.springframework.stereotype.Component;

/**
 * Serasa Adapter
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-14
 */
@Component
public class SerasaAdapter implements CreditServiceBureau {
    @Override
    public CreditData scoreSearch(String cpf) {
        return null;
    }
}
