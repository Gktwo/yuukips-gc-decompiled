package p013io.javalin.http.util;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;

/* compiled from: RateLimitUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��$\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n��\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, m373d2 = {"Lio/javalin/http/util/NaiveRateLimit;", "", "()V", "requestPerTimeUnit", "", "ctx", "Lio/javalin/http/Context;", "numRequests", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "javalin"})
/* renamed from: io.javalin.http.util.NaiveRateLimit */
/* loaded from: grasscutter.jar:io/javalin/http/util/NaiveRateLimit.class */
public final class NaiveRateLimit {
    @NotNull
    public static final NaiveRateLimit INSTANCE = new NaiveRateLimit();

    private NaiveRateLimit() {
    }

    @JvmStatic
    public static final void requestPerTimeUnit(@NotNull Context ctx, int numRequests, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        RateLimitUtil.INSTANCE.getLimiters().computeIfAbsent(timeUnit, (v1) -> {
            return m5844requestPerTimeUnit$lambda0(r2, v1);
        }).incrementCounter(ctx, numRequests);
    }

    /* renamed from: requestPerTimeUnit$lambda-0  reason: not valid java name */
    private static final RateLimiter m5844requestPerTimeUnit$lambda0(TimeUnit $timeUnit, TimeUnit it) {
        Intrinsics.checkNotNullParameter($timeUnit, "$timeUnit");
        Intrinsics.checkNotNullParameter(it, "it");
        return new RateLimiter($timeUnit);
    }
}
