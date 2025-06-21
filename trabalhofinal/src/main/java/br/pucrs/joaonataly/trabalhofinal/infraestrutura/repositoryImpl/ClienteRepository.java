package br.pucrs.joaonataly.trabalhofinal.infraestrutura.repositoryImpl;

import br.pucrs.joaonataly.trabalhofinal.domain.repository.IClienteRepository;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Cliente;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class ClienteRepository implements IClienteRepository {
    private final SpringDataClienteRepository springCliente;
    public ClienteRepository(SpringDataClienteRepository springCliente) {
        this.springCliente = springCliente;
    }

    @Override
    public Optional<Cliente> buscarPorId(int numero) {
        return springCliente.findById(numero);
    }
}

