package br.pucrs.joaonataly.trabalhofinal.adaptadorInterface.repositorio;

import java.util.List;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoModel;

public interface IJogoRepo {
    List<JogoModel> getAllJogos();
}
