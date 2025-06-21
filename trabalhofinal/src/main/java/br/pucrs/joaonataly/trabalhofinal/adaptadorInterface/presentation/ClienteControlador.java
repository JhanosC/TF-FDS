package br.pucrs.joaonataly.trabalhofinal.adaptadorInterface.presentation;

import java.util.ArrayList;
import java.util.List;

import br.pucrs.joaonataly.trabalhofinal.application.useCases.BuscaClienteIdUC;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IClienteRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.pucrs.joaonataly.trabalhofinal.domain.repository.IEmpresarialRepository;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.ListaTodosJogosUC;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Cliente;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Empresarial;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.*;

@RestController
@RequestMapping("/acmegames")
public class ClienteControlador {
    @Autowired
    private IEmpresarialRepository empresarialRepositorio;
    @Autowired
    private IndividualRepository individualRepository;
    @Autowired
    private ListaTodosJogosUC listaTodosJogosUC;
    private BuscaClienteIdUC buscaClienteIdUC;

    public ClienteControlador(IEmpresarialRepository empresarialRepositorio, IndividualRepository individualRepository, ListaTodosJogosUC listaTodosJogosUC, BuscaClienteIdUC buscaClienteIdUC) {
        this.empresarialRepositorio = empresarialRepositorio;
        this.individualRepository = individualRepository;
        this.listaTodosJogosUC = listaTodosJogosUC;
        this.buscaClienteIdUC = buscaClienteIdUC;
    }

    @GetMapping
    public List<Cliente> listarTodosClientes() {
        List<Cliente> todos = new ArrayList<>();
        todos.addAll(individualRepository.findAll());
        todos.addAll(empresarialRepositorio.findAll());
        return todos;
    }

    @GetMapping("/empresarial")
    public Empresarial listEmpresarial(@RequestParam String cnpj) {
        return empresarialRepositorio.findByCnpj(cnpj);
    }

    @GetMapping("/jogos")
    public List<JogoDTO> listarTodosJogos() {
        return listaTodosJogosUC.execute();
    }

    @PostMapping("/validacliente")
    public boolean validaCliente(@RequestBody ClienteNumeroDTO numeroDTO) {
        return buscaClienteIdUC.executar(numeroDTO.getNumero()).isPresent();
    }


}
