package com.github.flmn.util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;

class TimeUtilsTest {

    @Test
    @Disabled
    void parseDateTime() {
        System.out.println(TimeUtils.parseDateTime("2020-11-20T12:34:56Z"));
        System.out.println(TimeUtils.parseDateTime("2020-11-20T12:34:56.789Z"));
        System.out.println(TimeUtils.parseDateTime("2020-11-20T12:34:56"));
        System.out.println(TimeUtils.parseDateTime("2020-11-20T12:34:56.789"));
        System.out.println(TimeUtils.parseDateTime("2020-11-20 12:34:56"));
        System.out.println(TimeUtils.parseDateTime("2020-11-20 12:34:56.789"));
    }

    @Test
    void near() {
        System.out.println(TimeUtils.near(TimeUtils.parseDateTime("2020-11-20T12:34:56Z"), TimeUtils.parseDateTime("2020-11-20T12:34:56Z"), 1, ChronoUnit.MINUTES));
        System.out.println(TimeUtils.near(TimeUtils.parseDateTime("2020-11-20T12:34:56Z"), TimeUtils.parseDateTime("2020-11-20T12:33:56Z"), 1, ChronoUnit.MINUTES));
        System.out.println(TimeUtils.near(TimeUtils.parseDateTime("2020-11-20T12:34:56Z"), TimeUtils.parseDateTime("2020-11-20T12:33:57Z"), 1, ChronoUnit.MINUTES));
        System.out.println(TimeUtils.near(TimeUtils.parseDateTime("2020-11-20T12:34:56Z"), TimeUtils.parseDateTime("2020-11-20T12:35:56Z"), 1, ChronoUnit.MINUTES));
        System.out.println(TimeUtils.near(TimeUtils.parseDateTime("2020-11-20T12:34:56Z"), TimeUtils.parseDateTime("2020-11-20T12:35:55Z"), 1, ChronoUnit.MINUTES));
    }
}