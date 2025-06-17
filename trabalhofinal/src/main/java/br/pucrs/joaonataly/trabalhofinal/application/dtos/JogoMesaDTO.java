package br.pucrs.joaonataly.trabalhofinal.application.dtos;

import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;

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
    
    public static JogoMesaDTO fromModel(JogoMesaModel model) {
        return new JogoMesaDTO(
                model.getNome(),
                model.getValorBase(),
                model.getCodigo(),
                model.getTipo(),
                model.getNumeroPecas()
        );
    }

    public JogoMesaDTO fromModel(JogoDTO model) {
        if (model instanceof JogoMesaDTO) {
            return (JogoMesaDTO) model;
        }
        throw new IllegalArgumentException("Model is not an instance of JogoMesaDTO");
    }
}
