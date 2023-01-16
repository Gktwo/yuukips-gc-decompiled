package p014it.unimi.dsi.fastutil.ints;

import p014it.unimi.dsi.fastutil.Stack;

/* renamed from: it.unimi.dsi.fastutil.ints.IntStack */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntStack.class */
public interface IntStack extends Stack<Integer> {
    void push(int i);

    int popInt();

    int topInt();

    int peekInt(int i);

    @Deprecated
    default void push(Integer o) {
        push(o.intValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Integer pop() {
        return Integer.valueOf(popInt());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Integer top() {
        return Integer.valueOf(topInt());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Integer peek(int i) {
        return Integer.valueOf(peekInt(i));
    }
}
