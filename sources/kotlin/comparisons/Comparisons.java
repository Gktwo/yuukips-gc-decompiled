package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��<\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n��\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010��\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010��\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b��\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\bø\u0001��\u001aY\u0010��\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b��\u0010\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\t\u001aZ\u0010��\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b��\u0012\u0002H\n0\u0001j\n\u0012\u0006\b��\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\bø\u0001��\u001a>\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b��\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\bø\u0001��\u001aZ\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b��\u0012\u0002H\n0\u0001j\n\u0012\u0006\b��\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\bø\u0001��\u001a-\u0010\r\u001a\u00020\u000e\"\f\b��\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u000f\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0010\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0011\u001aA\u0010\u0012\u001a\u00020\u000e\"\u0004\b��\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\bø\u0001��¢\u0006\u0002\u0010\u0013\u001aY\u0010\u0012\u001a\u00020\u000e\"\u0004\b��\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0014\u001a]\u0010\u0012\u001a\u00020\u000e\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b��\u0012\u0002H\n0\u0001j\n\u0012\u0006\b��\u0012\u0002H\n`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\bø\u0001��¢\u0006\u0002\u0010\u0015\u001aG\u0010\u0016\u001a\u00020\u000e\"\u0004\b��\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022 \u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0014\u001a&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a-\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\b\u001a@\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b��\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b��\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b��\u0012\u0002H\u0002`\u0003\u001a-\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\b\u001a@\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b��\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b��\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b��\u0012\u0002H\u0002`\u0003\u001a&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a0\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b��\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\u001aO\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b��\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b��\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b��\u0012\u0002H\u0002`\u0003H\u0004\u001aR\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b��\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\bø\u0001��\u001an\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b��\u0012\u0002H\n0\u0001j\n\u0012\u0006\b��\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\bø\u0001��\u001aR\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b��\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\bø\u0001��\u001an\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b��\u0012\u0002H\n0\u0001j\n\u0012\u0006\b��\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\bø\u0001��\u001ap\u0010!\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b��\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u000328\b\u0004\u0010\"\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0#H\bø\u0001��\u001aO\u0010&\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b��\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b��\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b��\u0012\u0002H\u0002`\u0003H\u0004\u0002\u0007\n\u0005\b20\u0001¨\u0006'"}, m373d2 = {"compareBy", "Ljava/util/Comparator;", "T", "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "thenDescending", "kotlin-stdlib"}, m368xs = "kotlin/comparisons/ComparisonsKt")
/* renamed from: kotlin.comparisons.ComparisonsKt__ComparisonsKt */
/* loaded from: grasscutter.jar:kotlin/comparisons/ComparisonsKt__ComparisonsKt.class */
public class Comparisons {
    public static final <T> int compareValuesBy(T t, T t2, @NotNull Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.checkNotNullParameter(function1Arr, "selectors");
        if (function1Arr.length > 0) {
            return compareValuesByImpl$ComparisonsKt__ComparisonsKt(t, t2, function1Arr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T t, T t2, Function1<? super T, ? extends Comparable<?>>[] function1Arr) {
        for (Function1<? super T, ? extends Comparable<?>> function1 : function1Arr) {
            int diff = ComparisonsKt.compareValues((Comparable) function1.invoke(t), (Comparable) function1.invoke(t2));
            if (diff != 0) {
                return diff;
            }
        }
        return 0;
    }

    @InlineOnly
    private static final <T> int compareValuesBy(T t, T t2, Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(function1, "selector");
        return ComparisonsKt.compareValues((Comparable) function1.invoke(t), (Comparable) function1.invoke(t2));
    }

    @InlineOnly
    private static final <T, K> int compareValuesBy(T t, T t2, Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return comparator.compare((Object) function1.invoke(t), (Object) function1.invoke(t2));
    }

    public static final <T extends Comparable<?>> int compareValues(@Nullable T t, @Nullable T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    @NotNull
    public static final <T> Comparator<T> compareBy(@NotNull Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.checkNotNullParameter(function1Arr, "selectors");
        if (function1Arr.length > 0) {
            return new Comparator(function1Arr) { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$1
                final /* synthetic */ Function1<T, Comparable<?>>[] $selectors;

                /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Comparable<?>>[] */
                /* JADX WARN: Multi-variable type inference failed */
                /* access modifiers changed from: package-private */
                {
                    this.$selectors = r4;
                }

                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return Comparisons.access$compareValuesByImpl(t, t2, this.$selectors);
                }
            };
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @InlineOnly
    private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new ComparisonsKt__ComparisonsKt$compareBy$2(function1);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> compareBy(Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new Comparator(comparator, function1) { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$3
            final /* synthetic */ Comparator<? super K> $comparator;
            final /* synthetic */ Function1<T, K> $selector;

            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends K> */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$comparator = r4;
                this.$selector = r5;
            }

            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Comparator<? super K> comparator2 = this.$comparator;
                Function1<T, K> function12 = this.$selector;
                return comparator2.compare(function12.invoke(t), function12.invoke(t2));
            }
        };
    }

    @InlineOnly
    private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> compareByDescending(Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new Comparator(comparator, function1) { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$2
            final /* synthetic */ Comparator<? super K> $comparator;
            final /* synthetic */ Function1<T, K> $selector;

            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends K> */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$comparator = r4;
                this.$selector = r5;
            }

            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Comparator<? super K> comparator2 = this.$comparator;
                Function1<T, K> function12 = this.$selector;
                return comparator2.compare(function12.invoke(t2), function12.invoke(t));
            }
        };
    }

    @InlineOnly
    private static final <T> Comparator<T> thenBy(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new Comparator(comparator, function1) { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$thenBy$1
            final /* synthetic */ Comparator<T> $this_thenBy;
            final /* synthetic */ Function1<T, Comparable<?>> $selector;

            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Comparable<?>> */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_thenBy = r4;
                this.$selector = r5;
            }

            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = this.$this_thenBy.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                Function1<T, Comparable<?>> function12 = this.$selector;
                return ComparisonsKt.compareValues(function12.invoke(t), function12.invoke(t2));
            }
        };
    }

    @InlineOnly
    private static final <T, K> Comparator<T> thenBy(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new Comparator(comparator, comparator2, function1) { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$thenBy$2
            final /* synthetic */ Comparator<T> $this_thenBy;
            final /* synthetic */ Comparator<? super K> $comparator;
            final /* synthetic */ Function1<T, K> $selector;

            /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends K> */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_thenBy = r4;
                this.$comparator = r5;
                this.$selector = r6;
            }

            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = this.$this_thenBy.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                Comparator<? super K> comparator3 = this.$comparator;
                Function1<T, K> function12 = this.$selector;
                return comparator3.compare(function12.invoke(t), function12.invoke(t2));
            }
        };
    }

    @InlineOnly
    private static final <T> Comparator<T> thenByDescending(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new Comparator(comparator, function1) { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$thenByDescending$1
            final /* synthetic */ Comparator<T> $this_thenByDescending;
            final /* synthetic */ Function1<T, Comparable<?>> $selector;

            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Comparable<?>> */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_thenByDescending = r4;
                this.$selector = r5;
            }

            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = this.$this_thenByDescending.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                Function1<T, Comparable<?>> function12 = this.$selector;
                return ComparisonsKt.compareValues(function12.invoke(t2), function12.invoke(t));
            }
        };
    }

    @InlineOnly
    private static final <T, K> Comparator<T> thenByDescending(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new Comparator(comparator, comparator2, function1) { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$thenByDescending$2
            final /* synthetic */ Comparator<T> $this_thenByDescending;
            final /* synthetic */ Comparator<? super K> $comparator;
            final /* synthetic */ Function1<T, K> $selector;

            /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends K> */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_thenByDescending = r4;
                this.$comparator = r5;
                this.$selector = r6;
            }

            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = this.$this_thenByDescending.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                Comparator<? super K> comparator3 = this.$comparator;
                Function1<T, K> function12 = this.$selector;
                return comparator3.compare(function12.invoke(t2), function12.invoke(t));
            }
        };
    }

    @InlineOnly
    private static final <T> Comparator<T> thenComparator(Comparator<T> comparator, Function2<? super T, ? super T, Integer> function2) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(function2, "comparison");
        return new Comparator(comparator, function2) { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$thenComparator$1
            final /* synthetic */ Comparator<T> $this_thenComparator;
            final /* synthetic */ Function2<T, T, Integer> $comparison;

            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function2<? super T, ? super T, java.lang.Integer> */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_thenComparator = r4;
                this.$comparison = r5;
            }

            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = this.$this_thenComparator.compare(t, t2);
                return previousCompare != 0 ? previousCompare : this.$comparison.invoke(t, t2).intValue();
            }
        };
    }

    @NotNull
    public static final <T> Comparator<T> then(@NotNull Comparator<T> comparator, @NotNull Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new Comparator(comparator, comparator2) { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$then$1
            final /* synthetic */ Comparator<T> $this_then;
            final /* synthetic */ Comparator<? super T> $comparator;

            /* access modifiers changed from: package-private */
            {
                this.$this_then = r4;
                this.$comparator = r5;
            }

            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = this.$this_then.compare(t, t2);
                return previousCompare != 0 ? previousCompare : this.$comparator.compare(t, t2);
            }
        };
    }

    @NotNull
    public static final <T> Comparator<T> thenDescending(@NotNull Comparator<T> comparator, @NotNull Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new Comparator(comparator, comparator2) { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$thenDescending$1
            final /* synthetic */ Comparator<T> $this_thenDescending;
            final /* synthetic */ Comparator<? super T> $comparator;

            /* access modifiers changed from: package-private */
            {
                this.$this_thenDescending = r4;
                this.$comparator = r5;
            }

            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = this.$this_thenDescending.compare(t, t2);
                return previousCompare != 0 ? previousCompare : this.$comparator.compare(t2, t);
            }
        };
    }

    @NotNull
    public static final <T> Comparator<T> nullsFirst(@NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new Comparator(comparator) { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$nullsFirst$1
            final /* synthetic */ Comparator<? super T> $comparator;

            /* access modifiers changed from: package-private */
            {
                this.$comparator = r4;
            }

            @Override // java.util.Comparator
            public final int compare(@Nullable T t, @Nullable T t2) {
                if (t == t2) {
                    return 0;
                }
                if (t == null) {
                    return -1;
                }
                if (t2 == null) {
                    return 1;
                }
                return this.$comparator.compare(t, t2);
            }
        };
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return ComparisonsKt.nullsFirst(ComparisonsKt.naturalOrder());
    }

    @NotNull
    public static final <T> Comparator<T> nullsLast(@NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new Comparator(comparator) { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$nullsLast$1
            final /* synthetic */ Comparator<? super T> $comparator;

            /* access modifiers changed from: package-private */
            {
                this.$comparator = r4;
            }

            @Override // java.util.Comparator
            public final int compare(@Nullable T t, @Nullable T t2) {
                if (t == t2) {
                    return 0;
                }
                if (t == null) {
                    return 1;
                }
                if (t2 == null) {
                    return -1;
                }
                return this.$comparator.compare(t, t2);
            }
        };
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder());
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return NaturalOrderComparator.INSTANCE;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        return ReverseOrderComparator.INSTANCE;
    }

    @NotNull
    public static final <T> Comparator<T> reversed(@NotNull Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        return comparator instanceof ReversedComparator ? ((ReversedComparator) comparator).getComparator() : Intrinsics.areEqual(comparator, NaturalOrderComparator.INSTANCE) ? ReverseOrderComparator.INSTANCE : Intrinsics.areEqual(comparator, ReverseOrderComparator.INSTANCE) ? NaturalOrderComparator.INSTANCE : new ReversedComparator(comparator);
    }
}
