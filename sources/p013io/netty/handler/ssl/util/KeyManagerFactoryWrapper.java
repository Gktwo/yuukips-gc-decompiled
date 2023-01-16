package p013io.netty.handler.ssl.util;

import java.security.KeyStore;
import javax.net.ssl.KeyManager;
import javax.net.ssl.ManagerFactoryParameters;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.util.KeyManagerFactoryWrapper */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/util/KeyManagerFactoryWrapper.class */
public final class KeyManagerFactoryWrapper extends SimpleKeyManagerFactory {

    /* renamed from: km */
    private final KeyManager f1029km;

    public KeyManagerFactoryWrapper(KeyManager km) {
        this.f1029km = (KeyManager) ObjectUtil.checkNotNull(km, "km");
    }

    @Override // p013io.netty.handler.ssl.util.SimpleKeyManagerFactory
    protected void engineInit(KeyStore keyStore, char[] var2) throws Exception {
    }

    @Override // p013io.netty.handler.ssl.util.SimpleKeyManagerFactory
    protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception {
    }

    @Override // p013io.netty.handler.ssl.util.SimpleKeyManagerFactory
    protected KeyManager[] engineGetKeyManagers() {
        return new KeyManager[]{this.f1029km};
    }
}
