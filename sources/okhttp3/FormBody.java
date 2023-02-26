package okhttp3;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: FormBody.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018�� \u001c2\u00020\u0001:\u0002\u001b\u001cB#\b��\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u001a\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n��R\u0011\u0010\u0007\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\u001d"}, m373d2 = {"Lokhttp3/FormBody;", "Lokhttp3/RequestBody;", "encodedNames", "", "", "encodedValues", "(Ljava/util/List;Ljava/util/List;)V", "size", "", "()I", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "encodedName", "index", "encodedValue", "name", "-deprecated_size", "value", "writeOrCountBytes", "sink", "Lokio/BufferedSink;", "countBytes", "", "writeTo", "", "Builder", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/FormBody.class */
public final class FormBody extends RequestBody {
    @NotNull
    private final List<String> encodedNames;
    @NotNull
    private final List<String> encodedValues;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final MediaType CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");

    public FormBody(@NotNull List<String> list, @NotNull List<String> list2) {
        Intrinsics.checkNotNullParameter(list, "encodedNames");
        Intrinsics.checkNotNullParameter(list2, "encodedValues");
        this.encodedNames = Util.toImmutableList(list);
        this.encodedValues = Util.toImmutableList(list2);
    }

    @JvmName(name = "size")
    public final int size() {
        return this.encodedNames.size();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m9190deprecated_size() {
        return size();
    }

    @NotNull
    public final String encodedName(int index) {
        return this.encodedNames.get(index);
    }

    @NotNull
    public final String name(int index) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(index), 0, 0, true, 3, null);
    }

    @NotNull
    public final String encodedValue(int index) {
        return this.encodedValues.get(index);
    }

    @NotNull
    public final String value(int index) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(index), 0, 0, true, 3, null);
    }

    @Override // okhttp3.RequestBody
    @NotNull
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@NotNull BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        writeOrCountBytes(sink, false);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    private final long writeOrCountBytes(BufferedSink sink, boolean countBytes) {
        Buffer buffer;
        char c = 0;
        if (countBytes) {
            buffer = new Buffer();
        } else {
            Intrinsics.checkNotNull(sink);
            buffer = sink.getBuffer();
        }
        int i = 0;
        int size = this.encodedNames.size();
        while (i < size) {
            i++;
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.encodedNames.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.encodedValues.get(i));
        }
        if (countBytes) {
            c = buffer.size();
            buffer.clear();
        }
        return c;
    }

    /* compiled from: FormBody.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��$\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020��2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020��2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n��R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u000f"}, m373d2 = {"Lokhttp3/FormBody$Builder;", "", "charset", "Ljava/nio/charset/Charset;", "(Ljava/nio/charset/Charset;)V", "names", "", "", "values", BeanUtil.PREFIX_ADDER, "name", "value", "addEncoded", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lokhttp3/FormBody;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/FormBody$Builder.class */
    public static final class Builder {
        @Nullable
        private final Charset charset;
        @NotNull
        private final List<String> names;
        @NotNull
        private final List<String> values;

        @JvmOverloads
        public Builder() {
            this(null, 1, null);
        }

        @JvmOverloads
        public Builder(@Nullable Charset charset) {
            this.charset = charset;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public /* synthetic */ Builder(Charset charset, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : charset);
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Builder $this$add_u24lambda_u2d0 = this;
            $this$add_u24lambda_u2d0.names.add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, $this$add_u24lambda_u2d0.charset, 91, null));
            $this$add_u24lambda_u2d0.values.add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, value, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, $this$add_u24lambda_u2d0.charset, 91, null));
            return this;
        }

        @NotNull
        public final Builder addEncoded(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Builder $this$addEncoded_u24lambda_u2d1 = this;
            $this$addEncoded_u24lambda_u2d1.names.add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, $this$addEncoded_u24lambda_u2d1.charset, 83, null));
            $this$addEncoded_u24lambda_u2d1.values.add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, value, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, $this$addEncoded_u24lambda_u2d1.charset, 83, null));
            return this;
        }

        @NotNull
        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }
    }

    /* compiled from: FormBody.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��¨\u0006\u0005"}, m373d2 = {"Lokhttp3/FormBody$Companion;", "", "()V", "CONTENT_TYPE", "Lokhttp3/MediaType;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/FormBody$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }
}
