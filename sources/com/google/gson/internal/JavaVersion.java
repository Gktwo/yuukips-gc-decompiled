package com.google.gson.internal;

import net.bytebuddy.ClassFileVersion;

/* loaded from: grasscutter.jar:com/google/gson/internal/JavaVersion.class */
public final class JavaVersion {
    private static final int majorJavaVersion = determineMajorJavaVersion();

    private static int determineMajorJavaVersion() {
        return getMajorJavaVersion(System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION));
    }

    static int getMajorJavaVersion(String javaVersion) {
        int version = parseDotted(javaVersion);
        if (version == -1) {
            version = extractBeginningInt(javaVersion);
        }
        if (version == -1) {
            return 6;
        }
        return version;
    }

    private static int parseDotted(String javaVersion) {
        try {
            String[] parts = javaVersion.split("[._]");
            int firstVer = Integer.parseInt(parts[0]);
            if (firstVer != 1 || parts.length <= 1) {
                return firstVer;
            }
            return Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static int extractBeginningInt(String javaVersion) {
        try {
            StringBuilder num = new StringBuilder();
            for (int i = 0; i < javaVersion.length(); i++) {
                char c = javaVersion.charAt(i);
                if (!Character.isDigit(c)) {
                    break;
                }
                num.append(c);
            }
            return Integer.parseInt(num.toString());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int getMajorJavaVersion() {
        return majorJavaVersion;
    }

    public static boolean isJava9OrLater() {
        return majorJavaVersion >= 9;
    }

    private JavaVersion() {
    }
}
