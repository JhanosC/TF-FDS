package br.pucrs.joaonataly.trabalhofinal.application.dtos;

import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.*;

public class JogoMesaDTO implements JogoDTO {
    private String nome;
    private double valorBase;
    private int codigo;
    private TipoMesaModel tipo;
    private int numeroPecas;

    public JogoMesaDTO(String nome, double valorBase, int codigo, TipoMesaModel tipo, int numeroPecas) {
        this.numeroPecas = numeroPecas;
        this.nome = nome;
        this.valorBase = valorBase;
        this.codigo = codigo;
        this.tipo = tipo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getValorBase() {
        return valorBase;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    public TipoMesaModel getTipoMesa() {
        return tipo;
    }
    public int getNumeroPecas() {
        return numeroPecas;
    }
    
    // @Override
    // public static JogoDTO fromModel(JogoModel model) {
    //     return new JogoMesaDTO(
    //             model.getNome(),
    //             model.getValorBase(),
    //             model.getCodigo(),
    //             model.getTipo(),
    //             model.getNumeroPecas()
    //     );
    // }
}
