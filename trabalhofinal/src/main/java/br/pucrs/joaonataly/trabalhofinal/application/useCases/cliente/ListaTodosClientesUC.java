package br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.ClienteDTO;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaTodosClientesUC {
    private final IClienteRepository clienteRepository;

    public ListaTodosClientesUC(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> executar() {
        return clienteRepository.getAllClientes().stream()
                .map(cliente -> cliente.toDTO())
                .toList();
    }
}
