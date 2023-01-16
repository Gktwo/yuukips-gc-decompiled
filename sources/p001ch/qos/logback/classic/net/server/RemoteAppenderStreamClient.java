package p001ch.qos.logback.classic.net.server;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.net.HardenedObjectInputStream;
import p001ch.qos.logback.core.util.CloseUtil;

/* renamed from: ch.qos.logback.classic.net.server.RemoteAppenderStreamClient */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/server/RemoteAppenderStreamClient.class */
class RemoteAppenderStreamClient implements RemoteAppenderClient {

    /* renamed from: id */
    private final String f6id;
    private final Socket socket;
    private final InputStream inputStream;

    /* renamed from: lc */
    private LoggerContext f7lc;
    private Logger logger;

    public RemoteAppenderStreamClient(String id, Socket socket) {
        this.f6id = id;
        this.socket = socket;
        this.inputStream = null;
    }

    public RemoteAppenderStreamClient(String id, InputStream inputStream) {
        this.f6id = id;
        this.socket = null;
        this.inputStream = inputStream;
    }

    @Override // p001ch.qos.logback.classic.net.server.RemoteAppenderClient
    public void setLoggerContext(LoggerContext lc) {
        this.f7lc = lc;
        this.logger = lc.getLogger(getClass().getPackage().getName());
    }

    @Override // p001ch.qos.logback.core.net.server.Client, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.socket != null) {
            CloseUtil.closeQuietly(this.socket);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        HardenedObjectInputStream ois;
        try {
            this.logger.info(this + ": connected");
            ois = null;
            try {
                try {
                    ois = createObjectInputStream();
                    while (true) {
                        ILoggingEvent event = (ILoggingEvent) ois.readObject();
                        Logger remoteLogger = this.f7lc.getLogger(event.getLoggerName());
                        if (remoteLogger.isEnabledFor(event.getLevel())) {
                            remoteLogger.callAppenders(event);
                        }
                    }
                } catch (IOException ex) {
                    this.logger.info(this + ": " + ex);
                    if (ois != null) {
                        CloseUtil.closeQuietly(ois);
                    }
                    close();
                    this.logger.info(this + ": connection closed");
                } catch (RuntimeException ex2) {
                    this.logger.error(this + ": " + ex2);
                    if (ois != null) {
                        CloseUtil.closeQuietly(ois);
                    }
                    close();
                    this.logger.info(this + ": connection closed");
                }
            } catch (EOFException e) {
                if (ois != null) {
                    CloseUtil.closeQuietly(ois);
                }
                close();
                this.logger.info(this + ": connection closed");
            } catch (ClassNotFoundException e2) {
                this.logger.error(this + ": unknown event class");
                if (ois != null) {
                    CloseUtil.closeQuietly(ois);
                }
                close();
                this.logger.info(this + ": connection closed");
            }
        } catch (Throwable th) {
            if (ois != null) {
                CloseUtil.closeQuietly(ois);
            }
            close();
            this.logger.info(this + ": connection closed");
            throw th;
        }
    }

    private HardenedObjectInputStream createObjectInputStream() throws IOException {
        if (this.inputStream != null) {
            return new HardenedLoggingEventInputStream(this.inputStream);
        }
        return new HardenedLoggingEventInputStream(this.socket.getInputStream());
    }

    @Override // java.lang.Object
    public String toString() {
        return "client " + this.f6id;
    }
}
