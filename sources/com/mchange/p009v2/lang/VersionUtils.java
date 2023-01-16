package com.mchange.p009v2.lang;

import com.mchange.p006v1.util.StringTokenizerUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import net.bytebuddy.ClassFileVersion;

/* renamed from: com.mchange.v2.lang.VersionUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/lang/VersionUtils.class */
public final class VersionUtils {
    private static final MLogger logger = MLog.getLogger(VersionUtils.class);
    private static final int[] DFLT_VERSION_ARRAY = {1, 1};
    private static final int[] JDK_VERSION_ARRAY;
    private static final int JDK_VERSION;
    private static final Integer NUM_BITS;

    static {
        int[] iArr;
        Integer num;
        String property = System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION);
        if (property == null) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.warning("Could not find java.version System property. Defaulting to JDK 1.1");
            }
            iArr = DFLT_VERSION_ARRAY;
        } else {
            try {
                iArr = extractVersionNumberArray(property);
            } catch (NumberFormatException e) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.warning("java.version ''" + property + "'' could not be parsed. Defaulting to JDK 1.1.");
                }
                iArr = DFLT_VERSION_ARRAY;
            }
        }
        int i = 0;
        if (iArr.length > 0) {
            i = 0 + (iArr[0] * 10);
        }
        if (iArr.length > 1) {
            i += iArr[1];
        }
        JDK_VERSION_ARRAY = iArr;
        JDK_VERSION = i;
        try {
            String property2 = System.getProperty("sun.arch.data.model");
            if (property2 == null) {
                num = null;
            } else {
                num = new Integer(property2);
            }
        } catch (Exception e2) {
            num = null;
        }
        if (num == null || num.intValue() == 32 || num.intValue() == 64) {
            NUM_BITS = num;
            return;
        }
        if (logger.isLoggable(MLevel.WARNING)) {
            logger.warning("Determined a surprising jvmNumerOfBits: " + num + ". Setting jvmNumberOfBits to unknown (null).");
        }
        NUM_BITS = null;
    }

    public static Integer jvmNumberOfBits() {
        return NUM_BITS;
    }

    public static boolean isJavaVersion10() {
        return JDK_VERSION == 10;
    }

    public static boolean isJavaVersion11() {
        return JDK_VERSION == 11;
    }

    public static boolean isJavaVersion12() {
        return JDK_VERSION == 12;
    }

    public static boolean isJavaVersion13() {
        return JDK_VERSION == 13;
    }

    public static boolean isJavaVersion14() {
        return JDK_VERSION == 14;
    }

    public static boolean isJavaVersion15() {
        return JDK_VERSION == 15;
    }

    public static boolean isAtLeastJavaVersion10() {
        return JDK_VERSION >= 10;
    }

    public static boolean isAtLeastJavaVersion11() {
        return JDK_VERSION >= 11;
    }

    public static boolean isAtLeastJavaVersion12() {
        return JDK_VERSION >= 12;
    }

    public static boolean isAtLeastJavaVersion13() {
        return JDK_VERSION >= 13;
    }

    public static boolean isAtLeastJavaVersion14() {
        return JDK_VERSION >= 14;
    }

    public static boolean isAtLeastJavaVersion15() {
        return JDK_VERSION >= 15;
    }

    public static boolean isAtLeastJavaVersion16() {
        return JDK_VERSION >= 16;
    }

    public static boolean isAtLeastJavaVersion17() {
        return JDK_VERSION >= 17;
    }

    public static int[] extractVersionNumberArray(String str) throws NumberFormatException {
        return extractVersionNumberArray(str, str.split("\\D+"));
    }

    public static int[] extractVersionNumberArray(String str, String str2) throws NumberFormatException {
        return extractVersionNumberArray(str, StringTokenizerUtils.tokenizeToArray(str, str2, false));
    }

    private static int[] extractVersionNumberArray(String str, String[] strArr) throws NumberFormatException {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            try {
                iArr[i] = Integer.parseInt(strArr[i]);
            } catch (NumberFormatException e) {
                if (i <= 1) {
                    throw e;
                }
                if (logger.isLoggable(MLevel.INFO)) {
                    logger.log(MLevel.INFO, "JVM version string (" + str + ") contains non-integral component (" + strArr[i] + "). Using precending components only to resolve JVM version.");
                }
                int[] iArr2 = new int[i];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr = iArr2;
            }
        }
        return iArr;
    }

    public boolean prefixMatches(int[] iArr, int[] iArr2) {
        if (iArr.length > iArr2.length) {
            return false;
        }
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int lexicalCompareVersionNumberArrays(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int length2 = iArr2.length;
        for (int i = 0; i < length; i++) {
            if (i == length2 || iArr[i] > iArr2[i]) {
                return 1;
            }
            if (iArr[i] < iArr2[i]) {
                return -1;
            }
        }
        if (length2 > length) {
            return -1;
        }
        return 0;
    }
}
