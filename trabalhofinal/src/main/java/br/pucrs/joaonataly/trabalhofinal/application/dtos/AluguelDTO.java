package br.pucrs.joaonataly.trabalhofinal.application.dtos;

import java.time.LocalDate;

import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.BuscaClienteIdUC;
import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.Cliente;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.Jogo;

public class AluguelDTO {
    private int identificador;
    private int clienteNumero;
    private int jogoCodigo;
    private int periodo;
    private LocalDate dataInicial;

    public AluguelDTO(int identificador, int periodo, LocalDate dataInicial, int clienteNumero, int jogoCodigo) {
        this.identificador = identificador;
        this.periodo = periodo;
        this.dataInicial = dataInicial;
        this.clienteNumero = clienteNumero;
        this.jogoCodigo = jogoCodigo;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getClienteNumero() {
        return clienteNumero;
    }

    public void setClienteNumero(int clienteNumero) {
        this.clienteNumero = clienteNumero;
    }

    public int getJogoCodigo() {
        return jogoCodigo;
    }

    public void setJogoCodigo(int jogoCodigo) {
        this.jogoCodigo = jogoCodigo;
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

    public AluguelModel toModel(ClienteModel cliente, JogoModel jogo) {
        return new AluguelModel(
                identificador,
                periodo,
                dataInicial,
                cliente,
                jogo
        );
    }
}
