package br.com.gs3.testetecnico.ports.application.usuario.listausuarios;

import br.com.gs3.testetecnico.core.domain.Usuario;
import br.com.gs3.testetecnico.ports.adapters.dao.UsuarioDAO;

import java.util.List;

public interface ListaUsuariosUseCase {

    List<Usuario> execute();
}
