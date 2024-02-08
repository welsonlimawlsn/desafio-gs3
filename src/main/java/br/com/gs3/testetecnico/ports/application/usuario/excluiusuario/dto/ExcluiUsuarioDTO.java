package br.com.gs3.testetecnico.ports.application.usuario.excluiusuario.dto;

import java.util.UUID;

public class ExcluiUsuarioDTO {

    private UUID codigoUsuario;

    public UUID getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(UUID codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
}
