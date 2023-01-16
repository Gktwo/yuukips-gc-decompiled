package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CacheInterceptor.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018�� \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m373d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "cache", "Lokhttp3/Cache;", "(Lokhttp3/Cache;)V", "getCache$okhttp", "()Lokhttp3/Cache;", "cacheWritingResponse", "Lokhttp3/Response;", "cacheRequest", "Lokhttp3/internal/cache/CacheRequest;", "response", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/cache/CacheInterceptor.class */
public final class CacheInterceptor implements Interceptor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Cache cache;

    public CacheInterceptor(@Nullable Cache cache) {
        this.cache = cache;
    }

    @Nullable
    public final Cache getCache$okhttp() {
        return this.cache;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:93:0x02b0
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
        */
    @Override // okhttp3.Interceptor
    @org.jetbrains.annotations.NotNull
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull okhttp3.Interceptor.Chain r8) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 706
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private final Response cacheWritingResponse(CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        Sink cacheBodyUnbuffered = cacheRequest.body();
        ResponseBody body = response.body();
        Intrinsics.checkNotNull(body);
        CacheInterceptor$cacheWritingResponse$cacheWritingSource$1 cacheWritingSource = new Source(body.source(), cacheRequest, Okio.buffer(cacheBodyUnbuffered)) { // from class: okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1
            private boolean cacheRequestClosed;
            final /* synthetic */ BufferedSource $source;
            final /* synthetic */ CacheRequest $cacheRequest;
            final /* synthetic */ BufferedSink $cacheBody;

            /* access modifiers changed from: package-private */
            {
                this.$source = $source;
                this.$cacheRequest = $cacheRequest;
                this.$cacheBody = $cacheBody;
            }

            @Override // okio.Source
            public long read(@NotNull Buffer sink, long byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                try {
                    long bytesRead = this.$source.read(sink, byteCount);
                    if (bytesRead != -1) {
                        sink.copyTo(this.$cacheBody.getBuffer(), sink.size() - bytesRead, bytesRead);
                        this.$cacheBody.emitCompleteSegments();
                        return bytesRead;
                    } else if (this.cacheRequestClosed) {
                        return -1;
                    } else {
                        this.cacheRequestClosed = true;
                        this.$cacheBody.close();
                        return -1;
                    }
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        this.$cacheRequest.abort();
                    }
                    throw e;
                }
            }

            @Override // okio.Source
            @NotNull
            public Timeout timeout() {
                return this.$source.timeout();
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    this.$cacheRequest.abort();
                }
                this.$source.close();
            }
        };
        return response.newBuilder().body(new RealResponseBody(Response.header$default(response, "Content-Type", null, 2, null), response.body().contentLength(), Okio.buffer(cacheWritingSource))).build();
    }

    /* compiled from: CacheInterceptor.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��*\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000f"}, m373d2 = {"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "()V", "combine", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isContentSpecificHeader", "", "fieldName", "", "isEndToEnd", "stripBody", "Lokhttp3/Response;", "response", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/cache/CacheInterceptor$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final Response stripBody(Response response) {
            if ((response == null ? null : response.body()) != null) {
                return response.newBuilder().body(null).build();
            }
            return response;
        }

        /* access modifiers changed from: private */
        public final Headers combine(Headers cachedHeaders, Headers networkHeaders) {
            Headers.Builder result = new Headers.Builder();
            int index = 0;
            int size = cachedHeaders.size();
            while (index < size) {
                index++;
                String fieldName = cachedHeaders.name(index);
                String value = cachedHeaders.value(index);
                if (!StringsKt.equals("Warning", fieldName, true) || !StringsKt.startsWith$default(value, "1", false, 2, (Object) null)) {
                    if (isContentSpecificHeader(fieldName) || !isEndToEnd(fieldName) || networkHeaders.get(fieldName) == null) {
                        result.addLenient$okhttp(fieldName, value);
                    }
                }
            }
            int index2 = 0;
            int size2 = networkHeaders.size();
            while (index2 < size2) {
                index2++;
                String fieldName2 = networkHeaders.name(index2);
                if (!isContentSpecificHeader(fieldName2) && isEndToEnd(fieldName2)) {
                    result.addLenient$okhttp(fieldName2, networkHeaders.value(index2));
                }
            }
            return result.build();
        }

        private final boolean isEndToEnd(String fieldName) {
            return !StringsKt.equals("Connection", fieldName, true) && !StringsKt.equals("Keep-Alive", fieldName, true) && !StringsKt.equals("Proxy-Authenticate", fieldName, true) && !StringsKt.equals("Proxy-Authorization", fieldName, true) && !StringsKt.equals("TE", fieldName, true) && !StringsKt.equals("Trailers", fieldName, true) && !StringsKt.equals("Transfer-Encoding", fieldName, true) && !StringsKt.equals("Upgrade", fieldName, true);
        }

        private final boolean isContentSpecificHeader(String fieldName) {
            return StringsKt.equals("Content-Length", fieldName, true) || StringsKt.equals("Content-Encoding", fieldName, true) || StringsKt.equals("Content-Type", fieldName, true);
        }
    }
}
