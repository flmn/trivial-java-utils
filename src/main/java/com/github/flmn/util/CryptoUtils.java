package com.github.flmn.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public final class CryptoUtils {
    private CryptoUtils() {
    }

    public static String hmacSha256(String src, String key) {
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(), "HmacSHA256");

        Mac mac;
        try {
            mac = Mac.getInstance("HmacSHA256");
            mac.init(secret_key);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            return null;
        }

        byte[] bytes = mac.doFinal(src.getBytes(StandardCharsets.UTF_8));

        return CodecUtils.bytesToHex(bytes);
    }
}
