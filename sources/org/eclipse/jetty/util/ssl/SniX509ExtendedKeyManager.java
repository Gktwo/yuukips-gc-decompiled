package org.eclipse.jetty.util.ssl;

import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509ExtendedKeyManager;
import net.bytebuddy.implementation.MethodDelegation;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.ssl.SslContextFactory;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/SniX509ExtendedKeyManager.class */
public class SniX509ExtendedKeyManager extends X509ExtendedKeyManager {
    public static final String SNI_X509 = "org.eclipse.jetty.util.ssl.snix509";
    private static final Logger LOG = Log.getLogger(SniX509ExtendedKeyManager.class);
    private final X509ExtendedKeyManager _delegate;
    private final SslContextFactory.Server _sslContextFactory;
    private UnaryOperator<String> _aliasMapper;

    @FunctionalInterface
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/SniX509ExtendedKeyManager$SniSelector.class */
    public interface SniSelector {
        public static final String DELEGATE = "delegate_no_sni_match";

        String sniSelect(String str, Principal[] principalArr, SSLSession sSLSession, String str2, Collection<X509> collection) throws SSLHandshakeException;
    }

    @Deprecated
    public SniX509ExtendedKeyManager(X509ExtendedKeyManager keyManager) {
        this(keyManager, null);
    }

    public SniX509ExtendedKeyManager(X509ExtendedKeyManager keyManager, SslContextFactory.Server sslContextFactory) {
        this._aliasMapper = UnaryOperator.identity();
        this._delegate = keyManager;
        this._sslContextFactory = (SslContextFactory.Server) Objects.requireNonNull(sslContextFactory, "SslContextFactory.Server must be provided");
    }

    public UnaryOperator<String> getAliasMapper() {
        return this._aliasMapper;
    }

    public void setAliasMapper(UnaryOperator<String> aliasMapper) {
        this._aliasMapper = (UnaryOperator) Objects.requireNonNull(aliasMapper);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
        return this._delegate.chooseClientAlias(keyType, issuers, socket);
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineClientAlias(String[] keyType, Principal[] issuers, SSLEngine engine) {
        return this._delegate.chooseEngineClientAlias(keyType, issuers, engine);
    }

    protected String chooseServerAlias(String keyType, Principal[] issuers, Collection<SNIMatcher> matchers, SSLSession session) {
        String host;
        String[] mangledAliases = this._delegate.getServerAliases(keyType, issuers);
        if (mangledAliases == null || mangledAliases.length == 0) {
            return null;
        }
        Map<String, String> aliasMap = new LinkedHashMap<>();
        Arrays.stream(mangledAliases).forEach(alias -> {
            aliasMap.put((String) getAliasMapper().apply(aliasMap), aliasMap);
        });
        if (matchers == null) {
            host = null;
        } else {
            Stream<SNIMatcher> stream = matchers.stream();
            Objects.requireNonNull(SslContextFactory.AliasSNIMatcher.class);
            Stream<SNIMatcher> filter = stream.filter((v1) -> {
                return r1.isInstance(v1);
            });
            Objects.requireNonNull(SslContextFactory.AliasSNIMatcher.class);
            host = (String) filter.map((v1) -> {
                return r1.cast(v1);
            }).findFirst().map((v0) -> {
                return v0.getHost();
            }).orElse(null);
        }
        try {
            Stream<String> stream2 = aliasMap.keySet().stream();
            SslContextFactory.Server server = this._sslContextFactory;
            Objects.requireNonNull(server);
            Collection<X509> certificates = (Collection) stream2.map(this::getX509).filter((v0) -> {
                return Objects.nonNull(v0);
            }).collect(Collectors.toList());
            SniSelector sniSelector = this._sslContextFactory.getSNISelector();
            if (sniSelector == null) {
                sniSelector = this._sslContextFactory;
            }
            String alias = sniSelector.sniSelect(keyType, issuers, session, host, certificates);
            if (alias == null || alias == SniSelector.DELEGATE) {
                return alias;
            }
            X509 x509 = this._sslContextFactory.getX509(alias);
            if (aliasMap.containsKey(alias) && x509 != null) {
                if (session != null) {
                    session.putValue(SNI_X509, x509);
                }
                String mangledAlias = aliasMap.get(alias);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Matched SNI {} with alias {}, certificate {} from aliases {}", host, mangledAlias, x509, aliasMap.keySet());
                }
                return mangledAlias;
            } else if (!LOG.isDebugEnabled()) {
                return null;
            } else {
                LOG.debug("Invalid X509 match for SNI {}: {}", host, alias);
                return null;
            }
        } catch (Throwable x) {
            if (!LOG.isDebugEnabled()) {
                return null;
            }
            LOG.debug("Failure matching X509 for SNI " + host, x);
            return null;
        }
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
        String alias;
        SSLSocket sslSocket = (SSLSocket) socket;
        if (socket == null) {
            alias = chooseServerAlias(keyType, issuers, Collections.emptyList(), null);
        } else {
            alias = chooseServerAlias(keyType, issuers, sslSocket.getSSLParameters().getSNIMatchers(), sslSocket.getHandshakeSession());
        }
        boolean delegate = alias == SniSelector.DELEGATE;
        if (delegate) {
            alias = this._delegate.chooseServerAlias(keyType, issuers, socket);
        }
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            Object[] objArr = new Object[4];
            objArr[0] = delegate ? MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX : "explicit";
            objArr[1] = String.valueOf(alias);
            objArr[2] = keyType;
            objArr[3] = socket;
            logger.debug("Chose {} alias={} keyType={} on {}", objArr);
        }
        return alias;
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineServerAlias(String keyType, Principal[] issuers, SSLEngine engine) {
        String alias;
        if (engine == null) {
            alias = chooseServerAlias(keyType, issuers, Collections.emptyList(), null);
        } else {
            alias = chooseServerAlias(keyType, issuers, engine.getSSLParameters().getSNIMatchers(), engine.getHandshakeSession());
        }
        boolean delegate = alias == SniSelector.DELEGATE;
        if (delegate) {
            alias = this._delegate.chooseEngineServerAlias(keyType, issuers, engine);
        }
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            Object[] objArr = new Object[4];
            objArr[0] = delegate ? MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX : "explicit";
            objArr[1] = String.valueOf(alias);
            objArr[2] = keyType;
            objArr[3] = engine;
            logger.debug("Chose {} alias={} keyType={} on {}", objArr);
        }
        return alias;
    }

    @Override // javax.net.ssl.X509KeyManager
    public X509Certificate[] getCertificateChain(String alias) {
        return this._delegate.getCertificateChain(alias);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getClientAliases(String keyType, Principal[] issuers) {
        return this._delegate.getClientAliases(keyType, issuers);
    }

    @Override // javax.net.ssl.X509KeyManager
    public PrivateKey getPrivateKey(String alias) {
        return this._delegate.getPrivateKey(alias);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getServerAliases(String keyType, Principal[] issuers) {
        return this._delegate.getServerAliases(keyType, issuers);
    }
}
