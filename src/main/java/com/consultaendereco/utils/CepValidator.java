package com.consultaendereco.utils;

import java.util.regex.Pattern;

public class CepValidator {

    private static final String CEP_PATTERN = "^[0-9]{5}-?[0-9]{3}$";
    private static final String DIGIT_PATTERN = "^[0-9]+$";

    public static boolean isValidCep(String cep) {
        return Pattern.matches(CEP_PATTERN, cep);
    }

    public static boolean containsOnlyDigits(String str) {
        return Pattern.matches(DIGIT_PATTERN, str);
    }
}
