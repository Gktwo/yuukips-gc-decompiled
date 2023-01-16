package com.mchange.p005io;

import com.mchange.util.RobustMessageLogger;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.mchange.io.OutputStreamUtils */
/* loaded from: grasscutter.jar:com/mchange/io/OutputStreamUtils.class */
public final class OutputStreamUtils {
    public static void attemptClose(OutputStream outputStream) {
        attemptClose(outputStream, null);
    }

    public static void attemptClose(OutputStream outputStream, RobustMessageLogger robustMessageLogger) {
        try {
            outputStream.close();
        } catch (IOException e) {
            if (robustMessageLogger != null) {
                robustMessageLogger.log(e, "IOException trying to close OutputStream");
            }
        } catch (NullPointerException e2) {
            if (robustMessageLogger != null) {
                robustMessageLogger.log(e2, "NullPointerException trying to close OutputStream");
            }
        }
    }

    private OutputStreamUtils() {
    }
}
