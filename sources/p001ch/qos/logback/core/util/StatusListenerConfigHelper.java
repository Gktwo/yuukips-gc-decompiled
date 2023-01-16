package p001ch.qos.logback.core.util;

import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.spi.ContextAware;
import p001ch.qos.logback.core.spi.LifeCycle;
import p001ch.qos.logback.core.status.OnConsoleStatusListener;
import p001ch.qos.logback.core.status.StatusListener;

/* renamed from: ch.qos.logback.core.util.StatusListenerConfigHelper */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/StatusListenerConfigHelper.class */
public class StatusListenerConfigHelper {
    public static void installIfAsked(Context context) {
        String slClass = OptionHelper.getSystemProperty(CoreConstants.STATUS_LISTENER_CLASS_KEY);
        if (!OptionHelper.isEmpty(slClass)) {
            addStatusListener(context, slClass);
        }
    }

    private static void addStatusListener(Context context, String listenerClassName) {
        StatusListener listener;
        if (CoreConstants.SYSOUT.equalsIgnoreCase(listenerClassName)) {
            listener = new OnConsoleStatusListener();
        } else {
            listener = createListenerPerClassName(context, listenerClassName);
        }
        initAndAddListener(context, listener);
    }

    private static void initAndAddListener(Context context, StatusListener listener) {
        if (listener != null) {
            if (listener instanceof ContextAware) {
                ((ContextAware) listener).setContext(context);
            }
            if (context.getStatusManager().add(listener) && (listener instanceof LifeCycle)) {
                ((LifeCycle) listener).start();
            }
        }
    }

    private static StatusListener createListenerPerClassName(Context context, String listenerClass) {
        try {
            return (StatusListener) OptionHelper.instantiateByClassName(listenerClass, StatusListener.class, context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void addOnConsoleListenerInstance(Context context, OnConsoleStatusListener onConsoleStatusListener) {
        onConsoleStatusListener.setContext(context);
        if (context.getStatusManager().add(onConsoleStatusListener)) {
            onConsoleStatusListener.start();
        }
    }
}
