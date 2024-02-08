package br.com.gs3.testetecnico.core.application.usuario;

import br.com.gs3.testetecnico.core.domain.Usuario;
import br.com.gs3.testetecnico.core.exceptions.NegocioException;
import br.com.gs3.testetecnico.ports.adapters.dao.UsuarioDAO;
import br.com.gs3.testetecnico.ports.application.usuario.buscausuario.BuscaUsuarioPorCodigoUseCase;
import br.com.gs3.testetecnico.ports.application.usuario.buscausuario.dto.BuscaUsuarioPorCodigoDTO;
import org.springframework.stereotype.Service;

@Service
public class BuscaUsuarioPorCodigoUseCaseImpl implements BuscaUsuarioPorCodigoUseCase {

    private final UsuarioDAO usuarioDAO;

    public BuscaUsuarioPorCodigoUseCaseImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public Usuario execute(BuscaUsuarioPorCodigoDTO dto) {
        return usuarioDAO.busca(dto.getCodigo())
                .orElseThrow(() -> new NegocioException("Usuario não encontrado"));
    }
}
