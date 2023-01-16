package p014it.unimi.dsi.fastutil.shorts;

import p014it.unimi.dsi.fastutil.Stack;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortStack */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortStack.class */
public interface ShortStack extends Stack<Short> {
    void push(short s);

    short popShort();

    short topShort();

    short peekShort(int i);

    @Deprecated
    default void push(Short o) {
        push(o.shortValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Short pop() {
        return Short.valueOf(popShort());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Short top() {
        return Short.valueOf(topShort());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Short peek(int i) {
        return Short.valueOf(peekShort(i));
    }
}
