package br.pucrs.joaonataly.trabalhofinal.infraestrutura.repositoryImpl;

import br.pucrs.joaonataly.trabalhofinal.domain.model.ClienteModel;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Cliente;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
@Primary
public interface SpringDataClienteRepository extends JpaRepository<Cliente, Integer> {
}
