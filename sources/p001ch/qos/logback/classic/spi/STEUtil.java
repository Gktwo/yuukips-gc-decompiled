package p001ch.qos.logback.classic.spi;

/* renamed from: ch.qos.logback.classic.spi.STEUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/STEUtil.class */
public class STEUtil {
    static int UNUSED_findNumberOfCommonFrames(StackTraceElement[] steArray, StackTraceElement[] otherSTEArray) {
        if (otherSTEArray == null) {
            return 0;
        }
        int steIndex = steArray.length - 1;
        int parentIndex = otherSTEArray.length - 1;
        int count = 0;
        while (steIndex >= 0 && parentIndex >= 0 && steArray[steIndex].equals(otherSTEArray[parentIndex])) {
            count++;
            steIndex--;
            parentIndex--;
        }
        return count;
    }

    /* access modifiers changed from: package-private */
    public static int findNumberOfCommonFrames(StackTraceElement[] steArray, StackTraceElementProxy[] otherSTEPArray) {
        if (otherSTEPArray == null) {
            return 0;
        }
        int steIndex = steArray.length - 1;
        int parentIndex = otherSTEPArray.length - 1;
        int count = 0;
        while (steIndex >= 0 && parentIndex >= 0 && steArray[steIndex].equals(otherSTEPArray[parentIndex].ste)) {
            count++;
            steIndex--;
            parentIndex--;
        }
        return count;
    }
}
