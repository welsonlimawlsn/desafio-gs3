package br.com.gs3.testetecnico.core.application.perfil;

import br.com.gs3.testetecnico.core.domain.Perfil;
import br.com.gs3.testetecnico.core.exceptions.NegocioException;
import br.com.gs3.testetecnico.ports.adapters.dao.PerfilDAO;

import java.util.UUID;

public class PerfilService {

    private final PerfilDAO perfilDAO;

    public PerfilService(PerfilDAO perfilDAO) {
        this.perfilDAO = perfilDAO;
    }

    public Perfil buscaPerfil(UUID codigo) {
        return perfilDAO.busca(codigo).orElseThrow(() -> new NegocioException("Perfil inválido"));
    }
}
