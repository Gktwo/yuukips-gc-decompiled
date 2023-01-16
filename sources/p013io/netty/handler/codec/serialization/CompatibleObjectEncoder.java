package p013io.netty.handler.codec.serialization;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufOutputStream;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToByteEncoder;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.serialization.CompatibleObjectEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/CompatibleObjectEncoder.class */
public class CompatibleObjectEncoder extends MessageToByteEncoder<Serializable> {
    private final int resetInterval;
    private int writtenObjects;

    public CompatibleObjectEncoder() {
        this(16);
    }

    public CompatibleObjectEncoder(int resetInterval) {
        this.resetInterval = ObjectUtil.checkPositiveOrZero(resetInterval, "resetInterval");
    }

    protected ObjectOutputStream newObjectOutputStream(OutputStream out) throws Exception {
        return new ObjectOutputStream(out);
    }

    /* access modifiers changed from: protected */
    public void encode(ChannelHandlerContext ctx, Serializable msg, ByteBuf out) throws Exception {
        ObjectOutputStream oos = newObjectOutputStream(new ByteBufOutputStream(out));
        try {
            if (this.resetInterval != 0) {
                this.writtenObjects++;
                if (this.writtenObjects % this.resetInterval == 0) {
                    oos.reset();
                }
            }
            oos.writeObject(msg);
            oos.flush();
            oos.close();
        } catch (Throwable th) {
            oos.close();
            throw th;
        }
    }
}
