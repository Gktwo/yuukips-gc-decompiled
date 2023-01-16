package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import p013io.netty.util.AbstractReferenceCounted;
import p013io.netty.util.IllegalReferenceCountException;
import p013io.netty.util.internal.EmptyArrays;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.ssl.OpenSslPrivateKey */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslPrivateKey.class */
public final class OpenSslPrivateKey extends AbstractReferenceCounted implements PrivateKey {
    private long privateKeyAddress;

    /* access modifiers changed from: package-private */
    public OpenSslPrivateKey(long privateKeyAddress) {
        this.privateKeyAddress = privateKeyAddress;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "unknown";
    }

    @Override // java.security.Key
    public String getFormat() {
        return null;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return null;
    }

    /* access modifiers changed from: private */
    public long privateKeyAddress() {
        if (refCnt() > 0) {
            return this.privateKeyAddress;
        }
        throw new IllegalReferenceCountException();
    }

    @Override // p013io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        SSL.freePrivateKey(this.privateKeyAddress);
        this.privateKeyAddress = 0;
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public OpenSslPrivateKey retain() {
        retain();
        return this;
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public OpenSslPrivateKey retain(int increment) {
        retain(increment);
        return this;
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public OpenSslPrivateKey touch() {
        touch();
        return this;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public OpenSslPrivateKey touch(Object hint) {
        return this;
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        release(refCnt());
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return refCnt() == 0;
    }

    /* access modifiers changed from: package-private */
    public OpenSslKeyMaterial newKeyMaterial(long certificateChain, X509Certificate[] chain) {
        return new OpenSslPrivateKeyMaterial(certificateChain, chain);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.ssl.OpenSslPrivateKey$OpenSslPrivateKeyMaterial */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslPrivateKey$OpenSslPrivateKeyMaterial.class */
    public final class OpenSslPrivateKeyMaterial extends AbstractReferenceCounted implements OpenSslKeyMaterial {
        long certificateChain;
        private final X509Certificate[] x509CertificateChain;

        OpenSslPrivateKeyMaterial(long certificateChain, X509Certificate[] x509CertificateChain) {
            this.certificateChain = certificateChain;
            this.x509CertificateChain = x509CertificateChain == null ? EmptyArrays.EMPTY_X509_CERTIFICATES : x509CertificateChain;
            OpenSslPrivateKey.this.retain();
        }

        @Override // p013io.netty.handler.ssl.OpenSslKeyMaterial
        public X509Certificate[] certificateChain() {
            return (X509Certificate[]) this.x509CertificateChain.clone();
        }

        @Override // p013io.netty.handler.ssl.OpenSslKeyMaterial
        public long certificateChainAddress() {
            if (refCnt() > 0) {
                return this.certificateChain;
            }
            throw new IllegalReferenceCountException();
        }

        @Override // p013io.netty.handler.ssl.OpenSslKeyMaterial
        public long privateKeyAddress() {
            if (refCnt() > 0) {
                return OpenSslPrivateKey.this.privateKeyAddress();
            }
            throw new IllegalReferenceCountException();
        }

        @Override // p013io.netty.util.ReferenceCounted
        public OpenSslKeyMaterial touch(Object hint) {
            OpenSslPrivateKey.this.touch(hint);
            return this;
        }

        @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
        public OpenSslKeyMaterial retain() {
            retain();
            return this;
        }

        @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
        public OpenSslKeyMaterial retain(int increment) {
            retain(increment);
            return this;
        }

        @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
        public OpenSslKeyMaterial touch() {
            OpenSslPrivateKey.this.touch();
            return this;
        }

        @Override // p013io.netty.util.AbstractReferenceCounted
        protected void deallocate() {
            releaseChain();
            OpenSslPrivateKey.this.release();
        }

        private void releaseChain() {
            SSL.freeX509Chain(this.certificateChain);
            this.certificateChain = 0;
        }
    }
}
