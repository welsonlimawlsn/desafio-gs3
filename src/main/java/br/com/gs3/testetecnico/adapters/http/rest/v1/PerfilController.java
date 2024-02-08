package br.com.gs3.testetecnico.adapters.http.rest.v1;

import br.com.gs3.testetecnico.core.domain.Perfil;
import br.com.gs3.testetecnico.ports.application.perfil.listaperfis.ListaPerfisUseCase;
import br.com.gs3.testetecnico.ports.application.perfil.alteraperfil.AlteraPerfilUseCase;
import br.com.gs3.testetecnico.ports.application.perfil.alteraperfil.dto.AlteraPerfilDTO;
import br.com.gs3.testetecnico.ports.application.perfil.criaperfil.CriaPerfilUseCase;
import br.com.gs3.testetecnico.ports.application.perfil.criaperfil.dto.CriaPerfilDTO;
import br.com.gs3.testetecnico.ports.application.perfil.excluiperfil.ExcluiPerfilUseCase;
import br.com.gs3.testetecnico.ports.application.perfil.excluiperfil.dto.ExcluiPerfilDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(PerfilController.PATH_PERFIL)
public class PerfilController {

    public static final String PATH_PERFIL = "v1/perfil";
    private final CriaPerfilUseCase criaPerfilUseCase;

    private final AlteraPerfilUseCase alteraPerfilUseCase;

    private final ListaPerfisUseCase listaPerfisUseCase;

    private final ExcluiPerfilUseCase excluiPerfilUseCase;

    public PerfilController(CriaPerfilUseCase criaPerfilUseCase, AlteraPerfilUseCase alteraPerfilUseCase, ListaPerfisUseCase listaPerfisUseCase, ExcluiPerfilUseCase excluiPerfilUseCase) {
        this.criaPerfilUseCase = criaPerfilUseCase;
        this.alteraPerfilUseCase = alteraPerfilUseCase;
        this.listaPerfisUseCase = listaPerfisUseCase;
        this.excluiPerfilUseCase = excluiPerfilUseCase;
    }

    @PostMapping
    public ResponseEntity<?> criaPerfil(@RequestBody CriaPerfilDTO dto) {
        Perfil perfilCriado = criaPerfilUseCase.execute(dto);
        return ResponseEntity
                .created(URI.create(String.format("%s/%s", PATH_PERFIL, perfilCriado.getCodigo())))
                .build();
    }

    @PutMapping("{codigo}")
    public ResponseEntity<?> alteraPerfil(@PathVariable("codigo") UUID codigo, @RequestBody AlteraPerfilDTO dto) {
        dto.setCodigo(codigo);

        Perfil perfil = alteraPerfilUseCase.execute(dto);

        return ResponseEntity.ok(perfil);
    }

    @GetMapping
    public ResponseEntity<?> listaPerfis() {
        List<Perfil> lista = listaPerfisUseCase.execute();

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity<?> excluiPerfil(@PathVariable UUID codigo) {
        ExcluiPerfilDTO dto = new ExcluiPerfilDTO();
        dto.setCodigo(codigo);

        excluiPerfilUseCase.execute(dto);

        return ResponseEntity.ok().build();
    }
}
