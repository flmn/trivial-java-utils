package com.github.flmn.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    void isNullOrEmpty() {
        Assertions.assertTrue(StringUtils.isNullOrEmpty(null));
        Assertions.assertTrue(StringUtils.isNullOrEmpty(""));
        Assertions.assertFalse(StringUtils.isNullOrEmpty(" "));
    }
}