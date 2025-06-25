package br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.AluguelDTO;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IAluguelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ListaAlugueisJogoUC {
    private final IAluguelRepository aluguelRepository;

    public ListaAlugueisJogoUC(IAluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public List<AluguelDTO> executar(int numeroJogo) {
        return aluguelRepository.getAluguelModelsDeJogo(numeroJogo)
        .stream()
        .map(a -> a.toDTO())
        .toList();
    }
}
