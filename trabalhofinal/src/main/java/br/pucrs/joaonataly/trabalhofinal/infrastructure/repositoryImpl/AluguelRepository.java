package br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl;

import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IAluguelRepository;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.*;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.ENUM.TipoEletronico;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.ENUM.TipoMesa;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl.springData.SpringDataAluguelRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AluguelRepository implements IAluguelRepository {
    private final SpringDataAluguelRepository springAluguel;
    public AluguelRepository(SpringDataAluguelRepository springAluguel) {
        this.springAluguel = springAluguel;
    }

    @Override
    public Optional<AluguelModel> findById(int identificador) {
        return springAluguel.findById(identificador)
                .map(this::toModel);
    }

    @Override
    public List<AluguelModel> getAllAluguel() {
        return springAluguel.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean addAluguel(AluguelModel aluguelModel) {
        Aluguel aluguel = toEntity(aluguelModel);

        Aluguel aluguelSalvo = springAluguel.save(aluguel);

        return aluguelSalvo != null && aluguelSalvo.getIdentificador() != 0;
    }

    private AluguelModel toModel(Aluguel entity){
        ClienteModel clienteModel = toModel(entity.getCliente());
        JogoModel jogoModel = toModel(entity.getJogo());

        return new AluguelModel(
                entity.getIdentificador(),
                entity.getPeriodo(),
                entity.getDataInicial(),
                clienteModel,
                jogoModel,
                entity.getValorFinal()
        );
    }
    private Aluguel toEntity(AluguelModel model){
        Cliente cliente = toEntity(model.getCliente());
        Jogo jogo = toEntity(model.getJogo());

        return new Aluguel(
                model.getPeriodo(),
                model.getDataInicial(),
                cliente,
                jogo,
                model.getValorFinal()
        );
    }

    private ClienteModel toModel(Cliente entity) {
        if (entity instanceof Individual individual) {
            return new IndividualModel(
                    individual.getNumero(),
                    individual.getNome(),
                    individual.getEndereco(),
                    individual.getCpf()
            );
        } else if (entity instanceof Empresarial empresarial) {
            return new EmpresarialModel(
                    empresarial.getNumero(),
                    empresarial.getNome(),
                    empresarial.getEndereco(),
                    empresarial.getCnpj(),
                    empresarial.getNomeFantasia()
            );
        } else {
            throw new IllegalArgumentException("Tipo de cliente desconhecido");
        }
    }

    private Cliente toEntity(ClienteModel model) {
        if (model instanceof IndividualModel individualModel) {
            Individual entity = new Individual(
                    individualModel.getNome(),
                    individualModel.getEndereco(),
                    individualModel.getCpf()
            );
            entity.setNumero(individualModel.getNumero());
            return entity;
        } else if (model instanceof EmpresarialModel empresarialModel) {
            Empresarial entity = new Empresarial(
                    empresarialModel.getNome(),
                    empresarialModel.getEndereco(),
                    empresarialModel.getNomeFantasia(),
                    empresarialModel.getCnpj()
            );
            entity.setNumero(empresarialModel.getNumero());
            return entity;
        } else {
            throw new IllegalArgumentException("Tipo de cliente desconhecido");
        }
    }

    private JogoModel toModel(Jogo entity) {
        if (entity instanceof JogoEletronico eletronico) {
            TipoEletronicoModel tipoModel = TipoEletronicoModel.valueOf(eletronico.getTipo().name());
            return new JogoEletronicoModel(
                    eletronico.getCodigo(),
                    eletronico.getNome(),
                    eletronico.getValorBase(),
                    eletronico.getPlataforma(),
                    tipoModel
            );
        } else if (entity instanceof JogoMesa mesa) {
            TipoMesaModel tipoModel = TipoMesaModel.valueOf(mesa.getTipo().name());
            return new JogoMesaModel(
                    mesa.getCodigo(),
                    mesa.getNome(),
                    mesa.getValorBase(),
                    mesa.getNumeroPecas(),
                    tipoModel
            );
        }else {
            throw new IllegalArgumentException("Tipo de jogo desconhecido: " + entity.getClass().getSimpleName());
        }
    }

    private Jogo toEntity(JogoModel model) {
        if (model instanceof JogoEletronicoModel eletronicoModel) {
            TipoEletronico tipo = TipoEletronico.valueOf(eletronicoModel.getTipo().name());
            JogoEletronico entity = new JogoEletronico(
                    eletronicoModel.getNome(),
                    eletronicoModel.getValorBase(),
                    eletronicoModel.getPlataforma(),
                    tipo
            );
            entity.setCodigo(eletronicoModel.getCodigo());
            return entity;
        } else if (model instanceof JogoMesaModel mesaModel) {
            TipoMesa tipo = TipoMesa.valueOf(mesaModel.getTipo().name());
            JogoMesa entity = new JogoMesa(
                    mesaModel.getNome(),
                    mesaModel.getValorBase(),
                    mesaModel.getNumeroPecas(),
                    tipo
            );
            entity.setCodigo(mesaModel.getCodigo());
            return entity;
        } else {
            throw new IllegalArgumentException("Tipo de jogo desconhecido: " + model.getClass().getSimpleName());
        }
    }

}
