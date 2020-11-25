package com.github.flmn.util;

public final class BitUtils {

    private BitUtils() {
    }

    public static byte int3(final int x) {
        return (byte) (x >> 24);
    }

    public static byte int2(final int x) {
        return (byte) (x >> 16);
    }

    public static byte int1(final int x) {
        return (byte) (x >> 8);
    }

    public static byte int0(final int x) {
        return (byte) (x);
    }

    public static byte short1(final short x) {
        return (byte) (x >> 8);
    }

    public static byte short0(final short x) {
        return (byte) (x);
    }

    public static int makeInt(final byte b3, final byte b2, final byte b1, final byte b0) {
        return (((b3) << 24) |
                ((b2 & 0xff) << 16) |
                ((b1 & 0xff) << 8) |
                ((b0 & 0xff)));
    }

    public static short makeShort(final byte b1, final byte b0) {
        return (short) (((b1 & 0xff) << 8) | ((b0 & 0xff)));
    }
}
