package p014it.unimi.dsi.fastutil;

/* renamed from: it.unimi.dsi.fastutil.Stack */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/Stack.class */
public interface Stack<K> {
    void push(K k);

    K pop();

    @Override // java.util.Collection, java.util.List, p014it.unimi.dsi.fastutil.Stack
    boolean isEmpty();

    default K top() {
        return peek(0);
    }

    default K peek(int i) {
        throw new UnsupportedOperationException();
    }
}
