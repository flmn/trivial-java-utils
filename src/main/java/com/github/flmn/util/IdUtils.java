package com.github.flmn.util;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import static com.github.flmn.util.BitUtils.*;

public final class IdUtils {
    private static final AtomicInteger NEXT_COUNTER = new AtomicInteger(new SecureRandom().nextInt());
    private static final int RANDOM_VALUE1;
    private static final short RANDOM_VALUE2;

    static {
        try {
            SecureRandom secureRandom = new SecureRandom();
            RANDOM_VALUE1 = secureRandom.nextInt(0x01000000);
            RANDOM_VALUE2 = (short) secureRandom.nextInt(0x00008000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private IdUtils() {
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String shortUuid() {
        return uuid().replace("-", "");
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
