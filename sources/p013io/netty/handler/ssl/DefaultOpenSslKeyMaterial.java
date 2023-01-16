package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import java.security.cert.X509Certificate;
import p013io.netty.util.AbstractReferenceCounted;
import p013io.netty.util.IllegalReferenceCountException;
import p013io.netty.util.ResourceLeakDetector;
import p013io.netty.util.ResourceLeakDetectorFactory;
import p013io.netty.util.ResourceLeakTracker;

/* renamed from: io.netty.handler.ssl.DefaultOpenSslKeyMaterial */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/DefaultOpenSslKeyMaterial.class */
final class DefaultOpenSslKeyMaterial extends AbstractReferenceCounted implements OpenSslKeyMaterial {
    private static final ResourceLeakDetector<DefaultOpenSslKeyMaterial> leakDetector;
    private final ResourceLeakTracker<DefaultOpenSslKeyMaterial> leak = leakDetector.track(this);
    private final X509Certificate[] x509CertificateChain;
    private long chain;
    private long privateKey;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !DefaultOpenSslKeyMaterial.class.desiredAssertionStatus();
        leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(DefaultOpenSslKeyMaterial.class);
    }

    /* access modifiers changed from: package-private */
    public DefaultOpenSslKeyMaterial(long chain, long privateKey, X509Certificate[] x509CertificateChain) {
        this.chain = chain;
        this.privateKey = privateKey;
        this.x509CertificateChain = x509CertificateChain;
    }

    @Override // p013io.netty.handler.ssl.OpenSslKeyMaterial
    public X509Certificate[] certificateChain() {
        return (X509Certificate[]) this.x509CertificateChain.clone();
    }

    @Override // p013io.netty.handler.ssl.OpenSslKeyMaterial
    public long certificateChainAddress() {
        if (refCnt() > 0) {
            return this.chain;
        }
        throw new IllegalReferenceCountException();
    }

    @Override // p013io.netty.handler.ssl.OpenSslKeyMaterial
    public long privateKeyAddress() {
        if (refCnt() > 0) {
            return this.privateKey;
        }
        throw new IllegalReferenceCountException();
    }

    @Override // p013io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        SSL.freeX509Chain(this.chain);
        this.chain = 0;
        SSL.freePrivateKey(this.privateKey);
        this.privateKey = 0;
        if (this.leak != null) {
            boolean closed = this.leak.close(this);
            if (!$assertionsDisabled && !closed) {
                throw new AssertionError();
            }
        }
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public DefaultOpenSslKeyMaterial retain() {
        if (this.leak != null) {
            this.leak.record();
        }
        retain();
        return this;
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public DefaultOpenSslKeyMaterial retain(int increment) {
        if (this.leak != null) {
            this.leak.record();
        }
        retain(increment);
        return this;
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public DefaultOpenSslKeyMaterial touch() {
        if (this.leak != null) {
            this.leak.record();
        }
        touch();
        return this;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public DefaultOpenSslKeyMaterial touch(Object hint) {
        if (this.leak != null) {
            this.leak.record(hint);
        }
        return this;
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public boolean release() {
        if (this.leak != null) {
            this.leak.record();
        }
        return release();
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public boolean release(int decrement) {
        if (this.leak != null) {
            this.leak.record();
        }
        return release(decrement);
    }
}
