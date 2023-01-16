package p013io.netty.handler.ssl.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import p013io.netty.util.concurrent.FastThreadLocal;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SuppressJava6Requirement;

/* renamed from: io.netty.handler.ssl.util.SimpleKeyManagerFactory */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/util/SimpleKeyManagerFactory.class */
public abstract class SimpleKeyManagerFactory extends KeyManagerFactory {
    private static final Provider PROVIDER = new Provider("", 0.0d, "") { // from class: io.netty.handler.ssl.util.SimpleKeyManagerFactory.1
        private static final long serialVersionUID = -2680540247105807895L;
    };
    private static final FastThreadLocal<SimpleKeyManagerFactorySpi> CURRENT_SPI = new FastThreadLocal<SimpleKeyManagerFactorySpi>() { // from class: io.netty.handler.ssl.util.SimpleKeyManagerFactory.2
        /* access modifiers changed from: protected */
        @Override // p013io.netty.util.concurrent.FastThreadLocal
        public SimpleKeyManagerFactorySpi initialValue() {
            return new SimpleKeyManagerFactorySpi();
        }
    };

    protected abstract void engineInit(KeyStore keyStore, char[] cArr) throws Exception;

    protected abstract void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception;

    protected abstract KeyManager[] engineGetKeyManagers();

    /* access modifiers changed from: protected */
    public SimpleKeyManagerFactory() {
        this("");
    }

    protected SimpleKeyManagerFactory(String name) {
        super(CURRENT_SPI.get(), PROVIDER, (String) ObjectUtil.checkNotNull(name, "name"));
        CURRENT_SPI.get().init(this);
        CURRENT_SPI.remove();
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.util.SimpleKeyManagerFactory$SimpleKeyManagerFactorySpi */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/util/SimpleKeyManagerFactory$SimpleKeyManagerFactorySpi.class */
    public static final class SimpleKeyManagerFactorySpi extends KeyManagerFactorySpi {
        private SimpleKeyManagerFactory parent;
        private volatile KeyManager[] keyManagers;

        private SimpleKeyManagerFactorySpi() {
        }

        void init(SimpleKeyManagerFactory parent) {
            this.parent = parent;
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        protected void engineInit(KeyStore keyStore, char[] pwd) throws KeyStoreException {
            try {
                this.parent.engineInit(keyStore, pwd);
            } catch (KeyStoreException e) {
                throw e;
            } catch (Exception e2) {
                throw new KeyStoreException(e2);
            }
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
            try {
                this.parent.engineInit(managerFactoryParameters);
            } catch (InvalidAlgorithmParameterException e) {
                throw e;
            } catch (Exception e2) {
                throw new InvalidAlgorithmParameterException(e2);
            }
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        protected KeyManager[] engineGetKeyManagers() {
            KeyManager[] keyManagers = this.keyManagers;
            if (keyManagers == null) {
                keyManagers = this.parent.engineGetKeyManagers();
                if (PlatformDependent.javaVersion() >= 7) {
                    wrapIfNeeded(keyManagers);
                }
                this.keyManagers = keyManagers;
            }
            return (KeyManager[]) keyManagers.clone();
        }

        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        private static void wrapIfNeeded(KeyManager[] keyManagers) {
            for (int i = 0; i < keyManagers.length; i++) {
                KeyManager tm = keyManagers[i];
                if ((tm instanceof X509KeyManager) && !(tm instanceof X509ExtendedKeyManager)) {
                    keyManagers[i] = new X509KeyManagerWrapper((X509KeyManager) tm);
                }
            }
        }
    }
}
