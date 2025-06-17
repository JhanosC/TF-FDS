package br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes_individual")
public class Individual extends Cliente {

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    public Individual() {}

    public Individual(String nome, String endereco, String cpf) {
        super(nome, endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "cpf='" + cpf + '\'' +
                ", numero=" + getNumero() +
                ", nome='" + getNome() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                '}';
    }
}
