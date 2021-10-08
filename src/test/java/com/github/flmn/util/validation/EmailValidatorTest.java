package com.github.flmn.util.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailValidatorTest {
    private static final String[] GOODS = {
            "username@domain.com",
            "user.name@domain.com",
            "user-name@domain.com",
            "username@domain.co.in",
            "user_name@domain.com"
    };

    private static final String[] BADS = {
            "username.@domain.com",
            ".user.name@domain.com",
            "user-name@domain.com.",
            "username@.com"
    };

    @Test
    void simple() {
        for (String s : GOODS) {
            boolean result = EmailValidator.simple(s);
            assertTrue(result);
        }
    }

    @Test
    void strict() {
        for (String s : GOODS) {
            boolean result = EmailValidator.strict(s);
            assertTrue(result);
        }

        for (String s : BADS) {
            boolean result = EmailValidator.strict(s);
            assertFalse(result);
        }
    }

    @Test
    void unicode() {
        assertTrue(EmailValidator.unicode("用户名@领域.电脑"));

        for (String s : GOODS) {
            boolean result = EmailValidator.rfc5322(s);
            assertTrue(result);
        }

        for (String s : BADS) {
            boolean result = EmailValidator.strict(s);
            assertFalse(result);
        }
    }

    @Test
    void rfc5322() {
        for (String s : GOODS) {
            boolean result = EmailValidator.rfc5322(s);
            assertTrue(result);
        }

        for (String s : BADS) {
            boolean result = EmailValidator.strict(s);
            assertFalse(result);
        }
    }

    @Test
    void tld() {
        for (String s : GOODS) {
            boolean result = EmailValidator.tld(s);
            assertTrue(result);
        }

        for (String s : BADS) {
            boolean result = EmailValidator.strict(s);
            assertFalse(result);
        }
    }

    @Test
    void restrictDots() {
        for (String s : GOODS) {
            boolean result = EmailValidator.restrictDots(s);
            assertTrue(result);
        }

        for (String s : BADS) {
            boolean result = EmailValidator.strict(s);
            assertFalse(result);
        }
    }

    @Test
    void owasp() {
        for (String s : GOODS) {
            boolean result = EmailValidator.owasp(s);
            assertTrue(result);
        }

        for (String s : BADS) {
            boolean result = EmailValidator.owasp(s);
            assertFalse(result);
        }
    }

    @Test
    void gmail() {
        for (String s : GOODS) {
            boolean result = EmailValidator.gmail(s);
            assertTrue(result);
        }

        for (String s : BADS) {
            boolean result = EmailValidator.gmail(s);
            assertFalse(result);
        }
    }
}