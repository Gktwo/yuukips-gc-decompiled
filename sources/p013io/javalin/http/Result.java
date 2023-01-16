package p013io.javalin.http;

import com.sun.jna.Callback;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: JavalinServletHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n��\b\b\u0018��2\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\b\u0002\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\r\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005HÆ\u0003J\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0003J7\u0010\u0012\u001a\u00020��2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\b\u0002\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001b\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\b\n��\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, m373d2 = {"Lio/javalin/http/Result;", "", "previous", "Ljava/io/InputStream;", "future", "Ljava/util/concurrent/CompletableFuture;", Callback.METHOD_NAME, "Ljava/util/function/Consumer;", "(Ljava/io/InputStream;Ljava/util/concurrent/CompletableFuture;Ljava/util/function/Consumer;)V", "getCallback", "()Ljava/util/function/Consumer;", "getFuture", "()Ljava/util/concurrent/CompletableFuture;", "getPrevious", "()Ljava/io/InputStream;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", Printer.TO_STRING, "", "javalin"})
/* renamed from: io.javalin.http.Result */
/* loaded from: grasscutter.jar:io/javalin/http/Result.class */
public final class Result {
    @Nullable
    private final InputStream previous;
    @NotNull
    private final CompletableFuture<?> future;
    @Nullable
    private final Consumer<Object> callback;

    @Nullable
    public final InputStream component1() {
        return this.previous;
    }

    @NotNull
    public final CompletableFuture<?> component2() {
        return this.future;
    }

    @Nullable
    public final Consumer<Object> component3() {
        return this.callback;
    }

    @NotNull
    public final Result copy(@Nullable InputStream previous, @NotNull CompletableFuture<?> completableFuture, @Nullable Consumer<Object> consumer) {
        Intrinsics.checkNotNullParameter(completableFuture, "future");
        return new Result(previous, completableFuture, consumer);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.javalin.http.Result */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Result copy$default(Result result, InputStream inputStream, CompletableFuture completableFuture, Consumer consumer, int i, Object obj) {
        if ((i & 1) != 0) {
            inputStream = result.previous;
        }
        if ((i & 2) != 0) {
            completableFuture = result.future;
        }
        if ((i & 4) != 0) {
            consumer = result.callback;
        }
        return result.copy(inputStream, completableFuture, consumer);
    }

    @NotNull
    public String toString() {
        return "Result(previous=" + this.previous + ", future=" + this.future + ", callback=" + this.callback + ')';
    }

    public int hashCode() {
        return ((((this.previous == null ? 0 : this.previous.hashCode()) * 31) + this.future.hashCode()) * 31) + (this.callback == null ? 0 : this.callback.hashCode());
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Result)) {
            return false;
        }
        Result result = (Result) other;
        return Intrinsics.areEqual(this.previous, result.previous) && Intrinsics.areEqual(this.future, result.future) && Intrinsics.areEqual(this.callback, result.callback);
    }

    public Result() {
        this(null, null, null, 7, null);
    }

    public Result(@Nullable InputStream previous, @NotNull CompletableFuture<?> completableFuture, @Nullable Consumer<Object> consumer) {
        Intrinsics.checkNotNullParameter(completableFuture, "future");
        this.previous = previous;
        this.future = completableFuture;
        this.callback = consumer;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Result(java.io.InputStream r6, java.util.concurrent.CompletableFuture r7, java.util.function.Consumer r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r5 = this;
            r0 = r9
            r1 = 1
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0009
            r0 = 0
            r6 = r0
        L_0x0009:
            r0 = r9
            r1 = 2
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0020
            r0 = 0
            java.util.concurrent.CompletableFuture r0 = java.util.concurrent.CompletableFuture.completedFuture(r0)
            r11 = r0
            r0 = r11
            java.lang.String r1 = "completedFuture(null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0 = r11
            r7 = r0
        L_0x0020:
            r0 = r9
            r1 = 4
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0029
            r0 = 0
            r8 = r0
        L_0x0029:
            r0 = r5
            r1 = r6
            r2 = r7
            r3 = r8
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.http.Result.<init>(java.io.InputStream, java.util.concurrent.CompletableFuture, java.util.function.Consumer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Nullable
    public final InputStream getPrevious() {
        return this.previous;
    }

    @NotNull
    public final CompletableFuture<?> getFuture() {
        return this.future;
    }

    @Nullable
    public final Consumer<Object> getCallback() {
        return this.callback;
    }
}
