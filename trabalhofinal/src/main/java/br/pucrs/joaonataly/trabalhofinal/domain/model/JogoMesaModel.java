package br.pucrs.joaonataly.trabalhofinal.domain.model;

import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.*;

public class JogoMesaModel extends JogoModel {
    private TipoMesaModel tipo;
    private int numeroPecas;

    public JogoMesaModel(int codigo, String nome, double valorBase, int numeroPecas, TipoMesaModel tipo) {
        super(codigo, nome, valorBase);
        this.tipo = tipo;
        this.numeroPecas = numeroPecas;
    }
    public JogoMesaModel(String nome, double valorBase, int numeroPecas, TipoMesaModel tipo) {
        super( nome, valorBase);
        this.tipo = tipo;
        this.numeroPecas = numeroPecas;
    }

    public TipoMesaModel getTipo() {
        return tipo;
    }
    public int getNumeroPecas() {
        return numeroPecas;
    }
    @Override
    public double getValorBase() {
        if(tipo == TipoMesaModel.TABULEIRO) {
            return super.getValorBase() * numeroPecas;
        }else{
            return super.getValorBase() * 1.2;
        }
    }

    @Override
    public JogoDTO toDTO(){
        return new JogoMesaDTO(
                getNome(),
                getValorBase(),
                getCodigo(),
                getTipo(),
                getNumeroPecas()
        );
    }
    
    @Override
    public String toString() {
        return "{" +
                "codigo=" + getCodigo() +
                ", nome='" + getNome() + '\'' +
                ", valorBase=" + getValorBase() +
                ", numeroPecas=" + numeroPecas +
                ", tipo=" + tipo +
                '}';
    }
}
