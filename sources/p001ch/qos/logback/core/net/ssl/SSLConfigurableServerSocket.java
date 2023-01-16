package p001ch.qos.logback.core.net.ssl;

import javax.net.ssl.SSLServerSocket;

/* renamed from: ch.qos.logback.core.net.ssl.SSLConfigurableServerSocket */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/ssl/SSLConfigurableServerSocket.class */
public class SSLConfigurableServerSocket implements SSLConfigurable {
    private final SSLServerSocket delegate;

    public SSLConfigurableServerSocket(SSLServerSocket delegate) {
        this.delegate = delegate;
    }

    @Override // p001ch.qos.logback.core.net.ssl.SSLConfigurable
    public String[] getDefaultProtocols() {
        return this.delegate.getEnabledProtocols();
    }

    @Override // p001ch.qos.logback.core.net.ssl.SSLConfigurable
    public String[] getSupportedProtocols() {
        return this.delegate.getSupportedProtocols();
    }

    @Override // p001ch.qos.logback.core.net.ssl.SSLConfigurable
    public void setEnabledProtocols(String[] protocols) {
        this.delegate.setEnabledProtocols(protocols);
    }

    @Override // p001ch.qos.logback.core.net.ssl.SSLConfigurable
    public String[] getDefaultCipherSuites() {
        return this.delegate.getEnabledCipherSuites();
    }

    @Override // p001ch.qos.logback.core.net.ssl.SSLConfigurable
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    @Override // p001ch.qos.logback.core.net.ssl.SSLConfigurable
    public void setEnabledCipherSuites(String[] suites) {
        this.delegate.setEnabledCipherSuites(suites);
    }

    @Override // p001ch.qos.logback.core.net.ssl.SSLConfigurable
    public void setNeedClientAuth(boolean state) {
        this.delegate.setNeedClientAuth(state);
    }

    @Override // p001ch.qos.logback.core.net.ssl.SSLConfigurable
    public void setWantClientAuth(boolean state) {
        this.delegate.setWantClientAuth(state);
    }

    @Override // p001ch.qos.logback.core.net.ssl.SSLConfigurable
    public void setHostnameVerification(boolean verifyHostname) {
    }
}
