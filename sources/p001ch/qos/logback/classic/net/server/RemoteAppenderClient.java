package p001ch.qos.logback.classic.net.server;

import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.core.net.server.Client;

/* renamed from: ch.qos.logback.classic.net.server.RemoteAppenderClient */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/server/RemoteAppenderClient.class */
interface RemoteAppenderClient extends Client {
    void setLoggerContext(LoggerContext loggerContext);
}
