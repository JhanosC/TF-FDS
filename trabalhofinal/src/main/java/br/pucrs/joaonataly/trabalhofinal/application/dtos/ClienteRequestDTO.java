package br.pucrs.joaonataly.trabalhofinal.application.dtos;

public class ClienteRequestDTO {
    private String tipoCliente;

    private String nome;
    private String endereco;

    // Campos para Cliente Individual
    private String cpf;

    // Campos para Cliente Empresarial
    private String nomeFantasia;
    private String cnpj;

    // Getters
    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }
}

