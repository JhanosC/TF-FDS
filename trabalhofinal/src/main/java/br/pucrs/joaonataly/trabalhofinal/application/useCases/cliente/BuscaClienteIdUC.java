package br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente;

import br.pucrs.joaonataly.trabalhofinal.domain.model.ClienteModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BuscaClienteIdUC {
    private final IClienteRepository clienteRepository;

    public BuscaClienteIdUC(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Optional<ClienteModel> executar(int id) {
        return clienteRepository.findById(id);
    }

}
