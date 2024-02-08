package br.com.gs3.testetecnico.core.application.perfil;

import br.com.gs3.testetecnico.core.domain.Perfil;
import br.com.gs3.testetecnico.core.exceptions.NegocioException;
import br.com.gs3.testetecnico.ports.application.perfil.alteraperfil.dto.AlteraPerfilDTO;
import br.com.gs3.testetecnico.ports.adapters.dao.PerfilDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.AssertionErrors;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class AlteraPerfilUseCaseImplTest {

    @InjectMocks
    private AlteraPerfilUseCaseImpl alteraPerfilUseCase;

    @Mock
    private PerfilDAO perfilDAO;

    @Captor
    private ArgumentCaptor<Perfil> perfilArgumentCaptor;

    @Test
    void deveAlterarPerfil() {
        UUID codigo = UUID.randomUUID();

        AlteraPerfilDTO alteraPerfilDTO = new AlteraPerfilDTO();
        alteraPerfilDTO.setNome("ADMIN");
        alteraPerfilDTO.setDescricao("Descrição admin");
        alteraPerfilDTO.setCodigo(codigo);

        Mockito.when(perfilDAO.busca(codigo)).thenReturn(Optional.of(new Perfil(codigo, "dwd", "dwd")));

        Perfil perfil = alteraPerfilUseCase.execute(alteraPerfilDTO);

        Mockito.verify(perfilDAO, Mockito.times(1)).salva(perfilArgumentCaptor.capture());

        Assertions.assertEquals(alteraPerfilDTO.getCodigo(), perfil.getCodigo());
        Assertions.assertEquals(alteraPerfilDTO.getNome(), perfil.getNome());
        Assertions.assertEquals(alteraPerfilDTO.getDescricao(), perfil.getDescricao());

    }

    @Test
    void deveAlterarPerfilParaValoresInvalidos() {

        try {
            UUID codigo = UUID.randomUUID();

            AlteraPerfilDTO alteraPerfilDTO = new AlteraPerfilDTO();
            alteraPerfilDTO.setNome("ADMIN");
            alteraPerfilDTO.setDescricao(null);
            alteraPerfilDTO.setCodigo(codigo);

            Mockito.when(perfilDAO.busca(codigo)).thenReturn(Optional.of(new Perfil(codigo, "dwd", "dwd")));

            Perfil perfil = alteraPerfilUseCase.execute(alteraPerfilDTO);

            AssertionErrors.fail("Deveria ter dado Negocio Exception");
        } catch (NegocioException e) {
            Assertions.assertEquals("Descrição não deve ser nula", e.getMessage());
        } catch (Exception e) {
            AssertionErrors.fail("Deveria ter dado NegocioException");
        }

    }

}