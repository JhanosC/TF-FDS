package br.pucrs.joaonataly.trabalhofinal.application.dtos;

import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;

public class JogoEletronicoDTO implements JogoDTO {
    private String nome;
    private double valorBase;
    private int codigo;
    private TipoEletronicoModel tipo;
    private String plataforma;

    public JogoEletronicoDTO(String nome, double valorBase, int codigo, TipoEletronicoModel tipo, String plataforma) {
        this.plataforma = plataforma;
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

    public TipoEletronicoModel getTipoEletronico() {
        return tipo;
    }
    public String getPlataforma() {
        return plataforma;
    }

    public static JogoEletronicoDTO fromModel(JogoEletronicoModel model) {
        return new JogoEletronicoDTO(
                model.getNome(),
                model.getValorBase(),
                model.getCodigo(),
                model.getTipo(),
                model.getPlataforma()
        );
    }
    public JogoEletronicoDTO fromModel(JogoDTO model) {
        if (model instanceof JogoEletronicoDTO) {
            return (JogoEletronicoDTO) model;
        }
        throw new IllegalArgumentException("Model is not an instance of JogoEletronicoDTO");
    }
    
}
