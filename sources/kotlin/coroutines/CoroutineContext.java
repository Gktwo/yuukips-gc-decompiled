package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: CoroutineContext.kt */
@SinceKotlin(version = "1.3")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018��2\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b��\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b��\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH¦\u0002¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020��2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020��2\u0006\u0010\u0010\u001a\u00020��H\u0002¨\u0006\u0013"}, m373d2 = {"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", BeanUtil.PREFIX_GETTER_GET, "E", Action.KEY_ATTRIBUTE, "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", CoreConstants.CONTEXT_SCOPE_VALUE, "Element", "Key", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/coroutines/CoroutineContext.class */
public interface CoroutineContext {

    /* compiled from: CoroutineContext.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0010\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0010��\n��\bf\u0018��*\b\b��\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, m373d2 = {"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/coroutines/CoroutineContext$Key.class */
    public interface Key<E extends Element> {
    }

    @Nullable
    <E extends Element> E get(@NotNull Key<E> key);

    <R> R fold(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2);

    @NotNull
    CoroutineContext plus(@NotNull CoroutineContext coroutineContext);

    @NotNull
    CoroutineContext minusKey(@NotNull Key<?> key);

    /* compiled from: CoroutineContext.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48)
    /* loaded from: grasscutter.jar:kotlin/coroutines/CoroutineContext$DefaultImpls.class */
    public static final class DefaultImpls {
        @NotNull
        public static CoroutineContext plus(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, CoreConstants.CONTEXT_SCOPE_VALUE);
            return context == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) context.fold(coroutineContext, CoroutineContext$plus$1.INSTANCE);
        }
    }

    /* compiled from: CoroutineContext.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018��2\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b��\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020��\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b��\u0010\r*\u00020��2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0002¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, m373d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", Action.KEY_ATTRIBUTE, "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", BeanUtil.PREFIX_GETTER_GET, "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/coroutines/CoroutineContext$Element.class */
    public interface Element extends CoroutineContext {
        @NotNull
        Key<?> getKey();

        @Override // kotlin.coroutines.CoroutineContext
        @Nullable
        <E extends Element> E get(@NotNull Key<E> key);

        @Override // kotlin.coroutines.CoroutineContext
        <R> R fold(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2);

        @Override // kotlin.coroutines.CoroutineContext
        @NotNull
        CoroutineContext minusKey(@NotNull Key<?> key);

        /* compiled from: CoroutineContext.kt */
        @Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48)
        /* loaded from: grasscutter.jar:kotlin/coroutines/CoroutineContext$Element$DefaultImpls.class */
        public static final class DefaultImpls {
            @NotNull
            public static CoroutineContext plus(@NotNull Element element, @NotNull CoroutineContext context) {
                Intrinsics.checkNotNullParameter(context, CoreConstants.CONTEXT_SCOPE_VALUE);
                return DefaultImpls.plus(element, context);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.coroutines.CoroutineContext$Element */
            /* JADX WARN: Multi-variable type inference failed */
            @Nullable
            public static <E extends Element> E get(@NotNull Element element, @NotNull Key<E> key) {
                Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
                if (Intrinsics.areEqual(element.getKey(), key)) {
                    return element;
                }
                return null;
            }

            public static <R> R fold(@NotNull Element element, R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
                Intrinsics.checkNotNullParameter(function2, "operation");
                return (R) function2.invoke(r, element);
            }

            @NotNull
            public static CoroutineContext minusKey(@NotNull Element element, @NotNull Key<?> key) {
                Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
                return Intrinsics.areEqual(element.getKey(), key) ? EmptyCoroutineContext.INSTANCE : element;
            }
        }
    }
}
