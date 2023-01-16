package p013io.javalin.http.util;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.jetty.http.HttpStatus;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import p013io.javalin.http.Context;
import p013io.javalin.http.HttpResponseException;

/* compiled from: RateLimitUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��0\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n��R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��¨\u0006\u0011"}, m373d2 = {"Lio/javalin/http/util/RateLimiter;", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(Ljava/util/concurrent/TimeUnit;)V", "keyToRequestCount", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getTimeUnit", "()Ljava/util/concurrent/TimeUnit;", "timeUnitString", "incrementCounter", "", "ctx", "Lio/javalin/http/Context;", "requestLimit", "javalin"})
/* renamed from: io.javalin.http.util.RateLimiter */
/* loaded from: grasscutter.jar:io/javalin/http/util/RateLimiter.class */
public final class RateLimiter {
    @NotNull
    private final TimeUnit timeUnit;
    @NotNull
    private final String timeUnitString;
    @NotNull
    private final ConcurrentHashMap<String, Integer> keyToRequestCount;

    public RateLimiter(@NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.timeUnit = timeUnit;
        String timeUnit2 = this.timeUnit.toString();
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, Logger.ROOT_LOGGER_NAME);
        if (timeUnit2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = timeUnit2.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        this.timeUnitString = StringsKt.removeSuffix(lowerCase, (CharSequence) "s");
        ConcurrentHashMap it = new ConcurrentHashMap();
        RateLimitUtil.INSTANCE.getExecutor().scheduleAtFixedRate(() -> {
            m5851keyToRequestCount$lambda1$lambda0(r1);
        }, 0, 1, getTimeUnit());
        Unit unit = Unit.INSTANCE;
        this.keyToRequestCount = it;
    }

    @NotNull
    public final TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    /* renamed from: keyToRequestCount$lambda-1$lambda-0  reason: not valid java name */
    private static final void m5851keyToRequestCount$lambda1$lambda0(ConcurrentHashMap $it) {
        Intrinsics.checkNotNullParameter($it, "$it");
        $it.clear();
    }

    public final void incrementCounter(@NotNull Context ctx, int requestLimit) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.keyToRequestCount.compute(RateLimitUtil.INSTANCE.getKeyFunction().invoke(ctx), (v2, v3) -> {
            return m5852incrementCounter$lambda2(r2, r3, v2, v3);
        });
    }

    /* renamed from: incrementCounter$lambda-2  reason: not valid java name */
    private static final Integer m5852incrementCounter$lambda2(int $requestLimit, RateLimiter this$0, String $noName_0, Integer count) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($noName_0, "$noName_0");
        if (count == null) {
            return 1;
        }
        if (count.intValue() < $requestLimit) {
            return Integer.valueOf(count.intValue() + 1);
        }
        throw new HttpResponseException(HttpStatus.TOO_MANY_REQUESTS_429, "Rate limit exceeded - Server allows " + $requestLimit + " requests per " + this$0.timeUnitString + '.', null, 4, null);
    }
}
