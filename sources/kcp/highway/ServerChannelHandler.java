package kcp.highway;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kcp.highway.erasure.fec.Fec;
import kcp.highway.threadPool.IMessageExecutorPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelInboundHandlerAdapter;
import p013io.netty.channel.socket.DatagramPacket;
import p013io.netty.util.HashedWheelTimer;

/* loaded from: grasscutter.jar:kcp/highway/ServerChannelHandler.class */
public class ServerChannelHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ServerChannelHandler.class);
    private final ServerConvChannelManager channelManager;
    private final ChannelConfig channelConfig;
    private final IMessageExecutorPool iMessageExecutorPool;
    private final KcpListener kcpListener;
    private final HashedWheelTimer hashedWheelTimer;
    private final ConcurrentLinkedQueue<HandshakeWaiter> handshakeWaiters = new ConcurrentLinkedQueue<>();
    private final SecureRandom secureRandom = new SecureRandom();

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:kcp/highway/ServerChannelHandler$HandshakeWaiter.class */
    public static final class HandshakeWaiter extends Record {
        private final long convId;
        private final InetSocketAddress address;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0001: INVOKE_CUSTOM
            jadx.plugins.input.java.utils.JavaClassParseException: Can't encode constant CLASS as encoded value
            	at jadx.plugins.input.java.data.ConstPoolReader.readAsEncodedValue(ConstPoolReader.java:230)
            	at jadx.plugins.input.java.data.ConstPoolReader.resolveMethodCallSite(ConstPoolReader.java:117)
            	at jadx.plugins.input.java.data.ConstPoolReader.getCallSite(ConstPoolReader.java:97)
            	at jadx.plugins.input.java.data.code.JavaInsnData.getIndexAsCallSite(JavaInsnData.java:168)
            	at jadx.plugins.input.java.data.code.decoders.InvokeDecoder.decode(InvokeDecoder.java:32)
            	at jadx.plugins.input.java.data.code.JavaInsnData.decode(JavaInsnData.java:46)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:122)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
            	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
            */
        /*  JADX ERROR: Failed to decode insn: 0x0001: INVOKE_CUSTOM, method: kcp.highway.ServerChannelHandler.HandshakeWaiter.toString():java.lang.String
            jadx.plugins.input.java.utils.JavaClassParseException: Can't encode constant CLASS as encoded value
            	at jadx.plugins.input.java.data.ConstPoolReader.readAsEncodedValue(ConstPoolReader.java:230)
            	at jadx.plugins.input.java.data.ConstPoolReader.resolveMethodCallSite(ConstPoolReader.java:117)
            	at jadx.plugins.input.java.data.ConstPoolReader.getCallSite(ConstPoolReader.java:97)
            	at jadx.plugins.input.java.data.code.JavaInsnData.getIndexAsCallSite(JavaInsnData.java:168)
            	at jadx.plugins.input.java.data.code.decoders.InvokeDecoder.decode(InvokeDecoder.java:32)
            	at jadx.plugins.input.java.data.code.JavaInsnData.decode(JavaInsnData.java:46)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:47)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            */
        public final java.lang.String toString() {
            /*
                r2 = this;
                r0 = r2
                // decode failed: Can't encode constant CLASS as encoded value
                r1 = -1
            */
            throw new UnsupportedOperationException("Method not decompiled: kcp.highway.ServerChannelHandler.HandshakeWaiter.toString():java.lang.String");
        }

        /*  JADX ERROR: Dependency scan failed at insn: 0x0001: INVOKE_CUSTOM
            jadx.plugins.input.java.utils.JavaClassParseException: Can't encode constant CLASS as encoded value
            	at jadx.plugins.input.java.data.ConstPoolReader.readAsEncodedValue(ConstPoolReader.java:230)
            	at jadx.plugins.input.java.data.ConstPoolReader.resolveMethodCallSite(ConstPoolReader.java:117)
            	at jadx.plugins.input.java.data.ConstPoolReader.getCallSite(ConstPoolReader.java:97)
            	at jadx.plugins.input.java.data.code.JavaInsnData.getIndexAsCallSite(JavaInsnData.java:168)
            	at jadx.plugins.input.java.data.code.decoders.InvokeDecoder.decode(InvokeDecoder.java:32)
            	at jadx.plugins.input.java.data.code.JavaInsnData.decode(JavaInsnData.java:46)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:122)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
            	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
            */
        /*  JADX ERROR: Failed to decode insn: 0x0001: INVOKE_CUSTOM, method: kcp.highway.ServerChannelHandler.HandshakeWaiter.hashCode():int
            jadx.plugins.input.java.utils.JavaClassParseException: Can't encode constant CLASS as encoded value
            	at jadx.plugins.input.java.data.ConstPoolReader.readAsEncodedValue(ConstPoolReader.java:230)
            	at jadx.plugins.input.java.data.ConstPoolReader.resolveMethodCallSite(ConstPoolReader.java:117)
            	at jadx.plugins.input.java.data.ConstPoolReader.getCallSite(ConstPoolReader.java:97)
            	at jadx.plugins.input.java.data.code.JavaInsnData.getIndexAsCallSite(JavaInsnData.java:168)
            	at jadx.plugins.input.java.data.code.decoders.InvokeDecoder.decode(InvokeDecoder.java:32)
            	at jadx.plugins.input.java.data.code.JavaInsnData.decode(JavaInsnData.java:46)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:47)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            */
        public final int hashCode() {
            /*
                r2 = this;
                r0 = r2
                // decode failed: Can't encode constant CLASS as encoded value
                r1 = -1
            */
            throw new UnsupportedOperationException("Method not decompiled: kcp.highway.ServerChannelHandler.HandshakeWaiter.hashCode():int");
        }

        /*  JADX ERROR: Dependency scan failed at insn: 0x0002: INVOKE_CUSTOM
            jadx.plugins.input.java.utils.JavaClassParseException: Can't encode constant CLASS as encoded value
            	at jadx.plugins.input.java.data.ConstPoolReader.readAsEncodedValue(ConstPoolReader.java:230)
            	at jadx.plugins.input.java.data.ConstPoolReader.resolveMethodCallSite(ConstPoolReader.java:117)
            	at jadx.plugins.input.java.data.ConstPoolReader.getCallSite(ConstPoolReader.java:97)
            	at jadx.plugins.input.java.data.code.JavaInsnData.getIndexAsCallSite(JavaInsnData.java:168)
            	at jadx.plugins.input.java.data.code.decoders.InvokeDecoder.decode(InvokeDecoder.java:32)
            	at jadx.plugins.input.java.data.code.JavaInsnData.decode(JavaInsnData.java:46)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:122)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
            	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
            */
        /*  JADX ERROR: Failed to decode insn: 0x0002: INVOKE_CUSTOM, method: kcp.highway.ServerChannelHandler.HandshakeWaiter.equals(java.lang.Object):boolean
            jadx.plugins.input.java.utils.JavaClassParseException: Can't encode constant CLASS as encoded value
            	at jadx.plugins.input.java.data.ConstPoolReader.readAsEncodedValue(ConstPoolReader.java:230)
            	at jadx.plugins.input.java.data.ConstPoolReader.resolveMethodCallSite(ConstPoolReader.java:117)
            	at jadx.plugins.input.java.data.ConstPoolReader.getCallSite(ConstPoolReader.java:97)
            	at jadx.plugins.input.java.data.code.JavaInsnData.getIndexAsCallSite(JavaInsnData.java:168)
            	at jadx.plugins.input.java.data.code.decoders.InvokeDecoder.decode(InvokeDecoder.java:32)
            	at jadx.plugins.input.java.data.code.JavaInsnData.decode(JavaInsnData.java:46)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:47)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r0 = r3
                r1 = r4
                // decode failed: Can't encode constant CLASS as encoded value
                r2 = -1
            */
            throw new UnsupportedOperationException("Method not decompiled: kcp.highway.ServerChannelHandler.HandshakeWaiter.equals(java.lang.Object):boolean");
        }

        HandshakeWaiter(long convId, InetSocketAddress address) {
            this.convId = convId;
            this.address = address;
        }

        public long convId() {
            return this.convId;
        }

        public InetSocketAddress address() {
            return this.address;
        }
    }

    public void handshakeWaitersAppend(HandshakeWaiter handshakeWaiter) {
        if (this.handshakeWaiters.size() > 10) {
            this.handshakeWaiters.poll();
        }
        this.handshakeWaiters.add(handshakeWaiter);
    }

    public void handshakeWaitersRemove(HandshakeWaiter handshakeWaiter) {
        this.handshakeWaiters.remove(handshakeWaiter);
    }

    public HandshakeWaiter handshakeWaitersFind(long conv) {
        Iterator<HandshakeWaiter> it = this.handshakeWaiters.iterator();
        while (it.hasNext()) {
            HandshakeWaiter waiter = it.next();
            if (waiter.convId == conv) {
                return waiter;
            }
        }
        return null;
    }

    public HandshakeWaiter handshakeWaitersFind(InetSocketAddress address) {
        Iterator<HandshakeWaiter> it = this.handshakeWaiters.iterator();
        while (it.hasNext()) {
            HandshakeWaiter waiter = it.next();
            if (waiter.address.equals(address)) {
                return waiter;
            }
        }
        return null;
    }

    public static void handleEnet(ByteBuf data, User user, Ukcp ukcp, long conv) {
        if (data != null && data.readableBytes() == 20) {
            int code = data.readInt();
            data.readUnsignedInt();
            data.readUnsignedInt();
            int enet = data.readInt();
            data.readUnsignedInt();
            try {
                switch (code) {
                    case 255:
                        sendHandshakeRsp(user, enet, conv);
                        break;
                    case 404:
                        sendDisconnectPacket(user, 1, conv);
                        if (ukcp != null) {
                            ukcp.close();
                            break;
                        }
                        break;
                }
            } catch (Throwable th) {
            }
        }
    }

    private static void sendHandshakeRsp(User user, int enet, long conv) throws IOException {
        ByteBuf packet = Unpooled.buffer(20);
        packet.writeInt(325);
        packet.writeIntLE((int) (conv >> 32));
        packet.writeIntLE((int) (conv & 4294967295L));
        packet.writeInt(enet);
        packet.writeInt(340870469);
        UDPSend(user, packet);
    }

    public static void sendDisconnectPacket(User user, int code, long conv) throws IOException {
        ByteBuf packet = Unpooled.buffer(20);
        packet.writeInt(404);
        packet.writeIntLE((int) (conv >> 32));
        packet.writeIntLE((int) (conv & 4294967295L));
        packet.writeInt(code);
        packet.writeInt(423728276);
        UDPSend(user, packet);
    }

    private static void UDPSend(User user, ByteBuf packet) {
        user.getChannel().writeAndFlush(new DatagramPacket(packet, user.getRemoteAddress(), user.getLocalAddress()));
    }

    public ServerChannelHandler(IChannelManager channelManager, ChannelConfig channelConfig, IMessageExecutorPool iMessageExecutorPool, KcpListener kcpListener, HashedWheelTimer hashedWheelTimer) {
        this.channelManager = (ServerConvChannelManager) channelManager;
        this.channelConfig = channelConfig;
        this.iMessageExecutorPool = iMessageExecutorPool;
        this.kcpListener = kcpListener;
        this.hashedWheelTimer = hashedWheelTimer;
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.error("", cause);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r0v49, types: [long] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void channelRead(p013io.netty.channel.ChannelHandlerContext r9, java.lang.Object r10) {
        /*
        // Method dump skipped, instructions count: 392
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.ServerChannelHandler.channelRead(io.netty.channel.ChannelHandlerContext, java.lang.Object):void");
    }

    private int getSn(ByteBuf byteBuf, ChannelConfig channelConfig) {
        int headerSize = 0;
        if (channelConfig.getFecAdapt() != null) {
            headerSize = 0 + Fec.fecHeaderSizePlus2;
        }
        return byteBuf.getIntLE(byteBuf.readerIndex() + 16 + headerSize);
    }
}
