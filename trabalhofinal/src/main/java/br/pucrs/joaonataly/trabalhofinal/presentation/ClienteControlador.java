package br.pucrs.joaonataly.trabalhofinal.presentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.joaonataly.trabalhofinal.infrastructure.entities.Cliente;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.entities.Empresarial;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.repositorio.EmpresarialRepositorio;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.repositorio.IndividualRepositorio;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {
    @Autowired
    private EmpresarialRepositorio empresarialRepositorio;
    @Autowired
    private IndividualRepositorio individualRepositorio;

    public ClienteControlador(EmpresarialRepositorio empresarialRepositorio, IndividualRepositorio individualRepositorio) {
        this.empresarialRepositorio = empresarialRepositorio;
        this.individualRepositorio = individualRepositorio;
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
}
