package com.github.flmn.util;

import java.time.LocalDate;

public final class IntDateUtils {
    public static final int EPOCH = 20000000;

    private IntDateUtils() {
    }

    public static int intDate(LocalDate localDate) {
        return localDate.getYear() * 10000 + localDate.getMonthValue() * 100 + localDate.getDayOfMonth();
    }

    public static LocalDate localDate(int intDate) {
        return LocalDate.of(intDate / 10000, (intDate % 10000) / 100, intDate % 100);
    }

    public static int plusDays(int today, int plus) {
        return intDate(localDate(today).plusDays(plus));
    }

    public static int minusDays(int today, int minus) {
        return intDate(localDate(today).minusDays(minus));
    }

    public static int yesterday(int today) {
        return minusDays(today, 1);
    }

    public static int tomorrow(int today) {
        return plusDays(today, 1);
    }
}
