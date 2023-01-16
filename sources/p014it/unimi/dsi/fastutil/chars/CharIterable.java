package p014it.unimi.dsi.fastutil.chars;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterators;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;

/* renamed from: it.unimi.dsi.fastutil.chars.CharIterable */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterable.class */
public interface CharIterable extends Iterable<Character> {
    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    CharIterator iterator();

    default IntIterator intIterator() {
        return IntIterators.wrap(iterator());
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    default CharSpliterator spliterator() {
        return CharSpliterators.asSpliteratorUnknownSize(iterator(), 0);
    }

    default IntSpliterator intSpliterator() {
        return IntSpliterators.wrap(spliterator());
    }

    default void forEach(CharConsumer action) {
        Objects.requireNonNull(action);
        iterator().forEachRemaining(action);
    }

    default void forEach(IntConsumer action) {
        CharConsumer charConsumer;
        Objects.requireNonNull(action);
        if (action instanceof CharConsumer) {
            charConsumer = (CharConsumer) action;
        } else {
            Objects.requireNonNull(action);
            charConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEach(charConsumer);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
    @Deprecated
    default void forEach(Consumer<? super Character> action) {
        CharConsumer charConsumer;
        Objects.requireNonNull(action);
        if (action instanceof CharConsumer) {
            charConsumer = (CharConsumer) action;
        } else {
            Objects.requireNonNull(action);
            charConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEach(charConsumer);
    }
}
