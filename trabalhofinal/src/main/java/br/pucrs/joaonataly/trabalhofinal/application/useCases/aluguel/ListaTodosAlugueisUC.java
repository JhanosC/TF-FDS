package br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel;

import br.pucrs.joaonataly.trabalhofinal.domain.model.AluguelModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ClienteModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IAluguelRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListaTodosAlugueisUC {
    private final IAluguelRepository aluguelRepository;

    public ListaTodosAlugueisUC(IAluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public List<AluguelModel> executar() {
        return aluguelRepository.getAllAluguel();
    }
}
