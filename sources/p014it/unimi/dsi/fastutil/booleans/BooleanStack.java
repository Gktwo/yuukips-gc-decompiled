package p014it.unimi.dsi.fastutil.booleans;

import p014it.unimi.dsi.fastutil.Stack;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanStack */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanStack.class */
public interface BooleanStack extends Stack<Boolean> {
    void push(boolean z);

    boolean popBoolean();

    boolean topBoolean();

    boolean peekBoolean(int i);

    @Deprecated
    default void push(Boolean o) {
        push(o.booleanValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Boolean pop() {
        return Boolean.valueOf(popBoolean());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Boolean top() {
        return Boolean.valueOf(topBoolean());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Boolean peek(int i) {
        return Boolean.valueOf(peekBoolean(i));
    }
}
