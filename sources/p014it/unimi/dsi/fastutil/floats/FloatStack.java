package p014it.unimi.dsi.fastutil.floats;

import p014it.unimi.dsi.fastutil.Stack;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatStack */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatStack.class */
public interface FloatStack extends Stack<Float> {
    void push(float f);

    float popFloat();

    float topFloat();

    float peekFloat(int i);

    @Deprecated
    default void push(Float o) {
        push(o.floatValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Float pop() {
        return Float.valueOf(popFloat());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Float top() {
        return Float.valueOf(topFloat());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Float peek(int i) {
        return Float.valueOf(peekFloat(i));
    }
}
