package br.pucrs.joaonataly.trabalhofinal.domain.model;

public class EmpresarialModel extends ClienteModel {
    private String cnpj;
    private String nomeFantasia;

    public EmpresarialModel(int numero, String nome, String endereco, String cnpj, String nomeFantasia) {
        super(numero, nome, endereco);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }
    public EmpresarialModel( String nome, String endereco, String cnpj, String nomeFantasia) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    
}
