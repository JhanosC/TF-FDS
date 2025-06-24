package br.pucrs.joaonataly.trabalhofinal.domain.repository;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.AluguelDTO;
import br.pucrs.joaonataly.trabalhofinal.domain.model.AluguelModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ClienteModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoEletronicoModel;

import java.util.List;
import java.util.Optional;

public interface IAluguelRepository {
    Optional<AluguelModel> findById(int identificador);
    List<AluguelModel> getAllAluguel();
    boolean addAluguel(AluguelModel aluguelModel);
    List<AluguelModel> getAluguelModelsDeCliente(int numeroCliente);
    List<AluguelModel> getAluguelModelsDeJogo(int codigoJogo);
    Optional<AluguelModel> getValorAluguelJogo(int codigoJogo);
    Optional<AluguelModel> getAluguelValorFinal(int indenficadorAluguel);
}
