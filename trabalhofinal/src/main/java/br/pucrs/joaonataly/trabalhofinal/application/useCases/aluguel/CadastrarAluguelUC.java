package br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel;

import br.pucrs.joaonataly.trabalhofinal.domain.model.AluguelModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IAluguelRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.services.AluguelService;
import org.springframework.stereotype.Service;

@Service
public class CadastrarAluguelUC {
    private final IAluguelRepository aluguelRepository;
    private final AluguelService aluguelService;
    public CadastrarAluguelUC(IAluguelRepository aluguelRepository, AluguelService aluguelService) {
        this.aluguelRepository = aluguelRepository;
        this.aluguelService = aluguelService;
    }
    public boolean executar(AluguelModel aluguelModel) {
        double valorFinal = AluguelService.calcularValorFinal(aluguelModel);
        aluguelModel.setValorFinal(valorFinal); // ou outro setter que você usar
        return aluguelRepository.addAluguel(aluguelModel);
    }
}
