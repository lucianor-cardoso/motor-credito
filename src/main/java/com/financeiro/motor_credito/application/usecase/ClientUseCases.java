package com.financeiro.motor_credito.application.usecase;

import com.financeiro.motor_credito.application.dto.ClientDto;
import com.financeiro.motor_credito.domain.client.Client;

import java.util.List;

/**
 * Client Use Cases
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-03
 */
public interface ClientUseCases {
    public Client createClient(ClientDto clientDto);

    public Client getClient(Long id);

    public void deleteClient(Long id);

    public List<Client> getClients();
}
