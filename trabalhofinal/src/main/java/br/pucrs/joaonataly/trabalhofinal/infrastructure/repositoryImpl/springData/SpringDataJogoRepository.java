package br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl.springData;

import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.Jogo;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface SpringDataJogoRepository extends JpaRepository<Jogo, Integer> {

}
