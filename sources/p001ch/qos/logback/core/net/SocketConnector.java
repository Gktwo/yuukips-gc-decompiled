package p001ch.qos.logback.core.net;

import java.net.Socket;
import java.util.concurrent.Callable;
import javax.net.SocketFactory;

/* renamed from: ch.qos.logback.core.net.SocketConnector */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/SocketConnector.class */
public interface SocketConnector extends Callable<Socket> {

    /* renamed from: ch.qos.logback.core.net.SocketConnector$ExceptionHandler */
    /* loaded from: grasscutter.jar:ch/qos/logback/core/net/SocketConnector$ExceptionHandler.class */
    public interface ExceptionHandler {
        void connectionFailed(SocketConnector socketConnector, Exception exc);
    }

    @Override // java.util.concurrent.Callable
    Socket call() throws InterruptedException;

    void setExceptionHandler(ExceptionHandler exceptionHandler);

    void setSocketFactory(SocketFactory socketFactory);
}
