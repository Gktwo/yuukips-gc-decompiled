package okhttp3.internal.http;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExchangeCodec.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��N\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018�� \u001c2\u00020\u0001:\u0001\u001cJ\b\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001d"}, m373d2 = {"Lokhttp3/internal/http/ExchangeCodec;", "", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "cancel", "", "createRequestBody", "Lokio/Sink;", "request", "Lokhttp3/Request;", "contentLength", "", "finishRequest", "flushRequest", "openResponseBodySource", "Lokio/Source;", "response", "Lokhttp3/Response;", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "", "reportedContentLength", "trailers", "Lokhttp3/Headers;", "writeRequestHeaders", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/http/ExchangeCodec.class */
public interface ExchangeCodec {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    @NotNull
    RealConnection getConnection();

    @NotNull
    Sink createRequestBody(@NotNull Request request, long j) throws IOException;

    void writeRequestHeaders(@NotNull Request request) throws IOException;

    void flushRequest() throws IOException;

    void finishRequest() throws IOException;

    @Nullable
    Response.Builder readResponseHeaders(boolean z) throws IOException;

    long reportedContentLength(@NotNull Response response) throws IOException;

    @NotNull
    Source openResponseBodySource(@NotNull Response response) throws IOException;

    @NotNull
    Headers trailers() throws IOException;

    void cancel();

    /* compiled from: ExchangeCodec.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\b\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\u0005"}, m373d2 = {"Lokhttp3/internal/http/ExchangeCodec$Companion;", "", "()V", "DISCARD_STREAM_TIMEOUT_MILLIS", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http/ExchangeCodec$Companion.class */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

        private Companion() {
        }
    }
}
