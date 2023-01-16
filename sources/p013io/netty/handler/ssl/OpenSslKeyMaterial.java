package p013io.netty.handler.ssl;

import java.security.cert.X509Certificate;
import p013io.netty.util.ReferenceCounted;

/* renamed from: io.netty.handler.ssl.OpenSslKeyMaterial */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslKeyMaterial.class */
interface OpenSslKeyMaterial extends ReferenceCounted {
    X509Certificate[] certificateChain();

    long certificateChainAddress();

    long privateKeyAddress();

    @Override // p013io.netty.util.ReferenceCounted
    OpenSslKeyMaterial retain();

    @Override // p013io.netty.util.ReferenceCounted
    OpenSslKeyMaterial retain(int i);

    @Override // p013io.netty.util.ReferenceCounted
    OpenSslKeyMaterial touch();

    @Override // p013io.netty.util.ReferenceCounted
    OpenSslKeyMaterial touch(Object obj);

    @Override // p013io.netty.util.ReferenceCounted
    boolean release();

    @Override // p013io.netty.util.ReferenceCounted
    boolean release(int i);
}
