package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* compiled from: Lazy.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��\u0018\n��\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010��\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b��\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0005\u001a\u0002H\u0002\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\n¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m373d2 = {"lazyOf", "Lkotlin/Lazy;", "T", "value", "(Ljava/lang/Object;)Lkotlin/Lazy;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Lkotlin/Lazy;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "kotlin-stdlib"}, m368xs = "kotlin/LazyKt")
/* loaded from: grasscutter.jar:kotlin/LazyKt__LazyKt.class */
class LazyKt__LazyKt extends LazyJVM {
    @NotNull
    public static final <T> Lazy<T> lazyOf(T t) {
        return new InitializedLazyImpl(t);
    }

    @InlineOnly
    private static final <T> T getValue(Lazy<? extends T> lazy, Object thisRef, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(lazy, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return (T) lazy.getValue();
    }
}
