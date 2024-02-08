package br.com.gs3.testetecnico.ports.application.usuario.buscausuario;

import br.com.gs3.testetecnico.core.domain.Usuario;
import br.com.gs3.testetecnico.ports.application.usuario.buscausuario.dto.BuscaUsuarioPorCodigoDTO;

public interface BuscaUsuarioPorCodigoUseCase {

    public Usuario execute(BuscaUsuarioPorCodigoDTO dto);
}
