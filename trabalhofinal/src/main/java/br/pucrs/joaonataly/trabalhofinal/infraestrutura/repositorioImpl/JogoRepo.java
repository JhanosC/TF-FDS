package br.pucrs.joaonataly.trabalhofinal.infraestrutura.repositorioImpl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucrs.joaonataly.trabalhofinal.adaptadorInterface.repositorio.IJogoRepo;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;

@Repository
public class JogoRepo implements IJogoRepo{
    private List<JogoModel> jogos;
    
    public JogoRepo() {
        jogos = new LinkedList<>();
        jogos.add(new JogoEletronicoModel(00,"Jogo0",10.0,"PC",TipoEletronicoModel.AVENTURA));
        jogos.add(new JogoEletronicoModel(01,"Jogo1",20.0,"PS5",TipoEletronicoModel.ESTRATEGIA));
        jogos.add(new JogoEletronicoModel(02,"Jogo2",30.0,"XBOX",TipoEletronicoModel.SIMULACAO));
        jogos.add(new JogoEletronicoModel(03,"Jogo3",40.0,"PC",TipoEletronicoModel.AVENTURA));
    }
    public List<JogoModel> getAllJogos(){
        return jogos;
    }
}
