package br.com.gs3.testetecnico.core.application.usuario;

import br.com.gs3.testetecnico.core.domain.Usuario;
import br.com.gs3.testetecnico.ports.adapters.dao.UsuarioDAO;
import br.com.gs3.testetecnico.ports.application.usuario.listausuarios.ListaUsuariosUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaUsuariosUseCaseImpl implements ListaUsuariosUseCase {

    private final UsuarioDAO usuarioDAO;

    public ListaUsuariosUseCaseImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public List<Usuario> execute() {
        return usuarioDAO.lista();
    }
}
