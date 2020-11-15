package com.github.flmn.util.id;

import org.junit.jupiter.api.Test;

class ObjectIdTest {

    @Test
    void test() {
        for (int i = 0; i < 100; i++) {
            ObjectId id = new ObjectId();

            System.out.println(id);
            System.out.println(id.toBase64String());
        }
    }
}