package br.pucrs.joaonataly.trabalhofinal.domain.model;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "modelo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = JogoEletronicoModel.class, name = "jogo_eletronico"),
        @JsonSubTypes.Type(value = JogoMesaModel.class, name = "jogo_mesa")
})
public abstract class JogoModel {
    private int codigo;
    private String nome;
    private double valorBase;

    public JogoModel(int codigo, String nome, double valorBase) {
        this.nome = nome;
        this.codigo = codigo;
        this.valorBase = valorBase;
    }
    public JogoModel(String nome, double valorBase) {
        this.nome = nome;
        this.valorBase = valorBase;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValorBase() {
        return valorBase;
    }

    public JogoDTO toDTO(){
        return null;
    }
}
