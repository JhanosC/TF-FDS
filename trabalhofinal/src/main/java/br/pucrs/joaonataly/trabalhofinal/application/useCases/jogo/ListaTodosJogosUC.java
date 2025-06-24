package br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo;

import java.util.List;

import br.pucrs.joaonataly.trabalhofinal.domain.model.ClienteModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IClienteRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IJogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.pucrs.joaonataly.trabalhofinal.domain.services.JogoService;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.JogoDTO;
import org.springframework.stereotype.Service;

@Service
public class ListaTodosJogosUC {
    private final IJogoRepository jogoRepository;

    public ListaTodosJogosUC(IJogoRepository jogoRepository) {

        this.jogoRepository = jogoRepository;
    }

    public List<JogoModel> executar() {
        return jogoRepository.getAllJogos();
    }
}
