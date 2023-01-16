package p001ch.qos.logback.classic.selector;

import java.util.List;
import p001ch.qos.logback.classic.LoggerContext;

/* renamed from: ch.qos.logback.classic.selector.ContextSelector */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/selector/ContextSelector.class */
public interface ContextSelector {
    LoggerContext getLoggerContext();

    LoggerContext getLoggerContext(String str);

    LoggerContext getDefaultLoggerContext();

    LoggerContext detachLoggerContext(String str);

    List<String> getContextNames();
}
