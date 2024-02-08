package br.com.gs3.testetecnico.ports.application.perfil.alteraperfil;

import br.com.gs3.testetecnico.core.domain.Perfil;
import br.com.gs3.testetecnico.ports.application.perfil.alteraperfil.dto.AlteraPerfilDTO;

public interface AlteraPerfilUseCase {

    Perfil execute(AlteraPerfilDTO perfil);
}
