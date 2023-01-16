package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.joran.action.Action;

/* compiled from: RequestBody.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��.\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018�� \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000f"}, m373d2 = {"Lokhttp3/RequestBody;", "", "()V", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "isDuplex", "", "isOneShot", "writeTo", "", "sink", "Lokio/BufferedSink;", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/RequestBody.class */
public abstract class RequestBody {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(@NotNull BufferedSink bufferedSink) throws IOException;

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final RequestBody create(@NotNull String $this$create, @Nullable MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final RequestBody create(@NotNull ByteString $this$create, @Nullable MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] $this$create, @Nullable MediaType contentType, int offset, int byteCount) {
        return Companion.create($this$create, contentType, offset, byteCount);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final RequestBody create(@NotNull File $this$create, @Nullable MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}), level = DeprecationLevel.WARNING)
    @NotNull
    public static final RequestBody create(@Nullable MediaType contentType, @NotNull String content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}), level = DeprecationLevel.WARNING)
    @NotNull
    public static final RequestBody create(@Nullable MediaType contentType, @NotNull ByteString content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @NotNull
    @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}), level = DeprecationLevel.WARNING)
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType contentType, @NotNull byte[] content, int offset, int byteCount) {
        return Companion.create(contentType, content, offset, byteCount);
    }

    @JvmStatic
    @Deprecated(message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}), level = DeprecationLevel.WARNING)
    @NotNull
    public static final RequestBody create(@Nullable MediaType contentType, @NotNull File file) {
        return Companion.create(contentType, file);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] $this$create, @Nullable MediaType contentType, int offset) {
        return Companion.create($this$create, contentType, offset);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] $this$create, @Nullable MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] $this$create) {
        return Companion.create($this$create);
    }

    @JvmStatic
    @NotNull
    @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}), level = DeprecationLevel.WARNING)
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType contentType, @NotNull byte[] content, int offset) {
        return Companion.create(contentType, content, offset);
    }

    @JvmStatic
    @NotNull
    @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}), level = DeprecationLevel.WARNING)
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType contentType, @NotNull byte[] content) {
        return Companion.create(contentType, content);
    }

    public long contentLength() throws IOException {
        return -1;
    }

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    /* compiled from: RequestBody.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��6\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0012\n��\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u000eH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u000fH\u0007J\u001d\u0010\u0010\u001a\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J1\u0010\u0011\u001a\u00020\u0004*\u00020\n2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u0011\u001a\u00020\u0004*\u00020\u000e2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u0011\u001a\u00020\u0004*\u00020\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003¨\u0006\u0012"}, m373d2 = {"Lokhttp3/RequestBody$Companion;", "", "()V", "create", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", Action.FILE_ATTRIBUTE, "Ljava/io/File;", "content", "", "offset", "", "byteCount", "", "Lokio/ByteString;", "asRequestBody", "toRequestBody", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/RequestBody$Companion.class */
    public static final class Companion {
        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] $this$toRequestBody, @Nullable MediaType contentType, int offset) {
            Intrinsics.checkNotNullParameter($this$toRequestBody, "<this>");
            return create$default(this, $this$toRequestBody, contentType, offset, 0, 4, (Object) null);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] $this$toRequestBody, @Nullable MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$toRequestBody, "<this>");
            return create$default(this, $this$toRequestBody, contentType, 0, 0, 6, (Object) null);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] $this$toRequestBody) {
            Intrinsics.checkNotNullParameter($this$toRequestBody, "<this>");
            return create$default(this, $this$toRequestBody, (MediaType) null, 0, 0, 7, (Object) null);
        }

        @JvmStatic
        @NotNull
        @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}), level = DeprecationLevel.WARNING)
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType contentType, @NotNull byte[] content, int offset) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create$default(this, contentType, content, offset, 0, 8, (Object) null);
        }

        @JvmStatic
        @NotNull
        @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}), level = DeprecationLevel.WARNING)
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType contentType, @NotNull byte[] content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create$default(this, contentType, content, 0, 0, 12, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final RequestBody create(@NotNull String $this$toRequestBody, @Nullable MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$toRequestBody, "<this>");
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
            byte[] bytes = $this$toRequestBody.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return create(bytes, finalContentType, 0, bytes.length);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final RequestBody create(@NotNull ByteString $this$toRequestBody, @Nullable MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$toRequestBody, "<this>");
            return new RequestBody$Companion$toRequestBody$1(contentType, $this$toRequestBody);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return companion.create(bArr, mediaType, i, i2);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] $this$toRequestBody, @Nullable MediaType contentType, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter($this$toRequestBody, "<this>");
            Util.checkOffsetAndCount((long) $this$toRequestBody.length, (long) offset, (long) byteCount);
            return new RequestBody$Companion$toRequestBody$2(contentType, byteCount, $this$toRequestBody, offset);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final RequestBody create(@NotNull File $this$asRequestBody, @Nullable MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$asRequestBody, "<this>");
            return new RequestBody$Companion$asRequestBody$1(contentType, $this$asRequestBody);
        }

        @JvmStatic
        @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}), level = DeprecationLevel.WARNING)
        @NotNull
        public final RequestBody create(@Nullable MediaType contentType, @NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType);
        }

        @JvmStatic
        @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}), level = DeprecationLevel.WARNING)
        @NotNull
        public final RequestBody create(@Nullable MediaType contentType, @NotNull ByteString content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return companion.create(mediaType, bArr, i, i2);
        }

        @JvmStatic
        @NotNull
        @Deprecated(message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}), level = DeprecationLevel.WARNING)
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType contentType, @NotNull byte[] content, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType, offset, byteCount);
        }

        @JvmStatic
        @Deprecated(message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}), level = DeprecationLevel.WARNING)
        @NotNull
        public final RequestBody create(@Nullable MediaType contentType, @NotNull File file) {
            Intrinsics.checkNotNullParameter(file, Action.FILE_ATTRIBUTE);
            return create(file, contentType);
        }
    }
}
