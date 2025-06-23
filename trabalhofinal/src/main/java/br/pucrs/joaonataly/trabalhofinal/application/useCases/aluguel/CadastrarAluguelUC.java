package br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.AluguelDTO;
import br.pucrs.joaonataly.trabalhofinal.domain.model.AluguelModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IAluguelRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.services.AluguelService;
import org.springframework.stereotype.Service;

@Service
public class CadastrarAluguelUC {
    private final IAluguelRepository aluguelRepository;
    private final AluguelService aluguelService;
    public CadastrarAluguelUC(IAluguelRepository aluguelRepository, AluguelService aluguelService) {
        this.aluguelRepository = aluguelRepository;
        this.aluguelService = aluguelService;
    }
    public boolean executar(AluguelDTO aluguelDTO) {
        return aluguelRepository.addAluguel(aluguelDTO.toModel());
    }
}
