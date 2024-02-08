package br.com.gs3.testetecnico.core.application.perfil;

import br.com.gs3.testetecnico.core.domain.Perfil;
import br.com.gs3.testetecnico.core.exceptions.NegocioException;
import br.com.gs3.testetecnico.ports.adapters.dao.PerfilDAO;
import br.com.gs3.testetecnico.ports.application.perfil.excluiperfil.ExcluiPerfilUseCase;
import br.com.gs3.testetecnico.ports.application.perfil.excluiperfil.dto.ExcluiPerfilDTO;
import org.springframework.stereotype.Service;

@Service
public class ExcluiPerfilUseCaseImpl implements ExcluiPerfilUseCase {

    private final PerfilDAO perfilDAO;

    public ExcluiPerfilUseCaseImpl(PerfilDAO perfilDAO) {
        this.perfilDAO = perfilDAO;
    }

    @Override

    public void execute(ExcluiPerfilDTO dto) {
        Perfil perfil = perfilDAO.busca(dto.getCodigo())
                .orElseThrow(() -> new NegocioException("Perfil não encontrado"));

        perfilDAO.deleta(perfil);
    }
}
