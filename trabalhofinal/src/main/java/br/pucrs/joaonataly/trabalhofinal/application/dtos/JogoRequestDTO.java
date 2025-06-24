package br.pucrs.joaonataly.trabalhofinal.application.dtos;

import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;

public class JogoRequestDTO {

    private String nome;
    private double valorBase;

    // Campos para Jogo Eletrônico
    private String plataforma;
    private TipoEletronicoModel tipoEletronico;
    

    // Campos para Jogo de Mesa
    private Integer numeroPecas;
    private TipoMesaModel tipoMesa;

    public JogoRequestDTO(String nome, double valorBase, String plataforma, TipoEletronicoModel tipoEletronico, Integer numeroPecas, TipoMesaModel tipoMesa) {
        this.nome = nome;
        this.valorBase = valorBase;
        this.plataforma = plataforma;
        this.tipoEletronico = tipoEletronico;
        this.numeroPecas = numeroPecas;
        this.tipoMesa = tipoMesa;
    }

    public String getNome() {
        return nome;
    }

    public double getValorBase() {
        return valorBase;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public TipoEletronicoModel getTipoEletronico() {
        return tipoEletronico;
    }

    public Integer getNumeroPecas() {
        return numeroPecas;
    }

    public TipoMesaModel getTipoMesa() {
        return tipoMesa;
    }

    public String getTipoJogo() {
        if (tipoEletronico != null) {
            return "ELETRONICO";
        } else if (numeroPecas != null && tipoMesa != null) {
            return "MESA";
        } else {
            throw new IllegalArgumentException("Tipo de jogo não especificado corretamente.");
        }
    }
    
}
