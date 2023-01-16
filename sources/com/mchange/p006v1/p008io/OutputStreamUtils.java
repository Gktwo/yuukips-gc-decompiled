package com.mchange.p006v1.p008io;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.log.NullMLogger;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.mchange.v1.io.OutputStreamUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/io/OutputStreamUtils.class */
public final class OutputStreamUtils {
    private static final MLogger logger = MLog.getLogger(OutputStreamUtils.class);

    public static void attemptClose(OutputStream outputStream, MLogger mLogger) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                if (mLogger.isLoggable(MLevel.WARNING)) {
                    mLogger.log(MLevel.WARNING, "OutputStream close FAILED.", (Throwable) e);
                }
            }
        }
    }

    public static void attemptClose(OutputStream outputStream) {
        attemptClose(outputStream, logger);
    }

    public static void attemptCloseIgnore(OutputStream outputStream) {
        attemptClose(outputStream, NullMLogger.instance());
    }

    private OutputStreamUtils() {
    }
}
