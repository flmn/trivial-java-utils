package com.github.flmn.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashUtils {
    private HashUtils() {
    }

    public static String md5(String src) {
        return digest("MD5", src);
    }

    public static String sha1(String src) {
        return digest("SHA1", src);
    }

    private static String digest(String algorithm, String src) {
        if (StringUtils.isNullOrEmpty(src)) {
            return "";
        }

        final MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            return "";
        }

        md.update(src.getBytes(StandardCharsets.UTF_8));

        return CodecUtils.bytesToHex(md.digest());
    }
}
