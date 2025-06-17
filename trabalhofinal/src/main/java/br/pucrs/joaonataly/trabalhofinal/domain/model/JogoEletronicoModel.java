package br.pucrs.joaonataly.trabalhofinal.domain.model;

public class JogoEletronicoModel extends JogoModel {
    private TipoEletronicoModel tipo;
    private String plataforma;

    public JogoEletronicoModel(int codigo, String nome, double valorBase, String plataforma, TipoEletronicoModel tipo) {
        super(codigo, nome, valorBase);
        this.plataforma = plataforma;
        this.tipo = tipo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public TipoEletronicoModel getTipo() {
        return tipo;
    }


}
