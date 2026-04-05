package com.financeiro.motor_credito.adapters.inbound.controllers;

import com.financeiro.motor_credito.application.dto.ClientRequestDto;
import com.financeiro.motor_credito.application.dto.ClientResponseDto;
import com.financeiro.motor_credito.application.usecase.ClientUseCases;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Client Controller
 *
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
@RestController
@RequestMapping("/api/client")
public class ClientController {

    private ClientUseCases useCases;

    public ClientController(ClientUseCases useCases) {
        this.useCases = useCases;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDto> addClient(@RequestBody ClientRequestDto dto) {
        System.out.println(dto);
        ClientResponseDto responseDto = useCases.createClient(dto);
        return ResponseEntity.ok(responseDto);
    }

}
