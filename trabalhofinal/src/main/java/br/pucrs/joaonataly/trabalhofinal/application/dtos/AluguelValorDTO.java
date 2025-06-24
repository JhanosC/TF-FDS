package br.pucrs.joaonataly.trabalhofinal.application.dtos;
import br.pucrs.joaonataly.trabalhofinal.domain.model.AluguelModel;

import java.time.LocalDate;

public class AluguelValorDTO {
    private int identificador;
    private int clienteNumero;
    private int jogoCodigo;
    private int periodo;
    private LocalDate dataInicial;
    private double valorJogo;
    
    public AluguelValorDTO(int identificador, int periodo, LocalDate dataInicial, int clienteNumero, int jogoCodigo, double valorJogo) {
        this.identificador = identificador;
        this.periodo = periodo;
        this.dataInicial = dataInicial;
        this.clienteNumero = clienteNumero;
        this.jogoCodigo = jogoCodigo;
        this.valorJogo = valorJogo;
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

    public double getValorJogo() {
        return valorJogo;
    }

    public void setValorJogo(double valorJogo) {
        this.valorJogo = valorJogo;
    }
    
    public static AluguelValorDTO fromModel(AluguelModel aluguel) {
        return  new AluguelValorDTO(
                aluguel.getIdentificador(),
                aluguel.getPeriodo(),
                aluguel.getDataInicial(),
                aluguel.getCliente().getNumero(),
                aluguel.getJogo().getCodigo(),
                aluguel.getValorFinal()
        );
    }
}
