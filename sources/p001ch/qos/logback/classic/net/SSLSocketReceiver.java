package p001ch.qos.logback.classic.net;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import p001ch.qos.logback.core.net.ssl.ConfigurableSSLSocketFactory;
import p001ch.qos.logback.core.net.ssl.SSLComponent;
import p001ch.qos.logback.core.net.ssl.SSLConfiguration;
import p001ch.qos.logback.core.net.ssl.SSLParametersConfiguration;

/* renamed from: ch.qos.logback.classic.net.SSLSocketReceiver */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/SSLSocketReceiver.class */
public class SSLSocketReceiver extends SocketReceiver implements SSLComponent {
    private SSLConfiguration ssl;
    private SocketFactory socketFactory;

    @Override // p001ch.qos.logback.classic.net.SocketReceiver
    protected SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    /* access modifiers changed from: protected */
    @Override // p001ch.qos.logback.classic.net.SocketReceiver, p001ch.qos.logback.classic.net.ReceiverBase
    public boolean shouldStart() {
        try {
            SSLContext sslContext = getSsl().createContext(this);
            SSLParametersConfiguration parameters = getSsl().getParameters();
            parameters.setContext(getContext());
            this.socketFactory = new ConfigurableSSLSocketFactory(parameters, sslContext.getSocketFactory());
            return shouldStart();
        } catch (Exception ex) {
            addError(ex.getMessage(), ex);
            return false;
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
