package br.com.gs3.testetecnico.core.application.perfil;

import br.com.gs3.testetecnico.core.domain.Perfil;
import br.com.gs3.testetecnico.ports.adapters.dao.PerfilDAO;
import br.com.gs3.testetecnico.ports.application.perfil.listaperfis.ListaPerfisUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaPerfisUseCaseImpl implements ListaPerfisUseCase {

    private final PerfilDAO perfilDAO;

    public ListaPerfisUseCaseImpl(PerfilDAO perfilDAO) {
        this.perfilDAO = perfilDAO;
    }

    @Override
    public List<Perfil> execute() {
        return perfilDAO.lista();
    }
}
