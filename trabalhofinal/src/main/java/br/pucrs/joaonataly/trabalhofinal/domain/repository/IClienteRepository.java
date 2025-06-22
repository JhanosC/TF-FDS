package br.pucrs.joaonataly.trabalhofinal.domain.repository;

import br.pucrs.joaonataly.trabalhofinal.domain.model.ClienteModel;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Cliente;

import java.util.List;
import java.util.Optional;


public interface IClienteRepository {

    Optional<ClienteModel> buscarPorId(int numero);


    List<Cliente> getAllClientes();
}
