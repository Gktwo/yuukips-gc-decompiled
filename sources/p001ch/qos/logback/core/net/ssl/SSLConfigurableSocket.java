package p001ch.qos.logback.core.net.ssl;

import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* renamed from: ch.qos.logback.core.net.ssl.SSLConfigurableSocket */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/ssl/SSLConfigurableSocket.class */
public class SSLConfigurableSocket implements SSLConfigurable {
    private final SSLSocket delegate;

    public SSLConfigurableSocket(SSLSocket delegate) {
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
    public void setHostnameVerification(boolean hostnameVerification) {
        if (hostnameVerification) {
            SSLParameters sslParameters = this.delegate.getSSLParameters();
            sslParameters.setEndpointIdentificationAlgorithm("HTTPS");
            this.delegate.setSSLParameters(sslParameters);
        }
    }
}
