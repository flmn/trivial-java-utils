package com.github.flmn.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class FilenameUtils {
    private static final Pattern ONE_EXTENSION_PATTERN = Pattern.compile("(?<!^)[.][^.]*$");
    private static final Pattern ALL_EXTENSION_PATTERN = Pattern.compile("(?<!^)[.].*");

    private FilenameUtils() {
    }

    public static String removeFileExtension(String filename, boolean removeAll) {
        if (StringUtils.isNullOrEmpty(filename)) {
            return filename;
        }

        Matcher matcher = removeAll ? ALL_EXTENSION_PATTERN.matcher(filename) : ONE_EXTENSION_PATTERN.matcher(filename);

        return matcher.replaceAll("");
    }
}
