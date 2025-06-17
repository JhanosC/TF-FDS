package br.pucrs.joaonataly.trabalhofinal.adaptadorInterface.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Individual;

@Repository
public interface IndividualRepositorio extends JpaRepository<Individual, Integer> {
    List<Individual> findAll();
}
