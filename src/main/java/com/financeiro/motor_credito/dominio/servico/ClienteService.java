package com.financeiro.motor_credito.dominio.servico;

import com.financeiro.motor_credito.adaptadores.saida.ClienteRepository;
import com.financeiro.motor_credito.dominio.modelo.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente gravar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
