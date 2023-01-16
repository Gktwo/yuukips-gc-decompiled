package org.eclipse.jetty.util.security;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CRL;
import java.security.cert.CertificateFactory;
import java.util.Collection;
import java.util.Objects;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/security/CertificateUtils.class */
public class CertificateUtils {
    public static KeyStore getKeyStore(Resource store, String storeType, String storeProvider, String storePassword) throws Exception {
        char[] charArray;
        KeyStore keystore = null;
        if (store != null) {
            Objects.requireNonNull(storeType, "storeType cannot be null");
            if (storeProvider != null) {
                keystore = KeyStore.getInstance(storeType, storeProvider);
            } else {
                keystore = KeyStore.getInstance(storeType);
            }
            if (!store.exists()) {
                throw new IllegalStateException(store.getName() + " is not a valid keystore");
            }
            InputStream inStream = store.getInputStream();
            if (storePassword == null) {
                charArray = null;
            } else {
                try {
                    charArray = storePassword.toCharArray();
                } catch (Throwable th) {
                    if (inStream != null) {
                        try {
                            inStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            keystore.load(inStream, charArray);
            if (inStream != null) {
                inStream.close();
            }
        }
        return keystore;
    }

    public static Collection<? extends CRL> loadCRL(String crlPath) throws Exception {
        Collection<? extends CRL> crlList = null;
        if (crlPath != null) {
            InputStream in = null;
            try {
                in = Resource.newResource(crlPath).getInputStream();
                crlList = CertificateFactory.getInstance("X.509").generateCRLs(in);
                if (in != null) {
                    in.close();
                }
            } catch (Throwable th) {
                if (in != null) {
                    in.close();
                }
                throw th;
            }
        }
        return crlList;
    }
}
