package br.pucrs.joaonataly.trabalhofinal.adaptadorInterface.presentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.joaonataly.trabalhofinal.adaptadorInterface.repositorio.IEmpresarialRepositorio;
import br.pucrs.joaonataly.trabalhofinal.adaptadorInterface.repositorio.IndividualRepositorio;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.ListaTodosJogosUC;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoModel;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Cliente;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Empresarial;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.*;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {
    @Autowired
    private IEmpresarialRepositorio empresarialRepositorio;
    @Autowired
    private IndividualRepositorio individualRepositorio;
    @Autowired
    private ListaTodosJogosUC listaTodosJogosUC;

    public ClienteControlador(IEmpresarialRepositorio empresarialRepositorio, IndividualRepositorio individualRepositorio, ListaTodosJogosUC listaTodosJogosUC) {
        this.empresarialRepositorio = empresarialRepositorio;
        this.individualRepositorio = individualRepositorio;
        this.listaTodosJogosUC = listaTodosJogosUC;
    }

    @GetMapping
    public List<Cliente> listarTodosClientes() {
        List<Cliente> todos = new ArrayList<>();
        todos.addAll(individualRepositorio.findAll());
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
}
