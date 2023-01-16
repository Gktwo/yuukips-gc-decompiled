package p001ch.qos.logback.core.net.ssl;

/* renamed from: ch.qos.logback.core.net.ssl.SSLConfigurable */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/ssl/SSLConfigurable.class */
public interface SSLConfigurable {
    String[] getDefaultProtocols();

    String[] getSupportedProtocols();

    void setEnabledProtocols(String[] strArr);

    String[] getDefaultCipherSuites();

    String[] getSupportedCipherSuites();

    void setEnabledCipherSuites(String[] strArr);

    void setNeedClientAuth(boolean z);

    void setWantClientAuth(boolean z);

    void setHostnameVerification(boolean z);
}
