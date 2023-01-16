package org.greenrobot.eventbus.util;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.greenrobot.eventbus.Logger;

/* loaded from: grasscutter.jar:org/greenrobot/eventbus/util/ExceptionToResourceMapping.class */
public class ExceptionToResourceMapping {
    public final Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap = new HashMap();

    public Integer mapThrowable(Throwable throwable) {
        Throwable throwableToCheck = throwable;
        int depthToGo = 20;
        do {
            Integer resId = mapThrowableFlat(throwableToCheck);
            if (resId != null) {
                return resId;
            }
            throwableToCheck = throwableToCheck.getCause();
            depthToGo--;
            if (depthToGo <= 0 || throwableToCheck == throwable) {
                break;
            }
        } while (throwableToCheck != null);
        Logger.Default.get().log(Level.FINE, "No specific message resource ID found for " + throwable);
        return null;
    }

    protected Integer mapThrowableFlat(Throwable throwable) {
        Class<?> cls = throwable.getClass();
        Integer resId = this.throwableToMsgIdMap.get(cls);
        if (resId == null) {
            Class<? extends Throwable> closestClass = null;
            for (Map.Entry<Class<? extends Throwable>, Integer> mapping : this.throwableToMsgIdMap.entrySet()) {
                Class<? extends Throwable> candidate = mapping.getKey();
                if (candidate.isAssignableFrom(cls) && (closestClass == null || closestClass.isAssignableFrom(candidate))) {
                    closestClass = candidate;
                    resId = mapping.getValue();
                }
            }
        }
        return resId;
    }

    public ExceptionToResourceMapping addMapping(Class<? extends Throwable> clazz, int msgId) {
        this.throwableToMsgIdMap.put(clazz, Integer.valueOf(msgId));
        return this;
    }
}
