package br.com.gs3.testetecnico.core.domain;

import br.com.gs3.testetecnico.core.exceptions.NegocioException;

import java.util.Objects;
import java.util.UUID;

public class Perfil {

    private UUID codigo;

    private String nome;

    private String descricao;

    public Perfil(String nome, String descricao) {
        this(UUID.randomUUID(), nome, descricao);
    }

    public Perfil(UUID codigo, String nome, String descricao) {
        setCodigo(codigo);
        setNome(nome);
        setDescricao(descricao);
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        if (Objects.isNull(codigo)) {
            throw new NegocioException("Código não deve ser nulo");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (Objects.isNull(nome)) {
            throw new NegocioException("Nome não deve ser nulo");
        }
        this.nome = nome.strip();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (Objects.isNull(descricao)) {
            throw new NegocioException("Descrição não deve ser nula");
        }
        this.descricao = descricao;
    }
}
