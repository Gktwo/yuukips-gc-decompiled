package com.mchange.p009v2.lang;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.lang.reflect.Method;

/* renamed from: com.mchange.v2.lang.ThreadUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/lang/ThreadUtils.class */
public final class ThreadUtils {
    private static final MLogger logger = MLog.getLogger(ThreadUtils.class);
    static final Method holdsLock;

    static {
        Method method;
        try {
            method = Thread.class.getMethod("holdsLock", Object.class);
        } catch (NoSuchMethodException e) {
            method = null;
        }
        holdsLock = method;
    }

    public static void enumerateAll(Thread[] threadArr) {
        ThreadGroupUtils.rootThreadGroup().enumerate(threadArr);
    }

    public static Boolean reflectiveHoldsLock(Object obj) {
        try {
            if (holdsLock == null) {
                return null;
            }
            return (Boolean) holdsLock.invoke(null, obj);
        } catch (Exception e) {
            if (!logger.isLoggable(MLevel.FINER)) {
                return null;
            }
            logger.log(MLevel.FINER, "An Exception occurred while trying to call Thread.holdsLock( ... ) reflectively.", (Throwable) e);
            return null;
        }
    }

    private ThreadUtils() {
    }
}
