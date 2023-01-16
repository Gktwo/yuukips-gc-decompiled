package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��\u001c\n��\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n��\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010��\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010��\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010��\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0002\u001a-\u0010��\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0002\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0002\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\u0004¨\u0006\r"}, m373d2 = {"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, m368xs = "kotlin/collections/SetsKt")
/* renamed from: kotlin.collections.SetsKt___SetsKt */
/* loaded from: grasscutter.jar:kotlin/collections/SetsKt___SetsKt.class */
class _Sets extends Sets {
    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> $this$filterTo$iv, T t) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$filterTo$iv, "<this>");
        LinkedHashSet result = new LinkedHashSet(MapsKt.mapCapacity($this$filterTo$iv.size()));
        boolean removed = false;
        for (T t2 : $this$filterTo$iv) {
            if (removed || !Intrinsics.areEqual(t2, t)) {
                z = true;
            } else {
                removed = true;
                z = false;
            }
            if (z) {
                result.add(t2);
            }
        }
        return result;
    }

    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> set, @NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        LinkedHashSet result = new LinkedHashSet(set);
        CollectionsKt.removeAll(result, tArr);
        return result;
    }

    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> $this$filterNotTo$iv, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter($this$filterNotTo$iv, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        Collection other = BrittleContainsOptimization.convertToSetForSetOperationWith(iterable, $this$filterNotTo$iv);
        if (other.isEmpty()) {
            return CollectionsKt.toSet($this$filterNotTo$iv);
        }
        if (other instanceof Set) {
            Collection destination$iv = new LinkedHashSet();
            for (T t : $this$filterNotTo$iv) {
                if (!other.contains(t)) {
                    destination$iv.add(t);
                }
            }
            return (Set) destination$iv;
        }
        LinkedHashSet result = new LinkedHashSet($this$filterNotTo$iv);
        result.removeAll(other);
        return result;
    }

    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> set, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        LinkedHashSet result = new LinkedHashSet(set);
        CollectionsKt.removeAll(result, sequence);
        return result;
    }

    @InlineOnly
    private static final <T> Set<T> minusElement(Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        return SetsKt.minus(set, t);
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        LinkedHashSet result = new LinkedHashSet(MapsKt.mapCapacity(set.size() + 1));
        result.addAll(set);
        result.add(t);
        return result;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> set, @NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        LinkedHashSet result = new LinkedHashSet(MapsKt.mapCapacity(set.size() + tArr.length));
        result.addAll(set);
        CollectionsKt.addAll(result, tArr);
        return result;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> iterable) {
        int i;
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        Integer collectionSizeOrNull = CollectionsKt.collectionSizeOrNull(iterable);
        if (collectionSizeOrNull != null) {
            i = set.size() + collectionSizeOrNull.intValue();
        } else {
            i = set.size() * 2;
        }
        LinkedHashSet result = new LinkedHashSet(MapsKt.mapCapacity(i));
        result.addAll(set);
        CollectionsKt.addAll(result, iterable);
        return result;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> set, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        LinkedHashSet result = new LinkedHashSet(MapsKt.mapCapacity(set.size() * 2));
        result.addAll(set);
        CollectionsKt.addAll(result, sequence);
        return result;
    }

    @InlineOnly
    private static final <T> Set<T> plusElement(Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        return SetsKt.plus(set, t);
    }
}
