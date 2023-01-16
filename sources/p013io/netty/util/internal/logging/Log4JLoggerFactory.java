package p013io.netty.util.internal.logging;

import org.apache.log4j.Logger;

/* renamed from: io.netty.util.internal.logging.Log4JLoggerFactory */
/* loaded from: grasscutter.jar:io/netty/util/internal/logging/Log4JLoggerFactory.class */
public class Log4JLoggerFactory extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE = new Log4JLoggerFactory();

    @Override // p013io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String name) {
        return new Log4JLogger(Logger.getLogger(name));
    }
}
