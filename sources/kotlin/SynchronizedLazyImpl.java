package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: LazyJVM.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��0\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010��\n\u0002\b\u0006\n\u0002\u0010\u000b\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018��*\u0006\b��\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028��0\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n��R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028��\u0018\u00010\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n��R\u0014\u0010\u000b\u001a\u00028��8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, m373d2 = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", Printer.TO_STRING, "", "writeReplace", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/SynchronizedLazyImpl.class */
final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {
    @Nullable
    private Function0<? extends T> initializer;
    @Nullable
    private volatile Object _value;
    @NotNull
    private final Object lock;

    public SynchronizedLazyImpl(@NotNull Function0<? extends T> function0, @Nullable Object lock) {
        Intrinsics.checkNotNullParameter(function0, "initializer");
        this.initializer = function0;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
        Object obj = lock;
        this.lock = obj == null ? this : obj;
    }

    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? null : obj);
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t;
        T t2 = (T) this._value;
        if (t2 != UNINITIALIZED_VALUE.INSTANCE) {
            return t2;
        }
        synchronized (this.lock) {
            Object _v2 = this._value;
            if (_v2 != UNINITIALIZED_VALUE.INSTANCE) {
                t = (T) _v2;
            } else {
                Function0<? extends T> function0 = this.initializer;
                Intrinsics.checkNotNull(function0);
                Object typedValue = function0.invoke();
                this._value = typedValue;
                this.initializer = null;
                t = (T) typedValue;
            }
        }
        return t;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this._value != UNINITIALIZED_VALUE.INSTANCE;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
