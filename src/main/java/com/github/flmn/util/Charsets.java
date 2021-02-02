package com.github.flmn.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public interface Charsets {
    Charset US_ASCII = StandardCharsets.US_ASCII;
    Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
    Charset UTF_8 = StandardCharsets.UTF_8;
    Charset UTF_16BE = StandardCharsets.UTF_16BE;
    Charset UTF_16LE = StandardCharsets.UTF_16LE;
    Charset UTF_16 = StandardCharsets.UTF_16;
    Charset GBK = Charset.forName("GBK");
    Charset GB2312 = Charset.forName("GB2312");
    Charset BIG5 = Charset.forName("BIG5");
}
