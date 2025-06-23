package br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente;

import br.pucrs.joaonataly.trabalhofinal.domain.model.EmpresarialModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.IndividualModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IEmpresarialRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IIndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastrarEmpresarialUC {
    private final IEmpresarialRepository empresarialRepository;

    public CadastrarEmpresarialUC(IEmpresarialRepository empresarialRepository) {
        this.empresarialRepository = empresarialRepository;
    }
    public EmpresarialModel executar(EmpresarialModel empresarialModel) {
        empresarialRepository.addEmpresarial(empresarialModel);
        return empresarialModel;

    }
}
