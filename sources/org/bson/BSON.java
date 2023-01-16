package org.bson;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/BSON.class */
public class BSON {
    static final byte B_GENERAL = 0;
    static final byte B_BINARY = 2;
    private static final int FLAG_GLOBAL = 256;
    private static final int[] FLAG_LOOKUP = new int[65535];

    BSON() {
    }

    static {
        FLAG_LOOKUP[103] = 256;
        FLAG_LOOKUP[105] = 2;
        FLAG_LOOKUP[109] = 8;
        FLAG_LOOKUP[115] = 32;
        FLAG_LOOKUP[99] = 128;
        FLAG_LOOKUP[120] = 4;
        FLAG_LOOKUP[100] = 1;
        FLAG_LOOKUP[116] = 16;
        FLAG_LOOKUP[117] = 64;
    }

    /* access modifiers changed from: package-private */
    public static int regexFlags(String s) {
        int flags = 0;
        if (s == null) {
            return 0;
        }
        for (char f : s.toLowerCase().toCharArray()) {
            flags |= regexFlag(f);
        }
        return flags;
    }

    private static int regexFlag(char c) {
        int flag = FLAG_LOOKUP[c];
        if (flag != 0) {
            return flag;
        }
        throw new IllegalArgumentException(String.format("Unrecognized flag [%c]", Character.valueOf(c)));
    }

    /* access modifiers changed from: package-private */
    public static String regexFlags(int flags) {
        int processedFlags = flags;
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < FLAG_LOOKUP.length; i++) {
            if ((processedFlags & FLAG_LOOKUP[i]) > 0) {
                buf.append((char) i);
                processedFlags -= FLAG_LOOKUP[i];
            }
        }
        if (processedFlags <= 0) {
            return buf.toString();
        }
        throw new IllegalArgumentException("Some flags could not be recognized.");
    }
}
