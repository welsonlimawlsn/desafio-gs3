package br.com.gs3.testetecnico.ports.application.usuario.criausuario;

import br.com.gs3.testetecnico.core.domain.Usuario;
import br.com.gs3.testetecnico.ports.application.usuario.criausuario.dto.CriaUsuarioDTO;

public interface CriaUsuarioUseCase {

    Usuario execute(CriaUsuarioDTO dto);
}
