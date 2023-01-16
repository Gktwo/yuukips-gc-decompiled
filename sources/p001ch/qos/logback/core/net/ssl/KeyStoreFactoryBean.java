package p001ch.qos.logback.core.net.ssl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import p001ch.qos.logback.core.util.LocationUtil;

/* renamed from: ch.qos.logback.core.net.ssl.KeyStoreFactoryBean */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/ssl/KeyStoreFactoryBean.class */
public class KeyStoreFactoryBean {
    private String location;
    private String provider;
    private String type;
    private String password;

    public KeyStore createKeyStore() throws NoSuchProviderException, NoSuchAlgorithmException, KeyStoreException {
        InputStream inputStream;
        if (getLocation() == null) {
            throw new IllegalArgumentException("location is required");
        }
        try {
            inputStream = null;
            try {
                try {
                    try {
                        try {
                            inputStream = LocationUtil.urlForResource(getLocation()).openStream();
                            KeyStore keyStore = newKeyStore();
                            keyStore.load(inputStream, getPassword().toCharArray());
                            return keyStore;
                        } catch (Exception ex) {
                            throw new KeyStoreException(getLocation() + ": " + ex.getMessage(), ex);
                        }
                    } catch (NoSuchAlgorithmException e) {
                        throw new NoSuchAlgorithmException("no such keystore type: " + getType());
                    }
                } catch (FileNotFoundException e2) {
                    throw new KeyStoreException(getLocation() + ": file not found");
                }
            } catch (NoSuchProviderException e3) {
                throw new NoSuchProviderException("no such keystore provider: " + getProvider());
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex2) {
                    ex2.printStackTrace(System.err);
                }
            }
        }
    }

    private KeyStore newKeyStore() throws NoSuchAlgorithmException, NoSuchProviderException, KeyStoreException {
        return getProvider() != null ? KeyStore.getInstance(getType(), getProvider()) : KeyStore.getInstance(getType());
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        if (this.type == null) {
            return SSL.DEFAULT_KEYSTORE_TYPE;
        }
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPassword() {
        if (this.password == null) {
            return SSL.DEFAULT_KEYSTORE_PASSWORD;
        }
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
