package com.mchange.p009v2.resourcepool;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;

/* renamed from: com.mchange.v2.resourcepool.ResourcePoolUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/resourcepool/ResourcePoolUtils.class */
final class ResourcePoolUtils {
    static final MLogger logger = MLog.getLogger(ResourcePoolUtils.class);

    ResourcePoolUtils() {
    }

    /* access modifiers changed from: package-private */
    public static final ResourcePoolException convertThrowable(String msg, Throwable t) {
        if (logger.isLoggable(MLevel.FINE)) {
            logger.log(MLevel.FINE, "Converting throwable to ResourcePoolException...", t);
        }
        if (t instanceof ResourcePoolException) {
            return (ResourcePoolException) t;
        }
        return new ResourcePoolException(msg, t);
    }

    /* access modifiers changed from: package-private */
    public static final ResourcePoolException convertThrowable(Throwable t) {
        return convertThrowable("Ouch! " + t.toString(), t);
    }
}
