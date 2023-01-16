package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import okio.Sink;
import org.jetbrains.annotations.NotNull;
import org.jline.reader.LineReader;

/* compiled from: CacheRequest.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0016\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\bf\u0018��2\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m373d2 = {"Lokhttp3/internal/cache/CacheRequest;", "", LineReader.SEND_BREAK, "", "body", "Lokio/Sink;", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/cache/CacheRequest.class */
public interface CacheRequest {
    @NotNull
    Sink body() throws IOException;

    void abort();
}
