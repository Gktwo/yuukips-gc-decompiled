package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.bytebuddy.implementation.MethodDelegation;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ResponseBody.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018�� !2\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J@\u0010\u0010\u001a\u0002H\u0011\"\b\b��\u0010\u0011*\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u00110\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00170\u0014H\b¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\b\u0010\u001d\u001a\u00020\u0015H&J\u0006\u0010\u001e\u001a\u00020\u001fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n��¨\u0006\""}, m373d2 = {"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", "()V", "reader", "Ljava/io/Reader;", "byteStream", "Ljava/io/InputStream;", "byteString", "Lokio/ByteString;", "bytes", "", "charStream", "charset", "Ljava/nio/charset/Charset;", "close", "", "consumeSource", "T", "", "consumer", "Lkotlin/Function1;", "Lokio/BufferedSource;", "sizeMapper", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "string", "", "BomAwareReader", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/ResponseBody.class */
public abstract class ResponseBody implements Closeable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private Reader reader;

    @Nullable
    public abstract MediaType contentType();

    public abstract long contentLength();

    @NotNull
    public abstract BufferedSource source();

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final ResponseBody create(@NotNull String $this$create, @Nullable MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final ResponseBody create(@NotNull byte[] $this$create, @Nullable MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final ResponseBody create(@NotNull ByteString $this$create, @Nullable MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final ResponseBody create(@NotNull BufferedSource $this$create, @Nullable MediaType contentType, long contentLength) {
        return Companion.create($this$create, contentType, contentLength);
    }

    @JvmStatic
    @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}), level = DeprecationLevel.WARNING)
    @NotNull
    public static final ResponseBody create(@Nullable MediaType contentType, @NotNull String content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}), level = DeprecationLevel.WARNING)
    @NotNull
    public static final ResponseBody create(@Nullable MediaType contentType, @NotNull byte[] content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}), level = DeprecationLevel.WARNING)
    @NotNull
    public static final ResponseBody create(@Nullable MediaType contentType, @NotNull ByteString content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}), level = DeprecationLevel.WARNING)
    @NotNull
    public static final ResponseBody create(@Nullable MediaType contentType, long contentLength, @NotNull BufferedSource content) {
        return Companion.create(contentType, contentLength, content);
    }

    @NotNull
    public final InputStream byteStream() {
        return source().inputStream();
    }

    @NotNull
    public final byte[] bytes() throws IOException {
        long contentLength$iv = contentLength();
        if (contentLength$iv > 2147483647L) {
            throw new IOException(Intrinsics.stringPlus("Cannot buffer entire body for content length: ", Long.valueOf(contentLength$iv)));
        }
        BufferedSource p0 = source();
        try {
            byte[] readByteArray = p0.readByteArray();
            kotlin.p016io.Closeable.closeFinally(p0, null);
            int size$iv = readByteArray.length;
            if (contentLength$iv == -1 || contentLength$iv == ((long) size$iv)) {
                return readByteArray;
            }
            throw new IOException("Content-Length (" + contentLength$iv + ") and stream length (" + size$iv + ") disagree");
        } catch (Throwable th) {
            kotlin.p016io.Closeable.closeFinally(p0, null);
            throw th;
        }
    }

    @NotNull
    public final ByteString byteString() throws IOException {
        long contentLength$iv = contentLength();
        if (contentLength$iv > 2147483647L) {
            throw new IOException(Intrinsics.stringPlus("Cannot buffer entire body for content length: ", Long.valueOf(contentLength$iv)));
        }
        BufferedSource p0 = source();
        try {
            ByteString readByteString = p0.readByteString();
            kotlin.p016io.Closeable.closeFinally(p0, null);
            int size$iv = readByteString.size();
            if (contentLength$iv == -1 || contentLength$iv == ((long) size$iv)) {
                return readByteString;
            }
            throw new IOException("Content-Length (" + contentLength$iv + ") and stream length (" + size$iv + ") disagree");
        } catch (Throwable th) {
            kotlin.p016io.Closeable.closeFinally(p0, null);
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> T consumeSource(kotlin.jvm.functions.Function1<? super okio.BufferedSource, ? extends T> r7, kotlin.jvm.functions.Function1<? super T, java.lang.Integer> r8) {
        /*
            r6 = this;
            r0 = 0
            r9 = r0
            r0 = r6
            long r0 = r0.contentLength()
            r10 = r0
            r0 = r10
            r1 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0023
            java.io.IOException r0 = new java.io.IOException
            r1 = r0
            java.lang.String r2 = "Cannot buffer entire body for content length: "
            r3 = r10
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            r1.<init>(r2)
            throw r0
        L_0x0023:
            r0 = r6
            okio.BufferedSource r0 = r0.source()
            java.io.Closeable r0 = (java.io.Closeable) r0
            r13 = r0
            r0 = 0
            r14 = r0
            r0 = r7
            r1 = r13
            java.lang.Object r0 = r0.invoke(r1)     // Catch: Throwable -> 0x004e, all -> 0x0057
            r15 = r0
            r0 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r0 = r13
            r1 = r14
            kotlin.p016io.Closeable.closeFinally(r0, r1)
            r0 = 1
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            r0 = r15
            goto L_0x006b
        L_0x004e:
            r15 = move-exception
            r1 = r15
            r14 = r1
            r1 = r15
            throw r1     // Catch: all -> 0x0057
        L_0x0057:
            r15 = move-exception
            r0 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r0 = r13
            r1 = r14
            kotlin.p016io.Closeable.closeFinally(r0, r1)
            r0 = 1
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            r0 = r15
            throw r0
        L_0x006b:
            r12 = r0
            r0 = r8
            r1 = r12
            java.lang.Object r0 = r0.invoke(r1)
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            r13 = r0
            r0 = r10
            r1 = -1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00ba
            r0 = r10
            r1 = r13
            long r1 = (long) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00ba
            java.io.IOException r0 = new java.io.IOException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Content-Length ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r10
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") and stream length ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r13
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") disagree"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x00ba:
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.ResponseBody.consumeSource(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @NotNull
    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader it = new BomAwareReader(source(), charset());
        this.reader = it;
        return it;
    }

    @NotNull
    public final String string() throws IOException {
        BufferedSource source = source();
        try {
            BufferedSource source2 = source;
            String readString = source2.readString(Util.readBomAsCharset(source2, charset()));
            kotlin.p016io.Closeable.closeFinally(source, null);
            return readString;
        } catch (Throwable th) {
            kotlin.p016io.Closeable.closeFinally(source, null);
            throw th;
        }
    }

    private final Charset charset() {
        MediaType contentType = contentType();
        Charset charset = contentType == null ? null : contentType.charset(Charsets.UTF_8);
        return charset == null ? Charsets.UTF_8 : charset;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    /* compiled from: ResponseBody.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0010\b\n��\n\u0002\u0010\u0019\n\u0002\b\u0003\b��\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n��R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��¨\u0006\u0012"}, m373d2 = {"Lokhttp3/ResponseBody$BomAwareReader;", "Ljava/io/Reader;", "source", "Lokio/BufferedSource;", "charset", "Ljava/nio/charset/Charset;", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)V", "closed", "", MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, "close", "", "read", "", "cbuf", "", "off", "len", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/ResponseBody$BomAwareReader.class */
    public static final class BomAwareReader extends Reader {
        @NotNull
        private final BufferedSource source;
        @NotNull
        private final Charset charset;
        private boolean closed;
        @Nullable
        private Reader delegate;

        public BomAwareReader(@NotNull BufferedSource source, @NotNull Charset charset) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        @Override // java.io.Reader
        public int read(@NotNull char[] cbuf, int off, int len) throws IOException {
            InputStreamReader finalDelegate;
            Intrinsics.checkNotNullParameter(cbuf, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.delegate;
            if (reader == null) {
                InputStreamReader it = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
                this.delegate = it;
                finalDelegate = it;
            } else {
                finalDelegate = reader;
            }
            return finalDelegate.read(cbuf, off, len);
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Unit unit;
            this.closed = true;
            Reader reader = this.delegate;
            if (reader == null) {
                unit = null;
            } else {
                reader.close();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                this.source.close();
            }
        }
    }

    /* compiled from: ResponseBody.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0012\n��\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000bH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\fH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\rH\u0007J'\u0010\u000e\u001a\u00020\u0004*\u00020\u000b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003¨\u0006\u0010"}, m373d2 = {"Lokhttp3/ResponseBody$Companion;", "", "()V", "create", "Lokhttp3/ResponseBody;", "contentType", "Lokhttp3/MediaType;", "content", "", "contentLength", "", "Lokio/BufferedSource;", "", "Lokio/ByteString;", "asResponseBody", "toResponseBody", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/ResponseBody$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final ResponseBody create(@NotNull String $this$toResponseBody, @Nullable MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$toResponseBody, "<this>");
            Charset charset = Charsets.UTF_8;
            MediaType finalContentType = contentType;
            if (contentType != null) {
                Charset resolvedCharset = MediaType.charset$default(contentType, null, 1, null);
                if (resolvedCharset == null) {
                    charset = Charsets.UTF_8;
                    finalContentType = MediaType.Companion.parse(contentType + "; charset=utf-8");
                } else {
                    charset = resolvedCharset;
                }
            }
            Buffer buffer = new Buffer().writeString($this$toResponseBody, charset);
            return create(buffer, finalContentType, buffer.size());
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final ResponseBody create(@NotNull byte[] $this$toResponseBody, @Nullable MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$toResponseBody, "<this>");
            return create(new Buffer().write($this$toResponseBody), contentType, (long) $this$toResponseBody.length);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final ResponseBody create(@NotNull ByteString $this$toResponseBody, @Nullable MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$toResponseBody, "<this>");
            return create(new Buffer().write($this$toResponseBody), contentType, (long) $this$toResponseBody.size());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v4 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ okhttp3.ResponseBody create$default(okhttp3.ResponseBody.Companion r6, okio.BufferedSource r7, okhttp3.MediaType r8, long r9, int r11, java.lang.Object r12) {
            /*
                r0 = r11
                r1 = 1
                r0 = r0 & r1
                if (r0 == 0) goto L_0x0009
                r0 = 0
                r8 = r0
            L_0x0009:
                r0 = r11
                r1 = 2
                r0 = r0 & r1
                if (r0 == 0) goto L_0x0014
                r0 = -1
                r9 = r0
            L_0x0014:
                r0 = r6
                r1 = r7
                r2 = r8
                r3 = r9
                okhttp3.ResponseBody r0 = r0.create(r1, r2, r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.ResponseBody.Companion.create$default(okhttp3.ResponseBody$Companion, okio.BufferedSource, okhttp3.MediaType, long, int, java.lang.Object):okhttp3.ResponseBody");
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final ResponseBody create(@NotNull BufferedSource $this$asResponseBody, @Nullable MediaType contentType, long contentLength) {
            Intrinsics.checkNotNullParameter($this$asResponseBody, "<this>");
            return new ResponseBody$Companion$asResponseBody$1(contentType, contentLength, $this$asResponseBody);
        }

        @JvmStatic
        @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}), level = DeprecationLevel.WARNING)
        @NotNull
        public final ResponseBody create(@Nullable MediaType contentType, @NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType);
        }

        @JvmStatic
        @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}), level = DeprecationLevel.WARNING)
        @NotNull
        public final ResponseBody create(@Nullable MediaType contentType, @NotNull byte[] content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType);
        }

        @JvmStatic
        @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}), level = DeprecationLevel.WARNING)
        @NotNull
        public final ResponseBody create(@Nullable MediaType contentType, @NotNull ByteString content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType);
        }

        @JvmStatic
        @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}), level = DeprecationLevel.WARNING)
        @NotNull
        public final ResponseBody create(@Nullable MediaType contentType, long contentLength, @NotNull BufferedSource content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType, contentLength);
        }
    }
}
