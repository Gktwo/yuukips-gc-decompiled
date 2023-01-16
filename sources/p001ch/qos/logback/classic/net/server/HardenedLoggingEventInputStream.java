package p001ch.qos.logback.classic.net.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.helpers.BasicMarker;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.classic.spi.ClassPackagingData;
import p001ch.qos.logback.classic.spi.IThrowableProxy;
import p001ch.qos.logback.classic.spi.LoggerContextVO;
import p001ch.qos.logback.classic.spi.LoggerRemoteView;
import p001ch.qos.logback.classic.spi.LoggingEventVO;
import p001ch.qos.logback.classic.spi.StackTraceElementProxy;
import p001ch.qos.logback.classic.spi.ThrowableProxy;
import p001ch.qos.logback.classic.spi.ThrowableProxyVO;
import p001ch.qos.logback.core.net.HardenedObjectInputStream;

/* renamed from: ch.qos.logback.classic.net.server.HardenedLoggingEventInputStream */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/server/HardenedLoggingEventInputStream.class */
public class HardenedLoggingEventInputStream extends HardenedObjectInputStream {
    static final String ARRAY_PREFIX = "[L";

    public static List<String> getWhilelist() {
        List<String> whitelist = new ArrayList<>();
        whitelist.add(LoggingEventVO.class.getName());
        whitelist.add(LoggerContextVO.class.getName());
        whitelist.add(LoggerRemoteView.class.getName());
        whitelist.add(ThrowableProxyVO.class.getName());
        whitelist.add(BasicMarker.class.getName());
        whitelist.add(Level.class.getName());
        whitelist.add(Logger.class.getName());
        whitelist.add(StackTraceElement.class.getName());
        whitelist.add(StackTraceElement[].class.getName());
        whitelist.add(ThrowableProxy.class.getName());
        whitelist.add(ThrowableProxy[].class.getName());
        whitelist.add(IThrowableProxy.class.getName());
        whitelist.add(IThrowableProxy[].class.getName());
        whitelist.add(StackTraceElementProxy.class.getName());
        whitelist.add(StackTraceElementProxy[].class.getName());
        whitelist.add(ClassPackagingData.class.getName());
        return whitelist;
    }

    public HardenedLoggingEventInputStream(InputStream is) throws IOException {
        super(is, getWhilelist());
    }

    public HardenedLoggingEventInputStream(InputStream is, List<String> additionalAuthorizedClasses) throws IOException {
        this(is);
        addToWhitelist(additionalAuthorizedClasses);
    }
}
