package br.com.gs3.testetecnico.core.domain;

import br.com.gs3.testetecnico.core.exceptions.NegocioException;
import br.com.gs3.testetecnico.core.util.HashUtil;
import br.com.gs3.testetecnico.core.util.ValidadorCPF;
import br.com.gs3.testetecnico.core.util.ValidadorEmail;

import java.util.Objects;
import java.util.UUID;

public class Usuario {

    public static final int MIN_CARACTERES_SENHA = 8;
    private UUID codigo;

    private String nome;

    private String email;

    private String senha;

    private String cpf;

    private Perfil perfil;

    public Usuario(UUID codigo, String nome, String email, String senha, String cpf, Perfil perfil) {
        setCodigo(codigo);
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setCpf(cpf);
        setPerfil(perfil);
    }

    public Usuario(String nome, String email, String senha, String cpf, Perfil perfil) {
        this(UUID.randomUUID(), nome, email, senha, cpf, perfil);
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
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (Objects.isNull(email)) {
            throw new NegocioException("E-mail não deve ser nulo");
        }

        if (!ValidadorEmail.isEmailValido(email)) {
            throw new NegocioException("E-mail inválido");
        }
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (Objects.isNull(senha)) {
            throw new NegocioException("Senha não deve ser nula");
        }

        if (senha.length() < MIN_CARACTERES_SENHA) {
            throw new NegocioException("Senha deve ter no minimo 8 caracteres");
        }
        this.senha = HashUtil.hashSenha(senha);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (Objects.isNull(cpf)) {
            throw new NegocioException("O CPF não pode ser nulo");
        }

        if (!ValidadorCPF.isCpfValido(cpf)) {
            throw new NegocioException("O CPF é inválido");
        }
        this.cpf = cpf;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        if (Objects.isNull(perfil)) {
            throw new NegocioException("O perfil não pode ser nulo");
        }
        this.perfil = perfil;
    }
}
