package br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl;

import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IMesaRepository;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.ENUM.TipoMesa;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.JogoMesa;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl.springData.SpringDataMesaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class MesaRepository implements IMesaRepository {
    private final SpringDataMesaRepository springMesa;
    public MesaRepository(SpringDataMesaRepository springMesa) {
        this.springMesa = springMesa;
    }

    @Override
    public List<JogoMesaModel> getAllJogoMesa() {
        return springMesa.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean addMesa(JogoMesaModel mesaModel) {
        JogoMesa mesa = toEntity(mesaModel);

        JogoMesa mesaSalvo = springMesa.save(mesa);

        return mesaSalvo != null && mesaSalvo.getCodigo() != 0;
    }
    private JogoMesaModel toModel(JogoMesa entity) {
        TipoMesaModel tipoModel = TipoMesaModel.valueOf(entity.getTipo().name());
        return new JogoMesaModel(entity.getCodigo(), entity.getNome(), entity.getValorBase(),entity.getNumeroPecas(), tipoModel);
    }
    private JogoMesa toEntity(JogoMesaModel model) {
        TipoMesa tipoEntity = TipoMesa.valueOf(model.getTipo().name());
        return new JogoMesa(model.getNome(), model.getValorBase(),model.getNumeroPecas(), tipoEntity);
    }
}
