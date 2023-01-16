package org.quartz.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/quartz/impl/SchedulerDetailsSetter.class */
public class SchedulerDetailsSetter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerDetailsSetter.class);

    private SchedulerDetailsSetter() {
    }

    /* access modifiers changed from: package-private */
    public static void setDetails(Object target, String schedulerName, String schedulerId) throws SchedulerException {
        set(target, "setInstanceName", schedulerName);
        set(target, "setInstanceId", schedulerId);
    }

    private static void set(Object target, String method, String value) throws SchedulerException {
        try {
            Method setter = target.getClass().getMethod(method, String.class);
            if (Modifier.isAbstract(setter.getModifiers())) {
                LOGGER.warn(target.getClass().getName() + " does not implement " + method + "(String)");
                return;
            }
            try {
                setter.invoke(target, value);
            } catch (InvocationTargetException ite) {
                throw new SchedulerException(ite.getTargetException());
            } catch (Exception e) {
                throw new SchedulerException(e);
            }
        } catch (NoSuchMethodException e2) {
            LOGGER.warn(target.getClass().getName() + " does not contain public method " + method + "(String)");
        } catch (SecurityException e3) {
            LOGGER.error("A SecurityException occured: " + e3.getMessage(), (Throwable) e3);
        }
    }
}
