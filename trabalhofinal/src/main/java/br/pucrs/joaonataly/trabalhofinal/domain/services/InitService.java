package br.pucrs.joaonataly.trabalhofinal.domain.services;

import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InitService {

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
    }

    @Transactional
    public void cadastrarClientesEJogos() {
        // Clientes Individuais
        individualRepository.addIndividual(new IndividualModel("Ana Souza", "Rua das Flores, 123", "12345678901"));
        individualRepository.addIndividual(new IndividualModel("Carlos Lima", "Rua Brasil, 321", "98765432101"));
        individualRepository.addIndividual(new IndividualModel("Eduardo Oliveira", "Rua Indigo, 312", "98765678901"));

        // Clientes Empresariais
        empresarialRepository.addEmpresarial(new EmpresarialModel("Joana Carolina", "Rua das Ortencias, 132", "Eletronicos Joana", "12345678901"));
        empresarialRepository.addEmpresarial(new EmpresarialModel("Sandra Santos", "Rua Carlos Oliveira, 213", "Games do Sul", "98765432101"));

        // Jogos Eletrônicos
        eletronicoRepository.addEletronico(new JogoEletronicoModel("The Legend of Link", 209.99, "Nintendo Switch 2", TipoEletronicoModel.AVENTURA));
        eletronicoRepository.addEletronico(new JogoEletronicoModel("Super Maria Sis", 199.99, "Nintendo Switch 2", TipoEletronicoModel.AVENTURA));
        eletronicoRepository.addEletronico(new JogoEletronicoModel("Call of Duty: Rustic Warfare", 249.99, "PlayStation 5", TipoEletronicoModel.ESTRATEGIA));
        eletronicoRepository.addEletronico(new JogoEletronicoModel("FIFA 28", 299.99, "Xbox Series X", TipoEletronicoModel.SIMULACAO));
        eletronicoRepository.addEletronico(new JogoEletronicoModel("Craft And Mine", 59.99, "PC", TipoEletronicoModel.SIMULACAO));

        // Jogos de Mesa
        mesaRepository.addMesa(new JogoMesaModel("Catan", 89.99, 19, TipoMesaModel.CARTAS));
        mesaRepository.addMesa(new JogoMesaModel("Ticket to Ride", 79.99, 15, TipoMesaModel.CARTAS));
        mesaRepository.addMesa(new JogoMesaModel("Dungeons & Dragons", 129.99, 30, TipoMesaModel.TABULEIRO));
        mesaRepository.addMesa(new JogoMesaModel("War", 69.99, 25, TipoMesaModel.TABULEIRO));
        mesaRepository.addMesa(new JogoMesaModel("Xadrez", 19.99, 32, TipoMesaModel.TABULEIRO));
    }

    @Transactional
    public void cadastrarAlugueis() {
        var cliente1 = clienteRepository.findById(2)
                .orElseThrow(() -> new RuntimeException("Cliente ID 2 não encontrado"));
        var jogo1 = jogoRepository.findById(3)
                .orElseThrow(() -> new RuntimeException("Jogo ID 3 não encontrado"));
        aluguelRepository.addAluguel(new AluguelModel(1, 15, LocalDate.of(2025, 6, 15), cliente1, jogo1));
        //int identificador, int periodo, LocalDate dataInicial, ClienteModel cliente, JogoModel jogo
        var cliente2 = clienteRepository.findById(4)
                .orElseThrow(() -> new RuntimeException("Cliente ID 4 não encontrado"));
        var jogo2 = jogoRepository.findById(7)
                .orElseThrow(() -> new RuntimeException("Jogo ID 7 não encontrado"));
        aluguelRepository.addAluguel(new AluguelModel(2, 6, LocalDate.of(2025, 7, 1), cliente2, jogo2));

        var cliente3 = clienteRepository.findById(5)
                .orElseThrow(() -> new RuntimeException("Cliente ID 5 não encontrado"));
        var jogo3 = jogoRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Jogo ID 1 não encontrado"));
        aluguelRepository.addAluguel(new AluguelModel(3, 4, LocalDate.of(2025, 7, 10), cliente3, jogo3));
    }
}
