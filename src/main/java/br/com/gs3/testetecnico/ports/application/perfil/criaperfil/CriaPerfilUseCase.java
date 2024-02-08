package br.com.gs3.testetecnico.ports.application.perfil.criaperfil;

import br.com.gs3.testetecnico.core.domain.Perfil;
import br.com.gs3.testetecnico.ports.application.perfil.criaperfil.dto.CriaPerfilDTO;

public interface CriaPerfilUseCase {

    Perfil execute(CriaPerfilDTO perfil);
}
