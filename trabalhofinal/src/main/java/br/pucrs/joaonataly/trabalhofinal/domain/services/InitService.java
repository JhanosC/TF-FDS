package br.pucrs.joaonataly.trabalhofinal.domain.services;

import br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel.CadastrarAluguelUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.BuscaClienteIdUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.CadastrarEmpresarialUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.CadastrarIndividualUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo.BuscaJogoIdUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo.CadastrarEletronicoUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo.CadastrarMesaUC;
import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InitService {
    private CadastrarEmpresarialUC cadastrarEmpresarialUC;
    private CadastrarIndividualUC cadastrarIndividualUC;
    private CadastrarEletronicoUC cadastrarEletronicoUC;
    private CadastrarMesaUC cadastrarMesaUC;
    private CadastrarAluguelUC cadastrarAluguelUC;
    private BuscaJogoIdUC buscaJogoIdUC;
    private BuscaClienteIdUC buscaClienteIdUC;

    public InitService(CadastrarEmpresarialUC cadastrarEmpresarialUC, CadastrarIndividualUC cadastrarIndividualUC,
                       CadastrarEletronicoUC cadastrarEletronicoUC, CadastrarMesaUC cadastrarMesaUC,
                       CadastrarAluguelUC cadastrarAluguelUC, BuscaJogoIdUC buscaJogoIdUC,
                       BuscaClienteIdUC buscaClienteIdUC) {
        this.cadastrarEmpresarialUC = cadastrarEmpresarialUC;
        this.cadastrarIndividualUC = cadastrarIndividualUC;
        this.cadastrarEletronicoUC = cadastrarEletronicoUC;
        this.cadastrarMesaUC = cadastrarMesaUC;
        this.cadastrarAluguelUC = cadastrarAluguelUC;
        this.buscaJogoIdUC = buscaJogoIdUC;
        this.buscaClienteIdUC = buscaClienteIdUC;
    }

    @Transactional
    public void cadastrarClientesEJogos() {
        // Clientes Individuais

        cadastrarIndividualUC.executar(new IndividualModel("Ana Souza", "Rua das Flores, 123", "12345678901"));
        cadastrarIndividualUC.executar(new IndividualModel("Carlos Lima", "Av. Brasil, 200", "98765432100"));
        cadastrarIndividualUC.executar(new IndividualModel("Fernanda Reis", "Rua A, 111", "11122233344"));

        // Clientes Empresariais
        cadastrarEmpresarialUC.executar(new EmpresarialModel("Supermercado Econômico", "Rua B, 222", "Econômico", "11222333444455"));
        cadastrarEmpresarialUC.executar(new EmpresarialModel("Livraria Cultura", "Rua C, 333", "Cultura", "22334455667788"));

        // Jogos de Eletronico
        cadastrarEletronicoUC.executar(new JogoEletronicoModel("The Legend of Zelda: Breath of the Wild", 299.90, "Nintendo Switch", TipoEletronicoModel.AVENTURA));
        cadastrarEletronicoUC.executar(new JogoEletronicoModel("Civilization VI", 159.90, "PC", TipoEletronicoModel.ESTRATEGIA));
        cadastrarEletronicoUC.executar(new JogoEletronicoModel("The Sims 4", 199.00, "PC", TipoEletronicoModel.SIMULACAO));
        cadastrarEletronicoUC.executar(new JogoEletronicoModel("Assassin's Creed Odyssey", 249.99, "PS5", TipoEletronicoModel.AVENTURA));
        cadastrarEletronicoUC.executar(new JogoEletronicoModel("Starcraft II", 20.00, "PC", TipoEletronicoModel.ESTRATEGIA));

        //Jogos de Mesa
        cadastrarMesaUC.executar(new JogoMesaModel("Catan", 189.90, 120, TipoMesaModel.TABULEIRO));
        cadastrarMesaUC.executar(new JogoMesaModel("Uno", 34.99, 108, TipoMesaModel.CARTAS));
        cadastrarMesaUC.executar(new JogoMesaModel("Banco Imobiliário", 129.00, 200, TipoMesaModel.TABULEIRO));
        cadastrarMesaUC.executar(new JogoMesaModel("Pokémon TCG", 89.90, 60, TipoMesaModel.CARTAS));
        cadastrarMesaUC.executar(new JogoMesaModel("War", 149.90, 150, TipoMesaModel.TABULEIRO));
    }

    @Transactional
    public void cadastrarAlugueis() {
        var cliente1 = buscaClienteIdUC.executar(2)
                .orElseThrow(() -> new RuntimeException("Cliente ID 2 não encontrado"));
        var jogo1 = buscaJogoIdUC.executar(3)
                .orElseThrow(() -> new RuntimeException("Jogo ID 3 não encontrado"));
        var aluguel1 = new AluguelModel(5, LocalDate.of(2025, 6, 20), cliente1, jogo1);
        cadastrarAluguelUC.executar(aluguel1);

        var cliente2 = buscaClienteIdUC.executar(4)
                .orElseThrow(() -> new RuntimeException("Cliente ID 4 não encontrado"));
        var jogo2 = buscaJogoIdUC.executar(7)
                .orElseThrow(() -> new RuntimeException("Jogo ID 7 não encontrado"));
        var aluguel2 = new AluguelModel(8, LocalDate.of(2025, 7, 21), cliente2, jogo2);
        cadastrarAluguelUC.executar(aluguel2);

        var cliente3 = buscaClienteIdUC.executar(5)
                .orElseThrow(() -> new RuntimeException("Cliente ID 5 não encontrado"));
        var jogo3 = buscaJogoIdUC.executar(1)
                .orElseThrow(() -> new RuntimeException("Jogo ID 1 não encontrado"));
        var aluguel3 = new AluguelModel(16, LocalDate.of(2025, 8, 20), cliente3, jogo3);
        cadastrarAluguelUC.executar(aluguel3);
    }
}
