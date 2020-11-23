package com.github.flmn.util;

public final class StringBoolean {
    public static final String TRUE = "Y";
    public static final String FALSE = "N";

    private StringBoolean() {
    }

    public static boolean toBool(String str) {
        return TRUE.equals(str);
    }

    public static String toString(Boolean bool) {
        if (bool != null && bool) {
            return TRUE;
        } else {
            return FALSE;
        }
    }

    public static boolean isValid(String str) {
        return !TRUE.equals(str) && !FALSE.equals(str);
    }
}
