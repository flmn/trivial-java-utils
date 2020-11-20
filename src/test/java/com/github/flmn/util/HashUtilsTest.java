package com.github.flmn.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashUtilsTest {

    @Test
    void fnv32Hash() {
        Assertions.assertEquals(0x050c5d49, HashUtils.fnv32Hash("V"));

        System.out.println(HashUtils.fnv32Hash("hello"));
        System.out.println(HashUtils.fnv32Hash("world"));
        System.out.println(HashUtils.fnv32Hash("hello world"));

        System.out.println(HashUtils.fnv64Hash("hello"));
    }
}