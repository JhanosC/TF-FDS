package br.pucrs.joaonataly.trabalhofinal.domain.services;

<<<<<<< HEAD
import br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel.CadastrarAluguelUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.BuscaClienteIdUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.CadastrarEmpresarialUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.CadastrarIndividualUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo.BuscaJogoIdUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo.CadastrarEletronicoUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo.CadastrarMesaUC;
=======
>>>>>>> Correcao
import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InitService {
<<<<<<< HEAD
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
=======

    private final IClienteRepository clienteRepository;
    private final IJogoRepository jogoRepository;
    private final IAluguelRepository aluguelRepository;
    private final IEmpresarialRepository empresarialRepository;
    private final IIndividualRepository individualRepository;
    private final IEletronicoRepository eletronicoRepository;
    private final IMesaRepository mesaRepository;

    public InitService(
        IClienteRepository clienteRepository,
        IJogoRepository jogoRepository,
        IAluguelRepository aluguelRepository,
        IEmpresarialRepository empresarialRepository,
        IIndividualRepository individualRepository,
        IEletronicoRepository eletronicoRepository,
        IMesaRepository mesaRepository){

        this.clienteRepository = clienteRepository;
        this.jogoRepository = jogoRepository;
        this.aluguelRepository = aluguelRepository;
        this.empresarialRepository = empresarialRepository;
        this.individualRepository = individualRepository;
        this.eletronicoRepository = eletronicoRepository;
        this.mesaRepository = mesaRepository;
>>>>>>> Correcao
    }

    @Transactional
    public void cadastrarClientesEJogos() {
        // Clientes Individuais
<<<<<<< HEAD

        cadastrarIndividualUC.executar(new IndividualModel("Ana Souza", "Rua das Flores, 123", "12345678901"));
        cadastrarIndividualUC.executar(new IndividualModel("Carlos Lima", "Av. Brasil, 200", "98765432100"));
        cadastrarIndividualUC.executar(new IndividualModel("Fernanda Reis", "Rua A, 111", "11122233344"));

        // Clientes Empresariais
        cadastrarEmpresarialUC.executar(new EmpresarialModel("Supermercado Econômico", "Rua B, 222", "Econômico", "11222333444455"));
        cadastrarEmpresarialUC.executar(new EmpresarialModel("Livraria Cultura", "Rua C, 333", "Cultura", "22334455667788"));
=======
        individualRepository.addIndividual(new IndividualModel(1,"Ana Souza", "Rua das Flores, 123", "12345678901"));
        individualRepository.addIndividual(new IndividualModel(2,"Carlos Lima", "Rua Brasil, 321", "98765432101"));
        individualRepository.addIndividual(new IndividualModel(3,"Eduardo Oliveira", "Rua Indigo, 312", "98765678901"));

        // Clientes Empresariais
        empresarialRepository.addEmpresarial(new EmpresarialModel(4,"Joana Carolina", "Rua das Ortencias, 132", "Eletronicos Joana", "12345678901"));
        empresarialRepository.addEmpresarial(new EmpresarialModel(5,"Sandra Santos", "Rua Carlos Oliveira, 213", "Games do Sul", "98765432101"));

        // Jogos Eletrônicos
        eletronicoRepository.addEletronico(new JogoEletronicoModel(1,"The Legend of Link", 209.99, "Nintendo Switch 2", TipoEletronicoModel.AVENTURA));
        eletronicoRepository.addEletronico(new JogoEletronicoModel(2,"Super Maria Sis", 199.99, "Nintendo Switch 2", TipoEletronicoModel.AVENTURA));
        eletronicoRepository.addEletronico(new JogoEletronicoModel(3,"Call of Duty: Rustic Warfare", 249.99, "PlayStation 5", TipoEletronicoModel.ESTRATEGIA));
        eletronicoRepository.addEletronico(new JogoEletronicoModel(4,"FIFA 28", 299.99, "Xbox Series X", TipoEletronicoModel.SIMULACAO));
        eletronicoRepository.addEletronico(new JogoEletronicoModel(5,"Craft And Mine", 59.99, "PC", TipoEletronicoModel.SIMULACAO));
>>>>>>> Correcao

        // Jogos de Mesa
        mesaRepository.addMesa(new JogoMesaModel(6,"Catan", 89.99, 19, TipoMesaModel.CARTAS));
        mesaRepository.addMesa(new JogoMesaModel(7,"Ticket to Ride", 79.99, 15, TipoMesaModel.CARTAS));
        mesaRepository.addMesa(new JogoMesaModel(8,"Dungeons & Dragons", 129.99, 30, TipoMesaModel.TABULEIRO));
        mesaRepository.addMesa(new JogoMesaModel(9,"War", 69.99, 25, TipoMesaModel.TABULEIRO));
        mesaRepository.addMesa(new JogoMesaModel(10,"Xadrez", 19.99, 32, TipoMesaModel.TABULEIRO));
    }

    @Transactional
    public void cadastrarAlugueis() {
        var cliente1 = clienteRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Cliente ID 2 não encontrado"));
        var jogo1 = jogoRepository.findById(3)
                .orElseThrow(() -> new RuntimeException("Jogo ID 3 não encontrado"));
<<<<<<< HEAD
        var aluguel1 = new AluguelModel(5, LocalDate.of(2025, 6, 20), cliente1, jogo1);
        cadastrarAluguelUC.executar(aluguel1);

        var cliente2 = buscaClienteIdUC.executar(4)
=======
        aluguelRepository.addAluguel(new AluguelModel(1, 15, LocalDate.of(2025, 6, 15), cliente1, jogo1));
        //int identificador, int periodo, LocalDate dataInicial, ClienteModel cliente, JogoModel jogo
        var cliente2 = clienteRepository.findById(2)
>>>>>>> Correcao
                .orElseThrow(() -> new RuntimeException("Cliente ID 4 não encontrado"));
        var jogo2 = jogoRepository.findById(7)
                .orElseThrow(() -> new RuntimeException("Jogo ID 7 não encontrado"));
<<<<<<< HEAD
        var aluguel2 = new AluguelModel(8, LocalDate.of(2025, 7, 21), cliente2, jogo2);
        cadastrarAluguelUC.executar(aluguel2);
=======
        aluguelRepository.addAluguel(new AluguelModel(2, 6, LocalDate.of(2025, 7, 1), cliente2, jogo2));
>>>>>>> Correcao

        var cliente3 = clienteRepository.findById(3)
                .orElseThrow(() -> new RuntimeException("Cliente ID 5 não encontrado"));
        var jogo3 = jogoRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Jogo ID 1 não encontrado"));
<<<<<<< HEAD
        var aluguel3 = new AluguelModel(16, LocalDate.of(2025, 8, 20), cliente3, jogo3);
        cadastrarAluguelUC.executar(aluguel3);
=======
        aluguelRepository.addAluguel(new AluguelModel(3, 4, LocalDate.of(2025, 7, 10), cliente3, jogo3));

        var jogo4 = jogoRepository.findById(2)
                .orElseThrow(() -> new RuntimeException("Jogo ID 2 não encontrado"));;
        aluguelRepository.addAluguel(new AluguelModel(4, 4, LocalDate.of(2025, 7, 10), cliente3, jogo4));
>>>>>>> Correcao
    }
}
