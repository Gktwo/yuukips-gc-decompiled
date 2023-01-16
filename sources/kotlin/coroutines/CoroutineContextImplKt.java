package kotlin.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.joran.action.Action;

/* compiled from: CoroutineContextImpl.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\u001a+\u0010��\u001a\u0004\u0018\u0001H\u0001\"\b\b��\u0010\u0001*\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007¨\u0006\b"}, m373d2 = {"getPolymorphicElement", "E", "Lkotlin/coroutines/CoroutineContext$Element;", Action.KEY_ATTRIBUTE, "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/coroutines/CoroutineContextImplKt.class */
public final class CoroutineContextImplKt {
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.coroutines.CoroutineContext$Element */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @Nullable
    public static final <E extends CoroutineContext.Element> E getPolymorphicElement(@NotNull CoroutineContext.Element $this$getPolymorphicElement, @NotNull CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter($this$getPolymorphicElement, "<this>");
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        if (key instanceof AbstractCoroutineContextKey) {
            if (!((AbstractCoroutineContextKey) key).isSubKey$kotlin_stdlib($this$getPolymorphicElement.getKey())) {
                return null;
            }
            E e = (E) ((AbstractCoroutineContextKey) key).tryCast$kotlin_stdlib($this$getPolymorphicElement);
            if (e instanceof CoroutineContext.Element) {
                return e;
            }
            return null;
        } else if ($this$getPolymorphicElement.getKey() == key) {
            return $this$getPolymorphicElement;
        } else {
            return null;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    public static final CoroutineContext minusPolymorphicKey(@NotNull CoroutineContext.Element $this$minusPolymorphicKey, @NotNull CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter($this$minusPolymorphicKey, "<this>");
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return key instanceof AbstractCoroutineContextKey ? (!((AbstractCoroutineContextKey) key).isSubKey$kotlin_stdlib($this$minusPolymorphicKey.getKey()) || ((AbstractCoroutineContextKey) key).tryCast$kotlin_stdlib($this$minusPolymorphicKey) == null) ? $this$minusPolymorphicKey : EmptyCoroutineContext.INSTANCE : $this$minusPolymorphicKey.getKey() == key ? EmptyCoroutineContext.INSTANCE : $this$minusPolymorphicKey;
    }
}
