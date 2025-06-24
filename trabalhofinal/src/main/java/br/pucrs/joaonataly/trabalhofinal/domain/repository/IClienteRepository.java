package br.pucrs.joaonataly.trabalhofinal.domain.repository;

import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.Aluguel;

import java.util.List;
import java.util.Optional;


public interface IClienteRepository {
    Optional<ClienteModel> findById(int numero);
    List<ClienteModel> getAllClientes();
}
