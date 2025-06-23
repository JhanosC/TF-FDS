package br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities;

import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.ENUM.TipoEletronico;
import jakarta.persistence.*;

@Entity
@Table(name = "jogo_eletronico")
public class JogoEletronico extends Jogo {
    @Enumerated(EnumType.STRING)
    private TipoEletronico tipo;
    @Column(nullable = false)
    private String plataforma;

    public JogoEletronico(String nome, double valorBase, String plataforma, TipoEletronico tipo) {
        super(nome, valorBase);
        this.plataforma = plataforma;
        this.tipo = tipo;
    }

    public JogoEletronico() {

    }

    public String getPlataforma() {
        return plataforma;
    }

    public TipoEletronico getTipo() {
        return tipo;
    }
}
