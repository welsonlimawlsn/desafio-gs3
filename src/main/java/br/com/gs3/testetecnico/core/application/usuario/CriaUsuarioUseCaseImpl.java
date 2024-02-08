package br.com.gs3.testetecnico.core.application.usuario;

import br.com.gs3.testetecnico.core.application.perfil.PerfilService;
import br.com.gs3.testetecnico.core.domain.Perfil;
import br.com.gs3.testetecnico.core.domain.Usuario;
import br.com.gs3.testetecnico.ports.adapters.dao.UsuarioDAO;
import br.com.gs3.testetecnico.ports.application.usuario.criausuario.CriaUsuarioUseCase;
import br.com.gs3.testetecnico.ports.application.usuario.criausuario.dto.CriaUsuarioDTO;
import org.springframework.stereotype.Service;

@Service
public class CriaUsuarioUseCaseImpl implements CriaUsuarioUseCase {

    private final UsuarioDAO usuarioDAO;

    private final PerfilService perfilService;

    public CriaUsuarioUseCaseImpl(UsuarioDAO usuarioDAO, PerfilService perfilService) {
        this.usuarioDAO = usuarioDAO;
        this.perfilService = perfilService;
    }

    @Override
    public Usuario execute(CriaUsuarioDTO dto) {
        Perfil perfil = perfilService.buscaPerfil(dto.getCodigoPerfil());

        Usuario usuario = new Usuario(dto.getNome(), dto.getEmail(), dto.getSenha(), dto.getCpf(), perfil);

        usuarioDAO.salva(usuario);

        return usuario;
    }
}
