package br.pucrs.joaonataly.trabalhofinal.infrastructure.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.joaonataly.trabalhofinal.infrastructure.entities.Individual;

@Repository
public interface IndividualRepositorio extends JpaRepository<Individual, Integer> {
    List<Individual> findAll(); // já existe, mas você pode sobrescrever
}
