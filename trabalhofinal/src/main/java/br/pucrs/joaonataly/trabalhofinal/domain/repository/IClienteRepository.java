package br.pucrs.joaonataly.trabalhofinal.domain.repository;

import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Cliente;

import java.util.Optional;


public interface IClienteRepository {

    Optional<Cliente> buscarPorId(int numero);
}
