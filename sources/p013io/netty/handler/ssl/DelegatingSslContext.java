package p013io.netty.handler.ssl;

import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSessionContext;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.DelegatingSslContext */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/DelegatingSslContext.class */
public abstract class DelegatingSslContext extends SslContext {
    private final SslContext ctx;

    protected abstract void initEngine(SSLEngine sSLEngine);

    protected DelegatingSslContext(SslContext ctx) {
        this.ctx = (SslContext) ObjectUtil.checkNotNull(ctx, "ctx");
    }

    @Override // p013io.netty.handler.ssl.SslContext
    public final boolean isClient() {
        return this.ctx.isClient();
    }

    @Override // p013io.netty.handler.ssl.SslContext
    public final List<String> cipherSuites() {
        return this.ctx.cipherSuites();
    }

    @Override // p013io.netty.handler.ssl.SslContext
    public final long sessionCacheSize() {
        return this.ctx.sessionCacheSize();
    }

    @Override // p013io.netty.handler.ssl.SslContext
    public final long sessionTimeout() {
        return this.ctx.sessionTimeout();
    }

    @Override // p013io.netty.handler.ssl.SslContext
    public final ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.ctx.applicationProtocolNegotiator();
    }

    @Override // p013io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator alloc) {
        SSLEngine engine = this.ctx.newEngine(alloc);
        initEngine(engine);
        return engine;
    }

    @Override // p013io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator alloc, String peerHost, int peerPort) {
        SSLEngine engine = this.ctx.newEngine(alloc, peerHost, peerPort);
        initEngine(engine);
        return engine;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator alloc, boolean startTls) {
        SslHandler handler = this.ctx.newHandler(alloc, startTls);
        initHandler(handler);
        return handler;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator alloc, String peerHost, int peerPort, boolean startTls) {
        SslHandler handler = this.ctx.newHandler(alloc, peerHost, peerPort, startTls);
        initHandler(handler);
        return handler;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator alloc, boolean startTls, Executor executor) {
        SslHandler handler = this.ctx.newHandler(alloc, startTls, executor);
        initHandler(handler);
        return handler;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator alloc, String peerHost, int peerPort, boolean startTls, Executor executor) {
        SslHandler handler = this.ctx.newHandler(alloc, peerHost, peerPort, startTls, executor);
        initHandler(handler);
        return handler;
    }

    @Override // p013io.netty.handler.ssl.SslContext
    public final SSLSessionContext sessionContext() {
        return this.ctx.sessionContext();
    }

    protected void initHandler(SslHandler handler) {
        initEngine(handler.engine());
    }
}
