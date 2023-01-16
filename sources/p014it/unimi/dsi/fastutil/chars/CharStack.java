package p014it.unimi.dsi.fastutil.chars;

import p014it.unimi.dsi.fastutil.Stack;

/* renamed from: it.unimi.dsi.fastutil.chars.CharStack */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharStack.class */
public interface CharStack extends Stack<Character> {
    void push(char c);

    char popChar();

    char topChar();

    char peekChar(int i);

    @Deprecated
    default void push(Character o) {
        push(o.charValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Character pop() {
        return Character.valueOf(popChar());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Character top() {
        return Character.valueOf(topChar());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Character peek(int i) {
        return Character.valueOf(peekChar(i));
    }
}
