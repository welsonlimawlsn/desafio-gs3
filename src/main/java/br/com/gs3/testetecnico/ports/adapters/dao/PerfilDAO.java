package br.com.gs3.testetecnico.ports.adapters.dao;

import br.com.gs3.testetecnico.core.domain.Perfil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PerfilDAO {

    void salva(Perfil perfil);

    Optional<Perfil> busca(UUID codigo);

    void deleta(Perfil perfil);

    List<Perfil> lista();
}
