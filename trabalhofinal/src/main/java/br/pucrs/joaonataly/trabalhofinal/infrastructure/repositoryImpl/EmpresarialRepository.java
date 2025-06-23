package br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl;

import br.pucrs.joaonataly.trabalhofinal.domain.model.EmpresarialModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IEmpresarialRepository;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.BD.entities.Empresarial;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl.springData.SpringDataEmpresarialRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class EmpresarialRepository implements IEmpresarialRepository {
    private final SpringDataEmpresarialRepository springEmpresarial;
    public EmpresarialRepository(SpringDataEmpresarialRepository springEmpresarial) {
        this.springEmpresarial = springEmpresarial;
    }
    @Override
    public List<EmpresarialModel> getAllEmpresarial() {
        return springEmpresarial.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean addEmpresarial(EmpresarialModel empresarialModel) {
        Empresarial emp = toEntity(empresarialModel);

        Empresarial empSalvo = springEmpresarial.save(emp);

        return empSalvo != null && empSalvo.getNumero() != 0;
    }

    private EmpresarialModel toModel(Empresarial entity) {
        return new EmpresarialModel(entity.getNumero(), entity.getNome(), entity.getEndereco(),entity.getCnpj(), entity.getNomeFantasia());
    }
    private Empresarial toEntity(EmpresarialModel model) {
        return new Empresarial(model.getNome(), model.getEndereco(),model.getCnpj(), model.getNomeFantasia());
    }
}
