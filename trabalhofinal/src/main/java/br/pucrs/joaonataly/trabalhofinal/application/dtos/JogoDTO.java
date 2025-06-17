package br.pucrs.joaonataly.trabalhofinal.application.dtos;

public interface JogoDTO {
    String getNome();
    double getValorBase();
    int getCodigo();
    JogoDTO fromModel(JogoDTO model);
}
