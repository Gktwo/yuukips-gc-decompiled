package p013io.netty.handler.ssl;

import java.math.BigInteger;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.Unpooled;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.IllegalReferenceCountException;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.PemX509Certificate */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/PemX509Certificate.class */
public final class PemX509Certificate extends X509Certificate implements PemEncoded {
    private static final byte[] BEGIN_CERT = "-----BEGIN CERTIFICATE-----\n".getBytes(CharsetUtil.US_ASCII);
    private static final byte[] END_CERT = "\n-----END CERTIFICATE-----\n".getBytes(CharsetUtil.US_ASCII);
    private final ByteBuf content;

    /* access modifiers changed from: package-private */
    public static PemEncoded toPEM(ByteBufAllocator allocator, boolean useDirect, X509Certificate... chain) throws CertificateEncodingException {
        ObjectUtil.checkNonEmpty(chain, "chain");
        if (chain.length == 1) {
            X509Certificate first = chain[0];
            if (first instanceof PemEncoded) {
                return ((PemEncoded) first).retain();
            }
        }
        ByteBuf pem = null;
        try {
            for (X509Certificate cert : chain) {
                if (cert == null) {
                    throw new IllegalArgumentException("Null element in chain: " + Arrays.toString(chain));
                }
                if (cert instanceof PemEncoded) {
                    pem = append(allocator, useDirect, (PemEncoded) cert, chain.length, pem);
                } else {
                    pem = append(allocator, useDirect, cert, chain.length, pem);
                }
            }
            PemValue value = new PemValue(pem, false);
            if (1 == 0 && pem != null) {
                pem.release();
            }
            return value;
        } catch (Throwable th) {
            if (0 == 0 && 0 != 0) {
                pem.release();
            }
            throw th;
        }
    }

    private static ByteBuf append(ByteBufAllocator allocator, boolean useDirect, PemEncoded encoded, int count, ByteBuf pem) {
        ByteBuf content = encoded.content();
        if (pem == null) {
            pem = newBuffer(allocator, useDirect, content.readableBytes() * count);
        }
        pem.writeBytes(content.slice());
        return pem;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x0051
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static p013io.netty.buffer.ByteBuf append(p013io.netty.buffer.ByteBufAllocator r5, boolean r6, java.security.cert.X509Certificate r7, int r8, p013io.netty.buffer.ByteBuf r9) throws java.security.cert.CertificateEncodingException {
        /*
            r0 = r7
            byte[] r0 = r0.getEncoded()
            io.netty.buffer.ByteBuf r0 = p013io.netty.buffer.Unpooled.wrappedBuffer(r0)
            r10 = r0
            r0 = r5
            r1 = r10
            io.netty.buffer.ByteBuf r0 = p013io.netty.handler.ssl.SslUtils.toBase64(r0, r1)     // Catch: all -> 0x0065
            r11 = r0
            r0 = r9
            if (r0 != 0) goto L_0x002e
            r0 = r5
            r1 = r6
            byte[] r2 = p013io.netty.handler.ssl.PemX509Certificate.BEGIN_CERT     // Catch: all -> 0x0065, all -> 0x0051
            int r2 = r2.length     // Catch: all -> 0x0065, all -> 0x0051
            r3 = r11
            int r3 = r3.readableBytes()     // Catch: all -> 0x0065, all -> 0x0051
            int r2 = r2 + r3
            byte[] r3 = p013io.netty.handler.ssl.PemX509Certificate.END_CERT     // Catch: all -> 0x0065, all -> 0x0051
            int r3 = r3.length     // Catch: all -> 0x0065, all -> 0x0051
            int r2 = r2 + r3
            r3 = r8
            int r2 = r2 * r3
            io.netty.buffer.ByteBuf r0 = newBuffer(r0, r1, r2)     // Catch: all -> 0x0065, all -> 0x0051
            r9 = r0
        L_0x002e:
            r0 = r9
            byte[] r1 = p013io.netty.handler.ssl.PemX509Certificate.BEGIN_CERT     // Catch: all -> 0x0065, all -> 0x0051
            io.netty.buffer.ByteBuf r0 = r0.writeBytes(r1)     // Catch: all -> 0x0065, all -> 0x0051
            r0 = r9
            r1 = r11
            io.netty.buffer.ByteBuf r0 = r0.writeBytes(r1)     // Catch: all -> 0x0065, all -> 0x0051
            r0 = r9
            byte[] r1 = p013io.netty.handler.ssl.PemX509Certificate.END_CERT     // Catch: all -> 0x0065, all -> 0x0051
            io.netty.buffer.ByteBuf r0 = r0.writeBytes(r1)     // Catch: all -> 0x0065, all -> 0x0051
            r0 = r11
            boolean r0 = r0.release()     // Catch: all -> 0x0065
            goto L_0x005c
        L_0x0051:
            r12 = move-exception
            r0 = r11
            boolean r0 = r0.release()     // Catch: all -> 0x0065
            r0 = r12
            throw r0     // Catch: all -> 0x0065
        L_0x005c:
            r0 = r10
            boolean r0 = r0.release()
            goto L_0x0070
        L_0x0065:
            r13 = move-exception
            r0 = r10
            boolean r0 = r0.release()
            r0 = r13
            throw r0
        L_0x0070:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.PemX509Certificate.append(io.netty.buffer.ByteBufAllocator, boolean, java.security.cert.X509Certificate, int, io.netty.buffer.ByteBuf):io.netty.buffer.ByteBuf");
    }

    private static ByteBuf newBuffer(ByteBufAllocator allocator, boolean useDirect, int initialCapacity) {
        return useDirect ? allocator.directBuffer(initialCapacity) : allocator.buffer(initialCapacity);
    }

    public static PemX509Certificate valueOf(byte[] key) {
        return valueOf(Unpooled.wrappedBuffer(key));
    }

    public static PemX509Certificate valueOf(ByteBuf key) {
        return new PemX509Certificate(key);
    }

    private PemX509Certificate(ByteBuf content) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(content, "content");
    }

    @Override // p013io.netty.handler.ssl.PemEncoded
    public boolean isSensitive() {
        return false;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.content.refCnt();
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        int count = refCnt();
        if (count > 0) {
            return this.content;
        }
        throw new IllegalReferenceCountException(count);
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder
    public PemX509Certificate copy() {
        return replace(this.content.copy());
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder
    public PemX509Certificate duplicate() {
        return replace(this.content.duplicate());
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder
    public PemX509Certificate retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder
    public PemX509Certificate replace(ByteBuf content) {
        return new PemX509Certificate(content);
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder, p013io.netty.util.ReferenceCounted
    public PemX509Certificate retain() {
        this.content.retain();
        return this;
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder, p013io.netty.util.ReferenceCounted
    public PemX509Certificate retain(int increment) {
        this.content.retain(increment);
        return this;
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder, p013io.netty.util.ReferenceCounted
    public PemX509Certificate touch() {
        this.content.touch();
        return this;
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder, p013io.netty.util.ReferenceCounted
    public PemX509Certificate touch(Object hint) {
        this.content.touch(hint);
        return this;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public boolean release() {
        return this.content.release();
    }

    @Override // p013io.netty.util.ReferenceCounted
    public boolean release(int decrement) {
        return this.content.release(decrement);
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String oid) {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey key) {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey key, String sigProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.cert.Certificate, java.lang.Object
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PemX509Certificate)) {
            return false;
        }
        return this.content.equals(((PemX509Certificate) o).content);
    }

    @Override // java.security.cert.Certificate, java.lang.Object
    public int hashCode() {
        return this.content.hashCode();
    }

    @Override // java.security.cert.Certificate, java.lang.Object
    public String toString() {
        return this.content.toString(CharsetUtil.UTF_8);
    }
}
