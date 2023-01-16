package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RequestBody.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��#\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��*\u0001��\b\n\u0018��2\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m373d2 = {"okhttp3/RequestBody$Companion$toRequestBody$2", "Lokhttp3/RequestBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/RequestBody$Companion$toRequestBody$2.class */
public final class RequestBody$Companion$toRequestBody$2 extends RequestBody {
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ int $byteCount;
    final /* synthetic */ byte[] $this_toRequestBody;
    final /* synthetic */ int $offset;

    /* access modifiers changed from: package-private */
    public RequestBody$Companion$toRequestBody$2(MediaType $contentType, int $byteCount, byte[] $receiver, int $offset) {
        this.$contentType = $contentType;
        this.$byteCount = $byteCount;
        this.$this_toRequestBody = $receiver;
        this.$offset = $offset;
    }

    @Override // okhttp3.RequestBody
    @Nullable
    public MediaType contentType() {
        return this.$contentType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return (long) this.$byteCount;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@NotNull BufferedSink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        sink.write(this.$this_toRequestBody, this.$offset, this.$byteCount);
    }
}
