package okhttp3;

import kotlin.Metadata;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ResponseBody.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001d\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��*\u0001��\b\n\u0018��2\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m373d2 = {"okhttp3/ResponseBody$Companion$asResponseBody$1", "Lokhttp3/ResponseBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "Lokio/BufferedSource;", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/ResponseBody$Companion$asResponseBody$1.class */
public final class ResponseBody$Companion$asResponseBody$1 extends ResponseBody {
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ long $contentLength;
    final /* synthetic */ BufferedSource $this_asResponseBody;

    /* access modifiers changed from: package-private */
    public ResponseBody$Companion$asResponseBody$1(MediaType $contentType, long $contentLength, BufferedSource $receiver) {
        this.$contentType = $contentType;
        this.$contentLength = $contentLength;
        this.$this_asResponseBody = $receiver;
    }

    @Override // okhttp3.ResponseBody
    @Nullable
    public MediaType contentType() {
        return this.$contentType;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.$contentLength;
    }

    @Override // okhttp3.ResponseBody
    @NotNull
    public BufferedSource source() {
        return this.$this_asResponseBody;
    }
}
