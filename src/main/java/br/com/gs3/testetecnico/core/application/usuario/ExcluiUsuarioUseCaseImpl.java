package br.com.gs3.testetecnico.core.application.usuario;

import br.com.gs3.testetecnico.core.domain.Usuario;
import br.com.gs3.testetecnico.core.exceptions.NegocioException;
import br.com.gs3.testetecnico.ports.adapters.dao.UsuarioDAO;
import br.com.gs3.testetecnico.ports.application.usuario.excluiusuario.ExcluiUsuarioUseCase;
import br.com.gs3.testetecnico.ports.application.usuario.excluiusuario.dto.ExcluiUsuarioDTO;
import org.springframework.stereotype.Service;

@Service
public class ExcluiUsuarioUseCaseImpl implements ExcluiUsuarioUseCase {

    private final UsuarioDAO usuarioDAO;

    public ExcluiUsuarioUseCaseImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public void execute(ExcluiUsuarioDTO dto) {
        Usuario usuario = usuarioDAO.busca(dto.getCodigoUsuario())
                .orElseThrow(() -> new NegocioException("Usuario não encontrado"));

        usuarioDAO.deleta(usuario);
    }
}
