package p013io.netty.handler.codec.serialization;

import java.io.ObjectInputStream;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufInputStream;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/* renamed from: io.netty.handler.codec.serialization.ObjectDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/ObjectDecoder.class */
public class ObjectDecoder extends LengthFieldBasedFrameDecoder {
    private final ClassResolver classResolver;

    public ObjectDecoder(ClassResolver classResolver) {
        this(1048576, classResolver);
    }

    public ObjectDecoder(int maxObjectSize, ClassResolver classResolver) {
        super(maxObjectSize, 0, 4, 0, 4);
        this.classResolver = classResolver;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.LengthFieldBasedFrameDecoder
    public Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf frame = (ByteBuf) decode(ctx, in);
        if (frame == null) {
            return null;
        }
        ObjectInputStream ois = new CompactObjectInputStream(new ByteBufInputStream(frame, true), this.classResolver);
        try {
            Object readObject = ois.readObject();
            ois.close();
            return readObject;
        } catch (Throwable th) {
            ois.close();
            throw th;
        }
    }
}
