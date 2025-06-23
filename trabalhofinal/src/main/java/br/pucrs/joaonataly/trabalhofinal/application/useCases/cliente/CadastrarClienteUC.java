package br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.ClienteDTO;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.JogoRequestDTO;
import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CadastrarClienteUC {
    private final CadastrarIndividualUC cadastrarIndividualUC;
    private final CadastrarEmpresarialUC cadastrarEmpresarialUC;

    public CadastrarClienteUC(CadastrarIndividualUC cadastrarIndividualUC, CadastrarEmpresarialUC cadastrarEmpresarialUC) {
        this.cadastrarIndividualUC = cadastrarIndividualUC;
        this.cadastrarEmpresarialUC = cadastrarEmpresarialUC;
    }

    public boolean executar(ClienteDTO request) {
        IndividualModel individual = null;
        EmpresarialModel empresarial = null;

        if ("INDIVIDUAL".equalsIgnoreCase(request.getTipoCliente())) {
            individual = new IndividualModel(request.getNome(), request.getEndereco(), request.getCpf());
            cadastrarIndividualUC.executar(individual);
        } else if ("EMPRESARIAL".equalsIgnoreCase(request.getTipoCliente())) {
            empresarial = new EmpresarialModel(request.getNome(), request.getEndereco(), request.getNomeFantasia(), request.getCnpj());
            cadastrarEmpresarialUC.executar(empresarial);
        } else {
            throw new IllegalArgumentException("Tipo de cliente inválido: " + request.getTipoCliente());
        }

        if (individual != null)
            return true;
        else if (empresarial != null)
            return true;
        else
            return false;
    }
}
