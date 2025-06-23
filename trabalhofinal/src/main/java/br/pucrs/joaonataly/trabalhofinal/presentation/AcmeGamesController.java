package br.pucrs.joaonataly.trabalhofinal.presentation;

import java.util.List;

import br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel.BuscaAluguelIdUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel.ListaTodosAlugueisUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.*;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import org.springframework.web.bind.annotation.*;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.*;

@RestController
@RequestMapping("/acmegames")
public class AcmeGamesController {

    private final  ListaTodosJogosUC listaTodosJogosUC;
    private final BuscaClienteIdUC buscaClienteIdUC;
    private final BuscaJogoIdUC buscaJogoIdUC;
    private final BuscaAluguelIdUC buscaAluguelIdUC;
    private final ListaTodosClientesUC listaTodosClientesUC;
    private final ListaTodosAlugueisUC listaTodosAlugueisUC;
    private final CadastrarJogoUC cadastrarJogoUC;
    private final CadastrarClienteUC cadastrarClienteUC;

    public AcmeGamesController(ListaTodosJogosUC listaTodosJogosUC, BuscaClienteIdUC buscaClienteIdUC, ListaTodosClientesUC listaTodosClientesUC,
                               BuscaJogoIdUC buscaJogoIdUC, BuscaAluguelIdUC buscaAluguelIdUC,ListaTodosAlugueisUC listaTodosAlugueisUC,
                               CadastrarJogoUC cadastrarJogoUC, CadastrarClienteUC cadastrarClienteUC) {
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
    public boolean validaAluguel(@RequestBody AluguelIdentificadorDTO identificadorDTO) {
        return  buscaAluguelIdUC.executar(identificadorDTO.getIdentificador()).isPresent();
    }
    @GetMapping("cadastro/listajogos")
    public List<JogoModel> listarTodosJogos() {
        return listaTodosJogosUC.executar();
    }
    @GetMapping("cadastro/listaclientes")
    public List<ClienteModel> listaTodosClientes() {
        return listaTodosClientesUC.executar();
    }
    @GetMapping("cadastro/listaalugueis")
    public List<AluguelModel> listaTodosAlugueis() {
        return listaTodosAlugueisUC.executar();
    }
    @PostMapping("cadastro/cadjogo")
    public boolean cadastrarJogo(@RequestBody JogoRequestDTO request) {
        return cadastrarJogoUC.executar(request);
    }
    @PostMapping("cadastro/cadcliente")
    public boolean cadastrarCliente(@RequestBody ClienteRequestDTO request) {
        return cadastrarClienteUC.executar(request);
    }
}