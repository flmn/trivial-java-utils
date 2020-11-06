package com.github.flmn.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberUtilsTest {

    @Test
    void toInt() {
        Assertions.assertEquals(-1, NumberUtils.toInt(null, -1));
        Assertions.assertEquals(-1, NumberUtils.toInt("", -1));
        Assertions.assertEquals(-1, NumberUtils.toInt("a", -1));
        Assertions.assertEquals(1, NumberUtils.toInt("1", -1));
    }

    @Test
    void toLong() {
        Assertions.assertEquals(-1, NumberUtils.toLong("", -1));
    }
}