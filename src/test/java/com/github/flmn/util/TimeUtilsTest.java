package com.github.flmn.util;

import org.junit.jupiter.api.Test;

class TimeUtilsTest {

    @Test
    void parseDateTime() {
        System.out.println(TimeUtils.parseDateTime("2020-11-20T12:34:56Z"));
        System.out.println(TimeUtils.parseDateTime("2020-11-20T12:34:56.789Z"));
        System.out.println(TimeUtils.parseDateTime("2020-11-20T12:34:56"));
        System.out.println(TimeUtils.parseDateTime("2020-11-20T12:34:56.789"));
        System.out.println(TimeUtils.parseDateTime("2020-11-20 12:34:56"));
        System.out.println(TimeUtils.parseDateTime("2020-11-20 12:34:56.789"));
    }
}