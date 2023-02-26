package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.p020io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.eclipse.jetty.util.URIUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.reader.LineReader;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: Cache.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n��\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018�� C2\u00020\u00012\u00020\u0002:\u0004BCDEB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b��\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0018\u00010\"R\u00020\fH\u0002J\b\u0010#\u001a\u00020 H\u0016J\u0006\u0010$\u001a\u00020 J\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b%J\u0006\u0010&\u001a\u00020 J\b\u0010'\u001a\u00020 H\u0016J\u0017\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H��¢\u0006\u0002\b,J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010-\u001a\u00020 J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0011J\u0017\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020)H��¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020 2\u0006\u0010*\u001a\u00020+H��¢\u0006\u0002\b3J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u00104\u001a\u00020\u0006J\r\u00105\u001a\u00020 H��¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020 2\u0006\u00108\u001a\u000209H��¢\u0006\u0002\b:J\u001d\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020)H��¢\u0006\u0002\b>J\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n��R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0011X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u0002\n��R\u001a\u0010\u0017\u001a\u00020\u0011X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006F"}, m373d2 = {"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "directory", "Ljava/io/File;", "maxSize", "", "(Ljava/io/File;J)V", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "(Ljava/io/File;JLokhttp3/internal/io/FileSystem;)V", "cache", "Lokhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "()Ljava/io/File;", "hitCount", "", "isClosed", "", "()Z", "networkCount", "requestCount", "writeAbortCount", "getWriteAbortCount$okhttp", "()I", "setWriteAbortCount$okhttp", "(I)V", "writeSuccessCount", "getWriteSuccessCount$okhttp", "setWriteSuccessCount$okhttp", "abortQuietly", "", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "close", "delete", "-deprecated_directory", "evictAll", "flush", BeanUtil.PREFIX_GETTER_GET, "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "get$okhttp", "initialize", "put", "Lokhttp3/internal/cache/CacheRequest;", "response", "put$okhttp", "remove", "remove$okhttp", "size", "trackConditionalCacheHit", "trackConditionalCacheHit$okhttp", "trackResponse", "cacheStrategy", "Lokhttp3/internal/cache/CacheStrategy;", "trackResponse$okhttp", "update", "cached", "network", "update$okhttp", "urls", "", "", "CacheResponseBody", "Companion", "Entry", "RealCacheRequest", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/Cache.class */
public final class Cache implements Closeable, Flushable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final DiskLruCache cache;
    private int writeSuccessCount;
    private int writeAbortCount;
    private int networkCount;
    private int hitCount;
    private int requestCount;
    private static final int VERSION = 201105;
    private static final int ENTRY_METADATA = 0;
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;

    @JvmStatic
    @NotNull
    public static final String key(@NotNull HttpUrl url) {
        return Companion.key(url);
    }

    public Cache(@NotNull File directory, long maxSize, @NotNull FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        this.cache = new DiskLruCache(fileSystem, directory, VERSION, 2, maxSize, TaskRunner.INSTANCE);
    }

    @NotNull
    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final void setWriteSuccessCount$okhttp(int i) {
        this.writeSuccessCount = i;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final void setWriteAbortCount$okhttp(int i) {
        this.writeAbortCount = i;
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(@NotNull File directory, long maxSize) {
        this(directory, maxSize, FileSystem.SYSTEM);
        Intrinsics.checkNotNullParameter(directory, "directory");
    }

    @Nullable
    public final Response get$okhttp(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                Util.closeQuietly(body);
                return null;
            } catch (IOException e) {
                Util.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:4:0x001e
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
        */
    @org.jetbrains.annotations.Nullable
    public final okhttp3.internal.cache.CacheRequest put$okhttp(@org.jetbrains.annotations.NotNull okhttp3.Response r8) {
        /*
            r7 = this;
            r0 = r8
            java.lang.String r1 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r8
            okhttp3.Request r0 = r0.request()
            java.lang.String r0 = r0.method()
            r9 = r0
            okhttp3.internal.http.HttpMethod r0 = okhttp3.internal.http.HttpMethod.INSTANCE
            r1 = r8
            okhttp3.Request r1 = r1.request()
            java.lang.String r1 = r1.method()
            boolean r0 = r0.invalidatesCache(r1)
            if (r0 == 0) goto L_0x002d
            r0 = r7
            r1 = r8
            okhttp3.Request r1 = r1.request()     // Catch: IOException -> 0x002a
            r0.remove$okhttp(r1)     // Catch: IOException -> 0x002a
            goto L_0x002b
        L_0x002a:
            r10 = move-exception
        L_0x002b:
            r0 = 0
            return r0
        L_0x002d:
            r0 = r9
            java.lang.String r1 = "GET"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 != 0) goto L_0x0038
            r0 = 0
            return r0
        L_0x0038:
            okhttp3.Cache$Companion r0 = okhttp3.Cache.Companion
            r1 = r8
            boolean r0 = r0.hasVaryAll(r1)
            if (r0 == 0) goto L_0x0044
            r0 = 0
            return r0
        L_0x0044:
            okhttp3.Cache$Entry r0 = new okhttp3.Cache$Entry
            r1 = r0
            r2 = r8
            r1.<init>(r2)
            r10 = r0
            r0 = 0
            r11 = r0
            r0 = r7
            okhttp3.internal.cache.DiskLruCache r0 = r0.cache     // Catch: IOException -> 0x0085
            okhttp3.Cache$Companion r1 = okhttp3.Cache.Companion     // Catch: IOException -> 0x0085
            r2 = r8
            okhttp3.Request r2 = r2.request()     // Catch: IOException -> 0x0085
            okhttp3.HttpUrl r2 = r2.url()     // Catch: IOException -> 0x0085
            java.lang.String r1 = r1.key(r2)     // Catch: IOException -> 0x0085
            r2 = 0
            r3 = 2
            r4 = 0
            okhttp3.internal.cache.DiskLruCache$Editor r0 = okhttp3.internal.cache.DiskLruCache.edit$default(r0, r1, r2, r3, r4)     // Catch: IOException -> 0x0085
            r1 = r0
            if (r1 != 0) goto L_0x006f
            r0 = 0
            return r0
        L_0x006f:
            r11 = r0
            r0 = r10
            r1 = r11
            r0.writeTo(r1)     // Catch: IOException -> 0x0085
            okhttp3.Cache$RealCacheRequest r0 = new okhttp3.Cache$RealCacheRequest     // Catch: IOException -> 0x0085
            r1 = r0
            r2 = r7
            r3 = r11
            r1.<init>(r2, r3)     // Catch: IOException -> 0x0085
            okhttp3.internal.cache.CacheRequest r0 = (okhttp3.internal.cache.CacheRequest) r0     // Catch: IOException -> 0x0085
            return r0
        L_0x0085:
            r12 = move-exception
            r0 = r7
            r1 = r11
            r0.abortQuietly(r1)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.put$okhttp(okhttp3.Response):okhttp3.internal.cache.CacheRequest");
    }

    public final void remove$okhttp(@NotNull Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final void update$okhttp(@NotNull Response cached, @NotNull Response network) {
        Intrinsics.checkNotNullParameter(cached, "cached");
        Intrinsics.checkNotNullParameter(network, "network");
        Entry entry = new Entry(network);
        ResponseBody body = cached.body();
        if (body == null) {
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        }
        DiskLruCache.Editor editor = null;
        try {
            DiskLruCache.Editor edit = ((CacheResponseBody) body).getSnapshot().edit();
            if (edit != null) {
                editor = edit;
                entry.writeTo(editor);
                editor.commit();
            }
        } catch (IOException e) {
            abortQuietly(editor);
        }
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException e) {
            }
        }
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @NotNull
    public final Iterator<String> urls() throws IOException {
        return new Object(this) { // from class: okhttp3.Cache$urls$1
            @NotNull
            private final Iterator<DiskLruCache.Snapshot> delegate;
            @Nullable
            private String nextUrl;
            private boolean canRemove;
            final /* synthetic */ Cache this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
                this.delegate = this.this$0.getCache$okhttp().snapshots();
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:9:0x001a
                	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
                	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
                */
            @Override // java.util.Iterator
            public boolean hasNext() {
                /*
                    r3 = this;
                    r0 = r3
                    java.lang.String r0 = r0.nextUrl
                    if (r0 == 0) goto L_0x0009
                    r0 = 1
                    return r0
                L_0x0009:
                    r0 = r3
                    r1 = 0
                    r0.canRemove = r1
                L_0x000e:
                    r0 = r3
                    java.util.Iterator<okhttp3.internal.cache.DiskLruCache$Snapshot> r0 = r0.delegate
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L_0x0064
                    r0 = r3
                    java.util.Iterator<okhttp3.internal.cache.DiskLruCache$Snapshot> r0 = r0.delegate     // Catch: IOException -> 0x0060
                    java.lang.Object r0 = r0.next()     // Catch: IOException -> 0x0060
                    java.io.Closeable r0 = (java.io.Closeable) r0     // Catch: IOException -> 0x0060
                    r4 = r0
                    r0 = 0
                    r5 = r0
                    r0 = r4
                    okhttp3.internal.cache.DiskLruCache$Snapshot r0 = (okhttp3.internal.cache.DiskLruCache.Snapshot) r0     // Catch: IOException -> 0x0060, Throwable -> 0x0053, all -> 0x0058
                    r6 = r0
                    r0 = 0
                    r7 = r0
                    r0 = r6
                    r1 = 0
                    okio.Source r0 = r0.getSource(r1)     // Catch: IOException -> 0x0060, Throwable -> 0x0053, all -> 0x0058
                    okio.BufferedSource r0 = okio.Okio.buffer(r0)     // Catch: IOException -> 0x0060, Throwable -> 0x0053, all -> 0x0058
                    r8 = r0
                    r0 = r3
                    r1 = r8
                    java.lang.String r1 = r1.readUtf8LineStrict()     // Catch: IOException -> 0x0060, Throwable -> 0x0053, all -> 0x0058
                    r0.nextUrl = r1     // Catch: IOException -> 0x0060, Throwable -> 0x0053, all -> 0x0058
                    r0 = 1
                    r9 = r0
                    r0 = r4
                    r1 = r5
                    kotlin.p016io.Closeable.closeFinally(r0, r1)     // Catch: IOException -> 0x0060
                    r0 = r9
                    return r0
                L_0x0053:
                    r6 = move-exception
                    r0 = r6
                    r5 = r0
                    r0 = r6
                    throw r0     // Catch: IOException -> 0x0060, all -> 0x0058
                L_0x0058:
                    r6 = move-exception
                    r0 = r4
                    r1 = r5
                    kotlin.p016io.Closeable.closeFinally(r0, r1)     // Catch: IOException -> 0x0060
                    r0 = r6
                    throw r0     // Catch: IOException -> 0x0060
                L_0x0060:
                    r4 = move-exception
                    goto L_0x000e
                L_0x0064:
                    r0 = 0
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache$urls$1.hasNext():boolean");
            }

            @Override // java.util.Iterator
            @NotNull
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String result = this.nextUrl;
                Intrinsics.checkNotNull(result);
                this.nextUrl = null;
                this.canRemove = true;
                return result;
            }

            @Override // java.util.Iterator
            public void remove() {
                if (!this.canRemove) {
                    throw new IllegalStateException("remove() before next()".toString());
                }
                this.delegate.remove();
            }
        };
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    @JvmName(name = "directory")
    @NotNull
    public final File directory() {
        return this.cache.getDirectory();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "directory", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_directory")
    @NotNull
    /* renamed from: -deprecated_directory  reason: not valid java name */
    public final File m9148deprecated_directory() {
        return this.cache.getDirectory();
    }

    public final synchronized void trackResponse$okhttp(@NotNull CacheStrategy cacheStrategy) {
        Intrinsics.checkNotNullParameter(cacheStrategy, "cacheStrategy");
        this.requestCount++;
        if (cacheStrategy.getNetworkRequest() != null) {
            this.networkCount++;
        } else if (cacheStrategy.getCacheResponse() != null) {
            this.hitCount++;
        }
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    /* compiled from: Cache.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n��\b\u0004\u0018��2\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\u0002\n��¨\u0006\u0011"}, m373d2 = {"Lokhttp3/Cache$RealCacheRequest;", "Lokhttp3/internal/cache/CacheRequest;", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "body", "Lokio/Sink;", "cacheOut", "done", "", "getDone", "()Z", "setDone", "(Z)V", LineReader.SEND_BREAK, "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/Cache$RealCacheRequest.class */
    private final class RealCacheRequest implements CacheRequest {
        @NotNull
        private final DiskLruCache.Editor editor;
        @NotNull
        private final Sink cacheOut;
        @NotNull
        private final Sink body;
        private boolean done;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(@NotNull Cache this$0, DiskLruCache.Editor editor) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(editor, "editor");
            this.this$0 = this$0;
            this.editor = editor;
            this.cacheOut = this.editor.newSink(1);
            Sink sink = this.cacheOut;
            final Cache cache = this.this$0;
            this.body = new ForwardingSink(sink) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    Cache cache2 = cache;
                    RealCacheRequest realCacheRequest = this;
                    Cache cache3 = cache;
                    synchronized (cache2) {
                        if (!realCacheRequest.getDone()) {
                            realCacheRequest.setDone(true);
                            cache3.setWriteSuccessCount$okhttp(cache3.getWriteSuccessCount$okhttp() + 1);
                            close();
                            this.editor.commit();
                        }
                    }
                }
            };
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z) {
            this.done = z;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache cache = this.this$0;
            Cache cache2 = this.this$0;
            synchronized (cache) {
                if (!getDone()) {
                    setDone(true);
                    cache2.setWriteAbortCount$okhttp(cache2.getWriteAbortCount$okhttp() + 1);
                    Util.closeQuietly(this.cacheOut);
                    try {
                        this.editor.abort();
                    } catch (IOException e) {
                    }
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        @NotNull
        public Sink body() {
            return this.body;
        }
    }

    /* compiled from: Cache.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0001\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018�� /2\u00020\u0001:\u0001/B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\n\u0010$\u001a\u00060%R\u00020&J\u001e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0012\u0010,\u001a\u00020(2\n\u0010-\u001a\u00060.R\u00020&R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n��R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n��R\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0015\u001a\u00020\u0010X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0018\u001a\u00020\u0014X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n��R\u000e\u0010\u001b\u001a\u00020\u0017X\u0004¢\u0006\u0002\n��¨\u00060"}, m373d2 = {"Lokhttp3/Cache$Entry;", "", "rawSource", "Lokio/Source;", "(Lokio/Source;)V", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "code", "", "handshake", "Lokhttp3/Handshake;", "isHttps", "", "()Z", SendMailJob.PROP_MESSAGE, "", "protocol", "Lokhttp3/Protocol;", "receivedResponseMillis", "", "requestMethod", "responseHeaders", "Lokhttp3/Headers;", "sentRequestMillis", "url", "Lokhttp3/HttpUrl;", "varyHeaders", "matches", "request", "Lokhttp3/Request;", "readCertificateList", "", "Ljava/security/cert/Certificate;", "source", "Lokio/BufferedSource;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "writeCertList", "", "sink", "Lokio/BufferedSink;", "certificates", "writeTo", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Companion", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/Cache$Entry.class */
    private static final class Entry {
        @NotNull
        private final HttpUrl url;
        @NotNull
        private final Headers varyHeaders;
        @NotNull
        private final String requestMethod;
        @NotNull
        private final Protocol protocol;
        private final int code;
        @NotNull
        private final String message;
        @NotNull
        private final Headers responseHeaders;
        @Nullable
        private final Handshake handshake;
        private final long sentRequestMillis;
        private final long receivedResponseMillis;
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private static final String SENT_MILLIS = Intrinsics.stringPlus(Platform.Companion.get().getPrefix(), "-Sent-Millis");
        @NotNull
        private static final String RECEIVED_MILLIS = Intrinsics.stringPlus(Platform.Companion.get().getPrefix(), "-Received-Millis");

        private final boolean isHttps() {
            return Intrinsics.areEqual(this.url.scheme(), URIUtil.HTTPS);
        }

        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v33 */
        /* JADX WARN: Type inference failed for: r1v47, types: [long] */
        /* JADX WARN: Type inference failed for: r1v48 */
        /* JADX WARN: Type inference failed for: r1v49 */
        /* JADX WARN: Type inference failed for: r1v51, types: [long] */
        /* JADX WARN: Type inference failed for: r1v52 */
        /* JADX WARN: Type inference failed for: r1v53 */
        public Entry(@NotNull Source rawSource) throws IOException {
            TlsVersion tlsVersion;
            Intrinsics.checkNotNullParameter(rawSource, "rawSource");
            Source source = rawSource;
            try {
                Source source2 = source;
                BufferedSource source3 = Okio.buffer(rawSource);
                String urlLine = source3.readUtf8LineStrict();
                HttpUrl parse = HttpUrl.Companion.parse(urlLine);
                if (parse == null) {
                    IOException it = new IOException(Intrinsics.stringPlus("Cache corruption for ", urlLine));
                    Platform.Companion.get().log("cache corruption", 5, it);
                    throw it;
                }
                this.url = parse;
                this.requestMethod = source3.readUtf8LineStrict();
                Headers.Builder varyHeadersBuilder = new Headers.Builder();
                int varyRequestHeaderLineCount = Cache.Companion.readInt$okhttp(source3);
                int i = 0;
                while (i < varyRequestHeaderLineCount) {
                    i++;
                    varyHeadersBuilder.addLenient$okhttp(source3.readUtf8LineStrict());
                }
                this.varyHeaders = varyHeadersBuilder.build();
                StatusLine statusLine = StatusLine.Companion.parse(source3.readUtf8LineStrict());
                this.protocol = statusLine.protocol;
                this.code = statusLine.code;
                this.message = statusLine.message;
                Headers.Builder responseHeadersBuilder = new Headers.Builder();
                int responseHeaderLineCount = Cache.Companion.readInt$okhttp(source3);
                int i2 = 0;
                while (i2 < responseHeaderLineCount) {
                    i2++;
                    responseHeadersBuilder.addLenient$okhttp(source3.readUtf8LineStrict());
                }
                String sendRequestMillisString = responseHeadersBuilder.get(SENT_MILLIS);
                String receivedResponseMillisString = responseHeadersBuilder.get(RECEIVED_MILLIS);
                responseHeadersBuilder.removeAll(SENT_MILLIS);
                responseHeadersBuilder.removeAll(RECEIVED_MILLIS);
                this.sentRequestMillis = (sendRequestMillisString == null ? 0 : Long.parseLong(sendRequestMillisString)) == true ? 1 : 0;
                this.receivedResponseMillis = (receivedResponseMillisString == null ? 0 : Long.parseLong(receivedResponseMillisString)) == true ? 1 : 0;
                this.responseHeaders = responseHeadersBuilder.build();
                if (isHttps()) {
                    String blank = source3.readUtf8LineStrict();
                    if (blank.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + blank + '\"');
                    }
                    CipherSuite cipherSuite = CipherSuite.Companion.forJavaName(source3.readUtf8LineStrict());
                    List peerCertificates = readCertificateList(source3);
                    List localCertificates = readCertificateList(source3);
                    if (!source3.exhausted()) {
                        tlsVersion = TlsVersion.Companion.forJavaName(source3.readUtf8LineStrict());
                    } else {
                        tlsVersion = TlsVersion.SSL_3_0;
                    }
                    this.handshake = Handshake.Companion.get(tlsVersion, cipherSuite, peerCertificates, localCertificates);
                } else {
                    this.handshake = null;
                }
                Unit unit = Unit.INSTANCE;
                kotlin.p016io.Closeable.closeFinally(source, null);
            } catch (Throwable th) {
                kotlin.p016io.Closeable.closeFinally(source, null);
                throw th;
            }
        }

        public Entry(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.url = response.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }

        public final void writeTo(@NotNull DiskLruCache.Editor editor) throws IOException {
            Intrinsics.checkNotNullParameter(editor, "editor");
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            try {
                BufferedSink sink = buffer;
                sink.writeUtf8(this.url.toString()).writeByte(10);
                sink.writeUtf8(this.requestMethod).writeByte(10);
                sink.writeDecimalLong((long) this.varyHeaders.size()).writeByte(10);
                int i = 0;
                int size = this.varyHeaders.size();
                while (i < size) {
                    i++;
                    sink.writeUtf8(this.varyHeaders.name(i)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(i)).writeByte(10);
                }
                sink.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
                sink.writeDecimalLong((long) (this.responseHeaders.size() + 2)).writeByte(10);
                int i2 = 0;
                int size2 = this.responseHeaders.size();
                while (i2 < size2) {
                    i2++;
                    sink.writeUtf8(this.responseHeaders.name(i2)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i2)).writeByte(10);
                }
                sink.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
                sink.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
                if (isHttps()) {
                    sink.writeByte(10);
                    Handshake handshake = this.handshake;
                    Intrinsics.checkNotNull(handshake);
                    sink.writeUtf8(handshake.cipherSuite().javaName()).writeByte(10);
                    writeCertList(sink, this.handshake.peerCertificates());
                    writeCertList(sink, this.handshake.localCertificates());
                    sink.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
                }
                Unit unit = Unit.INSTANCE;
                kotlin.p016io.Closeable.closeFinally(buffer, null);
            } catch (Throwable th) {
                kotlin.p016io.Closeable.closeFinally(buffer, null);
                throw th;
            }
        }

        private final List<Certificate> readCertificateList(BufferedSource source) throws IOException {
            int length = Cache.Companion.readInt$okhttp(source);
            if (length == -1) {
                return CollectionsKt.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList result = new ArrayList(length);
                int i = 0;
                while (i < length) {
                    i++;
                    String line = source.readUtf8LineStrict();
                    Buffer bytes = new Buffer();
                    ByteString decodeBase64 = ByteString.Companion.decodeBase64(line);
                    Intrinsics.checkNotNull(decodeBase64);
                    bytes.write(decodeBase64);
                    result.add(certificateFactory.generateCertificate(bytes.inputStream()));
                }
                return result;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private final void writeCertList(BufferedSink sink, List<? extends Certificate> list) throws IOException {
            try {
                sink.writeDecimalLong((long) list.size()).writeByte(10);
                for (Certificate element : list) {
                    byte[] bytes = element.getEncoded();
                    ByteString.Companion companion = ByteString.Companion;
                    Intrinsics.checkNotNullExpressionValue(bytes, "bytes");
                    sink.writeUtf8(ByteString.Companion.of$default(companion, bytes, 0, 0, 3, null).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean matches(@NotNull Request request, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            return Intrinsics.areEqual(this.url, request.url()) && Intrinsics.areEqual(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        @NotNull
        public final Response response(@NotNull DiskLruCache.Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            String contentType = this.responseHeaders.get("Content-Type");
            String contentLength = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, contentType, contentLength)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        /* compiled from: Cache.kt */
        @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��¨\u0006\u0006"}, m373d2 = {"Lokhttp3/Cache$Entry$Companion;", "", "()V", "RECEIVED_MILLIS", "", "SENT_MILLIS", "okhttp"})
        /* loaded from: grasscutter.jar:okhttp3/Cache$Entry$Companion.class */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: Cache.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��0\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018��2\u00020\u0001B%\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0007\u001a\u00020\rH\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n��R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n��R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, m373d2 = {"Lokhttp3/Cache$CacheResponseBody;", "Lokhttp3/ResponseBody;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "contentType", "", "contentLength", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V", "bodySource", "Lokio/BufferedSource;", "getSnapshot", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "", "Lokhttp3/MediaType;", "source", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/Cache$CacheResponseBody.class */
    public static final class CacheResponseBody extends ResponseBody {
        @NotNull
        private final DiskLruCache.Snapshot snapshot;
        @Nullable
        private final String contentType;
        @Nullable
        private final String contentLength;
        @NotNull
        private final BufferedSource bodySource;

        @NotNull
        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        public CacheResponseBody(@NotNull DiskLruCache.Snapshot snapshot, @Nullable String contentType, @Nullable String contentLength) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = contentType;
            this.contentLength = contentLength;
            this.bodySource = Okio.buffer(new ForwardingSource(this.snapshot.getSource(1), this) { // from class: okhttp3.Cache.CacheResponseBody.1
                final /* synthetic */ Source $source;
                final /* synthetic */ CacheResponseBody this$0;

                {
                    this.$source = $source;
                    this.this$0 = $receiver;
                }

                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    this.this$0.getSnapshot().close();
                    close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        @Nullable
        public MediaType contentType() {
            String str = this.contentType;
            if (str == null) {
                return null;
            }
            return MediaType.Companion.parse(str);
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String str = this.contentLength;
            if (str == null) {
                return -1;
            }
            return Util.toLongOrDefault(str, -1);
        }

        @Override // okhttp3.ResponseBody
        @NotNull
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    /* compiled from: Cache.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��N\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH��¢\u0006\u0002\b\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\n\u0010\u001b\u001a\u00020\u0015*\u00020\u0017J\u0012\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u001d*\u00020\u0011H\u0002J\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\u001e"}, m373d2 = {"Lokhttp3/Cache$Companion;", "", "()V", "ENTRY_BODY", "", "ENTRY_COUNT", "ENTRY_METADATA", "VERSION", Action.KEY_ATTRIBUTE, "", "url", "Lokhttp3/HttpUrl;", "readInt", "source", "Lokio/BufferedSource;", "readInt$okhttp", "varyHeaders", "Lokhttp3/Headers;", "requestHeaders", "responseHeaders", "varyMatches", "", "cachedResponse", "Lokhttp3/Response;", "cachedRequest", "newRequest", "Lokhttp3/Request;", "hasVaryAll", "varyFields", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/Cache$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final String key(@NotNull HttpUrl url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return ByteString.Companion.encodeUtf8(url.toString()).md5().hex();
        }

        public final int readInt$okhttp(@NotNull BufferedSource source) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            try {
                long result = source.readDecimalLong();
                String line = source.readUtf8LineStrict();
                if (result >= 0 && result <= 2147483647L) {
                    if (!(line.length() > 0)) {
                        return (int) result;
                    }
                }
                throw new IOException("expected an int but was \"" + result + line + '\"');
            } catch (NumberFormatException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean varyMatches(@NotNull Response cachedResponse, @NotNull Headers cachedRequest, @NotNull Request newRequest) {
            boolean z;
            Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
            Intrinsics.checkNotNullParameter(cachedRequest, "cachedRequest");
            Intrinsics.checkNotNullParameter(newRequest, "newRequest");
            Iterable<String> $this$none$iv = varyFields(cachedResponse.headers());
            if (($this$none$iv instanceof Collection) && ((Collection) $this$none$iv).isEmpty()) {
                return true;
            }
            for (String it : $this$none$iv) {
                if (!Intrinsics.areEqual(cachedRequest.values(it), newRequest.headers(it))) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return false;
                }
            }
            return true;
        }

        public final boolean hasVaryAll(@NotNull Response $this$hasVaryAll) {
            Intrinsics.checkNotNullParameter($this$hasVaryAll, "<this>");
            return varyFields($this$hasVaryAll.headers()).contains("*");
        }

        private final Set<String> varyFields(Headers $this$varyFields) {
            Set result = null;
            int i = 0;
            int size = $this$varyFields.size();
            while (i < size) {
                i++;
                if (StringsKt.equals("Vary", $this$varyFields.name(i), true)) {
                    String value = $this$varyFields.value(i);
                    if (result == null) {
                        result = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
                    }
                    for (String varyField : StringsKt.split$default((CharSequence) value, new char[]{','}, false, 0, 6, (Object) null)) {
                        result.add(StringsKt.trim((CharSequence) varyField).toString());
                    }
                }
            }
            return result == null ? SetsKt.emptySet() : result;
        }

        @NotNull
        public final Headers varyHeaders(@NotNull Response $this$varyHeaders) {
            Intrinsics.checkNotNullParameter($this$varyHeaders, "<this>");
            Response networkResponse = $this$varyHeaders.networkResponse();
            Intrinsics.checkNotNull(networkResponse);
            return varyHeaders(networkResponse.request().headers(), $this$varyHeaders.headers());
        }

        private final Headers varyHeaders(Headers requestHeaders, Headers responseHeaders) {
            Set varyFields = varyFields(responseHeaders);
            if (varyFields.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder result = new Headers.Builder();
            int i = 0;
            int size = requestHeaders.size();
            while (i < size) {
                i++;
                String fieldName = requestHeaders.name(i);
                if (varyFields.contains(fieldName)) {
                    result.add(fieldName, requestHeaders.value(i));
                }
            }
            return result.build();
        }
    }
}
