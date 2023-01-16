package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import java.util.SortedSet;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteSortedSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteSortedSet.class */
public interface ByteSortedSet extends ByteSet, SortedSet<Byte>, ByteBidirectionalIterable {
    ByteBidirectionalIterator iterator(byte b);

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteSet, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, java.util.Set
    ByteBidirectionalIterator iterator();

    ByteSortedSet subSet(byte b, byte b2);

    ByteSortedSet headSet(byte b);

    ByteSortedSet tailSet(byte b);

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // java.util.SortedSet
    Comparator<? super Byte> comparator();

    byte firstByte();

    byte lastByte();

    /* JADX WARN: Type inference failed for: r3v1, types: [it.unimi.dsi.fastutil.bytes.ByteComparator] */
    @Override // p014it.unimi.dsi.fastutil.bytes.ByteSet, p014it.unimi.dsi.fastutil.bytes.ByteIterable, java.util.Set
    default ByteSpliterator spliterator() {
        return ByteSpliterators.asSpliteratorFromSorted(iterator(), Size64.sizeOf(this), 341, comparator());
    }

    @Deprecated
    default ByteSortedSet subSet(Byte from, Byte to) {
        return subSet(from.byteValue(), to.byteValue());
    }

    @Deprecated
    default ByteSortedSet headSet(Byte to) {
        return headSet(to.byteValue());
    }

    @Deprecated
    default ByteSortedSet tailSet(Byte from) {
        return tailSet(from.byteValue());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Byte first() {
        return Byte.valueOf(firstByte());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Byte last() {
        return Byte.valueOf(lastByte());
    }
}
