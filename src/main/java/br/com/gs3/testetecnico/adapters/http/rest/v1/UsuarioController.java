package br.com.gs3.testetecnico.adapters.http.rest.v1;

import br.com.gs3.testetecnico.core.domain.Usuario;
import br.com.gs3.testetecnico.ports.application.usuario.alterausuario.AlteraUsuarioUseCase;
import br.com.gs3.testetecnico.ports.application.usuario.alterausuario.dto.AlteraUsuarioDTO;
import br.com.gs3.testetecnico.ports.application.usuario.buscausuario.BuscaUsuarioPorCodigoUseCase;
import br.com.gs3.testetecnico.ports.application.usuario.buscausuario.dto.BuscaUsuarioPorCodigoDTO;
import br.com.gs3.testetecnico.ports.application.usuario.criausuario.CriaUsuarioUseCase;
import br.com.gs3.testetecnico.ports.application.usuario.criausuario.dto.CriaUsuarioDTO;
import br.com.gs3.testetecnico.ports.application.usuario.excluiusuario.ExcluiUsuarioUseCase;
import br.com.gs3.testetecnico.ports.application.usuario.excluiusuario.dto.ExcluiUsuarioDTO;
import br.com.gs3.testetecnico.ports.application.usuario.listausuarios.ListaUsuariosUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(UsuarioController.USUARIO_PATH)
public class UsuarioController {

    public static final String USUARIO_PATH = "v1/usuario";
    private final CriaUsuarioUseCase criaUsuarioUseCase;

    private final AlteraUsuarioUseCase alteraUsuarioUseCase;

    private final ExcluiUsuarioUseCase excluiUsuarioUseCase;

    private final ListaUsuariosUseCase listaUsuariosUseCase;

    private final BuscaUsuarioPorCodigoUseCase buscaUsuarioPorCodigoUseCase;

    public UsuarioController(CriaUsuarioUseCase criaUsuarioUseCase, AlteraUsuarioUseCase alteraUsuarioUseCase, ExcluiUsuarioUseCase excluiUsuarioUseCase, ListaUsuariosUseCase listaUsuariosUseCase, BuscaUsuarioPorCodigoUseCase buscaUsuarioPorCodigoUseCase) {
        this.criaUsuarioUseCase = criaUsuarioUseCase;
        this.alteraUsuarioUseCase = alteraUsuarioUseCase;
        this.excluiUsuarioUseCase = excluiUsuarioUseCase;
        this.listaUsuariosUseCase = listaUsuariosUseCase;
        this.buscaUsuarioPorCodigoUseCase = buscaUsuarioPorCodigoUseCase;
    }

    @PostMapping
    public ResponseEntity<?> criaUsuario(CriaUsuarioDTO dto) {
        Usuario usuarioCriado = criaUsuarioUseCase.execute(dto);

        return ResponseEntity.created(URI.create(USUARIO_PATH + "/" + usuarioCriado.getCodigo())).build();
    }

    @PutMapping
    public ResponseEntity<?> alteraUsuario(AlteraUsuarioDTO dto) {
        Usuario usuarioAlterado = alteraUsuarioUseCase.execute(dto);

        return ResponseEntity.ok(usuarioAlterado);
    }

    @DeleteMapping
    public ResponseEntity<?> excluiUsuario(ExcluiUsuarioDTO dto) {
        excluiUsuarioUseCase.execute(dto);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> listaUsuario() {
        List<Usuario> usuarios = listaUsuariosUseCase.execute();

        return ResponseEntity.ok(usuarios);
    }


    @GetMapping("{codigo}")
    public ResponseEntity<?> buscaUsuario(@RequestParam UUID codigo) {
        BuscaUsuarioPorCodigoDTO dto = new BuscaUsuarioPorCodigoDTO();
        dto.setCodigo(codigo);

        Usuario usuario = buscaUsuarioPorCodigoUseCase.execute(dto);

        return ResponseEntity.ok(usuario);
    }
}
