package com.mchange.p005io;

import com.mchange.util.RobustMessageLogger;
import java.io.IOException;
import java.io.Writer;

/* renamed from: com.mchange.io.WriterUtils */
/* loaded from: grasscutter.jar:com/mchange/io/WriterUtils.class */
public final class WriterUtils {
    public static void attemptClose(Writer writer) {
        attemptClose(writer, null);
    }

    public static void attemptClose(Writer writer, RobustMessageLogger robustMessageLogger) {
        try {
            writer.close();
        } catch (IOException e) {
            if (robustMessageLogger != null) {
                robustMessageLogger.log(e, "IOException trying to close Writer");
            }
        } catch (NullPointerException e2) {
            if (robustMessageLogger != null) {
                robustMessageLogger.log(e2, "NullPointerException trying to close Writer");
            }
        }
    }

    private WriterUtils() {
    }
}
