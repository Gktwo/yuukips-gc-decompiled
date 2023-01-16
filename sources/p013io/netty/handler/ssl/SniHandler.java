package p013io.netty.handler.ssl;

import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.DecoderException;
import p013io.netty.util.AsyncMapping;
import p013io.netty.util.DomainNameMapping;
import p013io.netty.util.Mapping;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.Promise;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.handler.ssl.SniHandler */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SniHandler.class */
public class SniHandler extends AbstractSniHandler<SslContext> {
    private static final Selection EMPTY_SELECTION = new Selection(null, null);
    protected final AsyncMapping<String, SslContext> mapping;
    private volatile Selection selection;

    public SniHandler(Mapping<? super String, ? extends SslContext> mapping) {
        this(new AsyncMappingAdapter(mapping));
    }

    public SniHandler(DomainNameMapping<? extends SslContext> mapping) {
        this((Mapping<? super String, ? extends SslContext>) mapping);
    }

    public SniHandler(AsyncMapping<? super String, ? extends SslContext> mapping) {
        this.selection = EMPTY_SELECTION;
        this.mapping = (AsyncMapping) ObjectUtil.checkNotNull(mapping, "mapping");
    }

    public String hostname() {
        return this.selection.hostname;
    }

    public SslContext sslContext() {
        return this.selection.context;
    }

    @Override // p013io.netty.handler.ssl.AbstractSniHandler
    protected Future<SslContext> lookup(ChannelHandlerContext ctx, String hostname) throws Exception {
        return this.mapping.map(hostname, ctx.executor().newPromise());
    }

    @Override // p013io.netty.handler.ssl.AbstractSniHandler
    protected final void onLookupComplete(ChannelHandlerContext ctx, String hostname, Future<SslContext> future) throws Exception {
        if (!future.isSuccess()) {
            Throwable cause = future.cause();
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new DecoderException("failed to get the SslContext for " + hostname, cause);
        }
        SslContext sslContext = future.getNow();
        this.selection = new Selection(sslContext, hostname);
        try {
            replaceHandler(ctx, hostname, sslContext);
        } catch (Throwable cause2) {
            this.selection = EMPTY_SELECTION;
            PlatformDependent.throwException(cause2);
        }
    }

    protected void replaceHandler(ChannelHandlerContext ctx, String hostname, SslContext sslContext) throws Exception {
        SslHandler sslHandler = null;
        try {
            ctx.pipeline().replace(this, SslHandler.class.getName(), newSslHandler(sslContext, ctx.alloc()));
            sslHandler = null;
            if (0 != 0) {
                ReferenceCountUtil.safeRelease(sslHandler.engine());
            }
        } catch (Throwable th) {
            if (sslHandler != null) {
                ReferenceCountUtil.safeRelease(sslHandler.engine());
            }
            throw th;
        }
    }

    protected SslHandler newSslHandler(SslContext context, ByteBufAllocator allocator) {
        return context.newHandler(allocator);
    }

    /* renamed from: io.netty.handler.ssl.SniHandler$AsyncMappingAdapter */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/SniHandler$AsyncMappingAdapter.class */
    private static final class AsyncMappingAdapter implements AsyncMapping<String, SslContext> {
        private final Mapping<? super String, ? extends SslContext> mapping;

        private AsyncMappingAdapter(Mapping<? super String, ? extends SslContext> mapping) {
            this.mapping = (Mapping) ObjectUtil.checkNotNull(mapping, "mapping");
        }

        public Future<SslContext> map(String input, Promise<SslContext> promise) {
            try {
                return promise.setSuccess((SslContext) this.mapping.map(input));
            } catch (Throwable cause) {
                return promise.setFailure(cause);
            }
        }
    }

    /* renamed from: io.netty.handler.ssl.SniHandler$Selection */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/SniHandler$Selection.class */
    private static final class Selection {
        final SslContext context;
        final String hostname;

        Selection(SslContext context, String hostname) {
            this.context = context;
            this.hostname = hostname;
        }
    }
}
