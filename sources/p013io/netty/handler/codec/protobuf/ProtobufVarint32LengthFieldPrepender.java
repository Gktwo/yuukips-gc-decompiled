package p013io.netty.handler.codec.protobuf;

import org.luaj.vm2.Lua;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToByteEncoder;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender */
/* loaded from: grasscutter.jar:io/netty/handler/codec/protobuf/ProtobufVarint32LengthFieldPrepender.class */
public class ProtobufVarint32LengthFieldPrepender extends MessageToByteEncoder<ByteBuf> {
    /* access modifiers changed from: protected */
    public void encode(ChannelHandlerContext ctx, ByteBuf msg, ByteBuf out) throws Exception {
        int bodyLen = msg.readableBytes();
        out.ensureWritable(computeRawVarint32Size(bodyLen) + bodyLen);
        writeRawVarint32(out, bodyLen);
        out.writeBytes(msg, msg.readerIndex(), bodyLen);
    }

    static void writeRawVarint32(ByteBuf out, int value) {
        while ((value & -128) != 0) {
            out.writeByte((value & 127) | 128);
            value >>>= 7;
        }
        out.writeByte(value);
    }

    static int computeRawVarint32Size(int value) {
        if ((value & -128) == 0) {
            return 1;
        }
        if ((value & Lua.MASK_Bx) == 0) {
            return 2;
        }
        if ((value & -2097152) == 0) {
            return 3;
        }
        if ((value & -268435456) == 0) {
            return 4;
        }
        return 5;
    }
}
