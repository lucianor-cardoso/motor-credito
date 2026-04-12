package com.financeiro.motor_credito.adapters.inbound.controllers;

import com.financeiro.motor_credito.application.dto.ClientRequestDto;
import com.financeiro.motor_credito.application.dto.ClientResponseDto;
import com.financeiro.motor_credito.application.usecase.ClientUseCases;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Client Controller
 *
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientUseCases useCases;

    public ClientController(ClientUseCases useCases) {
        this.useCases = useCases;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDto> addClient(@RequestBody ClientRequestDto dto) {
        ClientResponseDto responseDto = useCases.createClient(dto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> getClient(@PathVariable("id") Long id) {
        ClientResponseDto responseDto = useCases.getClient(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getClients() {
        List<ClientResponseDto> responseDto = useCases.getClients();
        return ResponseEntity.ok(responseDto);
    }

}
