package kotlin;

import kotlin.Result;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Result.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��:\n��\n\u0002\u0010��\n��\n\u0002\u0010\u0003\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a.\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b��\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\bø\u0001��ø\u0001\u0001¢\u0006\u0002\u0010\t\u001a\u0001\u0010\n\u001a\u0002H\u0006\"\u0004\b��\u0010\u0006\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\f\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00060\r2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\bø\u0001��ø\u0001\u0001\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 ��\n\b\b\u0001\u0012\u0002\u0010\u0002 ��¢\u0006\u0002\u0010\u0012\u001a3\u0010\u0013\u001a\u0002H\u0006\"\u0004\b��\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052\u0006\u0010\u0014\u001a\u0002H\u0006H\bø\u0001��¢\u0006\u0002\u0010\u0015\u001a^\u0010\u0016\u001a\u0002H\u0006\"\u0004\b��\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\bø\u0001��ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 ��¢\u0006\u0002\u0010\u0017\u001a!\u0010\u0018\u001a\u0002H\u000b\"\u0004\b��\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u0005H\bø\u0001��¢\u0006\u0002\u0010\u0019\u001a`\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b��\u0010\u0006\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00060\rH\bø\u0001��ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 ��¢\u0006\u0002\u0010\u0017\u001aS\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b��\u0010\u0006\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00060\rH\bø\u0001��ø\u0001\u0001¢\u0006\u0002\u0010\u0017\u001aZ\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0005\"\u0004\b��\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u001e0\rH\bø\u0001��ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 ��¢\u0006\u0002\u0010\u0017\u001aZ\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0005\"\u0004\b��\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u001e0\rH\bø\u0001��ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 ��¢\u0006\u0002\u0010\u0017\u001ad\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b��\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\bø\u0001��ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 ��¢\u0006\u0002\u0010\u0017\u001aW\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b��\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\bø\u0001��ø\u0001\u0001¢\u0006\u0002\u0010\u0017\u001aC\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b��\u0010\u000b\"\u0004\b\u0001\u0010\u0006*\u0002H\u000b2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00060\r¢\u0006\u0002\b!H\bø\u0001��ø\u0001\u0001¢\u0006\u0002\u0010\u0017\u001a\u0018\u0010\"\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u0005H\u0001ø\u0001��¢\u0006\u0002\u0010#\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006$"}, m373d2 = {"createFailure", "", "exception", "", "runCatching", "Lkotlin/Result;", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "fold", "T", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "onFailure", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "map", "transform", "mapCatching", "action", "", "recover", "recoverCatching", "Lkotlin/ExtensionFunctionType;", "throwOnFailure", "(Ljava/lang/Object;)V", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/ResultKt.class */
public final class ResultKt {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Object createFailure(@NotNull Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        return new Result.Failure(exception);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final void throwOnFailure(@NotNull Object $this$throwOnFailure) {
        if ($this$throwOnFailure instanceof Result.Failure) {
            throw ((Result.Failure) $this$throwOnFailure).exception;
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R> Object runCatching(Function0<? extends R> function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m7059constructorimpl(function0.invoke());
        } catch (Throwable e) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m7059constructorimpl(createFailure(e));
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T, R> Object runCatching(T t, Function1<? super T, ? extends R> function1) {
        Object obj;
        Intrinsics.checkNotNullParameter(function1, "block");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m7059constructorimpl(function1.invoke(t));
        } catch (Throwable e) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m7059constructorimpl(createFailure(e));
        }
        return obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> T getOrThrow(Object $this$getOrThrow) {
        throwOnFailure($this$getOrThrow);
        return $this$getOrThrow;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R getOrElse(Object $this$getOrElse, Function1<? super Throwable, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "onFailure");
        Throwable exception = Result.m7055exceptionOrNullimpl($this$getOrElse);
        return exception == null ? $this$getOrElse : (R) function1.invoke(exception);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R getOrDefault(Object $this$getOrDefault, R r) {
        return Result.m7053isFailureimpl($this$getOrDefault) ? r : $this$getOrDefault;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> R fold(Object $this$fold, Function1<? super T, ? extends R> function1, Function1<? super Throwable, ? extends R> function12) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onFailure");
        Throwable exception = Result.m7055exceptionOrNullimpl($this$fold);
        return exception == null ? (R) function1.invoke($this$fold) : (R) function12.invoke(exception);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object map(Object $this$map, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "transform");
        if (!Result.m7052isSuccessimpl($this$map)) {
            return Result.m7059constructorimpl($this$map);
        }
        Result.Companion companion = Result.Companion;
        return Result.m7059constructorimpl(function1.invoke($this$map));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object mapCatching(Object $this$mapCatching, Function1<? super T, ? extends R> function1) {
        Object obj;
        Intrinsics.checkNotNullParameter(function1, "transform");
        if (!Result.m7052isSuccessimpl($this$mapCatching)) {
            return Result.m7059constructorimpl($this$mapCatching);
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m7059constructorimpl(function1.invoke($this$mapCatching));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m7059constructorimpl(createFailure(th));
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> Object recover(Object $this$recover, Function1<? super Throwable, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "transform");
        Throwable exception = Result.m7055exceptionOrNullimpl($this$recover);
        if (exception == null) {
            return $this$recover;
        }
        Result.Companion companion = Result.Companion;
        return Result.m7059constructorimpl(function1.invoke(exception));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> Object recoverCatching(Object $this$recoverCatching, Function1<? super Throwable, ? extends R> function1) {
        Object obj;
        Intrinsics.checkNotNullParameter(function1, "transform");
        Throwable exception = Result.m7055exceptionOrNullimpl($this$recoverCatching);
        if (exception == null) {
            return $this$recoverCatching;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m7059constructorimpl(function1.invoke(exception));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m7059constructorimpl(createFailure(th));
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object onFailure(Object $this$onFailure, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        Throwable it = Result.m7055exceptionOrNullimpl($this$onFailure);
        if (it != null) {
            function1.invoke(it);
        }
        return $this$onFailure;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object onSuccess(Object $this$onSuccess, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        if (Result.m7052isSuccessimpl($this$onSuccess)) {
            function1.invoke($this$onSuccess);
        }
        return $this$onSuccess;
    }
}
