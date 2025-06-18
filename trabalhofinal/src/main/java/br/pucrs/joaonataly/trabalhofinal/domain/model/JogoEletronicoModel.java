package br.pucrs.joaonataly.trabalhofinal.domain.model;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.JogoDTO;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.JogoEletronicoDTO;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;

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

    @Override
    public JogoDTO toDTO(){
        return new JogoEletronicoDTO(
                getNome(),
                getValorBase(),
                getCodigo(),
                getTipo(),
                getPlataforma()
        );
    }


}
