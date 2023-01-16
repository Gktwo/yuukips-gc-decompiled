package p013io.netty.handler.ssl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLEngine;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.handler.ssl.Conscrypt */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/Conscrypt.class */
final class Conscrypt {
    private static final Method IS_CONSCRYPT_SSLENGINE;

    static {
        Method isConscryptSSLEngine = null;
        if ((PlatformDependent.javaVersion() >= 8 && PlatformDependent.javaVersion() < 15) || PlatformDependent.isAndroid()) {
            try {
                Class.forName("org.conscrypt.OpenSSLProvider", true, PlatformDependent.getClassLoader(ConscryptAlpnSslEngine.class)).newInstance();
                isConscryptSSLEngine = Class.forName("org.conscrypt.Conscrypt", true, PlatformDependent.getClassLoader(ConscryptAlpnSslEngine.class)).getMethod("isConscrypt", SSLEngine.class);
            } catch (Throwable th) {
            }
        }
        IS_CONSCRYPT_SSLENGINE = isConscryptSSLEngine;
    }

    /* access modifiers changed from: package-private */
    public static boolean isAvailable() {
        return IS_CONSCRYPT_SSLENGINE != null;
    }

    /* access modifiers changed from: package-private */
    public static boolean isEngineSupported(SSLEngine engine) {
        try {
            if (IS_CONSCRYPT_SSLENGINE != null) {
                if (((Boolean) IS_CONSCRYPT_SSLENGINE.invoke(null, engine)).booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (IllegalAccessException e) {
            return false;
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Conscrypt() {
    }
}
