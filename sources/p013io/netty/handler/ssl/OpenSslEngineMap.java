package p013io.netty.handler.ssl;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.ssl.OpenSslEngineMap */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslEngineMap.class */
public interface OpenSslEngineMap {
    ReferenceCountedOpenSslEngine remove(long j);

    void add(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine);

    ReferenceCountedOpenSslEngine get(long j);
}
