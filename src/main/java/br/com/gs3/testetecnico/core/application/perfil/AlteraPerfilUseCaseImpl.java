package br.com.gs3.testetecnico.core.application.perfil;

import br.com.gs3.testetecnico.core.domain.Perfil;
import br.com.gs3.testetecnico.core.exceptions.NegocioException;
import br.com.gs3.testetecnico.ports.application.perfil.alteraperfil.dto.AlteraPerfilDTO;
import br.com.gs3.testetecnico.ports.application.perfil.alteraperfil.AlteraPerfilUseCase;
import br.com.gs3.testetecnico.ports.adapters.dao.PerfilDAO;
import org.springframework.stereotype.Service;

@Service
public class AlteraPerfilUseCaseImpl implements AlteraPerfilUseCase {

    private final PerfilDAO perfilDAO;

    public AlteraPerfilUseCaseImpl(PerfilDAO perfilDAO) {
        this.perfilDAO = perfilDAO;
    }

    @Override
    public Perfil execute(AlteraPerfilDTO perfilAtualizacao) {
        Perfil perfil = perfilDAO.busca(perfilAtualizacao.getCodigo())
                .orElseThrow(() -> new NegocioException("Perfil não existe"));

        perfil.setNome(perfilAtualizacao.getNome());
        perfil.setDescricao(perfilAtualizacao.getDescricao());

        perfilDAO.salva(perfil);

        return perfil;
    }
}
