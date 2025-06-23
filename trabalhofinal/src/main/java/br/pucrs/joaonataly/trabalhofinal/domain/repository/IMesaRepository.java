package br.pucrs.joaonataly.trabalhofinal.domain.repository;

import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoMesaModel;

import java.util.List;

public interface IMesaRepository {
    List<JogoMesaModel> getAllJogoMesa();
    boolean addMesa(JogoMesaModel mesaModel);
}
