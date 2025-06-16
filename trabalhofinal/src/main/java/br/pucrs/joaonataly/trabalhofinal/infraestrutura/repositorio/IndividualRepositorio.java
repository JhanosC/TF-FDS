package br.pucrs.joaonataly.trabalhofinal.infraestrutura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.joaonataly.trabalhofinal.dominio.entidades.Individual;

@Repository
public interface IndividualRepositorio extends JpaRepository<Individual, Integer> {
    List<Individual> findAll(); // já existe, mas você pode sobrescrever
}
