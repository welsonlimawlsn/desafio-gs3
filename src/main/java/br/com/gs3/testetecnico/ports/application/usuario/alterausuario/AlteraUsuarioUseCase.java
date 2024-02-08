package br.com.gs3.testetecnico.ports.application.usuario.alterausuario;

import br.com.gs3.testetecnico.core.domain.Usuario;
import br.com.gs3.testetecnico.ports.application.usuario.alterausuario.dto.AlteraUsuarioDTO;

public interface AlteraUsuarioUseCase {

    Usuario execute(AlteraUsuarioDTO dto);
}
