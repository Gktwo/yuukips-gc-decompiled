package p001ch.qos.logback.classic.net;

import java.security.NoSuchAlgorithmException;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.core.net.ssl.ConfigurableSSLServerSocketFactory;
import p001ch.qos.logback.core.net.ssl.SSLParametersConfiguration;

/* renamed from: ch.qos.logback.classic.net.SimpleSSLSocketServer */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/SimpleSSLSocketServer.class */
public class SimpleSSLSocketServer extends SimpleSocketServer {
    private final ServerSocketFactory socketFactory;

    public static void main(String[] argv) throws Exception {
        doMain(SimpleSSLSocketServer.class, argv);
    }

    public SimpleSSLSocketServer(LoggerContext lc, int port) throws NoSuchAlgorithmException {
        this(lc, port, SSLContext.getDefault());
    }

    public SimpleSSLSocketServer(LoggerContext lc, int port, SSLContext sslContext) {
        super(lc, port);
        if (sslContext == null) {
            throw new NullPointerException("SSL context required");
        }
        SSLParametersConfiguration parameters = new SSLParametersConfiguration();
        parameters.setContext(lc);
        this.socketFactory = new ConfigurableSSLServerSocketFactory(parameters, sslContext.getServerSocketFactory());
    }

    @Override // p001ch.qos.logback.classic.net.SimpleSocketServer
    protected ServerSocketFactory getServerSocketFactory() {
        return this.socketFactory;
    }
}
