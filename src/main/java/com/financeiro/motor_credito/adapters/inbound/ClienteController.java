package com.financeiro.motor_credito.adapters.inbound;

import com.financeiro.motor_credito.aplicacao.dto.ClienteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller para Clientes
 *
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    /**
     * Endpoint para inserção de Clientes
     *
     * @param cliente Dados de Cliente
     * @return ResponseEntity<ClienteDto>
     */
    @PostMapping
    public ResponseEntity<ClienteDto> inserirCliente(@RequestBody ClienteDto cliente) {
        System.out.println(cliente);
        return ResponseEntity.ok(cliente);
    }

}
