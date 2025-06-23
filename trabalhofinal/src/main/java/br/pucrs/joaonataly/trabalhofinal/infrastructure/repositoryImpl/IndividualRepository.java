package br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl;

import br.pucrs.joaonataly.trabalhofinal.domain.model.IndividualModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IIndividualRepository;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.Individual;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl.springData.SpringDataIndividualRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class IndividualRepository implements IIndividualRepository {
    private final SpringDataIndividualRepository springIndividual;
    public IndividualRepository(SpringDataIndividualRepository springIndividual) {
        this.springIndividual = springIndividual;
    }
    @Override
    public List<IndividualModel> getAllIndividual() {
        return springIndividual.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean addIndividual(IndividualModel individualModel) {
        Individual ind = toEntity(individualModel);

        Individual indSalvo = springIndividual.save(ind);

        return indSalvo != null && indSalvo.getNumero() != 0;
    }

    private IndividualModel toModel(Individual entity) {
        return new IndividualModel(entity.getNumero(), entity.getNome(), entity.getEndereco(),entity.getCpf());
    }
    private Individual toEntity(IndividualModel model) {
        return new Individual(model.getNome(), model.getEndereco(),model.getCpf());
    }
}

