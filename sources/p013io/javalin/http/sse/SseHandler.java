package p013io.javalin.http.sse;

import java.util.function.Consumer;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.core.util.Header;
import p013io.javalin.http.Context;
import p013io.javalin.http.Handler;
import p013io.javalin.http.JavalinServletHandlerKt;

/* compiled from: SseHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B\u001f\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��¨\u0006\f"}, m373d2 = {"Lio/javalin/http/sse/SseHandler;", "Lio/javalin/http/Handler;", "timeout", "", "clientConsumer", "Ljava/util/function/Consumer;", "Lio/javalin/http/sse/SseClient;", "(JLjava/util/function/Consumer;)V", "handle", "", "ctx", "Lio/javalin/http/Context;", "javalin"})
/* renamed from: io.javalin.http.sse.SseHandler */
/* loaded from: grasscutter.jar:io/javalin/http/sse/SseHandler.class */
public final class SseHandler implements Handler {
    private final long timeout;
    @NotNull
    private final Consumer<SseClient> clientConsumer;

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SseHandler(@NotNull Consumer<SseClient> consumer) {
        this(0, consumer, 1, null);
        Intrinsics.checkNotNullParameter(consumer, "clientConsumer");
    }

    @JvmOverloads
    public SseHandler(long timeout, @NotNull Consumer<SseClient> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clientConsumer");
        this.timeout = timeout;
        this.clientConsumer = consumer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    public /* synthetic */ SseHandler(long j, Consumer consumer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(((i & 1) != 0 ? 0 : j) == true ? 1 : 0, consumer);
    }

    @Override // p013io.javalin.http.Handler
    public void handle(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (Intrinsics.areEqual(ctx.header("Accept"), "text/event-stream")) {
            HttpServletResponse $this$handle_u24lambda_u2d0 = ctx.res;
            $this$handle_u24lambda_u2d0.setStatus(200);
            $this$handle_u24lambda_u2d0.setCharacterEncoding("UTF-8");
            $this$handle_u24lambda_u2d0.setContentType("text/event-stream");
            $this$handle_u24lambda_u2d0.addHeader("Connection", "close");
            $this$handle_u24lambda_u2d0.addHeader("Cache-Control", "no-cache");
            $this$handle_u24lambda_u2d0.addHeader(Header.X_ACCEL_BUFFERING, "no");
            $this$handle_u24lambda_u2d0.flushBuffer();
            AsyncContext asyncContext = ctx.req.startAsync(ctx.req, ctx.res);
            asyncContext.setTimeout(this.timeout);
            Intrinsics.checkNotNullExpressionValue(asyncContext, "asyncContext");
            JavalinServletHandlerKt.addListener$default(asyncContext, null, new Function1<AsyncEvent, Unit>(asyncContext) { // from class: io.javalin.http.sse.SseHandler$handle$2$1
                final /* synthetic */ AsyncContext $asyncContext;

                /* access modifiers changed from: package-private */
                {
                    this.$asyncContext = $asyncContext;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AsyncEvent asyncEvent) {
                    invoke(asyncEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull AsyncEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.$asyncContext.complete();
                }
            }, null, new Function1<AsyncEvent, Unit>(asyncContext) { // from class: io.javalin.http.sse.SseHandler$handle$2$2
                final /* synthetic */ AsyncContext $asyncContext;

                /* access modifiers changed from: package-private */
                {
                    this.$asyncContext = $asyncContext;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AsyncEvent asyncEvent) {
                    invoke(asyncEvent);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull AsyncEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.$asyncContext.complete();
                }
            }, 5, null);
            this.clientConsumer.accept(new SseClient(ctx));
        }
    }
}
