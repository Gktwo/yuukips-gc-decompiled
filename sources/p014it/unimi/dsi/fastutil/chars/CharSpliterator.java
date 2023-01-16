package p014it.unimi.dsi.fastutil.chars;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/* renamed from: it.unimi.dsi.fastutil.chars.CharSpliterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharSpliterator.class */
public interface CharSpliterator extends Spliterator.OfPrimitive<Character, CharConsumer, CharSpliterator> {
    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    CharSpliterator trySplit();

    @Override // java.util.Spliterator
    @Deprecated
    default boolean tryAdvance(Consumer<? super Character> action) {
        CharConsumer charConsumer;
        if (action instanceof CharConsumer) {
            charConsumer = (CharConsumer) action;
        } else {
            Objects.requireNonNull(action);
            charConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        return tryAdvance((CharSpliterator) charConsumer);
    }

    @Override // java.util.Spliterator
    @Deprecated
    default void forEachRemaining(Consumer<? super Character> action) {
        CharConsumer charConsumer;
        if (action instanceof CharConsumer) {
            charConsumer = (CharConsumer) action;
        } else {
            Objects.requireNonNull(action);
            charConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        forEachRemaining((CharSpliterator) charConsumer);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [long] */
    default long skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument must be nonnegative: " + n);
        }
        char c = n;
        do {
            c--;
            if (c == 0) {
                break;
            }
        } while (tryAdvance((CharSpliterator) unused -> {
        }));
        return (n - c) - 1;
    }

    @Override // java.util.Spliterator
    default CharComparator getComparator() {
        throw new IllegalStateException();
    }
}
