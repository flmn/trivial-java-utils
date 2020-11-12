package com.github.flmn.util;

import java.util.UUID;

public final class StringUtils {
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String LF = "\n";
    public static final String CR = "\r";

    private StringUtils() {
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String shortUuid() {
        return uuid().replace("-", "");
    }
}
