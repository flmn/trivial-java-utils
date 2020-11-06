package com.github.flmn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void isNullOrEmpty() {
        Assertions.assertTrue(StringUtils.isNullOrEmpty(null));
        Assertions.assertTrue(StringUtils.isNullOrEmpty(""));
        Assertions.assertFalse(StringUtils.isNullOrEmpty(" "));
    }
}