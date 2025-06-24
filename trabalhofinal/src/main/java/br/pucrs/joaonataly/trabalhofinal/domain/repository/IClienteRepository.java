package br.pucrs.joaonataly.trabalhofinal.domain.repository;

import br.pucrs.joaonataly.trabalhofinal.domain.model.ClienteModel;

import java.util.List;
import java.util.Optional;


public interface IClienteRepository {
    Optional<ClienteModel> findById(int numero);
    List<ClienteModel> getAllClientes();
    
}
