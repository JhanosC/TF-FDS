package br.pucrs.joaonataly.trabalhofinal.presentation;

import java.util.List;

import br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel.*;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.*;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import org.springframework.web.bind.annotation.*;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

    public AcmeGamesController(ListaTodosJogosUC listaTodosJogosUC, BuscaClienteIdUC buscaClienteIdUC, ListaTodosClientesUC listaTodosClientesUC,
                               BuscaJogoIdUC buscaJogoIdUC, BuscaAluguelIdUC buscaAluguelIdUC,ListaTodosAlugueisUC listaTodosAlugueisUC,
                               CadastrarJogoUC cadastrarJogoUC, CadastrarClienteUC cadastrarClienteUC, CadastrarAluguelUC cadastrarAluguelUC) {
        this.cadastrarAluguelUC = cadastrarAluguelUC;
        this.listaTodosJogosUC = listaTodosJogosUC;
        this.buscaClienteIdUC = buscaClienteIdUC;
        this.listaTodosClientesUC = listaTodosClientesUC;
        this.buscaJogoIdUC = buscaJogoIdUC;
        this.buscaAluguelIdUC = buscaAluguelIdUC;
        this.listaTodosAlugueisUC = listaTodosAlugueisUC;
        this.cadastrarJogoUC = cadastrarJogoUC;
        this.cadastrarClienteUC = cadastrarClienteUC;
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
    
}