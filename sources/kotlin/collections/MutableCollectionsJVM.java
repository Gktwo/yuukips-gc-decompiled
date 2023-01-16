package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��2\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000f\n��\n\u0002\u0018\u0002\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010��\u001a\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\b\u001a!\u0010\u0006\u001a\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\b\u001a \u0010\t\u001a\u00020\u0001\"\u000e\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a6\u0010\t\u001a\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\r0\fH\bø\u0001��\u001a5\u0010\t\u001a\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b��\u0012\u0002H\u00020\u000fj\n\u0012\u0006\b��\u0012\u0002H\u0002`\u0010H\b\u001a2\u0010\u0011\u001a\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b��\u0012\u0002H\u00020\u000fj\n\u0012\u0006\b��\u0012\u0002H\u0002`\u0010\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0012"}, m373d2 = {"fill", "", "T", "", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "shuffle", "random", "Ljava/util/Random;", "sort", "", "comparison", "Lkotlin/Function2;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sortWith", "kotlin-stdlib"}, m368xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.CollectionsKt__MutableCollectionsJVMKt */
/* loaded from: grasscutter.jar:kotlin/collections/CollectionsKt__MutableCollectionsJVMKt.class */
class MutableCollectionsJVM extends Iterators {
    @Deprecated(message = "Use sortWith(comparator) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(comparator)", imports = {}), level = DeprecationLevel.ERROR)
    @InlineOnly
    private static final <T> void sort(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        throw new NotImplementedError(null, 1, null);
    }

    @Deprecated(message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(Comparator(comparison))", imports = {}), level = DeprecationLevel.ERROR)
    @InlineOnly
    private static final <T> void sort(List<T> list, Function2<? super T, ? super T, Integer> function2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function2, "comparison");
        throw new NotImplementedError(null, 1, null);
    }

    public static final <T extends Comparable<? super T>> void sort(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void sortWith(@NotNull List<T> list, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void fill(List<T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Collections.fill(list, t);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void shuffle(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Collections.shuffle(list);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void shuffle(List<T> list, Random random) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        Collections.shuffle(list, random);
    }
}
