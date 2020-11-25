package com.github.flmn.util;

import java.security.SecureRandom;
import java.util.Random;

public final class RandomUtils {
    private static final Random RANDOM = new SecureRandom();

    private RandomUtils() {
    }

    public static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }

    public static int nextInt() {
        return nextInt(0, Integer.MAX_VALUE);
    }

    public static int nextInt(int startInclusive, int endExclusive) {
        if (startInclusive == endExclusive) {
            return startInclusive;
        }

        return startInclusive + RANDOM.nextInt(endExclusive - startInclusive);
    }

    public static long nextLong() {
        return nextLong(0, Long.MAX_VALUE);
    }

    public static long nextLong(long startInclusive, long endExclusive) {
        if (startInclusive == endExclusive) {
            return startInclusive;
        }

        return (long) nextDouble(startInclusive, endExclusive);
    }

    public static float nextFloat() {
        return nextFloat(0, Float.MAX_VALUE);
    }

    public static float nextFloat(float startInclusive, float endExclusive) {
        if (startInclusive == endExclusive) {
            return startInclusive;
        }

        return startInclusive + ((endExclusive - startInclusive) * RANDOM.nextFloat());
    }

    public static double nextDouble() {
        return nextDouble(0, Double.MAX_VALUE);
    }

    public static double nextDouble(double startInclusive, double endExclusive) {
        if (startInclusive == endExclusive) {
            return startInclusive;
        }

        return startInclusive + ((endExclusive - startInclusive) * RANDOM.nextDouble());
    }
}
