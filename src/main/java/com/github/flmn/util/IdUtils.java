package com.github.flmn.util;

import static com.github.flmn.util.BitUtils.int0;
import static com.github.flmn.util.BitUtils.int1;
import static com.github.flmn.util.BitUtils.int2;
import static com.github.flmn.util.BitUtils.int3;
import static com.github.flmn.util.BitUtils.short0;
import static com.github.flmn.util.BitUtils.short1;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public final class IdUtils {
    private static final char[] NANO_ALPHABET = "_-0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            .toCharArray();
    private static final int NANO_SIZE = 21;
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final AtomicInteger NEXT_COUNTER = new AtomicInteger(new SecureRandom().nextInt());
    private static final int RANDOM_VALUE1;
    private static final short RANDOM_VALUE2;

    static {
        try {
            RANDOM_VALUE1 = SECURE_RANDOM.nextInt(0x01000000);
            RANDOM_VALUE2 = (short) SECURE_RANDOM.nextInt(0x00008000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private IdUtils() {
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String compactUuid() {
        return uuid().replace("-", "");
    }

    public static String nanoId() {
        final int mask = (2 << (int) Math.floor(Math.log(NANO_ALPHABET.length - 1) / Math.log(2))) - 1;
        final int step = (int) Math.ceil(1.6 * mask * NANO_SIZE / NANO_ALPHABET.length);

        final StringBuilder idBuilder = new StringBuilder();

        while (true) {
            final byte[] bytes = new byte[step];
            SECURE_RANDOM.nextBytes(bytes);

            for (int i = 0; i < step; i++) {

                final int alphabetIndex = bytes[i] & mask;

                if (alphabetIndex < NANO_ALPHABET.length) {
                    idBuilder.append(NANO_ALPHABET[alphabetIndex]);
                    if (idBuilder.length() == NANO_SIZE) {
                        return idBuilder.toString();
                    }
                }

            }
        }
    }

    public static String mongoId() {
        ByteBuffer buffer = ByteBuffer.allocate(12);

        int timestamp = (int) Instant.now().getEpochSecond();
        int counter = NEXT_COUNTER.getAndIncrement();

        buffer.put(int3(timestamp));
        buffer.put(int2(timestamp));
        buffer.put(int1(timestamp));
        buffer.put(int0(timestamp));

        buffer.put(int2(RANDOM_VALUE1));
        buffer.put(int1(RANDOM_VALUE1));
        buffer.put(int0(RANDOM_VALUE1));

        buffer.put(short1(RANDOM_VALUE2));
        buffer.put(short0(RANDOM_VALUE2));

        buffer.put(int2(counter));
        buffer.put(int1(counter));
        buffer.put(int0(counter));

        return CodecUtils.base64Encode(buffer.array(), true);
    }
}
