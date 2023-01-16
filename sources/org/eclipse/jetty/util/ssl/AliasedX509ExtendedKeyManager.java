package org.eclipse.jetty.util.ssl;

import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/AliasedX509ExtendedKeyManager.class */
public class AliasedX509ExtendedKeyManager extends X509ExtendedKeyManager {
    private final String _alias;
    private final X509ExtendedKeyManager _delegate;

    public AliasedX509ExtendedKeyManager(X509ExtendedKeyManager keyManager, String keyAlias) {
        this._alias = keyAlias;
        this._delegate = keyManager;
    }

    public X509ExtendedKeyManager getDelegate() {
        return this._delegate;
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
        if (this._alias == null) {
            return this._delegate.chooseClientAlias(keyType, issuers, socket);
        }
        for (String kt : keyType) {
            String[] aliases = this._delegate.getClientAliases(kt, issuers);
            if (aliases != null) {
                for (String a : aliases) {
                    if (this._alias.equals(a)) {
                        return this._alias;
                    }
                }
                continue;
            }
        }
        return null;
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
        if (this._alias == null) {
            return this._delegate.chooseServerAlias(keyType, issuers, socket);
        }
        String[] aliases = this._delegate.getServerAliases(keyType, issuers);
        if (aliases == null) {
            return null;
        }
        for (String a : aliases) {
            if (this._alias.equals(a)) {
                return this._alias;
            }
        }
        return null;
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getClientAliases(String keyType, Principal[] issuers) {
        return this._delegate.getClientAliases(keyType, issuers);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getServerAliases(String keyType, Principal[] issuers) {
        return this._delegate.getServerAliases(keyType, issuers);
    }

    @Override // javax.net.ssl.X509KeyManager
    public X509Certificate[] getCertificateChain(String alias) {
        return this._delegate.getCertificateChain(alias);
    }

    @Override // javax.net.ssl.X509KeyManager
    public PrivateKey getPrivateKey(String alias) {
        return this._delegate.getPrivateKey(alias);
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineServerAlias(String keyType, Principal[] issuers, SSLEngine engine) {
        if (this._alias == null) {
            return this._delegate.chooseEngineServerAlias(keyType, issuers, engine);
        }
        String[] aliases = this._delegate.getServerAliases(keyType, issuers);
        if (aliases == null) {
            return null;
        }
        for (String a : aliases) {
            if (this._alias.equals(a)) {
                return this._alias;
            }
        }
        return null;
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineClientAlias(String[] keyType, Principal[] issuers, SSLEngine engine) {
        if (this._alias == null) {
            return this._delegate.chooseEngineClientAlias(keyType, issuers, engine);
        }
        for (String kt : keyType) {
            String[] aliases = this._delegate.getClientAliases(kt, issuers);
            if (aliases != null) {
                for (String a : aliases) {
                    if (this._alias.equals(a)) {
                        return this._alias;
                    }
                }
                continue;
            }
        }
        return null;
    }
}
