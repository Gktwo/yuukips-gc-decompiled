package p014it.unimi.dsi.fastutil.booleans;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanCollection.class */
public interface BooleanCollection extends Collection<Boolean>, BooleanIterable {
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    BooleanIterator iterator();

    boolean add(boolean z);

    boolean contains(boolean z);

    boolean rem(boolean z);

    boolean[] toBooleanArray();

    boolean[] toArray(boolean[] zArr);

    boolean addAll(BooleanCollection booleanCollection);

    boolean containsAll(BooleanCollection booleanCollection);

    boolean removeAll(BooleanCollection booleanCollection);

    boolean retainAll(BooleanCollection booleanCollection);

    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    default BooleanSpliterator spliterator() {
        return BooleanSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 320);
    }

    @Deprecated
    default boolean add(Boolean key) {
        return add(key.booleanValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    @Deprecated
    default boolean contains(Object key) {
        if (key == null) {
            return false;
        }
        return contains(((Boolean) key).booleanValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    @Deprecated
    default boolean remove(Object key) {
        if (key == null) {
            return false;
        }
        return rem(((Boolean) key).booleanValue());
    }

    @Deprecated
    default boolean[] toBooleanArray(boolean[] a) {
        return toArray(a);
    }

    @Override // java.util.Collection
    @Deprecated
    default boolean removeIf(Predicate<? super Boolean> filter) {
        return removeIf(filter instanceof BooleanPredicate ? (BooleanPredicate) filter : key -> {
            return filter.test(Boolean.valueOf(key));
        });
    }

    default boolean removeIf(BooleanPredicate filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        BooleanIterator each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.nextBoolean())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }
}
