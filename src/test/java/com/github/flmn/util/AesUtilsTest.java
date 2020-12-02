package com.github.flmn.util;

import org.junit.jupiter.api.Test;

class AesUtilsTest {

    @Test
    void encrypt() {
        String a = AesUtils.encrypt("1234567812345678", "0000000000000000", "abcdefg");
        System.out.println(a);
        System.out.println(AesUtils.decrypt("1234567812345678", "0000000000000000", a));
    }
}