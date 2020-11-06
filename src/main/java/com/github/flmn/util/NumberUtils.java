package com.github.flmn.util;

public final class NumberUtils {
    private NumberUtils() {
    }

    public static int toInt(final String str, final int defaultValue) {
        if (StringUtils.isNullOrEmpty(str)) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(str);
        } catch (final NumberFormatException ignored) {
            return defaultValue;
        }
    }

    public static long toLong(final String str, final long defaultValue) {
        if (StringUtils.isNullOrEmpty(str)) {
            return defaultValue;
        }

        try {
            return Long.parseLong(str);
        } catch (final NumberFormatException ignored) {
            return defaultValue;
        }
    }
}
