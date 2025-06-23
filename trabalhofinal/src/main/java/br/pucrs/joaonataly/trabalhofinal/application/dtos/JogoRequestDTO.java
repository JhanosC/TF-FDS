package br.pucrs.joaonataly.trabalhofinal.application.dtos;

public class JogoRequestDTO {
    private String tipoJogo;

    private String nome;
    private double valorBase;

    // Campos para Jogo Eletrônico
    private String plataforma;
    private String tipoEletronico;

    // Campos para Jogo de Mesa
    private Integer numeroPecas;
    private String tipoMesa;

    public String getTipoJogo() {
        return tipoJogo;
    }

    public String getNome() {
        return nome;
    }

    public double getValorBase() {
        return valorBase;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getTipoEletronico() {
        return tipoEletronico;
    }

    public Integer getNumeroPecas() {
        return numeroPecas;
    }

    public String getTipoMesa() {
        return tipoMesa;
    }
}
