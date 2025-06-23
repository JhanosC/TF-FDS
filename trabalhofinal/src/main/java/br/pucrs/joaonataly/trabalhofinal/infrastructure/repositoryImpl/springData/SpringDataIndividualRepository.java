package br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl.springData;

import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.Individual;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Primary
public interface SpringDataIndividualRepository extends JpaRepository<Individual, Integer> {
    List<Individual> findAll();
}

