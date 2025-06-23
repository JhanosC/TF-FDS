package br.pucrs.joaonataly.trabalhofinal.domain.repository;

import java.util.List;

import br.pucrs.joaonataly.trabalhofinal.domain.model.EmpresarialModel;

public interface IEmpresarialRepository {
    List<EmpresarialModel> getAllEmpresarial();
    boolean addEmpresarial(EmpresarialModel empresarialModel);
}