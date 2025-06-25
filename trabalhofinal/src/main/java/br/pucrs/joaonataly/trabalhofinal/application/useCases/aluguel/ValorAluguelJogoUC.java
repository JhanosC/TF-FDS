package br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.AluguelDTO;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.AluguelIndentificadorDTO;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.AluguelJogoValorDTO;
import br.pucrs.joaonataly.trabalhofinal.domain.model.AluguelModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ClienteModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IAluguelRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IClienteRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Service
public class ValorAluguelJogoUC {
    private final IAluguelRepository aluguelRepository;

    public ValorAluguelJogoUC(IAluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public Optional<AluguelJogoValorDTO> executar(int codigoJogo) {
        return aluguelRepository.getValorAluguelJogo(codigoJogo)
        .map(aluguel -> AluguelJogoValorDTO.fromModel(aluguel));
    }
}
