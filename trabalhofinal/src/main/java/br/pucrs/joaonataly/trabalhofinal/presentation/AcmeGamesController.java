package br.pucrs.joaonataly.trabalhofinal.presentation;

import java.util.List;
import java.util.Optional;

import br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel.*;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.*;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import org.springframework.web.bind.annotation.*;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/acmegames")
public class AcmeGamesController {

    private final ListaTodosJogosUC listaTodosJogosUC;
    private final BuscaClienteIdUC buscaClienteIdUC;
    private final BuscaJogoIdUC buscaJogoIdUC;
    private final BuscaAluguelIdUC buscaAluguelIdUC;
    private final ListaTodosClientesUC listaTodosClientesUC;
    private final ListaTodosAlugueisUC listaTodosAlugueisUC;
    private final CadastrarJogoUC cadastrarJogoUC;
    private final CadastrarClienteUC cadastrarClienteUC;
    private final CadastrarAluguelUC cadastrarAluguelUC;
    private final ListaAlugueisClienteUC listaAlugueisClienteUC;
    private final ListaAlugueisJogoUC listaAlugueisJogoUC;
    private final ValorAluguelJogoUC valorAluguelJogoUC;
    private final ValorFinalAluguelUC valorFinalAluguelUC;

    public AcmeGamesController(
        ListaTodosJogosUC listaTodosJogosUC, BuscaClienteIdUC buscaClienteIdUC, ListaTodosClientesUC listaTodosClientesUC,
        BuscaJogoIdUC buscaJogoIdUC, BuscaAluguelIdUC buscaAluguelIdUC,ListaTodosAlugueisUC listaTodosAlugueisUC,
        CadastrarJogoUC cadastrarJogoUC, CadastrarClienteUC cadastrarClienteUC, CadastrarAluguelUC cadastrarAluguelUC,
        ListaAlugueisClienteUC listaAlugueisClienteUC, ListaAlugueisJogoUC listaAlugueisJogoUC, ValorAluguelJogoUC valorAluguelJogoUC,
        ValorFinalAluguelUC valorFinalAluguelUC) {
        this.cadastrarAluguelUC = cadastrarAluguelUC;
        this.listaTodosJogosUC = listaTodosJogosUC;
        this.buscaClienteIdUC = buscaClienteIdUC;
        this.listaTodosClientesUC = listaTodosClientesUC;
        this.buscaJogoIdUC = buscaJogoIdUC;
        this.buscaAluguelIdUC = buscaAluguelIdUC;
        this.listaTodosAlugueisUC = listaTodosAlugueisUC;
        this.cadastrarJogoUC = cadastrarJogoUC;
        this.cadastrarClienteUC = cadastrarClienteUC;
        this.listaAlugueisClienteUC = listaAlugueisClienteUC;
        this.listaAlugueisJogoUC = listaAlugueisJogoUC;
        this.valorAluguelJogoUC = valorAluguelJogoUC;
        this.valorFinalAluguelUC = valorFinalAluguelUC;
    }
    @GetMapping("/")
    public String hello() {
        return "API ACME Games no ar!";
    }
    @PostMapping("/validajogo")
    public boolean validaJogo(@RequestBody JogoCodigoDTO codigoDTO) {
        return  buscaJogoIdUC.executar(codigoDTO.getCodigo()).isPresent();
    }
    @PostMapping("/validacliente")
    public boolean validaCliente(@RequestBody ClienteNumeroDTO numeroDTO) {
        return  buscaClienteIdUC.executar(numeroDTO.getNumero()).isPresent();
    }
    @PostMapping("/validaaluguel")
    public boolean validaAluguel(@RequestBody AluguelIndentificadorDTO identificadorDTO) {
        return  buscaAluguelIdUC.executar(identificadorDTO.getIdentificador()).isPresent();
    }
    @GetMapping("cadastro/listajogos")
    public List<JogoDTO> listarTodosJogos() {
        return listaTodosJogosUC.executar();
    }
    @GetMapping("cadastro/listaclientes")
    public List<ClienteDTO> listaTodosClientes() {
        return listaTodosClientesUC.executar();
    }
    @GetMapping("cadastro/listaalugueis")
    public List<AluguelDTO> listaTodosAlugueis() {
        return listaTodosAlugueisUC.executar();
    }
    @PostMapping("cadastro/cadjogo")
    public boolean cadastrarJogo(@RequestBody JogoRequestDTO request) {
        return cadastrarJogoUC.executar(request);
    }
    @PostMapping("cadastro/cadcliente")
    public boolean cadastrarCliente(@RequestBody ClienteDTO request) {
        return cadastrarClienteUC.executar(request);
    }
    @PostMapping("cadastro/cadaluguel")
    public boolean cadastrarAluguel(@RequestBody AluguelDTO request) {
        return cadastrarAluguelUC.executar(request);
    }
    @GetMapping("cliente/aluguel/{numero}")
    public List<AluguelDTO> listarAlugueisPorCliente(@PathVariable int numero) {
        return listaAlugueisClienteUC.executar(numero);
    }
    @GetMapping("jogo/aluguel/{codigo}")
    public List<AluguelDTO> getMethodName(@PathVariable int codigo) {
        return listaAlugueisJogoUC.executar(codigo);
    }
    @GetMapping("aluguel/valorjogo/{codigo}")
    public Optional<AluguelJogoValorDTO> getValorJogo(@PathVariable int codigo) {
        return valorAluguelJogoUC.executar(codigo);
    }
    @GetMapping("aluguel/valorfinal/{identificador}")
    public Optional<AluguelJogoValorDTO> getValorFinalAluguel(@PathVariable int identificador) {
        return  valorFinalAluguelUC.executar(identificador);
    }
    
    
    
}