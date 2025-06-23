package br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.AluguelDTO;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.AluguelIndentificadorDTO;
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

    public List<AluguelDTO> executar() {
        return aluguelRepository.getAllAluguel().stream()
                .map(aluguel -> aluguel.toDTO()).toList();
    }
}
