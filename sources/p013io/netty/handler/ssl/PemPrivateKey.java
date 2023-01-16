package p013io.netty.handler.ssl;

import java.security.PrivateKey;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.Unpooled;
import p013io.netty.util.AbstractReferenceCounted;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.IllegalReferenceCountException;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.PemPrivateKey */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/PemPrivateKey.class */
public final class PemPrivateKey extends AbstractReferenceCounted implements PrivateKey, PemEncoded {
    private static final long serialVersionUID = 7978017465645018936L;
    private static final byte[] BEGIN_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n".getBytes(CharsetUtil.US_ASCII);
    private static final byte[] END_PRIVATE_KEY = "\n-----END PRIVATE KEY-----\n".getBytes(CharsetUtil.US_ASCII);
    private static final String PKCS8_FORMAT = "PKCS#8";
    private final ByteBuf content;

    /* access modifiers changed from: package-private */
    public static PemEncoded toPEM(ByteBufAllocator allocator, boolean useDirect, PrivateKey key) {
        if (key instanceof PemEncoded) {
            return ((PemEncoded) key).retain();
        }
        byte[] bytes = key.getEncoded();
        if (bytes != null) {
            return toPEM(allocator, useDirect, bytes);
        }
        throw new IllegalArgumentException(key.getClass().getName() + " does not support encoding");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x007c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    static p013io.netty.handler.ssl.PemEncoded toPEM(p013io.netty.buffer.ByteBufAllocator r5, boolean r6, byte[] r7) {
        /*
            r0 = r7
            io.netty.buffer.ByteBuf r0 = p013io.netty.buffer.Unpooled.wrappedBuffer(r0)
            r8 = r0
            r0 = r5
            r1 = r8
            io.netty.buffer.ByteBuf r0 = p013io.netty.handler.ssl.SslUtils.toBase64(r0, r1)     // Catch: all -> 0x0095
            r9 = r0
            byte[] r0 = p013io.netty.handler.ssl.PemPrivateKey.BEGIN_PRIVATE_KEY     // Catch: all -> 0x0095, all -> 0x008b
            int r0 = r0.length     // Catch: all -> 0x0095, all -> 0x008b
            r1 = r9
            int r1 = r1.readableBytes()     // Catch: all -> 0x0095, all -> 0x008b
            int r0 = r0 + r1
            byte[] r1 = p013io.netty.handler.ssl.PemPrivateKey.END_PRIVATE_KEY     // Catch: all -> 0x0095, all -> 0x008b
            int r1 = r1.length     // Catch: all -> 0x0095, all -> 0x008b
            int r0 = r0 + r1
            r10 = r0
            r0 = 0
            r11 = r0
            r0 = r6
            if (r0 == 0) goto L_0x002f
            r0 = r5
            r1 = r10
            io.netty.buffer.ByteBuf r0 = r0.directBuffer(r1)     // Catch: all -> 0x0095, all -> 0x008b
            goto L_0x0037
        L_0x002f:
            r0 = r5
            r1 = r10
            io.netty.buffer.ByteBuf r0 = r0.buffer(r1)     // Catch: all -> 0x0095, all -> 0x008b
        L_0x0037:
            r12 = r0
            r0 = r12
            byte[] r1 = p013io.netty.handler.ssl.PemPrivateKey.BEGIN_PRIVATE_KEY     // Catch: all -> 0x0095, all -> 0x007c, all -> 0x008b
            io.netty.buffer.ByteBuf r0 = r0.writeBytes(r1)     // Catch: all -> 0x0095, all -> 0x007c, all -> 0x008b
            r0 = r12
            r1 = r9
            io.netty.buffer.ByteBuf r0 = r0.writeBytes(r1)     // Catch: all -> 0x0095, all -> 0x007c, all -> 0x008b
            r0 = r12
            byte[] r1 = p013io.netty.handler.ssl.PemPrivateKey.END_PRIVATE_KEY     // Catch: all -> 0x0095, all -> 0x007c, all -> 0x008b
            io.netty.buffer.ByteBuf r0 = r0.writeBytes(r1)     // Catch: all -> 0x0095, all -> 0x007c, all -> 0x008b
            io.netty.handler.ssl.PemValue r0 = new io.netty.handler.ssl.PemValue     // Catch: all -> 0x0095, all -> 0x007c, all -> 0x008b
            r1 = r0
            r2 = r12
            r3 = 1
            r1.<init>(r2, r3)     // Catch: all -> 0x0095, all -> 0x007c, all -> 0x008b
            r13 = r0
            r0 = 1
            r11 = r0
            r0 = r13
            r14 = r0
            r0 = r11
            if (r0 != 0) goto L_0x0070
            r0 = r12
            p013io.netty.handler.ssl.SslUtils.zerooutAndRelease(r0)     // Catch: all -> 0x0095, all -> 0x008b
        L_0x0070:
            r0 = r9
            p013io.netty.handler.ssl.SslUtils.zerooutAndRelease(r0)     // Catch: all -> 0x0095
            r0 = r8
            p013io.netty.handler.ssl.SslUtils.zerooutAndRelease(r0)
            r0 = r14
            return r0
        L_0x007c:
            r15 = move-exception
            r0 = r11
            if (r0 != 0) goto L_0x0088
            r0 = r12
            p013io.netty.handler.ssl.SslUtils.zerooutAndRelease(r0)     // Catch: all -> 0x0095, all -> 0x008b
        L_0x0088:
            r0 = r15
            throw r0     // Catch: all -> 0x0095, all -> 0x008b
        L_0x008b:
            r16 = move-exception
            r0 = r9
            p013io.netty.handler.ssl.SslUtils.zerooutAndRelease(r0)     // Catch: all -> 0x0095
            r0 = r16
            throw r0     // Catch: all -> 0x0095
        L_0x0095:
            r17 = move-exception
            r0 = r8
            p013io.netty.handler.ssl.SslUtils.zerooutAndRelease(r0)
            r0 = r17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.PemPrivateKey.toPEM(io.netty.buffer.ByteBufAllocator, boolean, byte[]):io.netty.handler.ssl.PemEncoded");
    }

    public static PemPrivateKey valueOf(byte[] key) {
        return valueOf(Unpooled.wrappedBuffer(key));
    }

    public static PemPrivateKey valueOf(ByteBuf key) {
        return new PemPrivateKey(key);
    }

    private PemPrivateKey(ByteBuf content) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(content, "content");
    }

    @Override // p013io.netty.handler.ssl.PemEncoded
    public boolean isSensitive() {
        return true;
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
    public PemPrivateKey copy() {
        return replace(this.content.copy());
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder
    public PemPrivateKey duplicate() {
        return replace(this.content.duplicate());
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder
    public PemPrivateKey retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder
    public PemPrivateKey replace(ByteBuf content) {
        return new PemPrivateKey(content);
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public PemPrivateKey touch() {
        this.content.touch();
        return this;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public PemPrivateKey touch(Object hint) {
        this.content.touch(hint);
        return this;
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public PemPrivateKey retain() {
        return (PemPrivateKey) retain();
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public PemPrivateKey retain(int increment) {
        return (PemPrivateKey) retain(increment);
    }

    @Override // p013io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        SslUtils.zerooutAndRelease(this.content);
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.Key
    public String getFormat() {
        return PKCS8_FORMAT;
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        release(refCnt());
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return refCnt() == 0;
    }
}
