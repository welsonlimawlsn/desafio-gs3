package br.com.gs3.testetecnico.ports.adapters.dao;

import br.com.gs3.testetecnico.core.domain.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioDAO {
    void salva(Usuario usuario);

    Optional<Usuario> busca(UUID codigo);

    void deleta(Usuario usuario);

    List<Usuario> lista();

}
