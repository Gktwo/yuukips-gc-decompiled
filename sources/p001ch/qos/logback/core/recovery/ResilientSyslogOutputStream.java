package p001ch.qos.logback.core.recovery;

import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import p001ch.qos.logback.core.net.SyslogOutputStream;
import p013io.javalin.http.sse.EmitterKt;

/* renamed from: ch.qos.logback.core.recovery.ResilientSyslogOutputStream */
/* loaded from: grasscutter.jar:ch/qos/logback/core/recovery/ResilientSyslogOutputStream.class */
public class ResilientSyslogOutputStream extends ResilientOutputStreamBase {
    String syslogHost;
    int port;

    public ResilientSyslogOutputStream(String syslogHost, int port) throws UnknownHostException, SocketException {
        this.syslogHost = syslogHost;
        this.port = port;
        this.f15os = new SyslogOutputStream(syslogHost, port);
        this.presumedClean = true;
    }

    @Override // p001ch.qos.logback.core.recovery.ResilientOutputStreamBase
    String getDescription() {
        return "syslog [" + this.syslogHost + EmitterKt.COMMENT_PREFIX + this.port + "]";
    }

    @Override // p001ch.qos.logback.core.recovery.ResilientOutputStreamBase
    OutputStream openNewOutputStream() throws IOException {
        return new SyslogOutputStream(this.syslogHost, this.port);
    }

    @Override // java.lang.Object
    public String toString() {
        return "c.q.l.c.recovery.ResilientSyslogOutputStream@" + System.identityHashCode(this);
    }
}
