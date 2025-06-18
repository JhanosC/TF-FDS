package br.pucrs.joaonataly.trabalhofinal.domain.model;

import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.*;

public class JogoMesaModel extends JogoModel {
    private TipoMesaModel tipo;
    private int numeroPecas;

    public JogoMesaModel(int codigo, String nome, double valorBase, String fabricante, TipoMesaModel tipo, int numeroPecas) {
        super(codigo, nome, valorBase);
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
    public JogoDTO toDTO(){
        return new JogoMesaDTO(
                getNome(),
                getValorBase(),
                getCodigo(),
                getTipo(),
                getNumeroPecas()
        );
    }
    
}
