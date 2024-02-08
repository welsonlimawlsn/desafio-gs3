package br.com.gs3.testetecnico.core.application.perfil;

import br.com.gs3.testetecnico.core.domain.Perfil;
import br.com.gs3.testetecnico.ports.application.perfil.criaperfil.CriaPerfilUseCase;
import br.com.gs3.testetecnico.ports.application.perfil.criaperfil.dto.CriaPerfilDTO;
import br.com.gs3.testetecnico.ports.adapters.dao.PerfilDAO;
import org.springframework.stereotype.Service;

@Service
public class CriaPerfilUseCaseImpl implements CriaPerfilUseCase {

    private PerfilDAO perfilDAO;

    public CriaPerfilUseCaseImpl(PerfilDAO perfilDAO) {
        this.perfilDAO = perfilDAO;
    }

    @Override
    public Perfil execute(CriaPerfilDTO dto) {
        Perfil perfil = new Perfil(dto.getNome(), dto.getDescricao());

        perfilDAO.salva(perfil);

        return perfil;
    }
}
