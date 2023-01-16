package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.PriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.chars.CharPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharPriorityQueue.class */
public interface CharPriorityQueue extends PriorityQueue<Character> {
    void enqueue(char c);

    char dequeueChar();

    char firstChar();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    Comparator<? super Character> comparator();

    default char lastChar() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void enqueue(Character x) {
        enqueue(x.charValue());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Character dequeue() {
        return Character.valueOf(dequeueChar());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Character first() {
        return Character.valueOf(firstChar());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Character last() {
        return Character.valueOf(lastChar());
    }
}
