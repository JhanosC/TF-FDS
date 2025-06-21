package br.pucrs.joaonataly.trabalhofinal.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Empresarial;

@Repository
public interface IEmpresarialRepository extends JpaRepository<Empresarial, Integer> {
    List<Empresarial> findAll();
    Empresarial findByCnpj(String cnpj);
}