package p014it.unimi.dsi.fastutil.longs;

import p014it.unimi.dsi.fastutil.Stack;

/* renamed from: it.unimi.dsi.fastutil.longs.LongStack */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongStack.class */
public interface LongStack extends Stack<Long> {
    void push(long j);

    long popLong();

    long topLong();

    long peekLong(int i);

    @Deprecated
    default void push(Long o) {
        push(o.longValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Long pop() {
        return Long.valueOf(popLong());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Long top() {
        return Long.valueOf(topLong());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Long peek(int i) {
        return Long.valueOf(peekLong(i));
    }
}
