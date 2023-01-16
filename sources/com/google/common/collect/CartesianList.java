package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/CartesianList.class */
public final class CartesianList<E> extends AbstractList<List<E>> implements RandomAccess {
    private final transient ImmutableList<List<E>> axes;
    private final transient int[] axesSizeProduct;

    /* access modifiers changed from: package-private */
    public static <E> List<List<E>> create(List<? extends List<? extends E>> lists) {
        ImmutableList.Builder<List<E>> axesBuilder = new ImmutableList.Builder<>(lists.size());
        for (List<? extends E> list : lists) {
            List<E> copy = ImmutableList.copyOf((Collection) list);
            if (copy.isEmpty()) {
                return ImmutableList.m1438of();
            }
            axesBuilder.add((ImmutableList.Builder<List<E>>) copy);
        }
        return new CartesianList(axesBuilder.build());
    }

    /* access modifiers changed from: package-private */
    public CartesianList(ImmutableList<List<E>> axes) {
        this.axes = axes;
        int[] axesSizeProduct = new int[axes.size() + 1];
        axesSizeProduct[axes.size()] = 1;
        try {
            for (int i = axes.size() - 1; i >= 0; i--) {
                axesSizeProduct[i] = IntMath.checkedMultiply(axesSizeProduct[i + 1], axes.get(i).size());
            }
            this.axesSizeProduct = axesSizeProduct;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
    }

    /* access modifiers changed from: private */
    public int getAxisIndexForProductIndex(int index, int axis) {
        return (index / this.axesSizeProduct[axis + 1]) % this.axes.get(axis).size();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object o) {
        if (!(o instanceof List)) {
            return -1;
        }
        List<?> list = (List) o;
        if (list.size() != this.axes.size()) {
            return -1;
        }
        ListIterator<?> itr = list.listIterator();
        int computedIndex = 0;
        while (itr.hasNext()) {
            int axisIndex = itr.nextIndex();
            int elemIndex = this.axes.get(axisIndex).indexOf(itr.next());
            if (elemIndex == -1) {
                return -1;
            }
            computedIndex += elemIndex * this.axesSizeProduct[axisIndex + 1];
        }
        return computedIndex;
    }

    @Override // java.util.AbstractList, java.util.List
    public ImmutableList<E> get(final int index) {
        Preconditions.checkElementIndex(index, size());
        return new ImmutableList<E>() { // from class: com.google.common.collect.CartesianList.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return CartesianList.this.axes.size();
            }

            @Override // java.util.List
            public E get(int axis) {
                Preconditions.checkElementIndex(axis, size());
                return (E) ((List) CartesianList.this.axes.get(axis)).get(CartesianList.this.getAxisIndexForProductIndex(index, axis));
            }

            @Override // com.google.common.collect.ImmutableCollection
            boolean isPartialView() {
                return true;
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.axesSizeProduct[0];
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
}
