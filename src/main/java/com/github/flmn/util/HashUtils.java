package com.github.flmn.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class HashUtils {

    public static String md5(String src) {
        return digest("MD5", src);
    }

    public static String sha1(String src) {
        return digest("SHA1", src);
    }

    /**
     * FNV 32 hash
     * http://www.isthe.com/chongo/tech/comp/fnv/
     *
     * @param src input string
     * @return hash value
     */
    public static int fnv32Hash(String src) {
        long offsetBasics = 2166136261L;
        int prime = 16777619;

        int hash = (int) offsetBasics;

        for (byte b : src.getBytes(StandardCharsets.UTF_8)) {
            hash *= prime;
            hash ^= b;
        }

        return hash;
    }

    /**
     * FNV 64 hash
     * http://www.isthe.com/chongo/tech/comp/fnv/
     *
     * @param src input string
     * @return hash value
     */
    public static long fnv64Hash(String src) {
        long offsetBasics = 0xcbf29ce484222325L;
        long prime = 0x100000001b3L;

        long hash = offsetBasics;

        for (byte b : src.getBytes(StandardCharsets.UTF_8)) {
            hash *= prime;
            hash ^= b;
        }

        return hash;
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
