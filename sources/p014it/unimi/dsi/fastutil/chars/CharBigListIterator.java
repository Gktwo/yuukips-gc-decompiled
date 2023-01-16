package p014it.unimi.dsi.fastutil.chars;

import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.chars.CharBigListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharBigListIterator.class */
public interface CharBigListIterator extends CharBidirectionalIterator, BigListIterator<Character> {
    default void set(char k) {
        throw new UnsupportedOperationException();
    }

    default void add(char k) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Character k) {
        set(k.charValue());
    }

    @Deprecated
    default void add(Character k) {
        add(k.charValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [long] */
    default long skip(long n) {
        char c = n;
        while (true) {
            c--;
            if (c == 0 || !hasNext()) {
                break;
            }
            nextChar();
        }
        return (n - c) - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [long] */
    default long back(long n) {
        char c = n;
        while (true) {
            c--;
            if (c == 0 || !hasPrevious()) {
                break;
            }
            previousChar();
        }
        return (n - c) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.chars.CharIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return SafeMath.safeLongToInt(skip((long) n));
    }
}
