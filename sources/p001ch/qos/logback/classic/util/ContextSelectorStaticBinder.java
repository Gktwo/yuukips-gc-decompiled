package p001ch.qos.logback.classic.util;

import java.lang.reflect.InvocationTargetException;
import p001ch.qos.logback.classic.ClassicConstants;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.selector.ContextJNDISelector;
import p001ch.qos.logback.classic.selector.ContextSelector;
import p001ch.qos.logback.classic.selector.DefaultContextSelector;
import p001ch.qos.logback.core.util.Loader;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.classic.util.ContextSelectorStaticBinder */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/util/ContextSelectorStaticBinder.class */
public class ContextSelectorStaticBinder {
    static ContextSelectorStaticBinder singleton = new ContextSelectorStaticBinder();
    ContextSelector contextSelector;
    Object key;

    public static ContextSelectorStaticBinder getSingleton() {
        return singleton;
    }

    public void init(LoggerContext defaultLoggerContext, Object key) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        if (this.key == null) {
            this.key = key;
        } else if (this.key != key) {
            throw new IllegalAccessException("Only certain classes can access this method.");
        }
        String contextSelectorStr = OptionHelper.getSystemProperty(ClassicConstants.LOGBACK_CONTEXT_SELECTOR);
        if (contextSelectorStr == null) {
            this.contextSelector = new DefaultContextSelector(defaultLoggerContext);
        } else if (contextSelectorStr.equals("JNDI")) {
            this.contextSelector = new ContextJNDISelector(defaultLoggerContext);
        } else {
            this.contextSelector = dynamicalContextSelector(defaultLoggerContext, contextSelectorStr);
        }
    }

    static ContextSelector dynamicalContextSelector(LoggerContext defaultLoggerContext, String contextSelectorStr) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return (ContextSelector) Loader.loadClass(contextSelectorStr).getConstructor(LoggerContext.class).newInstance(defaultLoggerContext);
    }

    public ContextSelector getContextSelector() {
        return this.contextSelector;
    }
}
