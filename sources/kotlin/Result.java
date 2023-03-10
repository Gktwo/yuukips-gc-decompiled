package kotlin;

import java.io.Serializable;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: Result.kt */
@SinceKotlin(version = "1.3")
@JvmInline
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��8\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010��\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b@\u0018�� \"*\u0006\b��\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002\"#B\u0016\b\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001��¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00018��H\b¢\u0006\u0004\b\u0019\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058��X\u0004¢\u0006\b\n��\u0012\u0004\b\u000e\u0010\u000f\u0001\u0004\u0001\u0004\u0018\u00010\u0005ø\u0001��\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, m373d2 = {"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "getValue$annotations", "()V", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", Printer.TO_STRING, "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/Result.class */
public final class Result<T> implements Serializable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Object value;

    @PublishedApi
    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7057hashCodeimpl(Object arg0) {
        if (arg0 == null) {
            return 0;
        }
        return arg0.hashCode();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return m7057hashCodeimpl(this.value);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7058equalsimpl(Object arg0, Object other) {
        return (other instanceof Result) && Intrinsics.areEqual(arg0, ((Result) other).m7061unboximpl());
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        return m7058equalsimpl(this.value, other);
    }

    @PublishedApi
    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> Object m7059constructorimpl(@Nullable Object value) {
        return value;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Result m7060boximpl(Object v) {
        return new Result(v);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m7061unboximpl() {
        return this.value;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7062equalsimpl0(Object p1, Object p2) {
        return Intrinsics.areEqual(p1, p2);
    }

    @PublishedApi
    private /* synthetic */ Result(Object value) {
        this.value = value;
    }

    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m7052isSuccessimpl(Object arg0) {
        return !(arg0 instanceof Failure);
    }

    /* renamed from: isFailure-impl  reason: not valid java name */
    public static final boolean m7053isFailureimpl(Object arg0) {
        return arg0 instanceof Failure;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: getOrNull-impl  reason: not valid java name */
    private static final T m7054getOrNullimpl(Object arg0) {
        if (m7053isFailureimpl(arg0)) {
            return null;
        }
        return arg0;
    }

    @Nullable
    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m7055exceptionOrNullimpl(Object arg0) {
        if (arg0 instanceof Failure) {
            return ((Failure) arg0).exception;
        }
        return null;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return m7056toStringimpl(this.value);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7056toStringimpl(Object arg0) {
        return arg0 instanceof Failure ? ((Failure) arg0).toString() : "Success(" + arg0 + ')';
    }

    /* compiled from: Result.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001c\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\bø\u0001��¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\n\u001a\u0002H\u0005H\bø\u0001��¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m373d2 = {"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/Result$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @InlineOnly
        @JvmName(name = "success")
        private final <T> Object success(T t) {
            return Result.m7059constructorimpl(t);
        }

        @InlineOnly
        @JvmName(name = "failure")
        private final <T> Object failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return Result.m7059constructorimpl(ResultKt.createFailure(exception));
        }
    }

    /* compiled from: Result.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0010��\n��\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n��\b��\u0018��2\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u000e"}, m373d2 = {"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", Printer.TO_STRING, "", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/Result$Failure.class */
    public static final class Failure implements Serializable {
        @JvmField
        @NotNull
        public final Throwable exception;

        public Failure(@NotNull Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object other) {
            return (other instanceof Failure) && Intrinsics.areEqual(this.exception, ((Failure) other).exception);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.exception.hashCode();
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }
}
