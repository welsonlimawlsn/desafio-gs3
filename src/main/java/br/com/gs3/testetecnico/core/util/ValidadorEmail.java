package br.com.gs3.testetecnico.core.util;

import java.util.regex.Pattern;

public class ValidadorEmail {

    public static final Pattern EMAIL_PATTERN = Pattern.compile("^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.\\p{L}{2,})$");

    private ValidadorEmail() {
    }

    public static boolean isEmailValido(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
