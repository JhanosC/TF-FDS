package br.pucrs.joaonataly.trabalhofinal.application.useCases;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.ClienteNumeroDTO;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IClienteRepository;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Cliente;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.repositoryImpl.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BuscaClienteIdUC {
    private final IClienteRepository clienteRepository;

    public BuscaClienteIdUC(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Optional<Cliente> executar(int id) {
        return clienteRepository.buscarPorId(id);
    }

}
