package com.mchange.p006v1.util;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;

/* renamed from: com.mchange.v1.util.ClosableResourceUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/util/ClosableResourceUtils.class */
public final class ClosableResourceUtils {
    private static final MLogger logger = MLog.getLogger(ClosableResourceUtils.class);

    public static Exception attemptClose(ClosableResource closableResource) {
        if (closableResource == null) {
            return null;
        }
        try {
            closableResource.close();
            return null;
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "CloseableResource close FAILED.", (Throwable) e);
            }
            return e;
        }
    }

    private ClosableResourceUtils() {
    }
}
