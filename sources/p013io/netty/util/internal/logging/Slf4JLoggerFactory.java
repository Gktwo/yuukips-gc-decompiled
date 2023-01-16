package p013io.netty.util.internal.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

/* renamed from: io.netty.util.internal.logging.Slf4JLoggerFactory */
/* loaded from: grasscutter.jar:io/netty/util/internal/logging/Slf4JLoggerFactory.class */
public class Slf4JLoggerFactory extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !Slf4JLoggerFactory.class.desiredAssertionStatus();
        INSTANCE = new Slf4JLoggerFactory();
    }

    @Deprecated
    public Slf4JLoggerFactory() {
    }

    Slf4JLoggerFactory(boolean failIfNOP) {
        if (!$assertionsDisabled && !failIfNOP) {
            throw new AssertionError();
        } else if (LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory) {
            throw new NoClassDefFoundError("NOPLoggerFactory not supported");
        }
    }

    @Override // p013io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String name) {
        return wrapLogger(LoggerFactory.getLogger(name));
    }

    static InternalLogger wrapLogger(Logger logger) {
        return logger instanceof LocationAwareLogger ? new LocationAwareSlf4JLogger((LocationAwareLogger) logger) : new Slf4JLogger(logger);
    }

    /* access modifiers changed from: package-private */
    public static InternalLoggerFactory getInstanceWithNopCheck() {
        return NopInstanceHolder.INSTANCE_WITH_NOP_CHECK;
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.internal.logging.Slf4JLoggerFactory$NopInstanceHolder */
    /* loaded from: grasscutter.jar:io/netty/util/internal/logging/Slf4JLoggerFactory$NopInstanceHolder.class */
    public static final class NopInstanceHolder {
        private static final InternalLoggerFactory INSTANCE_WITH_NOP_CHECK = new Slf4JLoggerFactory(true);

        private NopInstanceHolder() {
        }
    }
}
