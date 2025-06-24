package br.pucrs.joaonataly.trabalhofinal.domain.repository;

import java.util.List;
import java.util.Optional;

import br.pucrs.joaonataly.trabalhofinal.domain.model.ClienteModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoModel;

public interface IJogoRepository {
    List<JogoModel> getAllJogos();
    Optional<JogoModel> findById(int codigo);
    
}
