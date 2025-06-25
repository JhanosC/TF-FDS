package br.pucrs.joaonataly.trabalhofinal.application.dtos;
import br.pucrs.joaonataly.trabalhofinal.domain.model.AluguelModel;

import java.time.LocalDate;

public class AluguelValorFinalDTO {
    private int identificador;
    private int clienteNumero;
    private int jogoCodigo;
    private int periodo;
    private LocalDate dataInicial;
    private double valorFinal;
    
    public AluguelValorFinalDTO(int identificador, int periodo, LocalDate dataInicial, int clienteNumero, int jogoCodigo, double valorFinal) {
        this.identificador = identificador;
        this.periodo = periodo;
        this.dataInicial = dataInicial;
        this.clienteNumero = clienteNumero;
        this.jogoCodigo = jogoCodigo;
        this.valorFinal = valorFinal;
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
        return valorFinal;
    }

    public void setValorJogo(double valorFinal) {
        this.valorFinal = valorFinal;
    }
    
    public static AluguelValorFinalDTO fromModel(AluguelModel aluguel) {
        return  new AluguelValorFinalDTO(
                aluguel.getIdentificador(),
                aluguel.getPeriodo(),
                aluguel.getDataInicial(),
                aluguel.getCliente().getNumero(),
                aluguel.getJogo().getCodigo(),
                aluguel.getValorFinal()
        );
    }

    @Override
    public String toString() {
        return "AluguelValorFinalDTO{" +
                "identificador=" + identificador +
                ", clienteNumero=" + clienteNumero +
                ", jogoCodigo=" + jogoCodigo +
                ", periodo=" + periodo +
                ", dataInicial=" + dataInicial +
                ", valorFinal=" + valorFinal +
                '}';
    }
}
