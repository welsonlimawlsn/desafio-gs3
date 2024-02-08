package br.com.gs3.testetecnico.adapters.database.mapper;

import br.com.gs3.testetecnico.adapters.database.entity.PerfilEntity;
import br.com.gs3.testetecnico.core.domain.Perfil;
import org.springframework.stereotype.Component;

@Component
public class PerfilMapper implements DatabaseMapper<PerfilEntity, Perfil> {
    @Override
    public PerfilEntity toEntity(Perfil model) {
        PerfilEntity perfilEntity = new PerfilEntity();

        perfilEntity.setCodigo(model.getCodigo());
        perfilEntity.setNome(model.getNome());
        perfilEntity.setDescricao(model.getDescricao());

        return perfilEntity;
    }

    @Override
    public Perfil toModel(PerfilEntity entity) {
        return new Perfil(entity.getCodigo(), entity.getNome(), entity.getDescricao());
    }
}
