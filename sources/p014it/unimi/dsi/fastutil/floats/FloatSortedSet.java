package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import java.util.SortedSet;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatSortedSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSortedSet.class */
public interface FloatSortedSet extends FloatSet, SortedSet<Float>, FloatBidirectionalIterable {
    FloatBidirectionalIterator iterator(float f);

    @Override // p014it.unimi.dsi.fastutil.floats.FloatSet, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
    FloatBidirectionalIterator iterator();

    FloatSortedSet subSet(float f, float f2);

    FloatSortedSet headSet(float f);

    FloatSortedSet tailSet(float f);

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // java.util.SortedSet
    Comparator<? super Float> comparator();

    float firstFloat();

    float lastFloat();

    /* JADX WARN: Type inference failed for: r3v1, types: [it.unimi.dsi.fastutil.floats.FloatComparator] */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatSet, p014it.unimi.dsi.fastutil.floats.FloatCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatIterable
    default FloatSpliterator spliterator() {
        return FloatSpliterators.asSpliteratorFromSorted(iterator(), Size64.sizeOf(this), 341, comparator());
    }

    @Deprecated
    default FloatSortedSet subSet(Float from, Float to) {
        return subSet(from.floatValue(), to.floatValue());
    }

    @Deprecated
    default FloatSortedSet headSet(Float to) {
        return headSet(to.floatValue());
    }

    @Deprecated
    default FloatSortedSet tailSet(Float from) {
        return tailSet(from.floatValue());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Float first() {
        return Float.valueOf(firstFloat());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Float last() {
        return Float.valueOf(lastFloat());
    }
}
