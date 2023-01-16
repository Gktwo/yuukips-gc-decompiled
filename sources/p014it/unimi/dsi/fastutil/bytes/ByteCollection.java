package p014it.unimi.dsi.fastutil.bytes;

import java.util.Collection;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteCollection.class */
public interface ByteCollection extends Collection<Byte>, ByteIterable {
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    ByteIterator iterator();

    boolean add(byte b);

    boolean contains(byte b);

    boolean rem(byte b);

    byte[] toByteArray();

    byte[] toArray(byte[] bArr);

    boolean addAll(ByteCollection byteCollection);

    boolean containsAll(ByteCollection byteCollection);

    boolean removeAll(ByteCollection byteCollection);

    boolean retainAll(ByteCollection byteCollection);

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
    default IntIterator intIterator() {
        return intIterator();
    }

    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    default ByteSpliterator spliterator() {
        return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 320);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
    default IntSpliterator intSpliterator() {
        return intSpliterator();
    }

    @Deprecated
    default boolean add(Byte key) {
        return add(key.byteValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    @Deprecated
    default boolean contains(Object key) {
        if (key == null) {
            return false;
        }
        return contains(((Byte) key).byteValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    @Deprecated
    default boolean remove(Object key) {
        if (key == null) {
            return false;
        }
        return rem(((Byte) key).byteValue());
    }

    @Deprecated
    default byte[] toByteArray(byte[] a) {
        return toArray(a);
    }

    @Override // java.util.Collection
    @Deprecated
    default boolean removeIf(Predicate<? super Byte> filter) {
        return removeIf(filter instanceof BytePredicate ? (BytePredicate) filter : key -> {
            return filter.test(Byte.valueOf(SafeMath.safeIntToByte(key)));
        });
    }

    default boolean removeIf(BytePredicate filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        ByteIterator each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.nextByte())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

    default boolean removeIf(IntPredicate filter) {
        BytePredicate bytePredicate;
        if (filter instanceof BytePredicate) {
            bytePredicate = (BytePredicate) filter;
        } else {
            Objects.requireNonNull(filter);
            bytePredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return removeIf(bytePredicate);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Byte> stream() {
        return stream();
    }

    default IntStream intStream() {
        return StreamSupport.intStream(intSpliterator(), false);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Byte> parallelStream() {
        return parallelStream();
    }

    default IntStream intParallelStream() {
        return StreamSupport.intStream(intSpliterator(), true);
    }
}
