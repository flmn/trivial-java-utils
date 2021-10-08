package com.github.flmn.util.validation;

import java.util.regex.Pattern;

/*
https://www.baeldung.com/java-email-validation-regex
 */
public final class EmailValidator {

    private static final Pattern SIMPLE = Pattern.compile("^(.+)@(\\S+)$");
    private static final Pattern STRICT = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    private static final Pattern UNICODE = Pattern.compile("^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$");
    private static final Pattern RFC_5322 = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    private static final Pattern TLD = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
    private static final Pattern RESTRICT_DOTS = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
    private static final Pattern OWASP = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}");
    private static final Pattern GMAIL = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-+]+(\\.[A-Za-z0-9-+]+)*(\\.[A-Za-z]{2,})$");

    private EmailValidator() {
    }

    private static boolean matches(Pattern pattern, String email) {
        return pattern.matcher(email)
                .matches();
    }

    public static boolean simple(String email) {
        return matches(SIMPLE, email);
    }

    public static boolean strict(String email) {
        return matches(STRICT, email);
    }

    public static boolean unicode(String email) {
        return matches(UNICODE, email);
    }

    public static boolean rfc5322(String email) {
        return matches(RFC_5322, email);
    }

    public static boolean tld(String email) {
        return matches(TLD, email);
    }

    public static boolean restrictDots(String email) {
        return matches(RESTRICT_DOTS, email);
    }

    public static boolean owasp(String email) {
        return matches(OWASP, email);
    }

    public static boolean gmail(String email) {
        return matches(GMAIL, email);
    }
}
