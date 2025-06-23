package br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel;

import br.pucrs.joaonataly.trabalhofinal.domain.model.AluguelModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IAluguelRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BuscaAluguelIdUC {
    private final IAluguelRepository aluguelRepository;

    public BuscaAluguelIdUC(IAluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public Optional<AluguelModel> executar(int id) {
        return aluguelRepository.findById(id);
    }

}
