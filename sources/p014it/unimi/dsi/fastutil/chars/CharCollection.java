package p014it.unimi.dsi.fastutil.chars;

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

/* renamed from: it.unimi.dsi.fastutil.chars.CharCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharCollection.class */
public interface CharCollection extends Collection<Character>, CharIterable {
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    CharIterator iterator();

    boolean add(char c);

    boolean contains(char c);

    boolean rem(char c);

    char[] toCharArray();

    char[] toArray(char[] cArr);

    boolean addAll(CharCollection charCollection);

    boolean containsAll(CharCollection charCollection);

    boolean removeAll(CharCollection charCollection);

    boolean retainAll(CharCollection charCollection);

    @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
    default IntIterator intIterator() {
        return intIterator();
    }

    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    default CharSpliterator spliterator() {
        return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 320);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
    default IntSpliterator intSpliterator() {
        return intSpliterator();
    }

    @Deprecated
    default boolean add(Character key) {
        return add(key.charValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.chars.CharCollection
    @Deprecated
    default boolean contains(Object key) {
        if (key == null) {
            return false;
        }
        return contains(((Character) key).charValue());
    }

    @Override // java.util.Collection, p014it.unimi.dsi.fastutil.chars.CharCollection
    @Deprecated
    default boolean remove(Object key) {
        if (key == null) {
            return false;
        }
        return rem(((Character) key).charValue());
    }

    @Deprecated
    default char[] toCharArray(char[] a) {
        return toArray(a);
    }

    @Override // java.util.Collection
    @Deprecated
    default boolean removeIf(Predicate<? super Character> filter) {
        return removeIf(filter instanceof CharPredicate ? (CharPredicate) filter : key -> {
            return filter.test(Character.valueOf(SafeMath.safeIntToChar(key)));
        });
    }

    default boolean removeIf(CharPredicate filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        CharIterator each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.nextChar())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

    default boolean removeIf(IntPredicate filter) {
        CharPredicate charPredicate;
        if (filter instanceof CharPredicate) {
            charPredicate = (CharPredicate) filter;
        } else {
            Objects.requireNonNull(filter);
            charPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return removeIf(charPredicate);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Character> stream() {
        return stream();
    }

    default IntStream intStream() {
        return StreamSupport.intStream(intSpliterator(), false);
    }

    @Override // java.util.Collection
    @Deprecated
    default Stream<Character> parallelStream() {
        return parallelStream();
    }

    default IntStream intParallelStream() {
        return StreamSupport.intStream(intSpliterator(), true);
    }
}
