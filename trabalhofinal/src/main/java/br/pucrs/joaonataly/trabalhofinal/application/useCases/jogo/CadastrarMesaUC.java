package br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo;

import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IMesaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastrarMesaUC {
    private final IMesaRepository mesaRepository;

    public CadastrarMesaUC(IMesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }
    public JogoMesaModel executar(JogoMesaModel jogoMesaModel) {
        mesaRepository.addMesa(jogoMesaModel);
        return jogoMesaModel;
    }
}
