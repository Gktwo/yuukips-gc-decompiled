package p001ch.qos.logback.core.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import p001ch.qos.logback.core.net.SocketConnector;
import p001ch.qos.logback.core.util.DelayStrategy;
import p001ch.qos.logback.core.util.FixedDelay;

/* renamed from: ch.qos.logback.core.net.DefaultSocketConnector */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/DefaultSocketConnector.class */
public class DefaultSocketConnector implements SocketConnector {
    private final InetAddress address;
    private final int port;
    private final DelayStrategy delayStrategy;
    private SocketConnector.ExceptionHandler exceptionHandler;
    private SocketFactory socketFactory;

    public DefaultSocketConnector(InetAddress address, int port, long initialDelay, long retryDelay) {
        this(address, port, new FixedDelay(initialDelay, retryDelay));
    }

    public DefaultSocketConnector(InetAddress address, int port, DelayStrategy delayStrategy) {
        this.address = address;
        this.port = port;
        this.delayStrategy = delayStrategy;
    }

    @Override // p001ch.qos.logback.core.net.SocketConnector, java.util.concurrent.Callable
    public Socket call() throws InterruptedException {
        useDefaultsForMissingFields();
        Socket socket = createSocket();
        while (socket == null && !Thread.currentThread().isInterrupted()) {
            Thread.sleep(this.delayStrategy.nextDelay());
            socket = createSocket();
        }
        return socket;
    }

    private Socket createSocket() {
        Socket newSocket = null;
        try {
            newSocket = this.socketFactory.createSocket(this.address, this.port);
        } catch (IOException ioex) {
            this.exceptionHandler.connectionFailed(this, ioex);
        }
        return newSocket;
    }

    private void useDefaultsForMissingFields() {
        if (this.exceptionHandler == null) {
            this.exceptionHandler = new ConsoleExceptionHandler();
        }
        if (this.socketFactory == null) {
            this.socketFactory = SocketFactory.getDefault();
        }
    }

    @Override // p001ch.qos.logback.core.net.SocketConnector
    public void setExceptionHandler(SocketConnector.ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    @Override // p001ch.qos.logback.core.net.SocketConnector
    public void setSocketFactory(SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
    }

    /* access modifiers changed from: private */
    /* renamed from: ch.qos.logback.core.net.DefaultSocketConnector$ConsoleExceptionHandler */
    /* loaded from: grasscutter.jar:ch/qos/logback/core/net/DefaultSocketConnector$ConsoleExceptionHandler.class */
    public static class ConsoleExceptionHandler implements SocketConnector.ExceptionHandler {
        private ConsoleExceptionHandler() {
        }

        @Override // p001ch.qos.logback.core.net.SocketConnector.ExceptionHandler
        public void connectionFailed(SocketConnector connector, Exception ex) {
            System.out.println(ex);
        }
    }
}
