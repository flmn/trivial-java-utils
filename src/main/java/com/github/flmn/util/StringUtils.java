package com.github.flmn.util;

import java.text.DecimalFormat;
import java.util.UUID;

public final class StringUtils {
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String LF = "\n";
    public static final String CR = "\r";

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#0.0");

    private StringUtils() {
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotNullOrEmpty(String str) {
        return !isNullOrEmpty(str);
    }

    public static String toString(Object obj, boolean nullString) {
        if (obj == null) {
            return nullString ? "null" : null;
        }

        return obj.toString();
    }

    public static boolean isBlank(String str) {
        if (isNullOrEmpty(str)) {
            return true;
        }

        return str.codePoints().allMatch(Character::isWhitespace);
    }

    public static String trim(String src, int count) {
        if (isNullOrEmpty(src) || src.length() <= count) {
            return src;
        }

        return src.substring(0, count);
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String shortUuid() {
        return uuid().replace("-", "");
    }

    public static String omit(String src, int count) {
        if (isNullOrEmpty(src) || src.length() <= count) {
            return src;
        }

        return src.substring(0, count - 3) + "...";
    }

    public static String fileSize(long size) {
        if (size == 0) {
            return "0B";
        }

        double d = (double) size;

        if (size < 1024L) {
            return String.format("%dB", size);
        } else if (size < 1024L * 1024L) {
            double a = d / 1024L;
            return DECIMAL_FORMAT.format(d / 1024L) + "KB";
        } else if (size < 1024L * 1024L * 1024L) {
            return DECIMAL_FORMAT.format(d / 1024L / 1024L) + "MB";
        } else if (size < 1024L * 1024L * 1024L * 1024L) {
            return DECIMAL_FORMAT.format(d / 1024L / 1024L / 1024L) + "GB";
        } else {
            return DECIMAL_FORMAT.format(d / 1024L / 1024L / 1024L / 1024L) + "TB";
        }
    }
}
