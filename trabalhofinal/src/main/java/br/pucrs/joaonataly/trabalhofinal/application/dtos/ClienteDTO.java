package br.pucrs.joaonataly.trabalhofinal.application.dtos;

import br.pucrs.joaonataly.trabalhofinal.domain.model.*;

public class ClienteDTO {
    private String tipoCliente;

    private String nome;
    private String endereco;
    private int numero;

    // Campos para Cliente Individual
    private String cpf;

    // Campos para Cliente Empresarial
    private String nomeFantasia;
    private String cnpj;

    public ClienteDTO(int numero, String tipoCliente, String nome, String endereco, String cpf, String nomeFantasia, String cnpj) {
        this.tipoCliente = tipoCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.numero = numero;
    }
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
    public int getNumero() {
        return numero;
    }
    public ClienteModel toModel() {
        if ("INDIVIDUAL".equals(tipoCliente)) {
            return new IndividualModel(numero, nome, endereco, cpf);
        } else if ("EMPRESARIAL".equals(tipoCliente)) {
            return new EmpresarialModel(numero, nome, endereco, nomeFantasia, cnpj);
        }
        return null;
    }
}

