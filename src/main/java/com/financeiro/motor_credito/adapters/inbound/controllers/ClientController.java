package com.financeiro.motor_credito.adapters.inbound.controllers;

import com.financeiro.motor_credito.application.dto.ClientDto;
import com.financeiro.motor_credito.application.usecase.ClientUseCases;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Client Controller
 *
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientUseCases useCases;

    public ClientController(ClientUseCases useCases) {
        this.useCases = useCases;
    }

    @PostMapping
    public ResponseEntity<ClientDto> addClient(ClientDto dto) {
        useCases.createClient(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ClientDto> getClient(ClientDto dto) {
        return useCases.getClient(dto.getId());
    }
}
