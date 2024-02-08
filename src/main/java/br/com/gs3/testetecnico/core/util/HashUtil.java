package br.com.gs3.testetecnico.core.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class HashUtil {

    public static String hashSenha(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }
}
