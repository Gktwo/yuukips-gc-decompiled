package p013io.javalin.http.util;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;

/* compiled from: RateLimitUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\tH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\b\n��\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, m373d2 = {"Lio/javalin/http/util/RateLimitUtil;", "", "()V", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "getExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "keyFunction", "Lkotlin/Function1;", "Lio/javalin/http/Context;", "", "getKeyFunction", "()Lkotlin/jvm/functions/Function1;", "setKeyFunction", "(Lkotlin/jvm/functions/Function1;)V", "limiters", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/TimeUnit;", "Lio/javalin/http/util/RateLimiter;", "getLimiters", "()Ljava/util/concurrent/ConcurrentHashMap;", "ip", "ctx", "javalin"})
/* renamed from: io.javalin.http.util.RateLimitUtil */
/* loaded from: grasscutter.jar:io/javalin/http/util/RateLimitUtil.class */
public final class RateLimitUtil {
    @NotNull
    public static final RateLimitUtil INSTANCE = new RateLimitUtil();
    @NotNull
    private static final ConcurrentHashMap<TimeUnit, RateLimiter> limiters = new ConcurrentHashMap<>();
    @NotNull
    private static Function1<? super Context, String> keyFunction = RateLimitUtil$keyFunction$1.INSTANCE;
    @NotNull
    private static final ScheduledExecutorService executor;

    private RateLimitUtil() {
    }

    @NotNull
    public final ConcurrentHashMap<TimeUnit, RateLimiter> getLimiters() {
        return limiters;
    }

    static {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor()");
        executor = newSingleThreadScheduledExecutor;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super io.javalin.http.Context, java.lang.String>, kotlin.jvm.functions.Function1<io.javalin.http.Context, java.lang.String> */
    @NotNull
    public final Function1<Context, String> getKeyFunction() {
        return keyFunction;
    }

    public final void setKeyFunction(@NotNull Function1<? super Context, String> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        keyFunction = function1;
    }

    @NotNull
    public final ScheduledExecutorService getExecutor() {
        return executor;
    }

    /* access modifiers changed from: private */
    /* renamed from: ip */
    public final String m1184ip(Context ctx) {
        String str;
        String header = ctx.header("X-Forwarded-For");
        if (header == null) {
            str = null;
        } else {
            List split$default = StringsKt.split$default((CharSequence) header, new String[]{","}, false, 0, 6, (Object) null);
            str = split$default == null ? null : (String) split$default.get(0);
        }
        return str == null ? ctx.m1185ip() : str;
    }
}
