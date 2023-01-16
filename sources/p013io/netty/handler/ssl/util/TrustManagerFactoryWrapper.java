package p013io.netty.handler.ssl.util;

import java.security.KeyStore;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.util.TrustManagerFactoryWrapper */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/util/TrustManagerFactoryWrapper.class */
public final class TrustManagerFactoryWrapper extends SimpleTrustManagerFactory {

    /* renamed from: tm */
    private final TrustManager f1030tm;

    public TrustManagerFactoryWrapper(TrustManager tm) {
        this.f1030tm = (TrustManager) ObjectUtil.checkNotNull(tm, "tm");
    }

    @Override // p013io.netty.handler.ssl.util.SimpleTrustManagerFactory
    protected void engineInit(KeyStore keyStore) throws Exception {
    }

    @Override // p013io.netty.handler.ssl.util.SimpleTrustManagerFactory
    protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception {
    }

    @Override // p013io.netty.handler.ssl.util.SimpleTrustManagerFactory
    protected TrustManager[] engineGetTrustManagers() {
        return new TrustManager[]{this.f1030tm};
    }
}
