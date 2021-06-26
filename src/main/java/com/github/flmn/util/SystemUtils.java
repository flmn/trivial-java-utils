package com.github.flmn.util;

import java.lang.management.ManagementFactory;

public final class SystemUtils {

    private SystemUtils() {
    }

    public static long getPid(long fallback) {
        String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        int index = StringUtils.isNullOrEmpty(jvmName) ? 0 : jvmName.indexOf('@');
        if (index < 1) {
            return fallback;
        }

        return NumberUtils.toLong(jvmName.substring(0, index), fallback);
    }
}
