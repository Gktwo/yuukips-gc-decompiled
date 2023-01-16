package p013io.netty.channel.socket.nio;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ProtocolFamily;
import java.nio.channels.Channel;
import java.nio.channels.spi.SelectorProvider;
import p013io.netty.channel.socket.InternetProtocolFamily;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SuppressJava6Requirement;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.socket.nio.SelectorProviderUtil */
/* loaded from: grasscutter.jar:io/netty/channel/socket/nio/SelectorProviderUtil.class */
final class SelectorProviderUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SelectorProviderUtil.class);

    /* access modifiers changed from: package-private */
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static Method findOpenMethod(String methodName) {
        if (PlatformDependent.javaVersion() < 15) {
            return null;
        }
        try {
            return SelectorProvider.class.getMethod(methodName, ProtocolFamily.class);
        } catch (Throwable e) {
            logger.debug("SelectorProvider.{}(ProtocolFamily) not available, will use default", methodName, e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static <C extends Channel> C newChannel(Method method, SelectorProvider provider, InternetProtocolFamily family) throws IOException {
        if (family == null || method == null) {
            return null;
        }
        try {
            return (C) ((Channel) method.invoke(provider, ProtocolFamilyConverter.convert(family)));
        } catch (IllegalAccessException e) {
            throw new IOException(e);
        } catch (InvocationTargetException e2) {
            throw new IOException(e2);
        }
    }

    private SelectorProviderUtil() {
    }
}
