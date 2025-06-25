package br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl;

import br.pucrs.joaonataly.trabalhofinal.domain.model.AluguelModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ClienteModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.EmpresarialModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.IndividualModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IClienteRepository;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.Cliente;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.Empresarial;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.Individual;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl.springData.SpringDataClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClienteRepository implements IClienteRepository {
    private final SpringDataClienteRepository springCliente;
    public ClienteRepository(SpringDataClienteRepository springCliente) {
        this.springCliente = springCliente;
    }

    @Override
    public Optional<ClienteModel> findById(int numero) {
        return springCliente.findById(numero)
                .map(this::toModel);
    }

    @Override
    public List<ClienteModel> getAllClientes() {
        return springCliente.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private ClienteModel toModel(Cliente entity) {
        if (entity instanceof Individual individual) {
            return new IndividualModel(
                    individual.getNumero(),
                    individual.getNome(),
                    individual.getEndereco(),
                    individual.getCpf()
            );
        } else if (entity instanceof Empresarial empresarial) {
            return new EmpresarialModel(
                    empresarial.getNumero(),
                    empresarial.getNome(),
                    empresarial.getEndereco(),
                    empresarial.getCnpj(),
                    empresarial.getNomeFantasia()
            );
        }else {
            throw new IllegalArgumentException("Tipo de cliente desconhecido: " + entity.getClass().getSimpleName());
        }
    }

    
}

