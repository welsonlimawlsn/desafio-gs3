package br.com.gs3.testetecnico.ports.application.usuario.buscausuario.dto;

import java.util.UUID;

public class BuscaUsuarioPorCodigoDTO {

    private UUID codigo;

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }
}
