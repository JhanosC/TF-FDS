package br.pucrs.joaonataly.trabalhofinal.domain.repository;

import br.pucrs.joaonataly.trabalhofinal.domain.model.EmpresarialModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoMesaModel;

import java.util.List;

public interface IEletronicoRepository {
    List<JogoEletronicoModel> getAllJogoEletronico();
    boolean addEletronico(JogoEletronicoModel eletronicoModel);
}
