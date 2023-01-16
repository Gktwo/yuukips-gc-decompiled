package p013io.netty.handler.ssl;

import p013io.netty.buffer.ByteBufAllocator;

/* renamed from: io.netty.handler.ssl.OpenSslEngine */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslEngine.class */
public final class OpenSslEngine extends ReferenceCountedOpenSslEngine {
    /* access modifiers changed from: package-private */
    public OpenSslEngine(OpenSslContext context, ByteBufAllocator alloc, String peerHost, int peerPort, boolean jdkCompatibilityMode) {
        super(context, alloc, peerHost, peerPort, jdkCompatibilityMode, false);
    }

    @Override // java.lang.Object
    protected void finalize() throws Throwable {
        finalize();
        OpenSsl.releaseIfNeeded(this);
    }
}
