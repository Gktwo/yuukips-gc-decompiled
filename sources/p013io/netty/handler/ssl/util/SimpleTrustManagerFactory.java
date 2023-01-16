package p013io.netty.handler.ssl.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.TrustManagerFactorySpi;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import p013io.netty.util.concurrent.FastThreadLocal;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SuppressJava6Requirement;

/* renamed from: io.netty.handler.ssl.util.SimpleTrustManagerFactory */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/util/SimpleTrustManagerFactory.class */
public abstract class SimpleTrustManagerFactory extends TrustManagerFactory {
    private static final Provider PROVIDER = new Provider("", 0.0d, "") { // from class: io.netty.handler.ssl.util.SimpleTrustManagerFactory.1
        private static final long serialVersionUID = -2680540247105807895L;
    };
    private static final FastThreadLocal<SimpleTrustManagerFactorySpi> CURRENT_SPI = new FastThreadLocal<SimpleTrustManagerFactorySpi>() { // from class: io.netty.handler.ssl.util.SimpleTrustManagerFactory.2
        /* access modifiers changed from: protected */
        @Override // p013io.netty.util.concurrent.FastThreadLocal
        public SimpleTrustManagerFactorySpi initialValue() {
            return new SimpleTrustManagerFactorySpi();
        }
    };

    protected abstract void engineInit(KeyStore keyStore) throws Exception;

    protected abstract void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception;

    protected abstract TrustManager[] engineGetTrustManagers();

    /* access modifiers changed from: protected */
    public SimpleTrustManagerFactory() {
        this("");
    }

    protected SimpleTrustManagerFactory(String name) {
        super(CURRENT_SPI.get(), PROVIDER, name);
        CURRENT_SPI.get().init(this);
        CURRENT_SPI.remove();
        ObjectUtil.checkNotNull(name, "name");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.ssl.util.SimpleTrustManagerFactory$SimpleTrustManagerFactorySpi */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/util/SimpleTrustManagerFactory$SimpleTrustManagerFactorySpi.class */
    public static final class SimpleTrustManagerFactorySpi extends TrustManagerFactorySpi {
        private SimpleTrustManagerFactory parent;
        private volatile TrustManager[] trustManagers;

        SimpleTrustManagerFactorySpi() {
        }

        void init(SimpleTrustManagerFactory parent) {
            this.parent = parent;
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        protected void engineInit(KeyStore keyStore) throws KeyStoreException {
            try {
                this.parent.engineInit(keyStore);
            } catch (KeyStoreException e) {
                throw e;
            } catch (Exception e2) {
                throw new KeyStoreException(e2);
            }
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
            try {
                this.parent.engineInit(managerFactoryParameters);
            } catch (InvalidAlgorithmParameterException e) {
                throw e;
            } catch (Exception e2) {
                throw new InvalidAlgorithmParameterException(e2);
            }
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        protected TrustManager[] engineGetTrustManagers() {
            TrustManager[] trustManagers = this.trustManagers;
            if (trustManagers == null) {
                trustManagers = this.parent.engineGetTrustManagers();
                if (PlatformDependent.javaVersion() >= 7) {
                    wrapIfNeeded(trustManagers);
                }
                this.trustManagers = trustManagers;
            }
            return (TrustManager[]) trustManagers.clone();
        }

        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        private static void wrapIfNeeded(TrustManager[] trustManagers) {
            for (int i = 0; i < trustManagers.length; i++) {
                TrustManager tm = trustManagers[i];
                if ((tm instanceof X509TrustManager) && !(tm instanceof X509ExtendedTrustManager)) {
                    trustManagers[i] = new X509TrustManagerWrapper((X509TrustManager) tm);
                }
            }
        }
    }
}
