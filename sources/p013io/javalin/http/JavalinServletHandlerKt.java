package p013io.javalin.http;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavalinServletHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��B\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ad\u0010��\u001a\u00020\u0001*\u00020\u00012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H��\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0002*\u0001\u0010\f\"(\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u0011`\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u00132W\u0012\u0004\u0012\u00020\u000e\u0012B\u0012@\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0014\u0012\u0004\u0012\u00020\u00050\u0003j\u0011`\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u0013*2\u0010\u0015\"\u000e\u0012\u0004\u0012\u0002`\u0014\u0012\u0004\u0012\u00020\u00050\u00032\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0014\u0012\u0004\u0012\u00020\u00050\u0003*\"\u0010\u0016\"\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u00032\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u0003¨\u0006\u0017"}, m373d2 = {"addListener", "Ljavax/servlet/AsyncContext;", "onComplete", "Lkotlin/Function1;", "Ljavax/servlet/AsyncEvent;", "", "onError", "onStartAsync", "onTimeout", "isAsync", "", "Lio/javalin/http/Context;", "StageInitializer", "Lkotlin/Function2;", "Lio/javalin/http/JavalinServletHandler;", "Lio/javalin/http/SubmitTask;", "Lkotlin/ParameterName;", "name", "submitTask", "Lkotlin/ExtensionFunctionType;", "Lio/javalin/http/TaskHandler;", "SubmitTask", "TaskHandler", "javalin"})
/* renamed from: io.javalin.http.JavalinServletHandlerKt */
/* loaded from: grasscutter.jar:io/javalin/http/JavalinServletHandlerKt.class */
public final class JavalinServletHandlerKt {
    public static final boolean isAsync(Context $this$isAsync) {
        return $this$isAsync.req.isAsyncStarted();
    }

    public static /* synthetic */ AsyncContext addListener$default(AsyncContext asyncContext, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = JavalinServletHandlerKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = JavalinServletHandlerKt$addListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            function13 = JavalinServletHandlerKt$addListener$3.INSTANCE;
        }
        if ((i & 8) != 0) {
            function14 = JavalinServletHandlerKt$addListener$4.INSTANCE;
        }
        return addListener(asyncContext, function1, function12, function13, function14);
    }

    @NotNull
    public static final AsyncContext addListener(@NotNull AsyncContext $this$addListener, @NotNull Function1<? super AsyncEvent, Unit> function1, @NotNull Function1<? super AsyncEvent, Unit> function12, @NotNull Function1<? super AsyncEvent, Unit> function13, @NotNull Function1<? super AsyncEvent, Unit> function14) {
        Intrinsics.checkNotNullParameter($this$addListener, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onComplete");
        Intrinsics.checkNotNullParameter(function12, "onError");
        Intrinsics.checkNotNullParameter(function13, "onStartAsync");
        Intrinsics.checkNotNullParameter(function14, "onTimeout");
        $this$addListener.addListener(new AsyncListener(function1, function12, function13, function14) { // from class: io.javalin.http.JavalinServletHandlerKt$addListener$5$1
            final /* synthetic */ Function1<AsyncEvent, Unit> $onComplete;
            final /* synthetic */ Function1<AsyncEvent, Unit> $onError;
            final /* synthetic */ Function1<AsyncEvent, Unit> $onStartAsync;
            final /* synthetic */ Function1<AsyncEvent, Unit> $onTimeout;

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super javax.servlet.AsyncEvent, kotlin.Unit> */
            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super javax.servlet.AsyncEvent, kotlin.Unit> */
            /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function1<? super javax.servlet.AsyncEvent, kotlin.Unit> */
            /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function1<? super javax.servlet.AsyncEvent, kotlin.Unit> */
            /* JADX WARN: Multi-variable type inference failed */
            /* access modifiers changed from: package-private */
            {
                this.$onComplete = r4;
                this.$onError = r5;
                this.$onStartAsync = r6;
                this.$onTimeout = r7;
            }

            @Override // javax.servlet.AsyncListener
            public void onComplete(@NotNull AsyncEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.$onComplete.invoke(event);
            }

            @Override // javax.servlet.AsyncListener
            public void onError(@NotNull AsyncEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.$onError.invoke(event);
            }

            @Override // javax.servlet.AsyncListener
            public void onStartAsync(@NotNull AsyncEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.$onStartAsync.invoke(event);
            }

            @Override // javax.servlet.AsyncListener
            public void onTimeout(@NotNull AsyncEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.$onTimeout.invoke(event);
            }
        });
        return $this$addListener;
    }
}
