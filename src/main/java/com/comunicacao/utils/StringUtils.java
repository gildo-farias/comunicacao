package com.comunicacao.utils;

import java.util.Objects;

public class StringUtils {

    public static boolean vazia(String str) {
        return Objects.isNull(str) || str.isEmpty() || str.isBlank();
    }

}
