package br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente;

import br.pucrs.joaonataly.trabalhofinal.domain.model.IndividualModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IIndividualRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastrarIndividualUC  {
    private final IIndividualRepository individualRepository;

    public CadastrarIndividualUC(IIndividualRepository individualRepository) {
        this.individualRepository = individualRepository;
    }
    public IndividualModel executar(IndividualModel individualModel) {
        individualRepository.addIndividual(individualModel);
        return individualModel;
    }
}
