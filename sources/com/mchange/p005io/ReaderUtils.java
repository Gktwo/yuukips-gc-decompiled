package com.mchange.p005io;

import com.mchange.util.RobustMessageLogger;
import java.io.IOException;
import java.io.Reader;

/* renamed from: com.mchange.io.ReaderUtils */
/* loaded from: grasscutter.jar:com/mchange/io/ReaderUtils.class */
public final class ReaderUtils {
    public static void attemptClose(Reader reader) {
        attemptClose(reader, null);
    }

    public static void attemptClose(Reader reader, RobustMessageLogger robustMessageLogger) {
        try {
            reader.close();
        } catch (IOException e) {
            if (robustMessageLogger != null) {
                robustMessageLogger.log(e, "IOException trying to close Reader");
            }
        } catch (NullPointerException e2) {
            if (robustMessageLogger != null) {
                robustMessageLogger.log(e2, "NullPointerException trying to close Reader");
            }
        }
    }

    private ReaderUtils() {
    }
}
