package br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo;

import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IJogoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BuscaJogoIdUC {
    private final IJogoRepository jogoRepository;

    public BuscaJogoIdUC(IJogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public Optional<JogoModel> executar(int id) {
        return jogoRepository.findById(id);
    }
}
