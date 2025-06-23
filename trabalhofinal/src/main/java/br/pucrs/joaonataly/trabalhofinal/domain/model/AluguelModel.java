package br.pucrs.joaonataly.trabalhofinal.domain.model;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.AluguelDTO;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.Cliente;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.Jogo;
import jakarta.persistence.*;

import java.time.LocalDate;

public class AluguelModel {

    private int identificador;
    private int periodo;
    private LocalDate dataInicial;
    private ClienteModel cliente;
    private JogoModel jogo;
    private double valorFinal;
    public AluguelModel(int identificador, int periodo, LocalDate dataInicial, ClienteModel cliente, JogoModel jogo) {
        this.identificador = identificador;
        this.periodo = periodo;
        this.dataInicial = dataInicial;
        this.cliente = cliente;
        this.jogo = jogo;
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

    public ClienteModel getCliente() {
        return cliente;
    }
    public JogoModel getJogo() {
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

    public AluguelDTO toDTO() {
        return new AluguelDTO(
                this.identificador,
                this.periodo,
                this.dataInicial,
                this.cliente.toDTO(),
                this.jogo.toDTO()
        );
    }
}


