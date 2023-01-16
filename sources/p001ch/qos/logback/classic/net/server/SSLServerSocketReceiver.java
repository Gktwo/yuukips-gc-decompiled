package p001ch.qos.logback.classic.net.server;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import p001ch.qos.logback.core.net.ssl.ConfigurableSSLServerSocketFactory;
import p001ch.qos.logback.core.net.ssl.SSLComponent;
import p001ch.qos.logback.core.net.ssl.SSLConfiguration;
import p001ch.qos.logback.core.net.ssl.SSLParametersConfiguration;

/* renamed from: ch.qos.logback.classic.net.server.SSLServerSocketReceiver */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/server/SSLServerSocketReceiver.class */
public class SSLServerSocketReceiver extends ServerSocketReceiver implements SSLComponent {
    private SSLConfiguration ssl;
    private ServerSocketFactory socketFactory;

    @Override // p001ch.qos.logback.classic.net.server.ServerSocketReceiver
    protected ServerSocketFactory getServerSocketFactory() throws Exception {
        if (this.socketFactory == null) {
            SSLContext sslContext = getSsl().createContext(this);
            SSLParametersConfiguration parameters = getSsl().getParameters();
            parameters.setContext(getContext());
            this.socketFactory = new ConfigurableSSLServerSocketFactory(parameters, sslContext.getServerSocketFactory());
        }
        return this.socketFactory;
    }

    @Override // p001ch.qos.logback.core.net.ssl.SSLComponent
    public SSLConfiguration getSsl() {
        if (this.ssl == null) {
            this.ssl = new SSLConfiguration();
        }
        return this.ssl;
    }

    @Override // p001ch.qos.logback.core.net.ssl.SSLComponent
    public void setSsl(SSLConfiguration ssl) {
        this.ssl = ssl;
    }
}
