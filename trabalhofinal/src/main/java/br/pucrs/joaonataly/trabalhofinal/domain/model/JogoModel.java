package br.pucrs.joaonataly.trabalhofinal.domain.model;

public abstract class JogoModel {
    private int codigo;
    private String nome;
    private double valorBase;

    public JogoModel(int codigo, String nome, double valorBase) {
        this.nome = nome;
        this.codigo = codigo;
        this.valorBase = valorBase;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValorBase() {
        return valorBase;
    }
}
