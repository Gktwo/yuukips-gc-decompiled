package p013io.netty.handler.ssl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.ssl.OpenSslKeyMaterialManager */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslKeyMaterialManager.class */
public final class OpenSslKeyMaterialManager {
    static final String KEY_TYPE_RSA = "RSA";
    static final String KEY_TYPE_DH_RSA = "DH_RSA";
    static final String KEY_TYPE_EC = "EC";
    static final String KEY_TYPE_EC_EC = "EC_EC";
    static final String KEY_TYPE_EC_RSA = "EC_RSA";
    private static final Map<String, String> KEY_TYPES = new HashMap();
    private final OpenSslKeyMaterialProvider provider;

    static {
        KEY_TYPES.put(KEY_TYPE_RSA, KEY_TYPE_RSA);
        KEY_TYPES.put("DHE_RSA", KEY_TYPE_RSA);
        KEY_TYPES.put("ECDHE_RSA", KEY_TYPE_RSA);
        KEY_TYPES.put("ECDHE_ECDSA", KEY_TYPE_EC);
        KEY_TYPES.put("ECDH_RSA", KEY_TYPE_EC_RSA);
        KEY_TYPES.put("ECDH_ECDSA", KEY_TYPE_EC_EC);
        KEY_TYPES.put(KEY_TYPE_DH_RSA, KEY_TYPE_DH_RSA);
    }

    /* access modifiers changed from: package-private */
    public OpenSslKeyMaterialManager(OpenSslKeyMaterialProvider provider) {
        this.provider = provider;
    }

    /* access modifiers changed from: package-private */
    public void setKeyMaterialServerSide(ReferenceCountedOpenSslEngine engine) throws SSLException {
        String alias;
        String[] authMethods = engine.authMethods();
        if (authMethods.length == 0) {
            throw new SSLHandshakeException("Unable to find key material");
        }
        Set<String> typeSet = new HashSet<>(KEY_TYPES.size());
        for (String authMethod : authMethods) {
            String type = KEY_TYPES.get(authMethod);
            if (type != null && typeSet.add(type) && (alias = chooseServerAlias(engine, type)) != null) {
                setKeyMaterial(engine, alias);
                return;
            }
        }
        throw new SSLHandshakeException("Unable to find key material for auth method(s): " + Arrays.toString(authMethods));
    }

    /* access modifiers changed from: package-private */
    public void setKeyMaterialClientSide(ReferenceCountedOpenSslEngine engine, String[] keyTypes, X500Principal[] issuer) throws SSLException {
        String alias = chooseClientAlias(engine, keyTypes, issuer);
        if (alias != null) {
            setKeyMaterial(engine, alias);
        }
    }

    private void setKeyMaterial(ReferenceCountedOpenSslEngine engine, String alias) throws SSLException {
        OpenSslKeyMaterial keyMaterial;
        try {
            keyMaterial = null;
            try {
                try {
                    keyMaterial = this.provider.chooseKeyMaterial(engine.alloc, alias);
                    if (keyMaterial != null) {
                        engine.setKeyMaterial(keyMaterial);
                        if (keyMaterial != null) {
                            keyMaterial.release();
                        }
                    } else if (keyMaterial != null) {
                        keyMaterial.release();
                    }
                } catch (Exception e) {
                    throw new SSLException(e);
                }
            } catch (SSLException e2) {
                throw e2;
            }
        } catch (Throwable th) {
            if (keyMaterial != null) {
                keyMaterial.release();
            }
            throw th;
        }
    }

    private String chooseClientAlias(ReferenceCountedOpenSslEngine engine, String[] keyTypes, X500Principal[] issuer) {
        X509KeyManager manager = this.provider.keyManager();
        if (manager instanceof X509ExtendedKeyManager) {
            return ((X509ExtendedKeyManager) manager).chooseEngineClientAlias(keyTypes, issuer, engine);
        }
        return manager.chooseClientAlias(keyTypes, issuer, null);
    }

    private String chooseServerAlias(ReferenceCountedOpenSslEngine engine, String type) {
        X509KeyManager manager = this.provider.keyManager();
        if (manager instanceof X509ExtendedKeyManager) {
            return ((X509ExtendedKeyManager) manager).chooseEngineServerAlias(type, null, engine);
        }
        return manager.chooseServerAlias(type, null, null);
    }
}
