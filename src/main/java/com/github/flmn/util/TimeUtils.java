package com.github.flmn.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class TimeUtils {
    public static final ZoneId CST = ZoneId.of("Asia/Shanghai");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String format(LocalDate ld) {
        return DATE_FORMATTER.format(ld);
    }

    public static String format(LocalDateTime ldt) {
        return DATE_TIME_FORMATTER.format(ldt);
    }

    public static LocalDate parseDate(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return null;
        }

        try {
            return LocalDate.parse(str, DATE_FORMATTER);
        } catch (DateTimeParseException ignored) {
        }

        return null;
    }

    public static LocalDateTime parseDateTime(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return null;
        }

        try {
            return LocalDateTime.parse(str, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException ignored) {
        }

        return null;
    }

    public static LocalDateTime toBeijingTime(ZonedDateTime zdt) {
        return LocalDateTime.ofInstant(zdt.toInstant(), TimeUtils.CST);
    }
}
