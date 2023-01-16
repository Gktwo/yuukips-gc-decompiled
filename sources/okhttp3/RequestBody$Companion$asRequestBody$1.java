package okhttp3;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p016io.Closeable;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RequestBody.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��#\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��*\u0001��\b\n\u0018��2\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m373d2 = {"okhttp3/RequestBody$Companion$asRequestBody$1", "Lokhttp3/RequestBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/RequestBody$Companion$asRequestBody$1.class */
public final class RequestBody$Companion$asRequestBody$1 extends RequestBody {
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ File $this_asRequestBody;

    /* access modifiers changed from: package-private */
    public RequestBody$Companion$asRequestBody$1(MediaType $contentType, File $receiver) {
        this.$contentType = $contentType;
        this.$this_asRequestBody = $receiver;
    }

    @Override // okhttp3.RequestBody
    @Nullable
    public MediaType contentType() {
        return this.$contentType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.$this_asRequestBody.length();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@NotNull BufferedSink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Source source = Okio.source(this.$this_asRequestBody);
        try {
            sink.writeAll(source);
            Closeable.closeFinally(source, null);
        } catch (Throwable th) {
            Closeable.closeFinally(source, null);
            throw th;
        }
    }
}
