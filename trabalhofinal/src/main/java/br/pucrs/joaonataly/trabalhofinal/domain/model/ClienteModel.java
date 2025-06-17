package br.pucrs.joaonataly.trabalhofinal.domain.model;

public class ClienteModel {
    private int numero;
    private String nome;
    private String endereco;

    public ClienteModel(int numero, String nome, String endereco) {
        this.numero = numero;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
}
