package p014it.unimi.dsi.fastutil.chars;

import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: it.unimi.dsi.fastutil.chars.CharIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterator.class */
public interface CharIterator extends PrimitiveIterator<Character, CharConsumer> {
    char nextChar();

    @Override // java.util.Iterator
    @Deprecated
    default Character next() {
        return Character.valueOf(nextChar());
    }

    default void forEachRemaining(CharConsumer action) {
        Objects.requireNonNull(action);
        while (hasNext()) {
            action.accept(nextChar());
        }
    }

    default void forEachRemaining(IntConsumer action) {
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
        forEachRemaining(charConsumer);
    }

    @Override // java.util.Iterator
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
        forEachRemaining(charConsumer);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument must be nonnegative: " + n);
        }
        int i = n;
        while (true) {
            i--;
            if (i == 0 || !hasNext()) {
                break;
            }
            nextChar();
        }
        return (n - i) - 1;
    }
}
