package br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identificador;

    @Column(nullable = false)
    private int periodo;

    @Column(nullable = false)
    private LocalDate dataInicial;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;
    private double valorFinal;

    protected Aluguel() {}

    public Aluguel(int periodo, LocalDate dataInicial, Cliente cliente, Jogo jogo, double valorFinal ) {
       this.periodo = periodo;
       this.dataInicial = dataInicial;
       this.cliente = cliente;
       this.jogo = jogo;
       this.valorFinal = valorFinal;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public Jogo getJogo() {
        return jogo;
    }
    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}
