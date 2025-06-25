package br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.AluguelDTO;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IAluguelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ListaAlugueisClienteUC {
    private final IAluguelRepository aluguelRepository;

    public ListaAlugueisClienteUC(IAluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public List<AluguelDTO> executar(int numeroCliente) {
        return aluguelRepository.getAluguelModelsDeCliente(numeroCliente)
        .stream()
        .map(a -> a.toDTO())
        .toList();
    }
}
