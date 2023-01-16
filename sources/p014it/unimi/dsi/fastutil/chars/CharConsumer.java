package p014it.unimi.dsi.fastutil.chars;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.chars.CharConsumer */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharConsumer.class */
public interface CharConsumer extends Consumer<Character>, IntConsumer {
    void accept(char c);

    @Override // java.util.function.IntConsumer
    @Deprecated
    default void accept(int t) {
        accept(SafeMath.safeIntToChar(t));
    }

    @Deprecated
    default void accept(Character t) {
        accept(t.charValue());
    }

    default CharConsumer andThen(CharConsumer after) {
        Objects.requireNonNull(after);
        return t -> {
            accept(after);
            after.accept(after);
        };
    }

    @Override // java.util.function.IntConsumer
    default CharConsumer andThen(IntConsumer after) {
        CharConsumer charConsumer;
        if (after instanceof CharConsumer) {
            charConsumer = (CharConsumer) after;
        } else {
            Objects.requireNonNull(after);
            charConsumer = (v1) -> {
                r1.accept(v1);
            };
        }
        return andThen(charConsumer);
    }

    @Override // java.util.function.Consumer
    @Deprecated
    default Consumer<Character> andThen(Consumer<? super Character> after) {
        return andThen(after);
    }
}
