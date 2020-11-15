package com.github.flmn.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    @Disabled
    void isNullOrEmpty() {
        Assertions.assertTrue(StringUtils.isNullOrEmpty(null));
        Assertions.assertTrue(StringUtils.isNullOrEmpty(""));
        Assertions.assertFalse(StringUtils.isNullOrEmpty(" "));
    }

    @Test
    void fileSize() {
        Assertions.assertEquals("768B", StringUtils.fileSize(768));
        Assertions.assertEquals("1.0KB", StringUtils.fileSize(1025));
        Assertions.assertEquals("1.9KB", StringUtils.fileSize(1986));
        Assertions.assertEquals("2.0KB", StringUtils.fileSize(1997));
    }
}