package p001ch.qos.logback.classic.selector;

import java.util.Arrays;
import java.util.List;
import p001ch.qos.logback.classic.LoggerContext;

/* renamed from: ch.qos.logback.classic.selector.DefaultContextSelector */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/selector/DefaultContextSelector.class */
public class DefaultContextSelector implements ContextSelector {
    private LoggerContext defaultLoggerContext;

    public DefaultContextSelector(LoggerContext context) {
        this.defaultLoggerContext = context;
    }

    @Override // p001ch.qos.logback.classic.selector.ContextSelector
    public LoggerContext getLoggerContext() {
        return getDefaultLoggerContext();
    }

    @Override // p001ch.qos.logback.classic.selector.ContextSelector
    public LoggerContext getDefaultLoggerContext() {
        return this.defaultLoggerContext;
    }

    @Override // p001ch.qos.logback.classic.selector.ContextSelector
    public LoggerContext detachLoggerContext(String loggerContextName) {
        return this.defaultLoggerContext;
    }

    @Override // p001ch.qos.logback.classic.selector.ContextSelector
    public List<String> getContextNames() {
        return Arrays.asList(this.defaultLoggerContext.getName());
    }

    @Override // p001ch.qos.logback.classic.selector.ContextSelector
    public LoggerContext getLoggerContext(String name) {
        if (this.defaultLoggerContext.getName().equals(name)) {
            return this.defaultLoggerContext;
        }
        return null;
    }
}
