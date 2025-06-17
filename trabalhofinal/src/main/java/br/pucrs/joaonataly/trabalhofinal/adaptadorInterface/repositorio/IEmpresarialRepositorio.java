package br.pucrs.joaonataly.trabalhofinal.adaptadorInterface.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Empresarial;

@Repository
public interface IEmpresarialRepositorio extends JpaRepository<Empresarial, Integer> {
    List<Empresarial> findAll();
    Empresarial findByCnpj(String cnpj);
}