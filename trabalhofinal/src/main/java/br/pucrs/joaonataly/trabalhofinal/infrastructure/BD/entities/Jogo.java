package br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double valorBase;

    protected Jogo() {}

    public Jogo(String nome, double valorBase) {
        this.nome = nome;
        this.valorBase = valorBase;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    
}
