package p001ch.qos.logback.core.net.server;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import p001ch.qos.logback.core.net.ssl.ConfigurableSSLServerSocketFactory;
import p001ch.qos.logback.core.net.ssl.SSLComponent;
import p001ch.qos.logback.core.net.ssl.SSLConfiguration;
import p001ch.qos.logback.core.net.ssl.SSLParametersConfiguration;

/* renamed from: ch.qos.logback.core.net.server.SSLServerSocketAppenderBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/server/SSLServerSocketAppenderBase.class */
public abstract class SSLServerSocketAppenderBase<E> extends AbstractServerSocketAppender<E> implements SSLComponent {
    private SSLConfiguration ssl;
    private ServerSocketFactory socketFactory;

    @Override // p001ch.qos.logback.core.net.server.AbstractServerSocketAppender
    protected ServerSocketFactory getServerSocketFactory() {
        return this.socketFactory;
    }

    @Override // p001ch.qos.logback.core.net.server.AbstractServerSocketAppender, p001ch.qos.logback.core.AppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        try {
            SSLContext sslContext = getSsl().createContext(this);
            SSLParametersConfiguration parameters = getSsl().getParameters();
            parameters.setContext(getContext());
            this.socketFactory = new ConfigurableSSLServerSocketFactory(parameters, sslContext.getServerSocketFactory());
            start();
        } catch (Exception ex) {
            addError(ex.getMessage(), ex);
        }
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
