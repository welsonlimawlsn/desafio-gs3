package br.com.gs3.testetecnico.core.application.usuario;

import br.com.gs3.testetecnico.core.application.perfil.PerfilService;
import br.com.gs3.testetecnico.core.domain.Perfil;
import br.com.gs3.testetecnico.core.domain.Usuario;
import br.com.gs3.testetecnico.core.exceptions.NegocioException;
import br.com.gs3.testetecnico.ports.adapters.dao.UsuarioDAO;
import br.com.gs3.testetecnico.ports.application.usuario.alterausuario.AlteraUsuarioUseCase;
import br.com.gs3.testetecnico.ports.application.usuario.alterausuario.dto.AlteraUsuarioDTO;
import org.springframework.stereotype.Service;

@Service
public class AlteraUsuarioUseCaseImpl implements AlteraUsuarioUseCase {

    private final UsuarioDAO usuarioDAO;

    private final PerfilService perfilService;

    public AlteraUsuarioUseCaseImpl(UsuarioDAO usuarioDAO, PerfilService perfilService) {
        this.usuarioDAO = usuarioDAO;
        this.perfilService = perfilService;
    }

    @Override
    public Usuario execute(AlteraUsuarioDTO dto) {
        Usuario usuario = usuarioDAO.busca(dto.getCodigo())
                .orElseThrow(() -> new NegocioException("Usuário não encontrado"));

        Perfil perfil = perfilService.buscaPerfil(dto.getCodigoPerfil());

        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        usuario.setPerfil(perfil);

        usuarioDAO.salva(usuario);

        return usuario;
    }
}
