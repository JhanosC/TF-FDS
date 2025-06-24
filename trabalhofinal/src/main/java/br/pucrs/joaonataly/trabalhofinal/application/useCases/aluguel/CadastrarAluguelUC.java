package br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.AluguelDTO;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.BuscaClienteIdUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo.BuscaJogoIdUC;
import br.pucrs.joaonataly.trabalhofinal.domain.model.AluguelModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IAluguelRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IClienteRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IJogoRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.services.AluguelService;
import org.springframework.stereotype.Service;

@Service
public class CadastrarAluguelUC {
    private final IAluguelRepository aluguelRepository;
    private final BuscaClienteIdUC buscaClienteIdUC;
    private final BuscaJogoIdUC buscaJogoIdUC;
    private final AluguelService aluguelService;
    public CadastrarAluguelUC(IAluguelRepository aluguelRepository, AluguelService aluguelService,
                              BuscaClienteIdUC buscaClienteIdUC, BuscaJogoIdUC buscaJogoIdUC){
        this.aluguelRepository = aluguelRepository;
        this.aluguelService = aluguelService;
        this.buscaClienteIdUC = buscaClienteIdUC;
        this.buscaJogoIdUC = buscaJogoIdUC;
    }
    public boolean executar(AluguelDTO aluguelDTO) {
        var clienteDTO = buscaClienteIdUC.executar(aluguelDTO.getClienteNumero())
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado: " + aluguelDTO.getClienteNumero()));
        var jogoDTO = buscaJogoIdUC.executar(aluguelDTO.getJogoCodigo())
            .orElseThrow(() -> new RuntimeException("Jogo não encontrado: " + aluguelDTO.getJogoCodigo()));
    
        return aluguelRepository.addAluguel(aluguelDTO.toModel(clienteDTO.toModel(), jogoDTO.toModel()));
    }
    
}
