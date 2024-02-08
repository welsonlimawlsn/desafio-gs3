package br.com.gs3.testetecnico.adapters.database.dao;

import br.com.gs3.testetecnico.adapters.database.entity.PerfilEntity;
import br.com.gs3.testetecnico.adapters.database.mapper.PerfilMapper;
import br.com.gs3.testetecnico.adapters.database.repository.PerfilRepository;
import br.com.gs3.testetecnico.core.domain.Perfil;
import br.com.gs3.testetecnico.ports.adapters.dao.PerfilDAO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PerfilDAOImpl implements PerfilDAO {

    private final PerfilRepository perfilRepository;

    private final PerfilMapper perfilMapper;

    public PerfilDAOImpl(PerfilRepository perfilRepository, PerfilMapper perfilMapper) {
        this.perfilRepository = perfilRepository;
        this.perfilMapper = perfilMapper;
    }

    @Override
    public void salva(Perfil perfil) {
        PerfilEntity entity = perfilMapper.toEntity(perfil);

        perfilRepository.save(entity);
    }

    @Override
    public Optional<Perfil> busca(UUID codigo) {
        Optional<PerfilEntity> entity = perfilRepository.findById(codigo);

        return entity.map(perfilMapper::toModel);
    }

    @Override
    public void deleta(Perfil perfil) {
        perfilRepository.delete(perfilMapper.toEntity(perfil));
    }

    @Override
    public List<Perfil> lista() {
        return perfilRepository.findAll().stream().map(perfilMapper::toModel).toList();
    }
}
