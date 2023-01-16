package p013io.netty.handler.logging;

import p013io.netty.util.internal.logging.InternalLogLevel;

/* renamed from: io.netty.handler.logging.LogLevel */
/* loaded from: grasscutter.jar:io/netty/handler/logging/LogLevel.class */
public enum LogLevel {
    TRACE(InternalLogLevel.TRACE),
    DEBUG(InternalLogLevel.DEBUG),
    INFO(InternalLogLevel.INFO),
    WARN(InternalLogLevel.WARN),
    ERROR(InternalLogLevel.ERROR);
    
    private final InternalLogLevel internalLevel;

    LogLevel(InternalLogLevel internalLevel) {
        this.internalLevel = internalLevel;
    }

    public InternalLogLevel toInternalLevel() {
        return this.internalLevel;
    }
}
