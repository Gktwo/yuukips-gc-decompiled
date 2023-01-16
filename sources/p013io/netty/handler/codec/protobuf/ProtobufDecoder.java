package p013io.netty.handler.codec.protobuf;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToMessageDecoder;
import p013io.netty.util.internal.ObjectUtil;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.codec.protobuf.ProtobufDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/protobuf/ProtobufDecoder.class */
public class ProtobufDecoder extends MessageToMessageDecoder<ByteBuf> {
    private static final boolean HAS_PARSER;
    private final MessageLite prototype;
    private final ExtensionRegistryLite extensionRegistry;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List] */
    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        decode(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    static {
        boolean hasParser = false;
        try {
            MessageLite.class.getDeclaredMethod("getParserForType", new Class[0]);
            hasParser = true;
        } catch (Throwable th) {
        }
        HAS_PARSER = hasParser;
    }

    public ProtobufDecoder(MessageLite prototype) {
        this(prototype, (ExtensionRegistry) null);
    }

    public ProtobufDecoder(MessageLite prototype, ExtensionRegistry extensionRegistry) {
        this(prototype, (ExtensionRegistryLite) extensionRegistry);
    }

    public ProtobufDecoder(MessageLite prototype, ExtensionRegistryLite extensionRegistry) {
        this.prototype = ((MessageLite) ObjectUtil.checkNotNull(prototype, "prototype")).getDefaultInstanceForType();
        this.extensionRegistry = extensionRegistry;
    }

    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        int offset;
        byte[] array;
        int length = msg.readableBytes();
        if (msg.hasArray()) {
            array = msg.array();
            offset = msg.arrayOffset() + msg.readerIndex();
        } else {
            array = ByteBufUtil.getBytes(msg, msg.readerIndex(), length, false);
            offset = 0;
        }
        if (this.extensionRegistry == null) {
            if (HAS_PARSER) {
                out.add(this.prototype.getParserForType().parseFrom(array, offset, length));
            } else {
                out.add(this.prototype.newBuilderForType().mergeFrom(array, offset, length).build());
            }
        } else if (HAS_PARSER) {
            out.add(this.prototype.getParserForType().parseFrom(array, offset, length, this.extensionRegistry));
        } else {
            out.add(this.prototype.newBuilderForType().mergeFrom(array, offset, length, this.extensionRegistry).build());
        }
    }
}
