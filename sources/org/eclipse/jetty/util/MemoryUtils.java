package org.eclipse.jetty.util;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/MemoryUtils.class */
public class MemoryUtils {
    private static final int cacheLineBytes;

    static {
        int value = 64;
        try {
            value = Integer.parseInt((String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: org.eclipse.jetty.util.MemoryUtils.1
                @Override // java.security.PrivilegedAction
                public String run() {
                    return System.getProperty("org.eclipse.jetty.util.cacheLineBytes", String.valueOf(64));
                }
            }));
        } catch (Exception e) {
        }
        cacheLineBytes = value;
    }

    private MemoryUtils() {
    }

    public static int getCacheLineBytes() {
        return cacheLineBytes;
    }

    public static int getIntegersPerCacheLine() {
        return getCacheLineBytes() >> 2;
    }

    public static int getLongsPerCacheLine() {
        return getCacheLineBytes() >> 3;
    }
}
