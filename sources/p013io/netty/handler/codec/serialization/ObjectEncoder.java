package p013io.netty.handler.codec.serialization;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufOutputStream;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToByteEncoder;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.codec.serialization.ObjectEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/ObjectEncoder.class */
public class ObjectEncoder extends MessageToByteEncoder<Serializable> {
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];

    /* access modifiers changed from: protected */
    public void encode(ChannelHandlerContext ctx, Serializable msg, ByteBuf out) throws Exception {
        int startIdx = out.writerIndex();
        ByteBufOutputStream bout = new ByteBufOutputStream(out);
        ObjectOutputStream oout = null;
        try {
            bout.write(LENGTH_PLACEHOLDER);
            oout = new CompactObjectOutputStream(bout);
            oout.writeObject(msg);
            oout.flush();
            if (oout != null) {
                oout.close();
            } else {
                bout.close();
            }
            out.setInt(startIdx, (out.writerIndex() - startIdx) - 4);
        } catch (Throwable th) {
            if (oout != null) {
                oout.close();
            } else {
                bout.close();
            }
            throw th;
        }
    }
}
