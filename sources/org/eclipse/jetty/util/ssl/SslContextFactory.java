package org.eclipse.jetty.util.ssl;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CRL;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.net.ssl.CertPathTrustManagerParameters;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509ExtendedTrustManager;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.security.CertificateUtils;
import org.eclipse.jetty.util.security.CertificateValidator;
import org.eclipse.jetty.util.security.Password;
import org.eclipse.jetty.util.ssl.SniX509ExtendedKeyManager;
import p001ch.qos.logback.core.net.ssl.SSL;
import p013io.netty.handler.ssl.SslProtocols;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/SslContextFactory.class */
public class SslContextFactory extends AbstractLifeCycle implements Dumpable {
    public static final String KEYPASSWORD_PROPERTY = "org.eclipse.jetty.ssl.keypassword";
    public static final String PASSWORD_PROPERTY = "org.eclipse.jetty.ssl.password";
    private final Set<String> _excludeProtocols;
    private final Set<String> _includeProtocols;
    private final Set<String> _excludeCipherSuites;
    private final Set<String> _includeCipherSuites;
    private final Map<String, X509> _aliasX509;
    private final Map<String, X509> _certHosts;
    private final Map<String, X509> _certWilds;
    private String[] _selectedProtocols;
    private boolean _useCipherSuitesOrder;
    private Comparator<String> _cipherComparator;
    private String[] _selectedCipherSuites;
    private Resource _keyStoreResource;
    private String _keyStoreProvider;
    private String _keyStoreType;
    private String _certAlias;
    private Resource _trustStoreResource;
    private String _trustStoreProvider;
    private String _trustStoreType;
    private boolean _needClientAuth;
    private boolean _wantClientAuth;
    private Password _keyStorePassword;
    private Password _keyManagerPassword;
    private Password _trustStorePassword;
    private String _sslProvider;
    private String _sslProtocol;
    private String _secureRandomAlgorithm;
    private String _keyManagerFactoryAlgorithm;
    private String _trustManagerFactoryAlgorithm;
    private boolean _validateCerts;
    private boolean _validatePeerCerts;
    private int _maxCertPathLength;
    private String _crlPath;
    private boolean _enableCRLDP;
    private boolean _enableOCSP;
    private String _ocspResponderURL;
    private KeyStore _setKeyStore;
    private KeyStore _setTrustStore;
    private boolean _sessionCachingEnabled;
    private int _sslSessionCacheSize;
    private int _sslSessionTimeout;
    private SSLContext _setContext;
    private String _endpointIdentificationAlgorithm;
    private boolean _trustAll;
    private boolean _renegotiationAllowed;
    private int _renegotiationLimit;
    private Factory _factory;
    private PKIXCertPathChecker _pkixCertPathChecker;
    private HostnameVerifier _hostnameVerifier;
    public static final TrustManager[] TRUST_ALL_CERTS = {new X509ExtendedTrustManagerWrapper(null)};
    public static final String DEFAULT_KEYMANAGERFACTORY_ALGORITHM = KeyManagerFactory.getDefaultAlgorithm();
    public static final String DEFAULT_TRUSTMANAGERFACTORY_ALGORITHM = TrustManagerFactory.getDefaultAlgorithm();
    private static final Logger LOG = Log.getLogger(SslContextFactory.class);
    private static final Logger LOG_CONFIG = LOG.getLogger("config");
    private static final String[] DEFAULT_EXCLUDED_PROTOCOLS = {SSL.DEFAULT_PROTOCOL, SslProtocols.SSL_v2, SslProtocols.SSL_v2_HELLO, SslProtocols.SSL_v3};
    private static final String[] DEFAULT_EXCLUDED_CIPHER_SUITES = {"^.*_(MD5|SHA|SHA1)$", "^TLS_RSA_.*$", "^SSL_.*$", "^.*_NULL_.*$", "^.*_anon_.*$"};

    @Deprecated
    public SslContextFactory() {
        this(false);
    }

    @Deprecated
    public SslContextFactory(boolean trustAll) {
        this(trustAll, null);
    }

    @Deprecated
    public SslContextFactory(String keyStorePath) {
        this(false, keyStorePath);
    }

    private SslContextFactory(boolean trustAll, String keyStorePath) {
        this._excludeProtocols = new LinkedHashSet();
        this._includeProtocols = new LinkedHashSet();
        this._excludeCipherSuites = new LinkedHashSet();
        this._includeCipherSuites = new LinkedHashSet();
        this._aliasX509 = new HashMap();
        this._certHosts = new HashMap();
        this._certWilds = new HashMap();
        this._useCipherSuitesOrder = true;
        this._keyStoreType = SSL.DEFAULT_KEYSTORE_TYPE;
        this._needClientAuth = false;
        this._wantClientAuth = false;
        this._sslProtocol = "TLS";
        this._keyManagerFactoryAlgorithm = DEFAULT_KEYMANAGERFACTORY_ALGORITHM;
        this._trustManagerFactoryAlgorithm = DEFAULT_TRUSTMANAGERFACTORY_ALGORITHM;
        this._maxCertPathLength = -1;
        this._enableCRLDP = false;
        this._enableOCSP = false;
        this._sessionCachingEnabled = true;
        this._sslSessionCacheSize = -1;
        this._sslSessionTimeout = -1;
        this._endpointIdentificationAlgorithm = "HTTPS";
        this._renegotiationAllowed = true;
        this._renegotiationLimit = 5;
        setTrustAll(trustAll);
        setExcludeProtocols(DEFAULT_EXCLUDED_PROTOCOLS);
        setExcludeCipherSuites(DEFAULT_EXCLUDED_CIPHER_SUITES);
        if (keyStorePath != null) {
            setKeyStorePath(keyStorePath);
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStart() throws Exception {
        doStart();
        synchronized (this) {
            load();
        }
        checkConfiguration();
    }

    protected void checkConfiguration() {
        SSLEngine engine = this._factory._context.createSSLEngine();
        customize(engine);
        SSLParameters supported = engine.getSSLParameters();
        checkProtocols(supported);
        checkCiphers(supported);
    }

    protected void checkTrustAll() {
        if (isTrustAll()) {
            LOG_CONFIG.warn("Trusting all certificates configured for {}", this);
        }
    }

    protected void checkEndPointIdentificationAlgorithm() {
        if (getEndpointIdentificationAlgorithm() == null) {
            LOG_CONFIG.warn("No Client EndPointIdentificationAlgorithm configured for {}", this);
        }
    }

    protected void checkProtocols(SSLParameters supported) {
        String[] protocols = supported.getProtocols();
        for (String protocol : protocols) {
            for (String excluded : DEFAULT_EXCLUDED_PROTOCOLS) {
                if (excluded.equals(protocol)) {
                    LOG_CONFIG.warn("Protocol {} not excluded for {}", protocol, this);
                }
            }
        }
    }

    protected void checkCiphers(SSLParameters supported) {
        String[] cipherSuites = supported.getCipherSuites();
        for (String suite : cipherSuites) {
            for (String excludedSuiteRegex : DEFAULT_EXCLUDED_CIPHER_SUITES) {
                if (suite.matches(excludedSuiteRegex)) {
                    LOG_CONFIG.warn("Weak cipher suite {} enabled for {}", suite, this);
                }
            }
        }
    }

    private void load() throws Exception {
        SSLContext context = this._setContext;
        KeyStore keyStore = this._setKeyStore;
        KeyStore trustStore = this._setTrustStore;
        if (context == null) {
            if (keyStore == null && this._keyStoreResource == null && trustStore == null && this._trustStoreResource == null) {
                TrustManager[] trustManagers = null;
                if (isTrustAll()) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("No keystore or trust store configured.  ACCEPTING UNTRUSTED CERTIFICATES!!!!!", new Object[0]);
                    }
                    trustManagers = TRUST_ALL_CERTS;
                }
                context = getSSLContextInstance();
                context.init(null, trustManagers, getSecureRandomInstance());
            } else {
                if (keyStore == null) {
                    keyStore = loadKeyStore(this._keyStoreResource);
                }
                if (trustStore == null) {
                    trustStore = loadTrustStore(this._trustStoreResource);
                }
                Collection<? extends CRL> crls = loadCRL(getCrlPath());
                if (keyStore != null) {
                    Iterator it = Collections.list(keyStore.aliases()).iterator();
                    while (it.hasNext()) {
                        String alias = (String) it.next();
                        Certificate certificate = keyStore.getCertificate(alias);
                        if (certificate != null && "X.509".equals(certificate.getType())) {
                            X509Certificate x509C = (X509Certificate) certificate;
                            if (!X509.isCertSign(x509C)) {
                                X509 x509 = new X509(alias, x509C);
                                this._aliasX509.put(alias, x509);
                                if (isValidateCerts()) {
                                    CertificateValidator validator = new CertificateValidator(trustStore, crls);
                                    validator.setMaxCertPathLength(getMaxCertPathLength());
                                    validator.setEnableCRLDP(isEnableCRLDP());
                                    validator.setEnableOCSP(isEnableOCSP());
                                    validator.setOcspResponderURL(getOcspResponderURL());
                                    validator.validate(keyStore, x509C);
                                }
                                LOG.info("x509={} for {}", x509, this);
                                for (String h : x509.getHosts()) {
                                    this._certHosts.put(h, x509);
                                }
                                for (String w : x509.getWilds()) {
                                    this._certWilds.put(w, x509);
                                }
                            } else if (LOG.isDebugEnabled()) {
                                LOG.debug("Skipping " + x509C, new Object[0]);
                            }
                        }
                    }
                }
                KeyManager[] keyManagers = getKeyManagers(keyStore);
                TrustManager[] trustManagers2 = getTrustManagers(trustStore, crls);
                context = getSSLContextInstance();
                context.init(keyManagers, trustManagers2, getSecureRandomInstance());
            }
        }
        SSLSessionContext serverContext = context.getServerSessionContext();
        if (serverContext != null) {
            if (getSslSessionCacheSize() > -1) {
                serverContext.setSessionCacheSize(getSslSessionCacheSize());
            }
            if (getSslSessionTimeout() > -1) {
                serverContext.setSessionTimeout(getSslSessionTimeout());
            }
        }
        SSLParameters enabled = context.getDefaultSSLParameters();
        SSLParameters supported = context.getSupportedSSLParameters();
        selectCipherSuites(enabled.getCipherSuites(), supported.getCipherSuites());
        selectProtocols(enabled.getProtocols(), supported.getProtocols());
        this._factory = new Factory(keyStore, trustStore, context);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Selected Protocols {} of {}", Arrays.asList(this._selectedProtocols), Arrays.asList(supported.getProtocols()));
            LOG.debug("Selected Ciphers   {} of {}", Arrays.asList(this._selectedCipherSuites), Arrays.asList(supported.getCipherSuites()));
        }
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return Dumpable.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        try {
            SSLEngine sslEngine = SSLContext.getDefault().createSSLEngine();
            Dumpable.dumpObjects(out, indent, this, "trustAll=" + this._trustAll, new SslSelectionDump("Protocol", sslEngine.getSupportedProtocols(), sslEngine.getEnabledProtocols(), getExcludeProtocols(), getIncludeProtocols()), new SslSelectionDump("Cipher Suite", sslEngine.getSupportedCipherSuites(), sslEngine.getEnabledCipherSuites(), getExcludeCipherSuites(), getIncludeCipherSuites()));
        } catch (NoSuchAlgorithmException x) {
            LOG.ignore(x);
        }
    }

    List<SslSelectionDump> selectionDump() throws NoSuchAlgorithmException {
        SSLEngine sslEngine = SSLContext.getDefault().createSSLEngine();
        List<SslSelectionDump> selections = new ArrayList<>();
        selections.add(new SslSelectionDump("Protocol", sslEngine.getSupportedProtocols(), sslEngine.getEnabledProtocols(), getExcludeProtocols(), getIncludeProtocols()));
        selections.add(new SslSelectionDump("Cipher Suite", sslEngine.getSupportedCipherSuites(), sslEngine.getEnabledCipherSuites(), getExcludeCipherSuites(), getIncludeCipherSuites()));
        return selections;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws Exception {
        synchronized (this) {
            unload();
        }
        doStop();
    }

    private void unload() {
        this._factory = null;
        this._selectedProtocols = null;
        this._selectedCipherSuites = null;
        this._aliasX509.clear();
        this._certHosts.clear();
        this._certWilds.clear();
    }

    Map<String, X509> aliasCerts() {
        return this._aliasX509;
    }

    @ManagedAttribute(value = "The selected TLS protocol versions", readonly = true)
    public String[] getSelectedProtocols() {
        return (String[]) Arrays.copyOf(this._selectedProtocols, this._selectedProtocols.length);
    }

    @ManagedAttribute(value = "The selected cipher suites", readonly = true)
    public String[] getSelectedCipherSuites() {
        return (String[]) Arrays.copyOf(this._selectedCipherSuites, this._selectedCipherSuites.length);
    }

    public Comparator<String> getCipherComparator() {
        return this._cipherComparator;
    }

    public void setCipherComparator(Comparator<String> cipherComparator) {
        if (cipherComparator != null) {
            setUseCipherSuitesOrder(true);
        }
        this._cipherComparator = cipherComparator;
    }

    public Set<String> getAliases() {
        return Collections.unmodifiableSet(this._aliasX509.keySet());
    }

    public X509 getX509(String alias) {
        return this._aliasX509.get(alias);
    }

    @ManagedAttribute("The excluded TLS protocols")
    public String[] getExcludeProtocols() {
        return (String[]) this._excludeProtocols.toArray(new String[0]);
    }

    public void setExcludeProtocols(String... protocols) {
        this._excludeProtocols.clear();
        this._excludeProtocols.addAll(Arrays.asList(protocols));
    }

    public void addExcludeProtocols(String... protocol) {
        this._excludeProtocols.addAll(Arrays.asList(protocol));
    }

    @ManagedAttribute("The included TLS protocols")
    public String[] getIncludeProtocols() {
        return (String[]) this._includeProtocols.toArray(new String[0]);
    }

    public void setIncludeProtocols(String... protocols) {
        this._includeProtocols.clear();
        this._includeProtocols.addAll(Arrays.asList(protocols));
    }

    @ManagedAttribute("The excluded cipher suites")
    public String[] getExcludeCipherSuites() {
        return (String[]) this._excludeCipherSuites.toArray(new String[0]);
    }

    public void setExcludeCipherSuites(String... cipherSuites) {
        this._excludeCipherSuites.clear();
        this._excludeCipherSuites.addAll(Arrays.asList(cipherSuites));
    }

    public void addExcludeCipherSuites(String... cipher) {
        this._excludeCipherSuites.addAll(Arrays.asList(cipher));
    }

    @ManagedAttribute("The included cipher suites")
    public String[] getIncludeCipherSuites() {
        return (String[]) this._includeCipherSuites.toArray(new String[0]);
    }

    public void setIncludeCipherSuites(String... cipherSuites) {
        this._includeCipherSuites.clear();
        this._includeCipherSuites.addAll(Arrays.asList(cipherSuites));
    }

    @ManagedAttribute("Whether to respect the cipher suites order")
    public boolean isUseCipherSuitesOrder() {
        return this._useCipherSuitesOrder;
    }

    public void setUseCipherSuitesOrder(boolean useCipherSuitesOrder) {
        this._useCipherSuitesOrder = useCipherSuitesOrder;
    }

    @ManagedAttribute("The keyStore path")
    public String getKeyStorePath() {
        return Objects.toString(this._keyStoreResource, null);
    }

    public void setKeyStorePath(String keyStorePath) {
        try {
            this._keyStoreResource = Resource.newResource(keyStorePath);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @ManagedAttribute("The keyStore provider name")
    public String getKeyStoreProvider() {
        return this._keyStoreProvider;
    }

    public void setKeyStoreProvider(String keyStoreProvider) {
        this._keyStoreProvider = keyStoreProvider;
    }

    @ManagedAttribute("The keyStore type")
    public String getKeyStoreType() {
        return this._keyStoreType;
    }

    public void setKeyStoreType(String keyStoreType) {
        this._keyStoreType = keyStoreType;
    }

    @ManagedAttribute("The certificate alias")
    public String getCertAlias() {
        return this._certAlias;
    }

    public void setCertAlias(String certAlias) {
        this._certAlias = certAlias;
    }

    @ManagedAttribute("The trustStore path")
    public String getTrustStorePath() {
        return Objects.toString(this._trustStoreResource, null);
    }

    public void setTrustStorePath(String trustStorePath) {
        try {
            this._trustStoreResource = Resource.newResource(trustStorePath);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @ManagedAttribute("The trustStore provider name")
    public String getTrustStoreProvider() {
        return this._trustStoreProvider;
    }

    public void setTrustStoreProvider(String trustStoreProvider) {
        this._trustStoreProvider = trustStoreProvider;
    }

    @ManagedAttribute("The trustStore type")
    public String getTrustStoreType() {
        return this._trustStoreType;
    }

    public void setTrustStoreType(String trustStoreType) {
        this._trustStoreType = trustStoreType;
    }

    @ManagedAttribute("Whether client authentication is needed")
    @Deprecated
    public boolean getNeedClientAuth() {
        return this._needClientAuth;
    }

    @Deprecated
    public void setNeedClientAuth(boolean needClientAuth) {
        this._needClientAuth = needClientAuth;
    }

    @ManagedAttribute("Whether client authentication is wanted")
    @Deprecated
    public boolean getWantClientAuth() {
        return this._wantClientAuth;
    }

    @Deprecated
    public void setWantClientAuth(boolean wantClientAuth) {
        this._wantClientAuth = wantClientAuth;
    }

    @ManagedAttribute("Whether certificates are validated")
    public boolean isValidateCerts() {
        return this._validateCerts;
    }

    public void setValidateCerts(boolean validateCerts) {
        this._validateCerts = validateCerts;
    }

    @ManagedAttribute("Whether peer certificates are validated")
    public boolean isValidatePeerCerts() {
        return this._validatePeerCerts;
    }

    public void setValidatePeerCerts(boolean validatePeerCerts) {
        this._validatePeerCerts = validatePeerCerts;
    }

    public void setKeyStorePassword(String password) {
        if (password != null) {
            this._keyStorePassword = newPassword(password);
        } else if (this._keyStoreResource != null) {
            this._keyStorePassword = getPassword(PASSWORD_PROPERTY);
        } else {
            this._keyStorePassword = null;
        }
    }

    public void setKeyManagerPassword(String password) {
        if (password != null) {
            this._keyManagerPassword = newPassword(password);
        } else if (System.getProperty(KEYPASSWORD_PROPERTY) != null) {
            this._keyManagerPassword = getPassword(KEYPASSWORD_PROPERTY);
        } else {
            this._keyManagerPassword = null;
        }
    }

    public void setTrustStorePassword(String password) {
        if (password != null) {
            this._trustStorePassword = newPassword(password);
        } else if (this._trustStoreResource == null || this._trustStoreResource.equals(this._keyStoreResource)) {
            this._trustStorePassword = null;
        } else {
            this._trustStorePassword = getPassword(PASSWORD_PROPERTY);
        }
    }

    @ManagedAttribute("The provider name")
    public String getProvider() {
        return this._sslProvider;
    }

    public void setProvider(String provider) {
        this._sslProvider = provider;
    }

    @ManagedAttribute("The TLS protocol")
    public String getProtocol() {
        return this._sslProtocol;
    }

    public void setProtocol(String protocol) {
        this._sslProtocol = protocol;
    }

    @ManagedAttribute("The SecureRandom algorithm")
    public String getSecureRandomAlgorithm() {
        return this._secureRandomAlgorithm;
    }

    public void setSecureRandomAlgorithm(String algorithm) {
        this._secureRandomAlgorithm = algorithm;
    }

    @ManagedAttribute("The KeyManagerFactory algorithm")
    public String getKeyManagerFactoryAlgorithm() {
        return this._keyManagerFactoryAlgorithm;
    }

    public void setKeyManagerFactoryAlgorithm(String algorithm) {
        this._keyManagerFactoryAlgorithm = algorithm;
    }

    @ManagedAttribute("The TrustManagerFactory algorithm")
    public String getTrustManagerFactoryAlgorithm() {
        return this._trustManagerFactoryAlgorithm;
    }

    @ManagedAttribute("Whether certificates should be trusted even if they are invalid")
    public boolean isTrustAll() {
        return this._trustAll;
    }

    public void setTrustAll(boolean trustAll) {
        this._trustAll = trustAll;
        if (trustAll) {
            setEndpointIdentificationAlgorithm(null);
        }
    }

    public void setTrustManagerFactoryAlgorithm(String algorithm) {
        this._trustManagerFactoryAlgorithm = algorithm;
    }

    @ManagedAttribute("Whether renegotiation is allowed")
    public boolean isRenegotiationAllowed() {
        return this._renegotiationAllowed;
    }

    public void setRenegotiationAllowed(boolean renegotiationAllowed) {
        this._renegotiationAllowed = renegotiationAllowed;
    }

    @ManagedAttribute("The max number of renegotiations allowed")
    public int getRenegotiationLimit() {
        return this._renegotiationLimit;
    }

    public void setRenegotiationLimit(int renegotiationLimit) {
        this._renegotiationLimit = renegotiationLimit;
    }

    @ManagedAttribute("The path to the certificate revocation list file")
    public String getCrlPath() {
        return this._crlPath;
    }

    public void setCrlPath(String crlPath) {
        this._crlPath = crlPath;
    }

    @ManagedAttribute("The maximum number of intermediate certificates")
    public int getMaxCertPathLength() {
        return this._maxCertPathLength;
    }

    public void setMaxCertPathLength(int maxCertPathLength) {
        this._maxCertPathLength = maxCertPathLength;
    }

    public SSLContext getSslContext() {
        SSLContext sSLContext;
        if (!isStarted()) {
            return this._setContext;
        }
        synchronized (this) {
            if (this._factory == null) {
                throw new IllegalStateException("SslContextFactory reload failed");
            }
            sSLContext = this._factory._context;
        }
        return sSLContext;
    }

    public void setSslContext(SSLContext sslContext) {
        this._setContext = sslContext;
    }

    @ManagedAttribute("The endpoint identification algorithm")
    public String getEndpointIdentificationAlgorithm() {
        return this._endpointIdentificationAlgorithm;
    }

    public void setEndpointIdentificationAlgorithm(String endpointIdentificationAlgorithm) {
        this._endpointIdentificationAlgorithm = endpointIdentificationAlgorithm;
    }

    public PKIXCertPathChecker getPkixCertPathChecker() {
        return this._pkixCertPathChecker;
    }

    public void setPkixCertPathChecker(PKIXCertPathChecker pkixCertPatchChecker) {
        this._pkixCertPathChecker = pkixCertPatchChecker;
    }

    protected KeyStore loadKeyStore(Resource resource) throws Exception {
        return CertificateUtils.getKeyStore(resource, getKeyStoreType(), getKeyStoreProvider(), Objects.toString(this._keyStorePassword, null));
    }

    protected KeyStore loadTrustStore(Resource resource) throws Exception {
        String type = Objects.toString(getTrustStoreType(), getKeyStoreType());
        String provider = Objects.toString(getTrustStoreProvider(), getKeyStoreProvider());
        Password passwd = this._trustStorePassword;
        if (resource == null || resource.equals(this._keyStoreResource)) {
            resource = this._keyStoreResource;
            if (passwd == null) {
                passwd = this._keyStorePassword;
            }
        }
        return CertificateUtils.getKeyStore(resource, type, provider, Objects.toString(passwd, null));
    }

    protected Collection<? extends CRL> loadCRL(String crlPath) throws Exception {
        return CertificateUtils.loadCRL(crlPath);
    }

    protected KeyManager[] getKeyManagers(KeyStore keyStore) throws Exception {
        KeyManager[] managers = null;
        if (keyStore != null) {
            KeyManagerFactory keyManagerFactory = getKeyManagerFactoryInstance();
            keyManagerFactory.init(keyStore, this._keyManagerPassword == null ? this._keyStorePassword == null ? null : this._keyStorePassword.toString().toCharArray() : this._keyManagerPassword.toString().toCharArray());
            managers = keyManagerFactory.getKeyManagers();
            if (managers != null) {
                String alias = getCertAlias();
                if (alias != null) {
                    for (int idx = 0; idx < managers.length; idx++) {
                        if (managers[idx] instanceof X509ExtendedKeyManager) {
                            managers[idx] = new AliasedX509ExtendedKeyManager((X509ExtendedKeyManager) managers[idx], alias);
                        }
                    }
                }
                if (((this instanceof Server) && ((Server) this).isSniRequired()) || !this._certWilds.isEmpty() || this._certHosts.size() > 1 || (this._certHosts.size() == 1 && this._aliasX509.size() > 1)) {
                    for (int idx2 = 0; idx2 < managers.length; idx2++) {
                        if (managers[idx2] instanceof X509ExtendedKeyManager) {
                            managers[idx2] = newSniX509ExtendedKeyManager((X509ExtendedKeyManager) managers[idx2]);
                        }
                    }
                }
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("managers={} for {}", managers, this);
        }
        return managers;
    }

    @Deprecated
    protected X509ExtendedKeyManager newSniX509ExtendedKeyManager(X509ExtendedKeyManager keyManager) {
        throw new IllegalStateException(String.format("KeyStores with multiple certificates are not supported on the base class %s. (Use %s or %s instead)", SslContextFactory.class.getName(), Server.class.getName(), Client.class.getName()));
    }

    protected TrustManager[] getTrustManagers(KeyStore trustStore, Collection<? extends CRL> crls) throws Exception {
        TrustManager[] managers = null;
        if (trustStore != null) {
            if (!isValidatePeerCerts() || !"PKIX".equalsIgnoreCase(getTrustManagerFactoryAlgorithm())) {
                TrustManagerFactory trustManagerFactory = getTrustManagerFactoryInstance();
                trustManagerFactory.init(trustStore);
                managers = trustManagerFactory.getTrustManagers();
            } else {
                PKIXBuilderParameters pbParams = newPKIXBuilderParameters(trustStore, crls);
                TrustManagerFactory trustManagerFactory2 = getTrustManagerFactoryInstance();
                trustManagerFactory2.init(new CertPathTrustManagerParameters(pbParams));
                managers = trustManagerFactory2.getTrustManagers();
            }
        }
        return managers;
    }

    protected PKIXBuilderParameters newPKIXBuilderParameters(KeyStore trustStore, Collection<? extends CRL> crls) throws Exception {
        PKIXBuilderParameters pbParams = new PKIXBuilderParameters(trustStore, new X509CertSelector());
        pbParams.setMaxPathLength(this._maxCertPathLength);
        pbParams.setRevocationEnabled(true);
        if (this._pkixCertPathChecker != null) {
            pbParams.addCertPathChecker(this._pkixCertPathChecker);
        }
        if (crls != null && !crls.isEmpty()) {
            pbParams.addCertStore(getCertStoreInstance(crls));
        }
        if (this._enableCRLDP) {
            System.setProperty("com.sun.security.enableCRLDP", C3P0Substitutions.DEBUG);
        }
        if (this._enableOCSP) {
            Security.setProperty("ocsp.enable", C3P0Substitutions.DEBUG);
            if (this._ocspResponderURL != null) {
                Security.setProperty("ocsp.responderURL", this._ocspResponderURL);
            }
        }
        return pbParams;
    }

    public void selectProtocols(String[] enabledProtocols, String[] supportedProtocols) {
        List<String> selectedProtocols = processIncludeExcludePatterns("Protocols", enabledProtocols, supportedProtocols, this._includeProtocols, this._excludeProtocols);
        if (selectedProtocols.isEmpty()) {
            LOG.warn("No selected Protocols from {}", Arrays.asList(supportedProtocols));
        }
        this._selectedProtocols = (String[]) selectedProtocols.toArray(new String[0]);
    }

    protected void selectCipherSuites(String[] enabledCipherSuites, String[] supportedCipherSuites) {
        List<String> selectedCiphers = processIncludeExcludePatterns("Cipher Suite", enabledCipherSuites, supportedCipherSuites, this._includeCipherSuites, this._excludeCipherSuites);
        if (selectedCiphers.isEmpty()) {
            LOG.warn("No supported Cipher Suite from {}", Arrays.asList(supportedCipherSuites));
        }
        Comparator<String> comparator = getCipherComparator();
        if (comparator != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Sorting selected ciphers with {}", comparator);
            }
            selectedCiphers.sort(comparator);
        }
        this._selectedCipherSuites = (String[]) selectedCiphers.toArray(new String[0]);
    }

    private List<String> processIncludeExcludePatterns(String type, String[] enabled, String[] supported, Set<String> included, Set<String> excluded) {
        List<String> selected = new ArrayList<>();
        if (included.isEmpty()) {
            selected.addAll(Arrays.asList(enabled));
        } else {
            for (String includedItem : included) {
                Pattern pattern = Pattern.compile(includedItem);
                boolean added = false;
                for (String supportedItem : supported) {
                    if (pattern.matcher(supportedItem).matches()) {
                        added = true;
                        selected.add(supportedItem);
                    }
                }
                if (!added) {
                    LOG.info("No {} matching '{}' is supported", type, includedItem);
                }
            }
        }
        for (String excludedItem : excluded) {
            Pattern pattern2 = Pattern.compile(excludedItem);
            selected.removeIf(selectedItem -> {
                return pattern2.matcher(selectedItem).matches();
            });
        }
        return selected;
    }

    @Deprecated
    protected void processIncludeCipherSuites(String[] supportedCipherSuites, List<String> selectedCiphers) {
    }

    @Deprecated
    protected void removeExcludedCipherSuites(List<String> selectedCiphers) {
    }

    private void checkIsStarted() {
        if (!isStarted()) {
            throw new IllegalStateException("!STARTED: " + this);
        }
    }

    @ManagedAttribute("Whether certificate revocation list distribution points is enabled")
    public boolean isEnableCRLDP() {
        return this._enableCRLDP;
    }

    public void setEnableCRLDP(boolean enableCRLDP) {
        this._enableCRLDP = enableCRLDP;
    }

    @ManagedAttribute("Whether online certificate status protocol support is enabled")
    public boolean isEnableOCSP() {
        return this._enableOCSP;
    }

    public void setEnableOCSP(boolean enableOCSP) {
        this._enableOCSP = enableOCSP;
    }

    @ManagedAttribute("The online certificate status protocol URL")
    public String getOcspResponderURL() {
        return this._ocspResponderURL;
    }

    public void setOcspResponderURL(String ocspResponderURL) {
        this._ocspResponderURL = ocspResponderURL;
    }

    public void setKeyStore(KeyStore keyStore) {
        this._setKeyStore = keyStore;
    }

    public KeyStore getKeyStore() {
        KeyStore keyStore;
        if (!isStarted()) {
            return this._setKeyStore;
        }
        synchronized (this) {
            if (this._factory == null) {
                throw new IllegalStateException("SslContextFactory reload failed");
            }
            keyStore = this._factory._keyStore;
        }
        return keyStore;
    }

    public void setTrustStore(KeyStore trustStore) {
        this._setTrustStore = trustStore;
    }

    public KeyStore getTrustStore() {
        KeyStore keyStore;
        if (!isStarted()) {
            return this._setTrustStore;
        }
        synchronized (this) {
            if (this._factory == null) {
                throw new IllegalStateException("SslContextFactory reload failed");
            }
            keyStore = this._factory._trustStore;
        }
        return keyStore;
    }

    public void setKeyStoreResource(Resource resource) {
        this._keyStoreResource = resource;
    }

    public Resource getKeyStoreResource() {
        return this._keyStoreResource;
    }

    public void setTrustStoreResource(Resource resource) {
        this._trustStoreResource = resource;
    }

    public Resource getTrustStoreResource() {
        return this._trustStoreResource;
    }

    @ManagedAttribute("Whether TLS session caching is enabled")
    public boolean isSessionCachingEnabled() {
        return this._sessionCachingEnabled;
    }

    public void setSessionCachingEnabled(boolean enableSessionCaching) {
        this._sessionCachingEnabled = enableSessionCaching;
    }

    @ManagedAttribute("The maximum TLS session cache size")
    public int getSslSessionCacheSize() {
        return this._sslSessionCacheSize;
    }

    public void setSslSessionCacheSize(int sslSessionCacheSize) {
        this._sslSessionCacheSize = sslSessionCacheSize;
    }

    @ManagedAttribute("The TLS session cache timeout, in seconds")
    public int getSslSessionTimeout() {
        return this._sslSessionTimeout;
    }

    public void setSslSessionTimeout(int sslSessionTimeout) {
        this._sslSessionTimeout = sslSessionTimeout;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this._hostnameVerifier;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this._hostnameVerifier = hostnameVerifier;
    }

    protected Password getPassword(String realm) {
        return Password.getPassword(realm, null, null);
    }

    public Password newPassword(String password) {
        return new Password(password);
    }

    public SSLServerSocket newSslServerSocket(String host, int port, int backlog) throws IOException {
        ServerSocket serverSocket;
        checkIsStarted();
        SSLServerSocketFactory factory = getSslContext().getServerSocketFactory();
        if (host == null) {
            serverSocket = factory.createServerSocket(port, backlog);
        } else {
            serverSocket = factory.createServerSocket(port, backlog, InetAddress.getByName(host));
        }
        SSLServerSocket socket = (SSLServerSocket) serverSocket;
        socket.setSSLParameters(customize(socket.getSSLParameters()));
        return socket;
    }

    public SSLSocket newSslSocket() throws IOException {
        checkIsStarted();
        SSLSocket socket = (SSLSocket) getSslContext().getSocketFactory().createSocket();
        socket.setSSLParameters(customize(socket.getSSLParameters()));
        return socket;
    }

    protected CertificateFactory getCertificateFactoryInstance(String type) throws CertificateException {
        String provider = getProvider();
        if (provider != null) {
            try {
                return CertificateFactory.getInstance(type, provider);
            } catch (Throwable cause) {
                LOG.info("Unable to get CertificateFactory instance for type [{}] on provider [{}], using default", type, provider);
                if (LOG.isDebugEnabled()) {
                    LOG.debug(cause);
                }
            }
        }
        return CertificateFactory.getInstance(type);
    }

    protected CertStore getCertStoreInstance(Collection<? extends CRL> crls) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {
        String provider = getProvider();
        if (provider != null) {
            try {
                return CertStore.getInstance("Collection", new CollectionCertStoreParameters(crls), provider);
            } catch (Throwable cause) {
                LOG.info("Unable to get CertStore instance for type [{}] on provider [{}], using default", "Collection", provider);
                if (LOG.isDebugEnabled()) {
                    LOG.debug(cause);
                }
            }
        }
        return CertStore.getInstance("Collection", new CollectionCertStoreParameters(crls));
    }

    protected KeyManagerFactory getKeyManagerFactoryInstance() throws NoSuchAlgorithmException {
        String algorithm = getKeyManagerFactoryAlgorithm();
        String provider = getProvider();
        if (provider != null) {
            try {
                return KeyManagerFactory.getInstance(algorithm, provider);
            } catch (Throwable cause) {
                LOG.info("Unable to get KeyManagerFactory instance for algorithm [{}] on provider [{}], using default", algorithm, provider);
                if (LOG.isDebugEnabled()) {
                    LOG.debug(cause);
                }
            }
        }
        return KeyManagerFactory.getInstance(algorithm);
    }

    protected SecureRandom getSecureRandomInstance() throws NoSuchAlgorithmException {
        String algorithm = getSecureRandomAlgorithm();
        if (algorithm == null) {
            return null;
        }
        String provider = getProvider();
        if (provider != null) {
            try {
                return SecureRandom.getInstance(algorithm, provider);
            } catch (Throwable cause) {
                LOG.info("Unable to get SecureRandom instance for algorithm [{}] on provider [{}], using default", algorithm, provider);
                if (LOG.isDebugEnabled()) {
                    LOG.debug(cause);
                }
            }
        }
        return SecureRandom.getInstance(algorithm);
    }

    protected SSLContext getSSLContextInstance() throws NoSuchAlgorithmException {
        String protocol = getProtocol();
        String provider = getProvider();
        if (provider != null) {
            try {
                return SSLContext.getInstance(protocol, provider);
            } catch (Throwable cause) {
                LOG.info("Unable to get SSLContext instance for protocol [{}] on provider [{}], using default", protocol, provider);
                if (LOG.isDebugEnabled()) {
                    LOG.debug(cause);
                }
            }
        }
        return SSLContext.getInstance(protocol);
    }

    protected TrustManagerFactory getTrustManagerFactoryInstance() throws NoSuchAlgorithmException {
        String algorithm = getTrustManagerFactoryAlgorithm();
        String provider = getProvider();
        if (provider != null) {
            try {
                return TrustManagerFactory.getInstance(algorithm, provider);
            } catch (Throwable cause) {
                LOG.info("Unable to get TrustManagerFactory instance for algorithm [{}] on provider [{}], using default", algorithm, provider);
                if (LOG.isDebugEnabled()) {
                    LOG.debug(cause);
                }
            }
        }
        return TrustManagerFactory.getInstance(algorithm);
    }

    public SSLEngine newSSLEngine() {
        checkIsStarted();
        SSLEngine sslEngine = getSslContext().createSSLEngine();
        customize(sslEngine);
        return sslEngine;
    }

    public SSLEngine newSSLEngine(String host, int port) {
        SSLEngine sslEngine;
        checkIsStarted();
        SSLContext context = getSslContext();
        if (isSessionCachingEnabled()) {
            sslEngine = context.createSSLEngine(host, port);
        } else {
            sslEngine = context.createSSLEngine();
        }
        customize(sslEngine);
        return sslEngine;
    }

    public SSLEngine newSSLEngine(InetSocketAddress address) {
        if (address == null) {
            return newSSLEngine();
        }
        return newSSLEngine(address.getHostString(), address.getPort());
    }

    public void customize(SSLEngine sslEngine) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Customize {}", sslEngine);
        }
        sslEngine.setSSLParameters(customize(sslEngine.getSSLParameters()));
    }

    public SSLParameters customize(SSLParameters sslParams) {
        sslParams.setEndpointIdentificationAlgorithm(getEndpointIdentificationAlgorithm());
        sslParams.setUseCipherSuitesOrder(isUseCipherSuitesOrder());
        if (!this._certHosts.isEmpty() || !this._certWilds.isEmpty()) {
            sslParams.setSNIMatchers(Collections.singletonList(new AliasSNIMatcher()));
        }
        if (this._selectedCipherSuites != null) {
            sslParams.setCipherSuites(this._selectedCipherSuites);
        }
        if (this._selectedProtocols != null) {
            sslParams.setProtocols(this._selectedProtocols);
        }
        if (!(this instanceof Client)) {
            if (getWantClientAuth()) {
                sslParams.setWantClientAuth(true);
            }
            if (getNeedClientAuth()) {
                sslParams.setNeedClientAuth(true);
            }
        }
        return sslParams;
    }

    public void reload(Consumer<SslContextFactory> consumer) throws Exception {
        synchronized (this) {
            consumer.accept(this);
            unload();
            load();
        }
    }

    public X509Certificate[] getX509CertChain(SSLSession sslSession) {
        return getX509CertChain(this, sslSession);
    }

    public static X509Certificate[] getCertChain(SSLSession sslSession) {
        return getX509CertChain(null, sslSession);
    }

    private static X509Certificate[] getX509CertChain(SslContextFactory sslContextFactory, SSLSession sslSession) {
        CertificateFactory cf;
        try {
            Certificate[] javaxCerts = sslSession.getPeerCertificates();
            if (javaxCerts == null || javaxCerts.length == 0) {
                return null;
            }
            int length = javaxCerts.length;
            X509Certificate[] javaCerts = new X509Certificate[length];
            if (sslContextFactory != null) {
                cf = sslContextFactory.getCertificateFactoryInstance("X.509");
            } else {
                cf = CertificateFactory.getInstance("X.509");
            }
            for (int i = 0; i < length; i++) {
                javaCerts[i] = (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(javaxCerts[i].getEncoded()));
            }
            return javaCerts;
        } catch (SSLPeerUnverifiedException e) {
            return null;
        } catch (Exception e2) {
            LOG.warn(Log.EXCEPTION, e2);
            return null;
        }
    }

    public static int deduceKeyLength(String cipherSuite) {
        if (cipherSuite == null) {
            return 0;
        }
        if (cipherSuite.contains("WITH_AES_256_")) {
            return 256;
        }
        if (cipherSuite.contains("WITH_RC4_128_") || cipherSuite.contains("WITH_AES_128_")) {
            return 128;
        }
        if (cipherSuite.contains("WITH_RC4_40_")) {
            return 40;
        }
        if (cipherSuite.contains("WITH_3DES_EDE_CBC_")) {
            return 168;
        }
        if (cipherSuite.contains("WITH_IDEA_CBC_")) {
            return 128;
        }
        if (cipherSuite.contains("WITH_RC2_CBC_40_") || cipherSuite.contains("WITH_DES40_CBC_")) {
            return 40;
        }
        if (cipherSuite.contains("WITH_DES_CBC_")) {
            return 56;
        }
        return 0;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x[provider=%s,keyStore=%s,trustStore=%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._sslProvider, this._keyStoreResource, this._trustStoreResource);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/SslContextFactory$Factory.class */
    public static class Factory {
        private final KeyStore _keyStore;
        private final KeyStore _trustStore;
        private final SSLContext _context;

        Factory(KeyStore keyStore, KeyStore trustStore, SSLContext context) {
            this._keyStore = keyStore;
            this._trustStore = trustStore;
            this._context = context;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/SslContextFactory$AliasSNIMatcher.class */
    public static class AliasSNIMatcher extends SNIMatcher {
        private String _host;

        AliasSNIMatcher() {
            super(0);
        }

        @Override // javax.net.ssl.SNIMatcher
        public boolean matches(SNIServerName serverName) {
            if (SslContextFactory.LOG.isDebugEnabled()) {
                SslContextFactory.LOG.debug("SNI matching for {}", serverName);
            }
            if (serverName instanceof SNIHostName) {
                this._host = StringUtil.asciiToLowerCase(((SNIHostName) serverName).getAsciiName());
                if (!SslContextFactory.LOG.isDebugEnabled()) {
                    return true;
                }
                SslContextFactory.LOG.debug("SNI host name {}", this._host);
                return true;
            } else if (!SslContextFactory.LOG.isDebugEnabled()) {
                return true;
            } else {
                SslContextFactory.LOG.debug("No SNI host name for {}", serverName);
                return true;
            }
        }

        public String getHost() {
            return this._host;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/SslContextFactory$Client.class */
    public static class Client extends SslContextFactory {
        private SniProvider sniProvider;

        @FunctionalInterface
        /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/SslContextFactory$Client$SniProvider.class */
        public interface SniProvider {
            public static final SniProvider NON_DOMAIN_SNI_PROVIDER = x$0, x$1 -> {
                return Client.getSniServerNames(x$0, x$1);
            };

            List<SNIServerName> apply(SSLEngine sSLEngine, List<SNIServerName> list);
        }

        public Client() {
            this(false);
        }

        public Client(boolean trustAll) {
            super(trustAll);
            this.sniProvider = sslEngine, serverNames -> {
                return serverNames;
            };
        }

        @Override // org.eclipse.jetty.util.ssl.SslContextFactory
        protected void checkConfiguration() {
            checkTrustAll();
            checkEndPointIdentificationAlgorithm();
            checkConfiguration();
        }

        @Override // org.eclipse.jetty.util.ssl.SslContextFactory
        protected X509ExtendedKeyManager newSniX509ExtendedKeyManager(X509ExtendedKeyManager keyManager) {
            return keyManager;
        }

        @Override // org.eclipse.jetty.util.ssl.SslContextFactory
        public void customize(SSLEngine sslEngine) {
            SSLParameters sslParameters = sslEngine.getSSLParameters();
            List<SNIServerName> serverNames = sslParameters.getServerNames();
            if (serverNames == null) {
                serverNames = Collections.emptyList();
            }
            List<SNIServerName> newServerNames = getSNIProvider().apply(sslEngine, serverNames);
            if (!(newServerNames == null || newServerNames == serverNames)) {
                sslParameters.setServerNames(newServerNames);
                sslEngine.setSSLParameters(sslParameters);
            }
            customize(sslEngine);
        }

        public SniProvider getSNIProvider() {
            return this.sniProvider;
        }

        public void setSNIProvider(SniProvider sniProvider) {
            this.sniProvider = (SniProvider) Objects.requireNonNull(sniProvider);
        }

        /* access modifiers changed from: private */
        public static List<SNIServerName> getSniServerNames(SSLEngine sslEngine, List<SNIServerName> serverNames) {
            String host;
            if (!serverNames.isEmpty() || (host = sslEngine.getPeerHost()) == null) {
                return serverNames;
            }
            return Collections.singletonList(new SNIHostName(host.getBytes(StandardCharsets.US_ASCII)));
        }
    }

    @ManagedObject
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/SslContextFactory$Server.class */
    public static class Server extends SslContextFactory implements SniX509ExtendedKeyManager.SniSelector {
        private boolean _sniRequired;
        private SniX509ExtendedKeyManager.SniSelector _sniSelector;

        public Server() {
            setEndpointIdentificationAlgorithm(null);
        }

        @Override // org.eclipse.jetty.util.ssl.SslContextFactory
        public boolean getWantClientAuth() {
            return getWantClientAuth();
        }

        @Override // org.eclipse.jetty.util.ssl.SslContextFactory
        public void setWantClientAuth(boolean wantClientAuth) {
            setWantClientAuth(wantClientAuth);
        }

        @Override // org.eclipse.jetty.util.ssl.SslContextFactory
        public boolean getNeedClientAuth() {
            return getNeedClientAuth();
        }

        @Override // org.eclipse.jetty.util.ssl.SslContextFactory
        public void setNeedClientAuth(boolean needClientAuth) {
            setNeedClientAuth(needClientAuth);
        }

        @ManagedAttribute("Whether the TLS handshake is rejected if there is no SNI host match")
        public boolean isSniRequired() {
            return this._sniRequired;
        }

        public void setSniRequired(boolean sniRequired) {
            this._sniRequired = sniRequired;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
            if (r0.noneMatch((v1) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return r1.isInstance(v1);
            }) != false) goto L_0x0029;
         */
        @Override // org.eclipse.jetty.util.ssl.SslContextFactory
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected javax.net.ssl.KeyManager[] getKeyManagers(java.security.KeyStore r5) throws java.lang.Exception {
            /*
                r4 = this;
                r0 = r4
                r1 = r5
                javax.net.ssl.KeyManager[] r0 = r0.getKeyManagers(r1)
                r6 = r0
                r0 = r4
                boolean r0 = r0.isSniRequired()
                if (r0 == 0) goto L_0x0033
                r0 = r6
                if (r0 == 0) goto L_0x0029
                r0 = r6
                java.util.stream.Stream r0 = java.util.Arrays.stream(r0)
                java.lang.Class<org.eclipse.jetty.util.ssl.SniX509ExtendedKeyManager> r1 = org.eclipse.jetty.util.ssl.SniX509ExtendedKeyManager.class
                r2 = r1
                java.lang.Object r2 = java.util.Objects.requireNonNull(r2)
                javax.net.ssl.KeyManager[] r1 = (v1) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                    return r1.isInstance(v1);
                }
                boolean r0 = r0.noneMatch(r1)
                if (r0 == 0) goto L_0x0033
            L_0x0029:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                r1 = r0
                java.lang.String r2 = "No SNI Key managers when SNI is required"
                r1.<init>(r2)
                throw r0
            L_0x0033:
                r0 = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ssl.SslContextFactory.Server.getKeyManagers(java.security.KeyStore):javax.net.ssl.KeyManager[]");
        }

        public SniX509ExtendedKeyManager.SniSelector getSNISelector() {
            return this._sniSelector;
        }

        public void setSNISelector(SniX509ExtendedKeyManager.SniSelector sniSelector) {
            this._sniSelector = sniSelector;
        }

        @Override // org.eclipse.jetty.util.ssl.SniX509ExtendedKeyManager.SniSelector
        public String sniSelect(String keyType, Principal[] issuers, SSLSession session, String sniHost, Collection<X509> certificates) {
            String alias;
            boolean sniRequired = isSniRequired();
            if (SslContextFactory.LOG.isDebugEnabled()) {
                SslContextFactory.LOG.debug("Selecting alias: keyType={}, sni={}, sniRequired={}, certs={}", keyType, String.valueOf(sniHost), Boolean.valueOf(sniRequired), certificates);
            }
            if (sniHost == null) {
                alias = sniRequired ? null : SniX509ExtendedKeyManager.SniSelector.DELEGATE;
            } else {
                List<X509> matching = (List) certificates.stream().filter(x509 -> {
                    return x509.matches(sniHost);
                }).collect(Collectors.toList());
                if (matching.isEmpty()) {
                    alias = (sniRequired || aliasCerts().values().stream().anyMatch(x509 -> {
                        return x509.matches(sniHost);
                    })) ? null : SniX509ExtendedKeyManager.SniSelector.DELEGATE;
                } else {
                    alias = matching.get(0).getAlias();
                    if (matching.size() > 1) {
                        alias = (String) matching.stream().min(Comparator.comparingInt(cert -> {
                            return cert.getWilds().size();
                        })).map((v0) -> {
                            return v0.getAlias();
                        }).orElse(alias);
                    }
                }
            }
            if (SslContextFactory.LOG.isDebugEnabled()) {
                SslContextFactory.LOG.debug("Selected alias={}", String.valueOf(alias));
            }
            return alias;
        }

        @Override // org.eclipse.jetty.util.ssl.SslContextFactory
        protected X509ExtendedKeyManager newSniX509ExtendedKeyManager(X509ExtendedKeyManager keyManager) {
            return new SniX509ExtendedKeyManager(keyManager, this);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/SslContextFactory$X509ExtendedKeyManagerWrapper.class */
    public static class X509ExtendedKeyManagerWrapper extends X509ExtendedKeyManager {
        private final X509ExtendedKeyManager keyManager;

        public X509ExtendedKeyManagerWrapper(X509ExtendedKeyManager keyManager) {
            this.keyManager = keyManager;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getClientAliases(String keyType, Principal[] issuers) {
            if (this.keyManager == null) {
                return null;
            }
            return this.keyManager.getClientAliases(keyType, issuers);
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
            if (this.keyManager == null) {
                return null;
            }
            return this.keyManager.chooseClientAlias(keyType, issuers, socket);
        }

        @Override // javax.net.ssl.X509ExtendedKeyManager
        public String chooseEngineClientAlias(String[] keyType, Principal[] issuers, SSLEngine engine) {
            if (this.keyManager == null) {
                return null;
            }
            return this.keyManager.chooseEngineClientAlias(keyType, issuers, engine);
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getServerAliases(String keyType, Principal[] issuers) {
            if (this.keyManager == null) {
                return null;
            }
            return this.keyManager.getServerAliases(keyType, issuers);
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
            if (this.keyManager == null) {
                return null;
            }
            return this.keyManager.chooseServerAlias(keyType, issuers, socket);
        }

        @Override // javax.net.ssl.X509ExtendedKeyManager
        public String chooseEngineServerAlias(String keyType, Principal[] issuers, SSLEngine engine) {
            if (this.keyManager == null) {
                return null;
            }
            return this.keyManager.chooseEngineServerAlias(keyType, issuers, engine);
        }

        @Override // javax.net.ssl.X509KeyManager
        public X509Certificate[] getCertificateChain(String alias) {
            if (this.keyManager == null) {
                return null;
            }
            return this.keyManager.getCertificateChain(alias);
        }

        @Override // javax.net.ssl.X509KeyManager
        public PrivateKey getPrivateKey(String alias) {
            if (this.keyManager == null) {
                return null;
            }
            return this.keyManager.getPrivateKey(alias);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/SslContextFactory$X509ExtendedTrustManagerWrapper.class */
    public static class X509ExtendedTrustManagerWrapper extends X509ExtendedTrustManager {
        private final X509ExtendedTrustManager trustManager;

        public X509ExtendedTrustManagerWrapper(X509ExtendedTrustManager trustManager) {
            this.trustManager = trustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.trustManager == null ? new X509Certificate[0] : this.trustManager.getAcceptedIssuers();
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
            if (this.trustManager != null) {
                this.trustManager.checkClientTrusted(certs, authType);
            }
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        public void checkClientTrusted(X509Certificate[] chain, String authType, Socket socket) throws CertificateException {
            if (this.trustManager != null) {
                this.trustManager.checkClientTrusted(chain, authType, socket);
            }
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        public void checkClientTrusted(X509Certificate[] chain, String authType, SSLEngine engine) throws CertificateException {
            if (this.trustManager != null) {
                this.trustManager.checkClientTrusted(chain, authType, engine);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
            if (this.trustManager != null) {
                this.trustManager.checkServerTrusted(certs, authType);
            }
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        public void checkServerTrusted(X509Certificate[] chain, String authType, Socket socket) throws CertificateException {
            if (this.trustManager != null) {
                this.trustManager.checkServerTrusted(chain, authType, socket);
            }
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        public void checkServerTrusted(X509Certificate[] chain, String authType, SSLEngine engine) throws CertificateException {
            if (this.trustManager != null) {
                this.trustManager.checkServerTrusted(chain, authType, engine);
            }
        }
    }
}
