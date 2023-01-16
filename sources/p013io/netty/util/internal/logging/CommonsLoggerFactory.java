package p013io.netty.util.internal.logging;

import org.apache.commons.logging.LogFactory;

@Deprecated
/* renamed from: io.netty.util.internal.logging.CommonsLoggerFactory */
/* loaded from: grasscutter.jar:io/netty/util/internal/logging/CommonsLoggerFactory.class */
public class CommonsLoggerFactory extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE = new CommonsLoggerFactory();

    @Override // p013io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String name) {
        return new CommonsLogger(LogFactory.getLog(name), name);
    }
}
