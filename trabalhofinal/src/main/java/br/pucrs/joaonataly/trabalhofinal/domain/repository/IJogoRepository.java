package br.pucrs.joaonataly.trabalhofinal.domain.repository;

import java.util.List;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoModel;

public interface IJogoRepository {
    List<JogoModel> getAllJogos();
}
