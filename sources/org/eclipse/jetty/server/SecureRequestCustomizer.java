package org.eclipse.jetty.server;

import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;
import org.eclipse.jetty.http.BadMessageException;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpScheme;
import org.eclipse.jetty.http.PreEncodedHttpField;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.ssl.SslConnection;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.ProxyConnectionFactory;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.annotation.Name;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.ssl.SniX509ExtendedKeyManager;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.ssl.X509;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/SecureRequestCustomizer.class */
public class SecureRequestCustomizer implements HttpConfiguration.Customizer {
    private static final Logger LOG = Log.getLogger(SecureRequestCustomizer.class);
    public static final String JAVAX_SERVLET_REQUEST_X_509_CERTIFICATE = "javax.servlet.request.X509Certificate";
    public static final String JAVAX_SERVLET_REQUEST_CIPHER_SUITE = "javax.servlet.request.cipher_suite";
    public static final String JAVAX_SERVLET_REQUEST_KEY_SIZE = "javax.servlet.request.key_size";
    public static final String JAVAX_SERVLET_REQUEST_SSL_SESSION_ID = "javax.servlet.request.ssl_session_id";
    private String sslSessionAttribute;
    private boolean _sniRequired;
    private boolean _sniHostCheck;
    private long _stsMaxAge;
    private boolean _stsIncludeSubDomains;
    private HttpField _stsField;

    public SecureRequestCustomizer() {
        this(true);
    }

    public SecureRequestCustomizer(@Name("sniHostCheck") boolean sniHostCheck) {
        this(sniHostCheck, -1, false);
    }

    public SecureRequestCustomizer(@Name("sniHostCheck") boolean sniHostCheck, @Name("stsMaxAgeSeconds") long stsMaxAgeSeconds, @Name("stsIncludeSubdomains") boolean stsIncludeSubdomains) {
        this(false, sniHostCheck, stsMaxAgeSeconds, stsIncludeSubdomains);
    }

    public SecureRequestCustomizer(@Name("sniRequired") boolean sniRequired, @Name("sniHostCheck") boolean sniHostCheck, @Name("stsMaxAgeSeconds") long stsMaxAgeSeconds, @Name("stsIncludeSubdomains") boolean stsIncludeSubdomains) {
        this.sslSessionAttribute = "org.eclipse.jetty.servlet.request.ssl_session";
        this._stsMaxAge = -1;
        this._sniRequired = sniRequired;
        this._sniHostCheck = sniHostCheck;
        this._stsMaxAge = stsMaxAgeSeconds;
        this._stsIncludeSubDomains = stsIncludeSubdomains;
        formatSTS();
    }

    public boolean isSniHostCheck() {
        return this._sniHostCheck;
    }

    public void setSniHostCheck(boolean sniHostCheck) {
        this._sniHostCheck = sniHostCheck;
    }

    public boolean isSniRequired() {
        return this._sniRequired;
    }

    public void setSniRequired(boolean sniRequired) {
        this._sniRequired = sniRequired;
    }

    public long getStsMaxAge() {
        return this._stsMaxAge;
    }

    public void setStsMaxAge(long stsMaxAgeSeconds) {
        this._stsMaxAge = stsMaxAgeSeconds;
        formatSTS();
    }

    public void setStsMaxAge(long period, TimeUnit units) {
        this._stsMaxAge = units.toSeconds(period);
        formatSTS();
    }

    public boolean isStsIncludeSubDomains() {
        return this._stsIncludeSubDomains;
    }

    public void setStsIncludeSubDomains(boolean stsIncludeSubDomains) {
        this._stsIncludeSubDomains = stsIncludeSubDomains;
        formatSTS();
    }

    private void formatSTS() {
        if (this._stsMaxAge < 0) {
            this._stsField = null;
            return;
        }
        HttpHeader httpHeader = HttpHeader.STRICT_TRANSPORT_SECURITY;
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(this._stsMaxAge);
        objArr[1] = this._stsIncludeSubDomains ? "; includeSubDomains" : "";
        this._stsField = new PreEncodedHttpField(httpHeader, String.format("max-age=%d%s", objArr));
    }

    @Override // org.eclipse.jetty.server.HttpConfiguration.Customizer
    public void customize(Connector connector, HttpConfiguration channelConfig, Request request) {
        EndPoint endp = request.getHttpChannel().getEndPoint();
        if (endp instanceof SslConnection.DecryptedEndPoint) {
            customize(((SslConnection.DecryptedEndPoint) endp).getSslConnection().getSSLEngine(), request);
            if (request.getHttpURI().getScheme() == null) {
                request.setScheme(HttpScheme.HTTPS.asString());
            }
        } else if (endp instanceof ProxyConnectionFactory.ProxyEndPoint) {
            ProxyConnectionFactory.ProxyEndPoint proxy = (ProxyConnectionFactory.ProxyEndPoint) endp;
            if (request.getHttpURI().getScheme() == null && proxy.getAttribute(ProxyConnectionFactory.TLS_VERSION) != null) {
                request.setScheme(HttpScheme.HTTPS.asString());
            }
        }
        if (HttpScheme.HTTPS.m39is(request.getScheme())) {
            customizeSecure(request);
        }
    }

    protected void customizeSecure(Request request) {
        request.setSecure(true);
        if (this._stsField != null) {
            request.getResponse().getHttpFields().add(this._stsField);
        }
    }

    protected void customize(SSLEngine sslEngine, Request request) {
        SSLSession sslSession = sslEngine.getSession();
        if (this._sniHostCheck || this._sniRequired) {
            X509 x509 = (X509) sslSession.getValue(SniX509ExtendedKeyManager.SNI_X509);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Host {} with SNI {}", request.getServerName(), x509);
            }
            if (x509 == null) {
                if (this._sniRequired) {
                    throw new BadMessageException(400, "SNI required");
                }
            } else if (this._sniHostCheck && !x509.matches(request.getServerName())) {
                throw new BadMessageException(400, "Host does not match SNI");
            }
        }
        request.setAttributes(new SslAttributes(request, sslSession, request.getAttributes()));
    }

    /* access modifiers changed from: private */
    public X509Certificate[] getCertChain(Connector connector, SSLSession sslSession) {
        SslContextFactory sslContextFactory;
        SslConnectionFactory sslConnectionFactory = (SslConnectionFactory) connector.getConnectionFactory(SslConnectionFactory.class);
        if (sslConnectionFactory == null || (sslContextFactory = sslConnectionFactory.getSslContextFactory()) == null) {
            return SslContextFactory.getCertChain(sslSession);
        }
        return sslContextFactory.getX509CertChain(sslSession);
    }

    public void setSslSessionAttribute(String attribute) {
        this.sslSessionAttribute = attribute;
    }

    public String getSslSessionAttribute() {
        return this.sslSessionAttribute;
    }

    public String toString() {
        return String.format("%s@%x", getClass().getSimpleName(), Integer.valueOf(hashCode()));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/SecureRequestCustomizer$SslAttributes.class */
    public class SslAttributes extends Attributes.Wrapper {
        private final Request _request;
        private final SSLSession _session;
        private X509Certificate[] _certs;
        private String _cipherSuite;
        private Integer _keySize;
        private String _sessionId;
        private String _sessionAttribute;

        public SslAttributes(Request request, SSLSession sslSession, Attributes attributes) {
            super(attributes);
            this._request = request;
            this._session = sslSession;
            try {
                SslSessionData sslSessionData = getSslSessionData();
                this._certs = sslSessionData.getCerts();
                this._cipherSuite = this._session.getCipherSuite();
                this._keySize = sslSessionData.getKeySize();
                this._sessionId = sslSessionData.getIdStr();
                this._sessionAttribute = SecureRequestCustomizer.this.getSslSessionAttribute();
            } catch (Exception e) {
                SecureRequestCustomizer.LOG.warn("Unable to get secure details ", e);
            }
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public Object getAttribute(String name) {
            char c = 65535;
            switch (name.hashCode()) {
                case -1630936796:
                    if (name.equals(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_CIPHER_SUITE)) {
                        c = 1;
                        break;
                    }
                    break;
                case -580517055:
                    if (name.equals(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_KEY_SIZE)) {
                        c = 2;
                        break;
                    }
                    break;
                case 100259031:
                    if (name.equals(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_SSL_SESSION_ID)) {
                        c = 3;
                        break;
                    }
                    break;
                case 1500284593:
                    if (name.equals(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_X_509_CERTIFICATE)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return this._certs;
                case 1:
                    return this._cipherSuite;
                case 2:
                    return this._keySize;
                case 3:
                    return this._sessionId;
                default:
                    if (StringUtil.isEmpty(this._sessionAttribute) || !this._sessionAttribute.equals(name)) {
                        return this._attributes.getAttribute(name);
                    }
                    return this._session;
            }
        }

        private SslSessionData getSslSessionData() {
            String key = SslSessionData.class.getName();
            SslSessionData sslSessionData = (SslSessionData) this._session.getValue(key);
            if (sslSessionData == null) {
                int keySize = SslContextFactory.deduceKeyLength(this._session.getCipherSuite());
                sslSessionData = new SslSessionData(Integer.valueOf(keySize), SecureRequestCustomizer.this.getCertChain(this._request.getHttpChannel().getConnector(), this._session), TypeUtil.toHexString(this._session.getId()));
                this._session.putValue(key, sslSessionData);
            }
            return sslSessionData;
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public Set<String> getAttributeNameSet() {
            Set<String> names = new HashSet<>(this._attributes.getAttributeNameSet());
            names.remove(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_X_509_CERTIFICATE);
            names.remove(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_CIPHER_SUITE);
            names.remove(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_KEY_SIZE);
            names.remove(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_SSL_SESSION_ID);
            if (this._certs != null) {
                names.add(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_X_509_CERTIFICATE);
            }
            if (this._cipherSuite != null) {
                names.add(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_CIPHER_SUITE);
            }
            if (this._keySize != null) {
                names.add(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_KEY_SIZE);
            }
            if (this._sessionId != null) {
                names.add(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_SSL_SESSION_ID);
            }
            if (!StringUtil.isEmpty(this._sessionAttribute)) {
                names.add(this._sessionAttribute);
            }
            return names;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/SecureRequestCustomizer$SslSessionData.class */
    public static class SslSessionData {
        private final Integer _keySize;
        private final X509Certificate[] _certs;
        private final String _idStr;

        private SslSessionData(Integer keySize, X509Certificate[] certs, String idStr) {
            this._keySize = keySize;
            this._certs = certs;
            this._idStr = idStr;
        }

        /* access modifiers changed from: private */
        public Integer getKeySize() {
            return this._keySize;
        }

        /* access modifiers changed from: private */
        public X509Certificate[] getCerts() {
            return this._certs;
        }

        /* access modifiers changed from: private */
        public String getIdStr() {
            return this._idStr;
        }
    }
}
