package br.pucrs.joaonataly.trabalhofinal.domain.model;

public class IndividualModel extends ClienteModel {
    private String cpf;

    public IndividualModel(int numero, String nome, String endereco, String cpf) {
        super(numero, nome, endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
}
