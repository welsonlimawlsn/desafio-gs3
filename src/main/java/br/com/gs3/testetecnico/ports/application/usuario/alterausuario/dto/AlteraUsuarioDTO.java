package br.com.gs3.testetecnico.ports.application.usuario.alterausuario.dto;

import java.util.UUID;

public class AlteraUsuarioDTO {

    private UUID codigo;
    private String nome;

    private String email;

    private String senha;

    private String cpf;

    private UUID codigoPerfil;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public UUID getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(UUID codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }
}
