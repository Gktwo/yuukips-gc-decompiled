package p014it.unimi.dsi.fastutil.chars;

import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.chars.CharBidirectionalIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharBidirectionalIterator.class */
public interface CharBidirectionalIterator extends CharIterator, ObjectBidirectionalIterator<Character> {
    char previousChar();

    @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Character previous() {
        return Character.valueOf(previousChar());
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
    default int back(int n) {
        int i = n;
        while (true) {
            i--;
            if (i == 0 || !hasPrevious()) {
                break;
            }
            previousChar();
        }
        return (n - i) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return skip(n);
    }
}
