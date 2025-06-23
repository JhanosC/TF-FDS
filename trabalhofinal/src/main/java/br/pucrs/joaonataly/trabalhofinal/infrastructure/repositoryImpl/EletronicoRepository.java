package br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl;

import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IEletronicoRepository;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.ENUM.TipoEletronico;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.JogoEletronico;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl.springData.SpringDataEletronicoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class EletronicoRepository implements IEletronicoRepository {
    private final SpringDataEletronicoRepository springEletronico;
    public EletronicoRepository(SpringDataEletronicoRepository springEletronico) {
        this.springEletronico = springEletronico;
    }

    @Override
    public List<JogoEletronicoModel> getAllJogoEletronico() {
        return springEletronico.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean addEletronico(JogoEletronicoModel eletronicoModel) {
        JogoEletronico eletronico = toEntity(eletronicoModel);

        JogoEletronico eletronicoSalvo = springEletronico.save(eletronico);

        return eletronicoSalvo != null && eletronicoSalvo.getCodigo() != 0;
    }
    private JogoEletronicoModel toModel(JogoEletronico entity) {
        TipoEletronicoModel tipoModel = TipoEletronicoModel.valueOf(entity.getTipo().name());
        return new JogoEletronicoModel(entity.getCodigo(), entity.getNome(), entity.getValorBase(),entity.getPlataforma(), tipoModel);
    }
    private JogoEletronico toEntity(JogoEletronicoModel model) {
        TipoEletronico tipoEntity = TipoEletronico.valueOf(model.getTipo().name());
        return new JogoEletronico(model.getNome(), model.getValorBase(),model.getPlataforma(), tipoEntity);
    }
}
