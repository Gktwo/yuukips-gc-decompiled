package p001ch.qos.logback.classic.spi;

import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.classic.spi.LoggerContextAwareBase */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/LoggerContextAwareBase.class */
public class LoggerContextAwareBase extends ContextAwareBase implements LoggerContextAware {
    @Override // p001ch.qos.logback.classic.spi.LoggerContextAware
    public void setLoggerContext(LoggerContext context) {
        setContext(context);
    }

    @Override // p001ch.qos.logback.core.spi.ContextAwareBase, p001ch.qos.logback.core.spi.ContextAware
    public void setContext(Context context) {
        if ((context instanceof LoggerContext) || context == null) {
            setContext(context);
            return;
        }
        throw new IllegalArgumentException("LoggerContextAwareBase only accepts contexts of type c.l.classic.LoggerContext");
    }

    public LoggerContext getLoggerContext() {
        return (LoggerContext) this.context;
    }
}
