package com.github.flmn.util;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public final class AesUtils {
    public static final String ALGORITHM = "AES";
    public static final String SECRET_KEY_ALGORITHM = "PBKDF2WithHmacSHA256";
    public static final String DEFAULT_PADDING = "AES/CBC/PKCS5Padding";

    private AesUtils() {
    }

    /**
     * generating an AES key with the size of keySize (128, 192, and 256) bits
     *
     * @param keySize length of key
     * @return SecretKey
     */
    public static SecretKey generateSecretKey(int keySize) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(keySize);

            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * generating an AES key from a given password with 65,536 iterations and a key length of 256 bits
     *
     * @param password
     * @param salt
     * @return SecretKey
     */
    public static SecretKey getKeyFromPassword(String password, String salt) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_ALGORITHM);
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);

            return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), ALGORITHM);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return null;
        }
    }

    /**
     * generate a random Initialization Vector (IV)
     *
     * @return IV
     */
    public static IvParameterSpec generateIv() {
        byte[] bytes = new byte[16];

        new SecureRandom().nextBytes(bytes);

        return new IvParameterSpec(bytes);
    }

    public static String encrypt(SecretKey key, IvParameterSpec iv, String data) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] cipherText = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(cipherText);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException | InvalidAlgorithmParameterException e) {
            return null;
        }
    }

    public static String encrypt(String key, String iv, String data) {
        return encrypt(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM)
                , new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)),
                data);
    }

    public static String decrypt(SecretKey key, IvParameterSpec iv, String base64Data) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_PADDING);
            cipher.init(Cipher.DECRYPT_MODE, key, iv);

            byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(base64Data));

            return new String(bytes, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException | InvalidAlgorithmParameterException e) {
            return null;
        }
    }

    public static String decrypt(String key, String iv, String base64Data) {
        return decrypt(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM),
                new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)),
                base64Data);
    }
}
