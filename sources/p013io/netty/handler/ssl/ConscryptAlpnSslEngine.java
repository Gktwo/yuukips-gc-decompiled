package p013io.netty.handler.ssl;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import org.conscrypt.AllocatedBuffer;
import org.conscrypt.BufferAllocator;
import org.conscrypt.Conscrypt;
import org.conscrypt.HandshakeListener;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.SystemPropertyUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.ssl.ConscryptAlpnSslEngine */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/ConscryptAlpnSslEngine.class */
public abstract class ConscryptAlpnSslEngine extends JdkSslEngine {
    private static final boolean USE_BUFFER_ALLOCATOR = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.conscrypt.useBufferAllocator", true);

    /* access modifiers changed from: package-private */
    public static ConscryptAlpnSslEngine newClientEngine(SSLEngine engine, ByteBufAllocator alloc, JdkApplicationProtocolNegotiator applicationNegotiator) {
        return new ClientEngine(engine, alloc, applicationNegotiator);
    }

    /* access modifiers changed from: package-private */
    public static ConscryptAlpnSslEngine newServerEngine(SSLEngine engine, ByteBufAllocator alloc, JdkApplicationProtocolNegotiator applicationNegotiator) {
        return new ServerEngine(engine, alloc, applicationNegotiator);
    }

    private ConscryptAlpnSslEngine(SSLEngine engine, ByteBufAllocator alloc, List<String> protocols) {
        super(engine);
        if (USE_BUFFER_ALLOCATOR) {
            Conscrypt.setBufferAllocator(engine, new BufferAllocatorAdapter(alloc));
        }
        Conscrypt.setApplicationProtocols(engine, (String[]) protocols.toArray(new String[0]));
    }

    /* access modifiers changed from: package-private */
    public final int calculateOutNetBufSize(int plaintextBytes, int numBuffers) {
        return (int) Math.min(2147483647L, ((long) plaintextBytes) + (((long) Conscrypt.maxSealOverhead(getWrappedEngine())) * ((long) numBuffers)));
    }

    /* access modifiers changed from: package-private */
    public final SSLEngineResult unwrap(ByteBuffer[] srcs, ByteBuffer[] dests) throws SSLException {
        return Conscrypt.unwrap(getWrappedEngine(), srcs, dests);
    }

    /* renamed from: io.netty.handler.ssl.ConscryptAlpnSslEngine$ClientEngine */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ConscryptAlpnSslEngine$ClientEngine.class */
    private static final class ClientEngine extends ConscryptAlpnSslEngine {
        private final JdkApplicationProtocolNegotiator.ProtocolSelectionListener protocolListener;

        ClientEngine(SSLEngine engine, ByteBufAllocator alloc, JdkApplicationProtocolNegotiator applicationNegotiator) {
            super(engine, alloc, applicationNegotiator.protocols());
            Conscrypt.setHandshakeListener(engine, new HandshakeListener() { // from class: io.netty.handler.ssl.ConscryptAlpnSslEngine.ClientEngine.1
                public void onHandshakeFinished() throws SSLException {
                    ClientEngine.this.selectProtocol();
                }
            });
            this.protocolListener = (JdkApplicationProtocolNegotiator.ProtocolSelectionListener) ObjectUtil.checkNotNull(applicationNegotiator.protocolListenerFactory().newListener(this, applicationNegotiator.protocols()), "protocolListener");
        }

        /* access modifiers changed from: private */
        public void selectProtocol() throws SSLException {
            try {
                this.protocolListener.selected(Conscrypt.getApplicationProtocol(getWrappedEngine()));
            } catch (Throwable e) {
                throw SslUtils.toSSLHandshakeException(e);
            }
        }
    }

    /* renamed from: io.netty.handler.ssl.ConscryptAlpnSslEngine$ServerEngine */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ConscryptAlpnSslEngine$ServerEngine.class */
    private static final class ServerEngine extends ConscryptAlpnSslEngine {
        private final JdkApplicationProtocolNegotiator.ProtocolSelector protocolSelector;

        ServerEngine(SSLEngine engine, ByteBufAllocator alloc, JdkApplicationProtocolNegotiator applicationNegotiator) {
            super(engine, alloc, applicationNegotiator.protocols());
            Conscrypt.setHandshakeListener(engine, new HandshakeListener() { // from class: io.netty.handler.ssl.ConscryptAlpnSslEngine.ServerEngine.1
                public void onHandshakeFinished() throws SSLException {
                    ServerEngine.this.selectProtocol();
                }
            });
            this.protocolSelector = (JdkApplicationProtocolNegotiator.ProtocolSelector) ObjectUtil.checkNotNull(applicationNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(applicationNegotiator.protocols())), "protocolSelector");
        }

        /* access modifiers changed from: private */
        public void selectProtocol() throws SSLException {
            try {
                String protocol = Conscrypt.getApplicationProtocol(getWrappedEngine());
                this.protocolSelector.select(protocol != null ? Collections.singletonList(protocol) : Collections.emptyList());
            } catch (Throwable e) {
                throw SslUtils.toSSLHandshakeException(e);
            }
        }
    }

    /* renamed from: io.netty.handler.ssl.ConscryptAlpnSslEngine$BufferAllocatorAdapter */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ConscryptAlpnSslEngine$BufferAllocatorAdapter.class */
    private static final class BufferAllocatorAdapter extends BufferAllocator {
        private final ByteBufAllocator alloc;

        BufferAllocatorAdapter(ByteBufAllocator alloc) {
            this.alloc = alloc;
        }

        public AllocatedBuffer allocateDirectBuffer(int capacity) {
            return new BufferAdapter(this.alloc.directBuffer(capacity));
        }
    }

    /* renamed from: io.netty.handler.ssl.ConscryptAlpnSslEngine$BufferAdapter */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ConscryptAlpnSslEngine$BufferAdapter.class */
    private static final class BufferAdapter extends AllocatedBuffer {
        private final ByteBuf nettyBuffer;
        private final ByteBuffer buffer;

        BufferAdapter(ByteBuf nettyBuffer) {
            this.nettyBuffer = nettyBuffer;
            this.buffer = nettyBuffer.nioBuffer(0, nettyBuffer.capacity());
        }

        public ByteBuffer nioBuffer() {
            return this.buffer;
        }

        public AllocatedBuffer retain() {
            this.nettyBuffer.retain();
            return this;
        }

        public AllocatedBuffer release() {
            this.nettyBuffer.release();
            return this;
        }
    }
}
