package com.financeiro.motor_credito.adaptadores.entrada;

import com.financeiro.motor_credito.aplicacao.dto.ClienteDto;
import com.financeiro.motor_credito.dominio.servico.ClienteService;
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

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

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
