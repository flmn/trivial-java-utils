package com.github.flmn.util;

public final class StringUtils {
    private StringUtils() {}

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
