package br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo;

import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IEletronicoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastrarEletronicoUC {
    private final IEletronicoRepository eletronicoRepository;

    public CadastrarEletronicoUC(IEletronicoRepository eletronicoRepository) {
        this.eletronicoRepository = eletronicoRepository;
    }
    public JogoEletronicoModel executar(JogoEletronicoModel jogoEletronicoModel) {
        eletronicoRepository.addEletronico(jogoEletronicoModel);
        return jogoEletronicoModel;

    }
}
