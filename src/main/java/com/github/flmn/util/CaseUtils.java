package com.github.flmn.util;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class CaseUtils {
    private static final Pattern SPLIT_WORDS = Pattern.compile("\\s*(_|-|\\s+)\\s*");

    private CaseUtils() {
    }

    public static String toPascalCase(String str) {

        return str;
    }

    public static String toCamelCase(String str) {
        return str;
    }

    public static String toSnakeCase(String str) {
        String[] words = SPLIT_WORDS.split(str.trim());

        return Arrays.stream(words)
                .map(String::toLowerCase)
                .collect(Collectors.joining("_"));
    }

    public static String toKebabCase(String str) {
        return str;
    }
}
