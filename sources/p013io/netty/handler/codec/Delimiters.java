package p013io.netty.handler.codec;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.Unpooled;

/* renamed from: io.netty.handler.codec.Delimiters */
/* loaded from: grasscutter.jar:io/netty/handler/codec/Delimiters.class */
public final class Delimiters {
    public static ByteBuf[] nulDelimiter() {
        return new ByteBuf[]{Unpooled.wrappedBuffer(new byte[]{0})};
    }

    public static ByteBuf[] lineDelimiter() {
        return new ByteBuf[]{Unpooled.wrappedBuffer(new byte[]{13, 10}), Unpooled.wrappedBuffer(new byte[]{10})};
    }

    private Delimiters() {
    }
}
