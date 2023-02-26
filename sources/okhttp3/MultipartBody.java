package okhttp3;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.javalin.http.ContentType;

/* compiled from: MultipartBody.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018�� #2\u00020\u0001:\u0003\"#$B%\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\b\u0015J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0012J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b\u0018J\r\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u001aJ\u001a\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n��R\u000e\u0010\u000f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n��R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n��\u001a\u0004\b\u0004\u0010\u0014¨\u0006%"}, m373d2 = {"Lokhttp3/MultipartBody;", "Lokhttp3/RequestBody;", "boundaryByteString", "Lokio/ByteString;", "type", "Lokhttp3/MediaType;", "parts", "", "Lokhttp3/MultipartBody$Part;", "(Lokio/ByteString;Lokhttp3/MediaType;Ljava/util/List;)V", "boundary", "", "()Ljava/lang/String;", "contentLength", "", "contentType", "()Ljava/util/List;", "size", "", "()I", "()Lokhttp3/MediaType;", "-deprecated_boundary", "part", "index", "-deprecated_parts", "-deprecated_size", "-deprecated_type", "writeOrCountBytes", "sink", "Lokio/BufferedSink;", "countBytes", "", "writeTo", "", "Builder", "Companion", "Part", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/MultipartBody.class */
public final class MultipartBody extends RequestBody {
    @NotNull
    private final ByteString boundaryByteString;
    @NotNull
    private final MediaType type;
    @NotNull
    private final List<Part> parts;
    @NotNull
    private final MediaType contentType;
    private long contentLength = -1;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final MediaType MIXED = MediaType.Companion.get("multipart/mixed");
    @JvmField
    @NotNull
    public static final MediaType ALTERNATIVE = MediaType.Companion.get("multipart/alternative");
    @JvmField
    @NotNull
    public static final MediaType DIGEST = MediaType.Companion.get("multipart/digest");
    @JvmField
    @NotNull
    public static final MediaType PARALLEL = MediaType.Companion.get("multipart/parallel");
    @JvmField
    @NotNull
    public static final MediaType FORM = MediaType.Companion.get(ContentType.FORM_DATA);
    @NotNull
    private static final byte[] COLONSPACE = {58, 32};
    @NotNull
    private static final byte[] CRLF = {13, 10};
    @NotNull
    private static final byte[] DASHDASH = {45, 45};

    @JvmName(name = "type")
    @NotNull
    public final MediaType type() {
        return this.type;
    }

    @JvmName(name = "parts")
    @NotNull
    public final List<Part> parts() {
        return this.parts;
    }

    public MultipartBody(@NotNull ByteString boundaryByteString, @NotNull MediaType type, @NotNull List<Part> list) {
        Intrinsics.checkNotNullParameter(boundaryByteString, "boundaryByteString");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(list, "parts");
        this.boundaryByteString = boundaryByteString;
        this.type = type;
        this.parts = list;
        this.contentType = MediaType.Companion.get(this.type + "; boundary=" + boundary());
    }

    @JvmName(name = "boundary")
    @NotNull
    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    @JvmName(name = "size")
    public final int size() {
        return this.parts.size();
    }

    @NotNull
    public final Part part(int index) {
        return this.parts.get(index);
    }

    @Override // okhttp3.RequestBody
    @NotNull
    public MediaType contentType() {
        return this.contentType;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_type")
    @NotNull
    /* renamed from: -deprecated_type  reason: not valid java name */
    public final MediaType m9236deprecated_type() {
        return this.type;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "boundary", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_boundary")
    @NotNull
    /* renamed from: -deprecated_boundary  reason: not valid java name */
    public final String m9237deprecated_boundary() {
        return boundary();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m9238deprecated_size() {
        return size();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "parts", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_parts")
    @NotNull
    /* renamed from: -deprecated_parts  reason: not valid java name */
    public final List<Part> m9239deprecated_parts() {
        return this.parts;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        char c = this.contentLength;
        if (c == -1) {
            c = writeOrCountBytes(null, true);
            this.contentLength = c;
        }
        return c;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@NotNull BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        writeOrCountBytes(sink, false);
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [long] */
    /* JADX WARN: Type inference failed for: r0v52, types: [long] */
    private final long writeOrCountBytes(BufferedSink sink, boolean countBytes) throws IOException {
        BufferedSink sink2 = sink;
        char c = 0;
        Buffer byteCountBuffer = null;
        if (countBytes) {
            byteCountBuffer = new Buffer();
            sink2 = byteCountBuffer;
        }
        int p = 0;
        int size = this.parts.size();
        while (p < size) {
            p++;
            Part part = this.parts.get(p);
            Headers headers = part.headers();
            RequestBody body = part.body();
            Intrinsics.checkNotNull(sink2);
            sink2.write(DASHDASH);
            sink2.write(this.boundaryByteString);
            sink2.write(CRLF);
            if (headers != null) {
                int h = 0;
                int size2 = headers.size();
                while (h < size2) {
                    h++;
                    sink2.writeUtf8(headers.name(h)).write(COLONSPACE).writeUtf8(headers.value(h)).write(CRLF);
                }
            }
            MediaType contentType = body.contentType();
            if (contentType != null) {
                sink2.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(CRLF);
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                sink2.writeUtf8("Content-Length: ").writeDecimalLong(contentLength).write(CRLF);
            } else if (countBytes) {
                Intrinsics.checkNotNull(byteCountBuffer);
                byteCountBuffer.clear();
                return -1;
            }
            sink2.write(CRLF);
            if (countBytes) {
                c += contentLength;
            } else {
                body.writeTo(sink2);
            }
            sink2.write(CRLF);
        }
        Intrinsics.checkNotNull(sink2);
        sink2.write(DASHDASH);
        sink2.write(this.boundaryByteString);
        sink2.write(DASHDASH);
        sink2.write(CRLF);
        if (countBytes) {
            Intrinsics.checkNotNull(byteCountBuffer);
            c += byteCountBuffer.size();
            byteCountBuffer.clear();
        }
        return c;
    }

    /* compiled from: MultipartBody.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018�� \u000b2\u00020\u0001:\u0001\u000bB\u0019\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\tJ\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\nR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n��\u001a\u0004\b\u0004\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\b¨\u0006\f"}, m373d2 = {"Lokhttp3/MultipartBody$Part;", "", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "(Lokhttp3/Headers;Lokhttp3/RequestBody;)V", "()Lokhttp3/RequestBody;", "()Lokhttp3/Headers;", "-deprecated_body", "-deprecated_headers", "Companion", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/MultipartBody$Part.class */
    public static final class Part {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @Nullable
        private final Headers headers;
        @NotNull
        private final RequestBody body;

        @JvmStatic
        @NotNull
        public static final Part create(@NotNull RequestBody body) {
            return Companion.create(body);
        }

        @JvmStatic
        @NotNull
        public static final Part create(@Nullable Headers headers, @NotNull RequestBody body) {
            return Companion.create(headers, body);
        }

        @JvmStatic
        @NotNull
        public static final Part createFormData(@NotNull String name, @NotNull String value) {
            return Companion.createFormData(name, value);
        }

        @JvmStatic
        @NotNull
        public static final Part createFormData(@NotNull String name, @Nullable String filename, @NotNull RequestBody body) {
            return Companion.createFormData(name, filename, body);
        }

        public /* synthetic */ Part(Headers headers, RequestBody body, DefaultConstructorMarker $constructor_marker) {
            this(headers, body);
        }

        private Part(Headers headers, RequestBody body) {
            this.headers = headers;
            this.body = body;
        }

        @JvmName(name = "headers")
        @Nullable
        public final Headers headers() {
            return this.headers;
        }

        @JvmName(name = "body")
        @NotNull
        public final RequestBody body() {
            return this.body;
        }

        @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}), level = DeprecationLevel.ERROR)
        @JvmName(name = "-deprecated_headers")
        @Nullable
        /* renamed from: -deprecated_headers  reason: not valid java name */
        public final Headers m9241deprecated_headers() {
            return this.headers;
        }

        @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}), level = DeprecationLevel.ERROR)
        @JvmName(name = "-deprecated_body")
        @NotNull
        /* renamed from: -deprecated_body  reason: not valid java name */
        public final RequestBody m9242deprecated_body() {
            return this.body;
        }

        /* compiled from: MultipartBody.kt */
        @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��(\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\u000e"}, m373d2 = {"Lokhttp3/MultipartBody$Part$Companion;", "", "()V", "create", "Lokhttp3/MultipartBody$Part;", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "createFormData", "name", "", "value", "filename", "okhttp"})
        /* loaded from: grasscutter.jar:okhttp3/MultipartBody$Part$Companion.class */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            @NotNull
            public final Part create(@NotNull RequestBody body) {
                Intrinsics.checkNotNullParameter(body, "body");
                return create(null, body);
            }

            @JvmStatic
            @NotNull
            public final Part create(@Nullable Headers headers, @NotNull RequestBody body) {
                Intrinsics.checkNotNullParameter(body, "body");
                if (!((headers == null ? null : headers.get("Content-Type")) == null)) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
                }
                if ((headers == null ? null : headers.get("Content-Length")) == null) {
                    return new Part(headers, body, null);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            }

            @JvmStatic
            @NotNull
            public final Part createFormData(@NotNull String name, @NotNull String value) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                return createFormData(name, null, RequestBody.Companion.create$default(RequestBody.Companion, value, (MediaType) null, 1, (Object) null));
            }

            @JvmStatic
            @NotNull
            public final Part createFormData(@NotNull String name, @Nullable String filename, @NotNull RequestBody body) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(body, "body");
                StringBuilder $this$createFormData_u24lambda_u2d2 = new StringBuilder();
                $this$createFormData_u24lambda_u2d2.append("form-data; name=");
                MultipartBody.Companion.appendQuotedString$okhttp($this$createFormData_u24lambda_u2d2, name);
                if (filename != null) {
                    $this$createFormData_u24lambda_u2d2.append("; filename=");
                    MultipartBody.Companion.appendQuotedString$okhttp($this$createFormData_u24lambda_u2d2, filename);
                }
                String disposition = $this$createFormData_u24lambda_u2d2.toString();
                Intrinsics.checkNotNullExpressionValue(disposition, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", disposition).build(), body);
            }
        }
    }

    /* compiled from: MultipartBody.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��@\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010!\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020��2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003J \u0010\u000b\u001a\u00020��2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020��2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020��2\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020��2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020��2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0005X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n��¨\u0006\u0018"}, m373d2 = {"Lokhttp3/MultipartBody$Builder;", "", "boundary", "", "(Ljava/lang/String;)V", "Lokio/ByteString;", "parts", "", "Lokhttp3/MultipartBody$Part;", "type", "Lokhttp3/MediaType;", "addFormDataPart", "name", "value", "filename", "body", "Lokhttp3/RequestBody;", "addPart", "headers", "Lokhttp3/Headers;", "part", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lokhttp3/MultipartBody;", "setType", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/MultipartBody$Builder.class */
    public static final class Builder {
        @NotNull
        private final ByteString boundary;
        @NotNull
        private MediaType type;
        @NotNull
        private final List<Part> parts;

        @JvmOverloads
        public Builder() {
            this(null, 1, null);
        }

        @JvmOverloads
        public Builder(@NotNull String boundary) {
            Intrinsics.checkNotNullParameter(boundary, "boundary");
            this.boundary = ByteString.Companion.encodeUtf8(boundary);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Builder(java.lang.String r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
            /*
                r3 = this;
                r0 = r5
                r1 = 1
                r0 = r0 & r1
                if (r0 == 0) goto L_0x0018
                java.util.UUID r0 = java.util.UUID.randomUUID()
                java.lang.String r0 = r0.toString()
                r7 = r0
                r0 = r7
                java.lang.String r1 = "randomUUID().toString()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                r0 = r7
                r4 = r0
            L_0x0018:
                r0 = r3
                r1 = r4
                r0.<init>(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartBody.Builder.<init>(java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        @NotNull
        public final Builder setType(@NotNull MediaType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            Builder $this$setType_u24lambda_u2d1 = this;
            if (!Intrinsics.areEqual(type.type(), "multipart")) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("multipart != ", type).toString());
            }
            $this$setType_u24lambda_u2d1.type = type;
            return this;
        }

        @NotNull
        public final Builder addPart(@NotNull RequestBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            addPart(Part.Companion.create(body));
            return this;
        }

        @NotNull
        public final Builder addPart(@Nullable Headers headers, @NotNull RequestBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            addPart(Part.Companion.create(headers, body));
            return this;
        }

        @NotNull
        public final Builder addFormDataPart(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            addPart(Part.Companion.createFormData(name, value));
            return this;
        }

        @NotNull
        public final Builder addFormDataPart(@NotNull String name, @Nullable String filename, @NotNull RequestBody body) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(body, "body");
            addPart(Part.Companion.createFormData(name, filename, body));
            return this;
        }

        @NotNull
        public final Builder addPart(@NotNull Part part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.parts.add(part);
            return this;
        }

        @NotNull
        public final MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }
    }

    /* compiled from: MultipartBody.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��0\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\r\u001a\u00020\u000e*\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u0012H��¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u0014"}, m373d2 = {"Lokhttp3/MultipartBody$Companion;", "", "()V", "ALTERNATIVE", "Lokhttp3/MediaType;", "COLONSPACE", "", "CRLF", "DASHDASH", "DIGEST", "FORM", "MIXED", "PARALLEL", "appendQuotedString", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", Action.KEY_ATTRIBUTE, "", "appendQuotedString$okhttp", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/MultipartBody$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        public final void appendQuotedString$okhttp(@NotNull StringBuilder $this$appendQuotedString, @NotNull String key) {
            Intrinsics.checkNotNullParameter($this$appendQuotedString, "<this>");
            Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
            $this$appendQuotedString.append('\"');
            int i = 0;
            int length = key.length();
            while (i < length) {
                i++;
                char ch = key.charAt(i);
                if (ch == '\n') {
                    $this$appendQuotedString.append("%0A");
                } else if (ch == '\r') {
                    $this$appendQuotedString.append("%0D");
                } else if (ch == '\"') {
                    $this$appendQuotedString.append("%22");
                } else {
                    $this$appendQuotedString.append(ch);
                }
            }
            $this$appendQuotedString.append('\"');
        }
    }
}
