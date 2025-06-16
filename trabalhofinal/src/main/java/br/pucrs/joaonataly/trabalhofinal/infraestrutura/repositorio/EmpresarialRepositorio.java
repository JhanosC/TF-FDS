package br.pucrs.joaonataly.trabalhofinal.infraestrutura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.joaonataly.trabalhofinal.dominio.entidades.Empresarial;

@Repository
public interface EmpresarialRepositorio extends JpaRepository<Empresarial, Integer> {
    List<Empresarial> findAll(); // já existe, mas você pode sobrescrever
    Empresarial findByCnpj(String cnpj);
    Boolean addEmpresarial(Empresarial empresarial);
}