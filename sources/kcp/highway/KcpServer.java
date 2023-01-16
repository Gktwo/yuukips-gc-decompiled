package kcp.highway;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kcp.highway.erasure.fec.Fec;
import kcp.highway.threadPool.IMessageExecutorPool;
import p013io.netty.bootstrap.Bootstrap;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelInitializer;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.EventLoopGroup;
import p013io.netty.channel.epoll.Epoll;
import p013io.netty.channel.epoll.EpollChannelOption;
import p013io.netty.channel.epoll.EpollDatagramChannel;
import p013io.netty.channel.epoll.EpollEventLoopGroup;
import p013io.netty.channel.kqueue.KQueue;
import p013io.netty.channel.kqueue.KQueueDatagramChannel;
import p013io.netty.channel.kqueue.KQueueEventLoopGroup;
import p013io.netty.channel.nio.NioEventLoopGroup;
import p013io.netty.channel.socket.nio.NioDatagramChannel;
import p013io.netty.util.HashedWheelTimer;

/* loaded from: grasscutter.jar:kcp/highway/KcpServer.class */
public class KcpServer {
    private IMessageExecutorPool iMessageExecutorPool;
    private Bootstrap bootstrap;
    private EventLoopGroup group;
    private List<Channel> localAddresss = new Vector();
    private IChannelManager channelManager;
    private HashedWheelTimer hashedWheelTimer;

    /* loaded from: grasscutter.jar:kcp/highway/KcpServer$TimerThreadFactory.class */
    private static class TimerThreadFactory implements ThreadFactory {
        private AtomicInteger timeThreadName = new AtomicInteger(0);

        /*  JADX ERROR: Dependency scan failed at insn: 0x000D: INVOKE_CUSTOM r-1
            java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
            	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
            */
        /*  JADX ERROR: Failed to decode insn: 0x000D: INVOKE_CUSTOM r3, method: kcp.highway.KcpServer.TimerThreadFactory.newThread(java.lang.Runnable):java.lang.Thread
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, KcpServerTimerThread ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, KcpServerTimerThread ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable r7) {
            /*
                r6 = this;
                java.lang.Thread r0 = new java.lang.Thread
                r1 = r0
                r2 = r7
                r3 = r6
                java.util.concurrent.atomic.AtomicInteger r3 = r3.timeThreadName
                r4 = 1
                int r3 = r3.addAndGet(r4)
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, KcpServerTimerThread ]}
                r1.<init>(r2, r3)
                r8 = r0
                r0 = r8
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kcp.highway.KcpServer.TimerThreadFactory.newThread(java.lang.Runnable):java.lang.Thread");
        }

        private TimerThreadFactory() {
        }
    }

    public void init(final KcpListener kcpListener, final ChannelConfig channelConfig, InetSocketAddress... addresses) {
        Class<? extends Channel> channelClass;
        if (channelConfig.isUseConvChannel()) {
            int convIndex = 0;
            if (channelConfig.getFecAdapt() != null) {
                convIndex = 0 + Fec.fecHeaderSizePlus2;
            }
            this.channelManager = new ServerConvChannelManager(convIndex);
        } else {
            this.channelManager = new ServerAddressChannelManager();
        }
        this.hashedWheelTimer = new HashedWheelTimer(new TimerThreadFactory(), 1, TimeUnit.MILLISECONDS);
        boolean epoll = Epoll.isAvailable();
        boolean kqueue = KQueue.isAvailable();
        this.iMessageExecutorPool = channelConfig.getiMessageExecutorPool();
        this.bootstrap = new Bootstrap();
        int cpuNum = Runtime.getRuntime().availableProcessors();
        int bindTimes = 1;
        if (epoll || kqueue) {
            this.bootstrap.option(EpollChannelOption.SO_REUSEPORT, true);
            bindTimes = cpuNum;
        }
        if (epoll) {
            this.group = new EpollEventLoopGroup(cpuNum);
            channelClass = EpollDatagramChannel.class;
        } else if (kqueue) {
            this.group = new KQueueEventLoopGroup(cpuNum);
            channelClass = KQueueDatagramChannel.class;
        } else {
            this.group = new NioEventLoopGroup(addresses.length);
            channelClass = NioDatagramChannel.class;
        }
        this.bootstrap.channel(channelClass);
        this.bootstrap.group(this.group);
        this.bootstrap.handler(new ChannelInitializer<Channel>() { // from class: kcp.highway.KcpServer.1
            @Override // p013io.netty.channel.ChannelInitializer
            protected void initChannel(Channel ch) {
                ServerChannelHandler serverChannelHandler = new ServerChannelHandler(KcpServer.this.channelManager, channelConfig, KcpServer.this.iMessageExecutorPool, kcpListener, KcpServer.this.hashedWheelTimer);
                ChannelPipeline cp = ch.pipeline();
                if (channelConfig.isCrc32Check()) {
                    Crc32Encode crc32Encode = new Crc32Encode();
                    Crc32Decode crc32Decode = new Crc32Decode();
                    cp.addLast(crc32Encode);
                    cp.addLast(crc32Decode);
                }
                cp.addLast(serverChannelHandler);
            }
        });
        this.bootstrap.option(ChannelOption.SO_REUSEADDR, true);
        for (InetSocketAddress addres : addresses) {
            for (int i = 0; i < bindTimes; i++) {
                this.localAddresss.add(this.bootstrap.bind(addres).channel());
            }
        }
        Runtime.getRuntime().addShutdownHook(new Thread(this::stop));
    }

    public void stop() {
        this.localAddresss.forEach((v0) -> {
            v0.close();
        });
        this.channelManager.getAll().forEach((v0) -> {
            v0.close();
        });
        if (this.iMessageExecutorPool != null) {
            this.iMessageExecutorPool.stop();
        }
        if (this.hashedWheelTimer != null) {
            this.hashedWheelTimer.stop();
        }
        if (this.group != null) {
            this.group.shutdownGracefully();
        }
    }

    public IChannelManager getChannelManager() {
        return this.channelManager;
    }
}
