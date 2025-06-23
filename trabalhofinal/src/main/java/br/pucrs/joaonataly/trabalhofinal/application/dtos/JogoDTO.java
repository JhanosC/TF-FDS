package br.pucrs.joaonataly.trabalhofinal.application.dtos;
import br.pucrs.joaonataly.trabalhofinal.domain.model.*;

public interface JogoDTO {
    String getNome();
    double getValorBase();
    int getCodigo();
    JogoModel toModel();
}
