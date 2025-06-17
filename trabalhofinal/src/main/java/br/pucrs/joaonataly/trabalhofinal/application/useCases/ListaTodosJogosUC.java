package br.pucrs.joaonataly.trabalhofinal.application.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.pucrs.joaonataly.trabalhofinal.domain.services.JogoService;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.JogoDTO;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoModel;

@Component
public class ListaTodosJogosUC {
    JogoService jogoService;

    @Autowired
    public ListaTodosJogosUC(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    public List<JogoModel> execute() {
        return jogoService.getAllJogos();
    }
}
