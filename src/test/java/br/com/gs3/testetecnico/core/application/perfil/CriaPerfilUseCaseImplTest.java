package br.com.gs3.testetecnico.core.application.perfil;

import br.com.gs3.testetecnico.core.domain.Perfil;
import br.com.gs3.testetecnico.core.exceptions.NegocioException;
import br.com.gs3.testetecnico.ports.application.perfil.criaperfil.dto.CriaPerfilDTO;
import br.com.gs3.testetecnico.ports.adapters.dao.PerfilDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CriaPerfilUseCaseImplTest {

    @InjectMocks
    private CriaPerfilUseCaseImpl criaPerfilUseCase;

    @Mock
    private PerfilDAO perfilDAO;

    @Captor
    private ArgumentCaptor<Perfil> perfilArgumentCaptor;

    @Test
    void deveCriarUmNovoPerfil() {
        CriaPerfilDTO dto = new CriaPerfilDTO();

        dto.setNome("Administrador");
        dto.setDescricao("Perfil administrador com todas as permissões");

        criaPerfilUseCase.execute(dto);

        verify(perfilDAO, times(1)).salva(perfilArgumentCaptor.capture());

        Perfil perfilCriado = perfilArgumentCaptor.getValue();

        assertEquals(dto.getNome(), perfilCriado.getNome());
        assertEquals(dto.getDescricao(), perfilCriado.getDescricao());
        assertNotNull(perfilCriado.getCodigo());
    }

    @Test
    void deveDarErroCriarNovoPerfil() {
        try {
            CriaPerfilDTO dto = new CriaPerfilDTO();
            dto.setDescricao("Perfil administrador com todas as permissões");

            criaPerfilUseCase.execute(dto);

            fail("Deveria ter dado erro");
        } catch (NegocioException e) {
            assertEquals("Nome não deve ser nulo", e.getMessage());
        } catch (Exception e) {
            fail("Deveria ter dado NegocioException");
        }

    }

}