package p014it.unimi.dsi.fastutil.bytes;

import p014it.unimi.dsi.fastutil.Stack;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteStack */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteStack.class */
public interface ByteStack extends Stack<Byte> {
    void push(byte b);

    byte popByte();

    byte topByte();

    byte peekByte(int i);

    @Deprecated
    default void push(Byte o) {
        push(o.byteValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Byte pop() {
        return Byte.valueOf(popByte());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Byte top() {
        return Byte.valueOf(topByte());
    }

    @Override // p014it.unimi.dsi.fastutil.Stack
    @Deprecated
    default Byte peek(int i) {
        return Byte.valueOf(peekByte(i));
    }
}
