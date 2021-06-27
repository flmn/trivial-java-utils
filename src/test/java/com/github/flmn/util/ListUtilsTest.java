package com.github.flmn.util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListUtilsTest {

    @Test
    @Disabled
    void head() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

        System.out.println(ListUtils.head(list, 5));

        list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i + 1);
        }

        System.out.println(ListUtils.head(list, 5));
        System.out.println(ListUtils.head(Collections.emptyList(), 5));
    }

    @Test
    void tail() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

        System.out.println(ListUtils.tail(list, 5));

        list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i + 1);
        }

        System.out.println(ListUtils.tail(list, 5));
        System.out.println(ListUtils.tail(Collections.emptyList(), 5));
    }
}