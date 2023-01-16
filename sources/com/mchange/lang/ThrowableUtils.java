package com.mchange.lang;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: grasscutter.jar:com/mchange/lang/ThrowableUtils.class */
public final class ThrowableUtils {
    public static String extractStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static boolean isChecked(Throwable th) {
        return (th instanceof Exception) && !(th instanceof RuntimeException);
    }

    public static boolean isUnchecked(Throwable th) {
        return !isChecked(th);
    }

    private ThrowableUtils() {
    }
}
