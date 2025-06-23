package br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.ENUM.TipoMesa;
import jakarta.persistence.*;

@Entity
@Table(name = "jogo_mesa")
public class JogoMesa extends Jogo{
    @Enumerated(EnumType.STRING)
    private TipoMesa tipo;
    @Column(nullable = false)
    private int numeroPecas;

    public JogoMesa(String nome, double valorBase, int numeroPecas, TipoMesa tipo) {
        super(nome, valorBase);
        this.numeroPecas = numeroPecas;
        this.tipo = tipo;
    }

    public JogoMesa() {

    }

    public int getNumeroPecas() {
        return numeroPecas;
    }

    public TipoMesa getTipo() {
        return tipo;
    }
}


