package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.dates;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CacheStrategy.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\b\u0018�� \u000b2\u00020\u0001:\u0002\u000b\fB\u001b\b��\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n��\u001a\u0004\b\t\u0010\n¨\u0006\r"}, m373d2 = {"Lokhttp3/internal/cache/CacheStrategy;", "", "networkRequest", "Lokhttp3/Request;", "cacheResponse", "Lokhttp3/Response;", "(Lokhttp3/Request;Lokhttp3/Response;)V", "getCacheResponse", "()Lokhttp3/Response;", "getNetworkRequest", "()Lokhttp3/Request;", "Companion", "Factory", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/cache/CacheStrategy.class */
public final class CacheStrategy {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Request networkRequest;
    @Nullable
    private final Response cacheResponse;

    public CacheStrategy(@Nullable Request networkRequest, @Nullable Response cacheResponse) {
        this.networkRequest = networkRequest;
        this.cacheResponse = cacheResponse;
    }

    @Nullable
    public final Request getNetworkRequest() {
        return this.networkRequest;
    }

    @Nullable
    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    /* compiled from: CacheStrategy.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��B\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018��2\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n��R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n��R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n��R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n��R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n��R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n��R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n��\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u0002\n��R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n��R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n��¨\u0006\u001f"}, m373d2 = {"Lokhttp3/internal/cache/CacheStrategy$Factory;", "", "nowMillis", "", "request", "Lokhttp3/Request;", "cacheResponse", "Lokhttp3/Response;", "(JLokhttp3/Request;Lokhttp3/Response;)V", "ageSeconds", "", "etag", "", "expires", "Ljava/util/Date;", "lastModified", "lastModifiedString", "receivedResponseMillis", "getRequest$okhttp", "()Lokhttp3/Request;", "sentRequestMillis", "servedDate", "servedDateString", "cacheResponseAge", "compute", "Lokhttp3/internal/cache/CacheStrategy;", "computeCandidate", "computeFreshnessLifetime", "hasConditions", "", "isFreshnessLifetimeHeuristic", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/cache/CacheStrategy$Factory.class */
    public static final class Factory {
        private final long nowMillis;
        @NotNull
        private final Request request;
        @Nullable
        private final Response cacheResponse;
        @Nullable
        private Date servedDate;
        @Nullable
        private String servedDateString;
        @Nullable
        private Date lastModified;
        @Nullable
        private String lastModifiedString;
        @Nullable
        private Date expires;
        private long sentRequestMillis;
        private long receivedResponseMillis;
        @Nullable
        private String etag;
        private int ageSeconds;

        public Factory(long nowMillis, @NotNull Request request, @Nullable Response cacheResponse) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.nowMillis = nowMillis;
            this.request = request;
            this.cacheResponse = cacheResponse;
            this.ageSeconds = -1;
            if (this.cacheResponse != null) {
                this.sentRequestMillis = this.cacheResponse.sentRequestAtMillis();
                this.receivedResponseMillis = this.cacheResponse.receivedResponseAtMillis();
                Headers headers = this.cacheResponse.headers();
                int i = 0;
                int size = headers.size();
                while (i < size) {
                    i++;
                    String fieldName = headers.name(i);
                    String value = headers.value(i);
                    if (StringsKt.equals(fieldName, "Date", true)) {
                        this.servedDate = dates.toHttpDateOrNull(value);
                        this.servedDateString = value;
                    } else if (StringsKt.equals(fieldName, "Expires", true)) {
                        this.expires = dates.toHttpDateOrNull(value);
                    } else if (StringsKt.equals(fieldName, "Last-Modified", true)) {
                        this.lastModified = dates.toHttpDateOrNull(value);
                        this.lastModifiedString = value;
                    } else if (StringsKt.equals(fieldName, "ETag", true)) {
                        this.etag = value;
                    } else if (StringsKt.equals(fieldName, "Age", true)) {
                        this.ageSeconds = Util.toNonNegativeInt(value, -1);
                    }
                }
            }
        }

        @NotNull
        public final Request getRequest$okhttp() {
            return this.request;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            Response response = this.cacheResponse;
            Intrinsics.checkNotNull(response);
            return response.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        @NotNull
        public final CacheStrategy compute() {
            CacheStrategy candidate = computeCandidate();
            if (candidate.getNetworkRequest() == null || !this.request.cacheControl().onlyIfCached()) {
                return candidate;
            }
            return new CacheStrategy(null, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v21, types: [long] */
        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1, types: [long] */
        /* JADX WARN: Type inference failed for: r0v90, types: [long] */
        /* JADX WARN: Type inference failed for: r14v4 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final okhttp3.internal.cache.CacheStrategy computeCandidate() {
            /*
            // Method dump skipped, instructions count: 458
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheStrategy.Factory.computeCandidate():okhttp3.internal.cache.CacheStrategy");
        }

        private final long computeFreshnessLifetime() {
            Response response = this.cacheResponse;
            Intrinsics.checkNotNull(response);
            CacheControl responseCaching = response.cacheControl();
            if (responseCaching.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis((long) responseCaching.maxAgeSeconds());
            }
            Date expires = this.expires;
            if (expires != null) {
                Date date = this.servedDate;
                Long valueOf = date == null ? null : Long.valueOf(date.getTime());
                long delta = expires.getTime() - (valueOf == null ? this.receivedResponseMillis : valueOf.longValue());
                if (delta > 0) {
                    return delta;
                }
                return 0;
            } else if (this.lastModified == null || this.cacheResponse.request().url().query() != null) {
                return 0;
            } else {
                Date date2 = this.servedDate;
                Long valueOf2 = date2 == null ? null : Long.valueOf(date2.getTime());
                long servedMillis = valueOf2 == null ? this.sentRequestMillis : valueOf2.longValue();
                Date date3 = this.lastModified;
                Intrinsics.checkNotNull(date3);
                long delta2 = servedMillis - date3.getTime();
                if (delta2 > 0) {
                    return delta2 / ((long) 10);
                }
                return 0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v31 */
        private final long cacheResponseAge() {
            long j;
            boolean z;
            Date servedDate = this.servedDate;
            if (servedDate != null) {
                j = Math.max(0L, this.receivedResponseMillis - servedDate.getTime());
            } else {
                j = 0;
            }
            if (this.ageSeconds != -1) {
                z = Math.max(j == 1 ? 1 : 0, TimeUnit.SECONDS.toMillis((long) this.ageSeconds));
            } else {
                z = j == 1 ? 1 : 0;
            }
            long responseDuration = this.receivedResponseMillis - this.sentRequestMillis;
            return (z == true ? 1 : 0) + responseDuration + (this.nowMillis - this.receivedResponseMillis);
        }

        private final boolean hasConditions(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }
    }

    /* compiled from: CacheStrategy.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m373d2 = {"Lokhttp3/internal/cache/CacheStrategy$Companion;", "", "()V", "isCacheable", "", "response", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/cache/CacheStrategy$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        public final boolean isCacheable(@NotNull Response response, @NotNull Request request) {
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(request, "request");
            switch (response.code()) {
                case 200:
                case 203:
                case 204:
                case 300:
                case 301:
                case 308:
                case 404:
                case 405:
                case 410:
                case 414:
                case 501:
                    break;
                default:
                    return false;
                case 302:
                case 307:
                    if (Response.header$default(response, "Expires", null, 2, null) == null && response.cacheControl().maxAgeSeconds() == -1 && !response.cacheControl().isPublic() && !response.cacheControl().isPrivate()) {
                        return false;
                    }
                    break;
            }
            return !response.cacheControl().noStore() && !request.cacheControl().noStore();
        }
    }
}
