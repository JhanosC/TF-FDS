package br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente;

import br.pucrs.joaonataly.trabalhofinal.domain.model.ClienteModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaTodosClientesUC {
    private final IClienteRepository clienteRepository;

    public ListaTodosClientesUC(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModel> executar() {
        return clienteRepository.getAllClientes();
    }
}
