package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: CoroutineContextImpl.kt */
@SinceKotlin(version = "1.3")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010��\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018��2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020��H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b��\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b��\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n��¨\u0006\""}, m373d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", CoreConstants.CONTEXT_SCOPE_VALUE, "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", BeanUtil.PREFIX_GETTER_GET, "E", Action.KEY_ATTRIBUTE, "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", Printer.TO_STRING, "", "writeReplace", "Serialized", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/coroutines/CombinedContext.class */
public final class CombinedContext implements CoroutineContext, Serializable {
    @NotNull
    private final CoroutineContext left;
    @NotNull
    private final CoroutineContext.Element element;

    public CombinedContext(@NotNull CoroutineContext left, @NotNull CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(element, "element");
        this.left = left;
        this.element = element;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext context) {
        return CoroutineContext.DefaultImpls.plus(this, context);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        CombinedContext cur = this;
        while (true) {
            E e = (E) cur.element.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext next = cur.left;
            if (!(next instanceof CombinedContext)) {
                return (E) next.get(key);
            }
            cur = (CombinedContext) next;
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) function2.invoke((Object) this.left.fold(r, function2), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        if (this.element.get(key) != null) {
            return this.left;
        }
        CoroutineContext newLeft = this.left.minusKey(key);
        return newLeft == this.left ? this : newLeft == EmptyCoroutineContext.INSTANCE ? this.element : new CombinedContext(newLeft, this.element);
    }

    private final int size() {
        CombinedContext cur = this;
        int size = 2;
        while (true) {
            CoroutineContext coroutineContext = cur.left;
            CombinedContext combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return size;
            }
            cur = combinedContext;
            size++;
        }
    }

    private final boolean contains(CoroutineContext.Element element) {
        return Intrinsics.areEqual(get(element.getKey()), element);
    }

    private final boolean containsAll(CombinedContext context) {
        CombinedContext cur = context;
        while (contains(cur.element)) {
            CoroutineContext next = cur.left;
            if (!(next instanceof CombinedContext)) {
                return contains((CoroutineContext.Element) next);
            }
            cur = (CombinedContext) next;
        }
        return false;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object other) {
        return this == other || ((other instanceof CombinedContext) && ((CombinedContext) other).size() == size() && ((CombinedContext) other).containsAll(this));
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return '[' + ((String) fold("", CoroutineContextImpl.INSTANCE)) + ']';
    }

    private final Object writeReplace() {
        int n = size();
        CoroutineContext[] elements = new CoroutineContext[n];
        Ref.IntRef index = new Ref.IntRef();
        fold(Unit.INSTANCE, new Function2<Unit, CoroutineContext.Element, Unit>(elements, index) { // from class: kotlin.coroutines.CombinedContext$writeReplace$1
            final /* synthetic */ CoroutineContext[] $elements;
            final /* synthetic */ Ref.IntRef $index;

            /* access modifiers changed from: package-private */
            {
                this.$elements = $elements;
                this.$index = $index;
            }

            public final void invoke(@NotNull Unit unit, @NotNull CoroutineContext.Element element) {
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(element, "element");
                CoroutineContext[] coroutineContextArr = this.$elements;
                int i = this.$index.element;
                this.$index.element = i + 1;
                coroutineContextArr[i] = element;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit, CoroutineContext.Element element) {
                invoke(unit, element);
                return Unit.INSTANCE;
            }
        });
        if (index.element == n) {
            return new Serialized(elements);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* compiled from: CoroutineContextImpl.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010��\n\u0002\b\u0002\b\u0002\u0018�� \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, m373d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/coroutines/CombinedContext$Serialized.class */
    private static final class Serialized implements Serializable {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final CoroutineContext[] elements;
        private static final long serialVersionUID = 0;

        /* compiled from: CoroutineContextImpl.kt */
        @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\t\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\u0005"}, m373d2 = {"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"})
        /* loaded from: grasscutter.jar:kotlin/coroutines/CombinedContext$Serialized$Companion.class */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            private Companion() {
            }
        }

        public Serialized(@NotNull CoroutineContext[] elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.elements = elements;
        }

        @NotNull
        public final CoroutineContext[] getElements() {
            return this.elements;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            Object accumulator$iv = EmptyCoroutineContext.INSTANCE;
            for (CoroutineContext coroutineContext : coroutineContextArr) {
                accumulator$iv = ((CoroutineContext) accumulator$iv).plus(coroutineContext);
            }
            return accumulator$iv;
        }
    }
}
