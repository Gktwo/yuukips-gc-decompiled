package p013io.netty.util.internal.logging;

import java.util.logging.Logger;

/* renamed from: io.netty.util.internal.logging.JdkLoggerFactory */
/* loaded from: grasscutter.jar:io/netty/util/internal/logging/JdkLoggerFactory.class */
public class JdkLoggerFactory extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE = new JdkLoggerFactory();

    @Override // p013io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String name) {
        return new JdkLogger(Logger.getLogger(name));
    }
}
