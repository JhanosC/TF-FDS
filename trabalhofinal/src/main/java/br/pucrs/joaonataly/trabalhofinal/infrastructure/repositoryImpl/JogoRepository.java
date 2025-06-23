package br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.*;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl.springData.SpringDataJogoRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.joaonataly.trabalhofinal.domain.repository.IJogoRepository;

@Repository
public class JogoRepository implements IJogoRepository {
    private final SpringDataJogoRepository springJogo;
    public JogoRepository(SpringDataJogoRepository springJogo) {
        this.springJogo = springJogo;
    }

    @Override
    public List<JogoModel> getAllJogos() {
        return springJogo.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
    @Override
    public Optional findById(int codigo) {
        return springJogo.findById(codigo)
                .map(this::toModel);
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


}
