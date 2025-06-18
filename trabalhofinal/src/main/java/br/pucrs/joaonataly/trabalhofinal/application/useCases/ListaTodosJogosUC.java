package br.pucrs.joaonataly.trabalhofinal.application.useCases;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.pucrs.joaonataly.trabalhofinal.domain.services.JogoService;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Jogo;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.JogoDTO;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;

@Component
public class ListaTodosJogosUC {
    JogoService jogoService;

    @Autowired
    public ListaTodosJogosUC(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    public List<JogoDTO> execute() {
        return jogoService.getAllJogos().stream().map(p -> p.toDTO()).toList();
        //return jogoService.getAllJogos().stream().map(p -> p.toDTO()).toList();
        // return jogoService.getAllJogos().stream()
        //     .map(p->JogoDTO.fromModel(p))
        //     .toList();
    }
}
