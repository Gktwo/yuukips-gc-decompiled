package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��4\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010��\u001a\u0002H\u0001\"\u0004\b��\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\n¢\u0006\u0002\u0010\u0007\u001a>\u0010��\u001a\u0002H\u0001\"\u0004\b��\u0010\b\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00010\t2\u0006\u0010\u0003\u001a\u0002H\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\n¢\u0006\u0002\u0010\n\u001a<\u0010\u000b\u001a\u00020\f\"\u0004\b��\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000e\u001a\u0002H\u0001H\n¢\u0006\u0002\u0010\u000f\u001aF\u0010\u000b\u001a\u00020\f\"\u0004\b��\u0010\b\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00010\u00102\u0006\u0010\u0003\u001a\u0002H\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000e\u001a\u0002H\u0001H\n¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, m373d2 = {"getValue", "V", "Lkotlin/reflect/KProperty0;", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Lkotlin/reflect/KProperty0;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "T", "Lkotlin/reflect/KProperty1;", "(Lkotlin/reflect/KProperty1;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "Lkotlin/reflect/KMutableProperty0;", "value", "(Lkotlin/reflect/KMutableProperty0;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Lkotlin/reflect/KMutableProperty1;", "(Lkotlin/reflect/KMutableProperty1;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"})
/* renamed from: kotlin.PropertyReferenceDelegatesKt */
/* loaded from: grasscutter.jar:kotlin/PropertyReferenceDelegatesKt.class */
public final class PropertyReferenceDelegates {
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <V> V getValue(KProperty0<? extends V> kProperty0, Object thisRef, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty0, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return (V) kProperty0.get();
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <V> void setValue(KMutableProperty0<V> kMutableProperty0, Object thisRef, KProperty<?> kProperty, V v) {
        Intrinsics.checkNotNullParameter(kMutableProperty0, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        kMutableProperty0.set(v);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <T, V> V getValue(KProperty1<T, ? extends V> kProperty1, T t, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty1, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return (V) kProperty1.get(t);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <T, V> void setValue(KMutableProperty1<T, V> kMutableProperty1, T t, KProperty<?> kProperty, V v) {
        Intrinsics.checkNotNullParameter(kMutableProperty1, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        kMutableProperty1.set(t, v);
    }
}
