package com.github.flmn.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class Charsets {

    public static final Charset US_ASCII = StandardCharsets.US_ASCII;
    public static final Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
    public static final Charset UTF_8 = StandardCharsets.UTF_8;
    public static final Charset UTF_16BE = StandardCharsets.UTF_16BE;
    public static final Charset UTF_16LE = StandardCharsets.UTF_16LE;
    public static final Charset UTF_16 = StandardCharsets.UTF_16;
    public static final Charset GBK = Charset.forName("GBK");
    public static final Charset GB2312 = Charset.forName("GB2312");
    public static final Charset BIG5 = Charset.forName("BIG5");

    private Charsets() {
    }
}
