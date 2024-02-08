package br.com.gs3.testetecnico.ports.application.perfil.alteraperfil.dto;

import java.util.UUID;

public class AlteraPerfilDTO {

    private UUID codigo;

    private String nome;

    private String descricao;

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
