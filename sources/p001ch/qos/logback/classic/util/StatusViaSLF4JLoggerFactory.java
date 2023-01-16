package p001ch.qos.logback.classic.util;

import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.status.ErrorStatus;
import p001ch.qos.logback.core.status.InfoStatus;
import p001ch.qos.logback.core.status.Status;

/* renamed from: ch.qos.logback.classic.util.StatusViaSLF4JLoggerFactory */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/util/StatusViaSLF4JLoggerFactory.class */
public class StatusViaSLF4JLoggerFactory {
    public static void addInfo(String msg, Object o) {
        addStatus(new InfoStatus(msg, o));
    }

    public static void addError(String msg, Object o) {
        addStatus(new ErrorStatus(msg, o));
    }

    public static void addError(String msg, Object o, Throwable t) {
        addStatus(new ErrorStatus(msg, o, t));
    }

    public static void addStatus(Status status) {
        ILoggerFactory iLoggerFactory = LoggerFactory.getILoggerFactory();
        if (iLoggerFactory instanceof LoggerContext) {
            ContextAwareBase contextAwareBase = new ContextAwareBase();
            contextAwareBase.setContext((LoggerContext) iLoggerFactory);
            contextAwareBase.addStatus(status);
        }
    }
}
