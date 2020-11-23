package com.github.flmn.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

public final class TimeUtils {
    public static final ZoneId CST = ZoneId.of("Asia/Shanghai");
    public static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final Map<String, DateTimeFormatter> DATE_TIME_FORMATTERS;

    static {
        DATE_TIME_FORMATTERS = new HashMap<>();

        String[] formats = {
                "yyyy-MM-dd HH:mm:ss",
                "yyyy-MM-dd HH:mm:ss.SSS",
                "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
                "yyyy-MM-dd'T'HH:mm:ss'Z'",
                "yyyy-MM-dd'T'HH:mm:ss.SSS",
                "yyyy-MM-dd'T'HH:mm:ss"
        };

        for (String format : formats) {
            DATE_TIME_FORMATTERS.put(format, DateTimeFormatter.ofPattern(format));
        }
    }

    private TimeUtils() {
    }

    public static LocalDateTime utcNow() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }

    public static String format(LocalDate ld) {
        return DEFAULT_DATE_FORMATTER.format(ld);
    }

    public static String format(LocalDateTime ldt) {
        return DEFAULT_DATE_TIME_FORMATTER.format(ldt);
    }

    public static String format(LocalDateTime ldt, String format) {
        DateTimeFormatter formatter = DATE_TIME_FORMATTERS.getOrDefault(format, DateTimeFormatter.ofPattern(format));

        return formatter.format(ldt);
    }

    public static LocalDate parseDate(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return null;
        }

        try {
            return LocalDate.parse(str, DEFAULT_DATE_FORMATTER);
        } catch (DateTimeParseException ignored) {
        }

        return null;
    }

    public static LocalDateTime parseDateTime(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return null;
        }

        for (DateTimeFormatter formatter : DATE_TIME_FORMATTERS.values()) {
            try {
                return LocalDateTime.parse(str, formatter);
            } catch (DateTimeParseException ignored) {
            }
        }

        return null;
    }

    public static LocalDateTime parseDateTime(String str, String format) {
        if (StringUtils.isNullOrEmpty(str)) {
            return null;
        }

        DateTimeFormatter formatter = DATE_TIME_FORMATTERS.getOrDefault(format, DateTimeFormatter.ofPattern(format));

        try {
            return LocalDateTime.parse(str, formatter);
        } catch (DateTimeParseException ignored) {
            return null;
        }
    }

    public static LocalDateTime toBeijingTime(ZonedDateTime zdt) {
        return LocalDateTime.ofInstant(zdt.toInstant(), TimeUtils.CST);
    }
}
