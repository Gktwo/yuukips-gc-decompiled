package p013io.netty.handler.ssl;

import javax.net.ssl.SSLEngine;

/* renamed from: io.netty.handler.ssl.BouncyCastle */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/BouncyCastle.class */
final class BouncyCastle {
    private static final boolean BOUNCY_CASTLE_ON_CLASSPATH;

    static {
        boolean bcOnClasspath = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider");
            bcOnClasspath = true;
        } catch (Throwable th) {
        }
        BOUNCY_CASTLE_ON_CLASSPATH = bcOnClasspath;
    }

    /* access modifiers changed from: package-private */
    public static boolean isAvailable() {
        return BOUNCY_CASTLE_ON_CLASSPATH;
    }

    /* access modifiers changed from: package-private */
    public static boolean isInUse(SSLEngine engine) {
        return engine.getClass().getPackage().getName().startsWith("org.bouncycastle.jsse.provider");
    }

    private BouncyCastle() {
    }
}
