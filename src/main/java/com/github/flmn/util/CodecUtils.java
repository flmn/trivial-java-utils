package com.github.flmn.util;

import java.util.Base64;

public final class CodecUtils {
    private CodecUtils() {
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() < 2) {
                sb.append(0);
            }
            sb.append(hex);
        }

        return sb.toString().toUpperCase();
    }

    public static String base64Encode(byte[] bytes, boolean urlSafe) {
        if (urlSafe) {
            return Base64.getUrlEncoder().encodeToString(bytes);
        } else {
            return Base64.getEncoder().encodeToString(bytes);
        }
    }

    public static byte[] base64Decode(String str, boolean urlSafe) {
        if (urlSafe) {
            return Base64.getUrlDecoder().decode(str);
        } else {
            return Base64.getDecoder().decode(str);
        }
    }
}
