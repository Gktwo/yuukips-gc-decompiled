package p001ch.qos.logback.core.net;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import p001ch.qos.logback.core.net.ssl.ConfigurableSSLSocketFactory;
import p001ch.qos.logback.core.net.ssl.SSLComponent;
import p001ch.qos.logback.core.net.ssl.SSLConfiguration;
import p001ch.qos.logback.core.net.ssl.SSLParametersConfiguration;

/* renamed from: ch.qos.logback.core.net.AbstractSSLSocketAppender */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/AbstractSSLSocketAppender.class */
public abstract class AbstractSSLSocketAppender<E> extends AbstractSocketAppender<E> implements SSLComponent {
    private SSLConfiguration ssl;
    private SocketFactory socketFactory;

    @Override // p001ch.qos.logback.core.net.AbstractSocketAppender
    protected SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    @Override // p001ch.qos.logback.core.net.AbstractSocketAppender, p001ch.qos.logback.core.AppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        try {
            SSLContext sslContext = getSsl().createContext(this);
            SSLParametersConfiguration parameters = getSsl().getParameters();
            parameters.setContext(getContext());
            this.socketFactory = new ConfigurableSSLSocketFactory(parameters, sslContext.getSocketFactory());
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
