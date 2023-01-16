package p014it.unimi.dsi.fastutil.doubles;

import p014it.unimi.dsi.fastutil.Stack;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleStack */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleStack.class */
public interface DoubleStack extends Stack<Double> {
    void push(double d);

    double popDouble();

    double topDouble();

    double peekDouble(int i);

    @Deprecated
    default void push(Double o) {
        push(o.doubleValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Double pop() {
        return Double.valueOf(popDouble());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Double top() {
        return Double.valueOf(topDouble());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Double peek(int i) {
        return Double.valueOf(peekDouble(i));
    }
}
