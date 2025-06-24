package br.pucrs.joaonataly.trabalhofinal.domain.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = IndividualModel.class, name = "individual"),
        @JsonSubTypes.Type(value = EmpresarialModel.class, name = "empresarial")
})
public abstract class ClienteModel {
    private int numero;
    private String nome;
    private String endereco;

    public ClienteModel(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public ClienteModel(int numero, String nome, String endereco) {
        this.numero = numero;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
}
