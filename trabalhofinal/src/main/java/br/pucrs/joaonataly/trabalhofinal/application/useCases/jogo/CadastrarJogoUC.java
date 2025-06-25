package br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.JogoRequestDTO;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoMesaModel;
import org.springframework.stereotype.Service;

@Service
public class CadastrarJogoUC {
    private final CadastrarEletronicoUC cadastrarEletronicoUC;
    private final CadastrarMesaUC cadastrarMesaUC;
    private final BuscaJogoIdUC buscaJogoIdUC;

    public CadastrarJogoUC(CadastrarEletronicoUC cadastrarEletronicoUC, CadastrarMesaUC cadastrarMesaUC,
    BuscaJogoIdUC buscaJogoIdUC) {
        this.cadastrarEletronicoUC = cadastrarEletronicoUC;
        this.cadastrarMesaUC = cadastrarMesaUC;
        this.buscaJogoIdUC = buscaJogoIdUC;
    }

    public boolean executar(JogoRequestDTO request) {
        if(buscaJogoIdUC.executar(request.getCodigo()).isPresent()){
            throw new IllegalArgumentException("ID já registrado: ");
        }
        JogoEletronicoModel eletronico = null;
        JogoMesaModel mesa = null;

        if ("ELETRONICO".equalsIgnoreCase(request.getTipoJogo())) {
            var jogo = new JogoEletronicoModel(
                    request.getNome(),
                    request.getValorBase(),
                    request.getPlataforma(),
                    TipoEletronicoModel.valueOf(request.getTipoEletronico().toString())
            );
            eletronico = cadastrarEletronicoUC.executar(jogo);
        } else if ("MESA".equalsIgnoreCase(request.getTipoJogo())) {
            var jogo = new JogoMesaModel(
                    request.getNome(),
                    request.getValorBase(),
                    request.getNumeroPecas(),
                    TipoMesaModel.valueOf(request.getTipoMesa().toString())
            );
            mesa = cadastrarMesaUC.executar(jogo);
        } else {
            throw new IllegalArgumentException("Tipo de jogo inválido: " + request.getTipoJogo());
        }

        if (eletronico != null)
            return true;
        else if (mesa != null)
            return true;
        else
            return false;
    }
}
