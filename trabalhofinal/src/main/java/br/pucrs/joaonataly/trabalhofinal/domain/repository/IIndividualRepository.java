package br.pucrs.joaonataly.trabalhofinal.domain.repository;

import java.util.List;

import br.pucrs.joaonataly.trabalhofinal.domain.model.IndividualModel;

public interface IIndividualRepository  {
    List<IndividualModel> getAllIndividual();
    boolean addIndividual(IndividualModel indiividualModel);
}
