package p013io.javalin.http;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.core.JavalinConfig;
import p013io.javalin.core.util.LogUtil;

/* compiled from: JavalinServletHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��h\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001BG\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\b\u0010#\u001a\u00020$H\u0002J\r\u0010%\u001a\u00020$H��¢\u0006\u0002\b&J\b\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n��\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n��R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n��R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n��R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n��R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n��\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n��\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n��R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0003X\u0004¢\u0006\u0002\n��¨\u0006)"}, m373d2 = {"Lio/javalin/http/JavalinServletHandler;", "", "stages", "Ljava/util/ArrayDeque;", "Lio/javalin/http/Stage;", "config", "Lio/javalin/core/JavalinConfig;", "errorMapper", "Lio/javalin/http/ErrorMapper;", "exceptionMapper", "Lio/javalin/http/ExceptionMapper;", "ctx", "Lio/javalin/http/Context;", "requestType", "Lio/javalin/http/HandlerType;", "requestUri", "", "(Ljava/util/ArrayDeque;Lio/javalin/core/JavalinConfig;Lio/javalin/http/ErrorMapper;Lio/javalin/http/ExceptionMapper;Lio/javalin/http/Context;Lio/javalin/http/HandlerType;Ljava/lang/String;)V", "getCtx", "()Lio/javalin/http/Context;", "currentTaskFuture", "Ljava/util/concurrent/CompletableFuture;", "Ljava/io/InputStream;", "errored", "", "finished", "Ljava/util/concurrent/atomic/AtomicBoolean;", "previousResult", "getRequestType", "()Lio/javalin/http/HandlerType;", "getRequestUri", "()Ljava/lang/String;", "tasks", "Lio/javalin/http/Task;", "executeNextTask", "finishResponse", "", "queueNextTaskOrFinish", "queueNextTaskOrFinish$javalin", "startAsyncAndAddDefaultTimeoutListeners", "Ljavax/servlet/AsyncContext;", "javalin"})
/* renamed from: io.javalin.http.JavalinServletHandler */
/* loaded from: grasscutter.jar:io/javalin/http/JavalinServletHandler.class */
public final class JavalinServletHandler {
    @NotNull
    private final ArrayDeque<Stage> stages;
    @NotNull
    private final JavalinConfig config;
    @NotNull
    private final ErrorMapper errorMapper;
    @NotNull
    private final ExceptionMapper exceptionMapper;
    @NotNull
    private final Context ctx;
    @NotNull
    private final HandlerType requestType;
    @NotNull
    private final String requestUri;
    @NotNull
    private final ArrayDeque<Task> tasks;
    @NotNull
    private CompletableFuture<InputStream> currentTaskFuture;
    @Nullable
    private InputStream previousResult;
    private boolean errored;
    @NotNull
    private final AtomicBoolean finished;

    public JavalinServletHandler(@NotNull ArrayDeque<Stage> arrayDeque, @NotNull JavalinConfig config, @NotNull ErrorMapper errorMapper, @NotNull ExceptionMapper exceptionMapper, @NotNull Context ctx, @NotNull HandlerType requestType, @NotNull String requestUri) {
        Intrinsics.checkNotNullParameter(arrayDeque, "stages");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(errorMapper, "errorMapper");
        Intrinsics.checkNotNullParameter(exceptionMapper, "exceptionMapper");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        Intrinsics.checkNotNullParameter(requestUri, "requestUri");
        this.stages = arrayDeque;
        this.config = config;
        this.errorMapper = errorMapper;
        this.exceptionMapper = exceptionMapper;
        this.ctx = ctx;
        this.requestType = requestType;
        this.requestUri = requestUri;
        this.tasks = new ArrayDeque<>(4);
        CompletableFuture<InputStream> completedFuture = CompletableFuture.completedFuture(null);
        Intrinsics.checkNotNullExpressionValue(completedFuture, "completedFuture(null)");
        this.currentTaskFuture = completedFuture;
        this.finished = new AtomicBoolean(false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ JavalinServletHandler(java.util.ArrayDeque r10, p013io.javalin.core.JavalinConfig r11, p013io.javalin.http.ErrorMapper r12, p013io.javalin.http.ExceptionMapper r13, p013io.javalin.http.Context r14, p013io.javalin.http.HandlerType r15, java.lang.String r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r9 = this;
            r0 = r17
            r1 = 32
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0015
            io.javalin.http.HandlerType$Companion r0 = p013io.javalin.http.HandlerType.Companion
            r1 = r14
            javax.servlet.http.HttpServletRequest r1 = r1.req
            io.javalin.http.HandlerType r0 = r0.fromServletRequest(r1)
            r15 = r0
        L_0x0015:
            r0 = r17
            r1 = 64
            r0 = r0 & r1
            if (r0 == 0) goto L_0x004f
            r0 = r14
            javax.servlet.http.HttpServletRequest r0 = r0.req
            java.lang.String r0 = r0.getRequestURI()
            r19 = r0
            r0 = r19
            java.lang.String r1 = "class JavalinServletHand…ctions\n        }\n    }\n\n}"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0 = r19
            r1 = r14
            javax.servlet.http.HttpServletRequest r1 = r1.req
            java.lang.String r1 = r1.getContextPath()
            r19 = r1
            r1 = r19
            java.lang.String r2 = "class JavalinServletHand…ctions\n        }\n    }\n\n}"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r1 = r19
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r0 = kotlin.text.StringsKt.removePrefix(r0, r1)
            r16 = r0
        L_0x004f:
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.http.JavalinServletHandler.<init>(java.util.ArrayDeque, io.javalin.core.JavalinConfig, io.javalin.http.ErrorMapper, io.javalin.http.ExceptionMapper, io.javalin.http.Context, io.javalin.http.HandlerType, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @NotNull
    public final Context getCtx() {
        return this.ctx;
    }

    @NotNull
    public final HandlerType getRequestType() {
        return this.requestType;
    }

    @NotNull
    public final String getRequestUri() {
        return this.requestUri;
    }

    public final void queueNextTaskOrFinish$javalin() {
        while (this.tasks.isEmpty()) {
            if (!(!this.stages.isEmpty())) {
                break;
            }
            Stage stage = this.stages.poll();
            stage.getInitializer().invoke(this, new Function1<Function1<? super JavalinServletHandler, ? extends Unit>, Unit>(this, stage) { // from class: io.javalin.http.JavalinServletHandler$queueNextTaskOrFinish$1
                final /* synthetic */ JavalinServletHandler this$0;
                final /* synthetic */ Stage $stage;

                /* access modifiers changed from: package-private */
                {
                    this.this$0 = $receiver;
                    this.$stage = $stage;
                }

                public final void invoke(@NotNull Function1<? super JavalinServletHandler, Unit> function1) {
                    Intrinsics.checkNotNullParameter(function1, "taskHandler");
                    ArrayDeque access$getTasks$p = JavalinServletHandler.access$getTasks$p(this.this$0);
                    Stage stage2 = this.$stage;
                    Intrinsics.checkNotNullExpressionValue(stage2, "stage");
                    access$getTasks$p.offer(new Task(stage2, function1));
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Function1<? super JavalinServletHandler, ? extends Unit> function1) {
                    invoke((Function1<? super JavalinServletHandler, Unit>) function1);
                    return Unit.INSTANCE;
                }
            });
        }
        if (this.tasks.isEmpty()) {
            finishResponse();
            return;
        }
        CompletableFuture<InputStream> exceptionally = this.currentTaskFuture.thenAccept((v1) -> {
            m5825queueNextTaskOrFinish$lambda0(r2, v1);
        }).thenCompose((v1) -> {
            return m5826queueNextTaskOrFinish$lambda1(r2, v1);
        }).exceptionally((Function<Throwable, ? extends U>) (v1) -> {
            return m5827queueNextTaskOrFinish$lambda2(r2, v1);
        });
        Intrinsics.checkNotNullExpressionValue(exceptionally, "currentTaskFuture\n      …ble(ctx.res, throwable) }");
        this.currentTaskFuture = exceptionally;
    }

    /* renamed from: queueNextTaskOrFinish$lambda-0  reason: not valid java name */
    private static final void m5825queueNextTaskOrFinish$lambda0(JavalinServletHandler this$0, InputStream inputStream) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.previousResult = inputStream;
    }

    /* renamed from: queueNextTaskOrFinish$lambda-1  reason: not valid java name */
    private static final CompletionStage m5826queueNextTaskOrFinish$lambda1(JavalinServletHandler this$0, Void it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.executeNextTask();
    }

    /* renamed from: queueNextTaskOrFinish$lambda-2  reason: not valid java name */
    private static final InputStream m5827queueNextTaskOrFinish$lambda2(JavalinServletHandler this$0, Throwable throwable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExceptionMapper exceptionMapper = this$0.exceptionMapper;
        HttpServletResponse httpServletResponse = this$0.getCtx().res;
        Intrinsics.checkNotNullExpressionValue(throwable, "throwable");
        return (InputStream) exceptionMapper.handleUnexpectedThrowable$javalin(httpServletResponse, throwable);
    }

    private final CompletableFuture<InputStream> executeNextTask() {
        Result result;
        Task task = this.tasks.poll();
        if (!this.errored || !task.getStage().getHaltsOnError()) {
            boolean wasAsync = JavalinServletHandlerKt.isAsync(this.ctx);
            try {
                task.getHandler().invoke(this);
            } catch (Exception exception) {
                this.errored = true;
                ((Result) this.ctx.getResultReference$javalin().getAndSet(new Result(this.previousResult, null, null, 6, null))).getFuture().cancel(true);
                this.exceptionMapper.handle$javalin(exception, this.ctx);
            }
            Result result2 = (Result) this.ctx.getResultReference$javalin().getAndSet(new Result(this.previousResult, null, null, 6, null));
            if (!(JavalinServletHandlerKt.isAsync(getCtx())) || wasAsync) {
                result = result2;
            } else {
                Intrinsics.checkNotNullExpressionValue(result2, "result");
                result = Result.copy$default(result2, null, new CompletableFuture(), null, 5, null);
            }
            if (!(JavalinServletHandlerKt.isAsync(getCtx())) && !result.getFuture().isDone()) {
                startAsyncAndAddDefaultTimeoutListeners();
            }
            if (JavalinServletHandlerKt.isAsync(getCtx())) {
                AsyncContext asyncContext = getCtx().req.getAsyncContext();
                Intrinsics.checkNotNullExpressionValue(asyncContext, "ctx.req.asyncContext");
                JavalinServletHandlerKt.addListener$default(asyncContext, null, null, null, new Function1<AsyncEvent, Unit>(result) { // from class: io.javalin.http.JavalinServletHandler$executeNextTask$3$1
                    final /* synthetic */ Result $result;

                    /* access modifiers changed from: package-private */
                    {
                        this.$result = $result;
                    }

                    public final void invoke(@NotNull AsyncEvent it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        this.$result.getFuture().cancel(true);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AsyncEvent asyncEvent) {
                        invoke(asyncEvent);
                        return Unit.INSTANCE;
                    }
                }, 7, null);
            }
            CompletableFuture<InputStream> thenApply = result.getFuture().thenAccept((v2) -> {
                m5828executeNextTask$lambda11$lambda6(r1, r2, v2);
            }).thenApply((v1) -> {
                return m5829executeNextTask$lambda11$lambda7(r1, v1);
            }).exceptionally((Function<Throwable, ? extends U>) (v1) -> {
                return m5830executeNextTask$lambda11$lambda8(r1, v1);
            }).thenApply((v1) -> {
                return m5831executeNextTask$lambda11$lambda10(r1, v1);
            });
            Intrinsics.checkNotNullExpressionValue(thenApply, "ctx.resultReference.getA…ping a void\n            }");
            return thenApply;
        }
        queueNextTaskOrFinish$javalin();
        CompletableFuture<InputStream> completedFuture = CompletableFuture.completedFuture(this.previousResult);
        Intrinsics.checkNotNullExpressionValue(completedFuture, "completedFuture(previousResult)");
        return completedFuture;
    }

    /* renamed from: executeNextTask$lambda-11$lambda-6  reason: not valid java name */
    private static final void m5828executeNextTask$lambda11$lambda6(Result $result, JavalinServletHandler this$0, Object any) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Consumer<Object> callback = $result.getCallback();
        if (callback == null) {
            unit = null;
        } else {
            callback.accept(any);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ContextResolverKt.contextResolver(this$0.getCtx()).defaultFutureCallback.invoke(this$0.getCtx(), any);
        }
    }

    /* renamed from: executeNextTask$lambda-11$lambda-7  reason: not valid java name */
    private static final InputStream m5829executeNextTask$lambda11$lambda7(JavalinServletHandler this$0, Void it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InputStream resultStream = this$0.getCtx().resultStream();
        return resultStream == null ? this$0.previousResult : resultStream;
    }

    /* renamed from: executeNextTask$lambda-11$lambda-8  reason: not valid java name */
    private static final InputStream m5830executeNextTask$lambda11$lambda8(JavalinServletHandler this$0, Throwable throwable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExceptionMapper exceptionMapper = this$0.exceptionMapper;
        Context ctx = this$0.getCtx();
        Intrinsics.checkNotNullExpressionValue(throwable, "throwable");
        return (InputStream) exceptionMapper.handleFutureException$javalin(ctx, throwable);
    }

    /* renamed from: executeNextTask$lambda-11$lambda-10  reason: not valid java name */
    private static final InputStream m5831executeNextTask$lambda11$lambda10(JavalinServletHandler this$0, InputStream inputStream) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.queueNextTaskOrFinish$javalin();
        return inputStream;
    }

    private final AsyncContext startAsyncAndAddDefaultTimeoutListeners() {
        AsyncContext startAsync = this.ctx.req.startAsync();
        Intrinsics.checkNotNullExpressionValue(startAsync, "ctx.req.startAsync()");
        AsyncContext asyncCtx = JavalinServletHandlerKt.addListener$default(startAsync, null, null, null, new Function1<AsyncEvent, Unit>(this) { // from class: io.javalin.http.JavalinServletHandler$startAsyncAndAddDefaultTimeoutListeners$1
            final /* synthetic */ JavalinServletHandler this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
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
                JavalinServletHandler.access$getCurrentTaskFuture$p(this.this$0).cancel(true);
                this.this$0.getCtx().status(500).result("Request timed out");
                JavalinServletHandler.access$getErrorMapper$p(this.this$0).handle(this.this$0.getCtx().status(), this.this$0.getCtx());
                JavalinServletHandler.access$finishResponse(this.this$0);
            }
        }, 7, null);
        Long l = this.config.asyncRequestTimeout;
        Intrinsics.checkNotNullExpressionValue(l, "config.asyncRequestTimeout");
        asyncCtx.setTimeout(l.longValue());
        return asyncCtx;
    }

    /* access modifiers changed from: private */
    public final void finishResponse() {
        if (!this.finished.getAndSet(true)) {
            try {
                new JavalinResponseWrapper(this.ctx, this.config, this.requestType).write(this.ctx.resultStream());
                RequestLogger requestLogger = this.config.inner.requestLogger;
                if (requestLogger != null) {
                    requestLogger.handle(this.ctx, Float.valueOf(LogUtil.INSTANCE.executionTimeMs(this.ctx)));
                }
                if (JavalinServletHandlerKt.isAsync(this.ctx)) {
                    this.ctx.req.getAsyncContext().complete();
                }
            } catch (Throwable th) {
                if (JavalinServletHandlerKt.isAsync(this.ctx)) {
                    this.ctx.req.getAsyncContext().complete();
                }
                throw th;
            }
        }
    }
}
