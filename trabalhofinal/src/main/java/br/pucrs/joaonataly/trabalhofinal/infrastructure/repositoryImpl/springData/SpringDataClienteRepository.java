package br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl.springData;

import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.Cliente;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
@Primary
public interface SpringDataClienteRepository extends JpaRepository<Cliente, Integer> {
}
