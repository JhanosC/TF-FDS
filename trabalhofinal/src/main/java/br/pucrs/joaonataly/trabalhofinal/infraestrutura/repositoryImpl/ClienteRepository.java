package br.pucrs.joaonataly.trabalhofinal.infraestrutura.repositoryImpl;

import br.pucrs.joaonataly.trabalhofinal.domain.model.ClienteModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IClienteRepository;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements IClienteRepository {
    private final SpringDataClienteRepository springCliente;
    public ClienteRepository(SpringDataClienteRepository springCliente) {
        this.springCliente = springCliente;
    }

    @Override
    public Optional<ClienteModel> buscarPorId(int numero) {
        return springCliente.findById(numero)
                .map(this::toModel);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return null;
    }
    private ClienteModel toModel(Cliente entity) {
        return new ClienteModel(entity.getNumero(), entity.getNome(), entity.getEndereco());
    }
}

