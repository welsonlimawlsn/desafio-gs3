package br.com.gs3.testetecnico.adapters.database.dao;

import br.com.gs3.testetecnico.adapters.database.entity.UsuarioEntity;
import br.com.gs3.testetecnico.adapters.database.mapper.UsuarioMapper;
import br.com.gs3.testetecnico.adapters.database.repository.UsuarioRepository;
import br.com.gs3.testetecnico.core.domain.Usuario;
import br.com.gs3.testetecnico.ports.adapters.dao.UsuarioDAO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UsuarioDAOImpl implements UsuarioDAO {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    public UsuarioDAOImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public void salva(Usuario usuario) {
        UsuarioEntity entity = usuarioMapper.toEntity(usuario);

        usuarioRepository.save(entity);
    }

    @Override
    public Optional<Usuario> busca(UUID codigo) {
        Optional<UsuarioEntity> entity = usuarioRepository.findById(codigo);

        return entity.map(usuarioMapper::toModel);
    }

    @Override
    public void deleta(Usuario perfil) {
        usuarioRepository.delete(usuarioMapper.toEntity(perfil));
    }

    @Override
    public List<Usuario> lista() {
        return usuarioRepository.findAll().stream().map(usuarioMapper::toModel).toList();
    }
}
