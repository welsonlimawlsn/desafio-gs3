package br.com.gs3.testetecnico.adapters.database.mapper;

import br.com.gs3.testetecnico.adapters.database.entity.UsuarioEntity;
import br.com.gs3.testetecnico.core.domain.Usuario;

public class UsuarioMapper implements DatabaseMapper<UsuarioEntity, Usuario> {
    @Override
    public UsuarioEntity toEntity(Usuario model) {
        return null;
    }

    @Override
    public Usuario toModel(UsuarioEntity entity) {
        return null;
    }
}
