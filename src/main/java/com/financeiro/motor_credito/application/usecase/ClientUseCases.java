package com.financeiro.motor_credito.application.usecase;

import com.financeiro.motor_credito.application.dto.ClientRequestDto;
import com.financeiro.motor_credito.application.dto.ClientResponseDto;

import java.util.List;

/**
 * Client Use Cases
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-03
 */
public interface ClientUseCases {
    public ClientResponseDto createClient(ClientRequestDto clientDto);

//    public ClientResponseDto getClient(Long id);
//    public void deleteClient(Long id);
//    public List<ClientResponseDto> getClients();
}
