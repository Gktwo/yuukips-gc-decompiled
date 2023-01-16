package p013io.javalin.http;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletionException;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.core.util.JavalinLogger;
import p013io.javalin.core.util.Util;
import p013io.javalin.jetty.JettyUtil;

/* compiled from: ExceptionMapper.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��R\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n��\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u000e\u001a\u00020\u000fH��¢\u0006\u0002\b\u0010J\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H��¢\u0006\u0002\b\u0015J\u001f\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H��¢\u0006\u0002\b\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001c\u001a\u00060\u0006j\u0002`\u0007H\u0002R5\u0010\u0003\u001a&\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u00060\u0006j\u0002`\u00070\u0005\u0012\u0010\u0012\u000e\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\b0\u0004¢\u0006\b\n��\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, m373d2 = {"Lio/javalin/http/ExceptionMapper;", "", "()V", "handlers", "", "Ljava/lang/Class;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lio/javalin/http/ExceptionHandler;", "getHandlers", "()Ljava/util/Map;", "handle", "", "exception", "ctx", "Lio/javalin/http/Context;", "handle$javalin", "handleFutureException", "", "throwable", "", "handleFutureException$javalin", "handleUnexpectedThrowable", "res", "Ljavax/servlet/http/HttpServletResponse;", "handleUnexpectedThrowable$javalin", "noUserHandler", "", "e", "javalin"})
/* renamed from: io.javalin.http.ExceptionMapper */
/* loaded from: grasscutter.jar:io/javalin/http/ExceptionMapper.class */
public final class ExceptionMapper {
    @NotNull
    private final Map<Class<? extends Exception>, ExceptionHandler<Exception>> handlers = new LinkedHashMap();

    @NotNull
    public final Map<Class<? extends Exception>, ExceptionHandler<Exception>> getHandlers() {
        return this.handlers;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: io.javalin.core.util.Util */
    /* JADX WARN: Multi-variable type inference failed */
    public final void handle$javalin(@NotNull Exception exception, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (!HttpResponseExceptionMapper.INSTANCE.canHandle(exception) || !noUserHandler(exception)) {
            ExceptionHandler exceptionHandler = (ExceptionHandler) Util.INSTANCE.findByClass(this.handlers, exception.getClass());
            if (exceptionHandler != null) {
                exceptionHandler.handle(exception, ctx);
                return;
            }
            JavalinLogger.warn("Uncaught exception", exception);
            HttpResponseExceptionMapper.INSTANCE.handle(new InternalServerErrorResponse(null, null, 3, null), ctx);
            return;
        }
        HttpResponseExceptionMapper.INSTANCE.handle(exception, ctx);
    }

    @Nullable
    public final Void handleFutureException$javalin(@NotNull Context ctx, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if ((throwable instanceof CompletionException) && (throwable.getCause() instanceof Exception)) {
            Throwable cause = throwable.getCause();
            if (cause == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Exception{ kotlin.TypeAliasesKt.Exception }");
            }
            handle$javalin((Exception) cause, ctx);
            return null;
        } else if (!(throwable instanceof Exception)) {
            return null;
        } else {
            handle$javalin((Exception) throwable, ctx);
            return null;
        }
    }

    @Nullable
    public final Void handleUnexpectedThrowable$javalin(@NotNull HttpServletResponse res, @NotNull Throwable throwable) {
        Throwable unwrapped;
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        CompletionException completionException = throwable instanceof CompletionException ? (CompletionException) throwable : null;
        if (completionException == null) {
            unwrapped = throwable;
        } else {
            Throwable cause = completionException.getCause();
            unwrapped = cause == null ? throwable : cause;
        }
        if (JettyUtil.INSTANCE.isClientAbortException(unwrapped) || JettyUtil.INSTANCE.isJettyTimeoutException(unwrapped)) {
            JavalinLogger.debug("Client aborted or timed out", throwable);
            return null;
        }
        res.setStatus(500);
        JavalinLogger.error("Exception occurred while servicing http-request", throwable);
        return null;
    }

    private final boolean noUserHandler(Exception e) {
        return this.handlers.get(e.getClass()) == null && this.handlers.get(HttpResponseException.class) == null;
    }
}
