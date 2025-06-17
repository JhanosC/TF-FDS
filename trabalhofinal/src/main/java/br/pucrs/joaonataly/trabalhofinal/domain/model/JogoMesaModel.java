package br.pucrs.joaonataly.trabalhofinal.domain.model;

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
    
}
