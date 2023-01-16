package kcp.highway;

import java.net.InetSocketAddress;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kcp.highway.erasure.fec.Fec;
import kcp.highway.threadPool.IMessageExecutor;
import kcp.highway.threadPool.IMessageExecutorPool;
import p013io.netty.bootstrap.Bootstrap;
import p013io.netty.channel.ChannelInitializer;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.EventLoopGroup;
import p013io.netty.channel.nio.NioEventLoopGroup;
import p013io.netty.channel.socket.nio.NioDatagramChannel;
import p013io.netty.util.HashedWheelTimer;

/* loaded from: grasscutter.jar:kcp/highway/KcpClient.class */
public class KcpClient {
    private IMessageExecutorPool iMessageExecutorPool;
    private Bootstrap bootstrap;
    private EventLoopGroup nioEventLoopGroup;
    private IChannelManager channelManager;
    private HashedWheelTimer hashedWheelTimer;

    /* loaded from: grasscutter.jar:kcp/highway/KcpClient$TimerThreadFactory.class */
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
        /*  JADX ERROR: Failed to decode insn: 0x000D: INVOKE_CUSTOM r3, method: kcp.highway.KcpClient.TimerThreadFactory.newThread(java.lang.Runnable):java.lang.Thread
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, KcpClientTimerThread ]}
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
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, KcpClientTimerThread ]}
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
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, KcpClientTimerThread ]}
                r1.<init>(r2, r3)
                r8 = r0
                r0 = r8
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kcp.highway.KcpClient.TimerThreadFactory.newThread(java.lang.Runnable):java.lang.Thread");
        }

        private TimerThreadFactory() {
        }
    }

    public void init(final ChannelConfig channelConfig) {
        if (channelConfig.isUseConvChannel()) {
            int convIndex = 0;
            if (channelConfig.getFecAdapt() != null) {
                convIndex = 0 + Fec.fecHeaderSizePlus2;
            }
            this.channelManager = new ClientConvChannelManager(convIndex);
        } else {
            this.channelManager = new ClientAddressChannelManager();
        }
        this.iMessageExecutorPool = channelConfig.getiMessageExecutorPool();
        this.nioEventLoopGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors());
        this.hashedWheelTimer = new HashedWheelTimer(new TimerThreadFactory(), 1, TimeUnit.MILLISECONDS);
        this.bootstrap = new Bootstrap();
        this.bootstrap.channel(NioDatagramChannel.class);
        this.bootstrap.group(this.nioEventLoopGroup);
        this.bootstrap.handler(new ChannelInitializer<NioDatagramChannel>() { // from class: kcp.highway.KcpClient.1
            /* access modifiers changed from: protected */
            public void initChannel(NioDatagramChannel ch) {
                ChannelPipeline cp = ch.pipeline();
                if (channelConfig.isCrc32Check()) {
                    Crc32Encode crc32Encode = new Crc32Encode();
                    Crc32Decode crc32Decode = new Crc32Decode();
                    cp.addLast(crc32Encode);
                    cp.addLast(crc32Decode);
                }
                cp.addLast(new ClientChannelHandler(KcpClient.this.channelManager));
            }
        });
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            stop();
        }));
    }

    public void reconnect(Ukcp ukcp) {
        if (!(this.channelManager instanceof ClientConvChannelManager)) {
            throw new UnsupportedOperationException("reconnect can only be used in convChannel");
        }
        ukcp.getiMessageExecutor().execute(()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001f: INVOKE  
              (wrap: kcp.highway.threadPool.IMessageExecutor : 0x0015: INVOKE  (r0v4 kcp.highway.threadPool.IMessageExecutor A[REMOVE]) = (r5v0 'ukcp' kcp.highway.Ukcp A[D('ukcp' kcp.highway.Ukcp)]) type: VIRTUAL call: kcp.highway.Ukcp.getiMessageExecutor():kcp.highway.threadPool.IMessageExecutor)
              (wrap: kcp.highway.threadPool.ITask : 0x001a: INVOKE_CUSTOM (r1v1 kcp.highway.threadPool.ITask A[REMOVE]) = 
              (r4v0 'this' kcp.highway.KcpClient A[D('this' kcp.highway.KcpClient), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r5v0 'ukcp' kcp.highway.Ukcp A[D('ukcp' kcp.highway.Ukcp), DONT_INLINE])
            
             handle type: INVOKE_INSTANCE
             lambda: kcp.highway.threadPool.ITask.execute():void
             call insn: ?: INVOKE  (r1 I:kcp.highway.KcpClient), (r2 I:kcp.highway.Ukcp) type: VIRTUAL call: kcp.highway.KcpClient.lambda$reconnect$1(kcp.highway.Ukcp):void)
             type: INTERFACE call: kcp.highway.threadPool.IMessageExecutor.execute(kcp.highway.threadPool.ITask):void in method: kcp.highway.KcpClient.reconnect(kcp.highway.Ukcp):void, file: grasscutter.jar:kcp/highway/KcpClient.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 19 more
            */
        /*
            this = this;
            r0 = r4
            kcp.highway.IChannelManager r0 = r0.channelManager
            boolean r0 = r0 instanceof kcp.highway.ClientConvChannelManager
            if (r0 != 0) goto L_0x0014
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            r1 = r0
            java.lang.String r2 = "reconnect can only be used in convChannel"
            r1.<init>(r2)
            throw r0
        L_0x0014:
            r0 = r5
            kcp.highway.threadPool.IMessageExecutor r0 = r0.getiMessageExecutor()
            r1 = r4
            r2 = r5
            void r1 = () -> { // kcp.highway.threadPool.ITask.execute():void
                r1.lambda$reconnect$1(r2);
            }
            r0.execute(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.KcpClient.reconnect(kcp.highway.Ukcp):void");
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [io.netty.channel.ChannelFuture] */
    public Ukcp connect(InetSocketAddress localAddress, InetSocketAddress remoteAddress, ChannelConfig channelConfig, KcpListener kcpListener) {
        if (localAddress == null) {
            localAddress = new InetSocketAddress(0);
        }
        NioDatagramChannel channel = (NioDatagramChannel) this.bootstrap.connect(remoteAddress, localAddress).syncUninterruptibly().channel();
        InetSocketAddress localAddress2 = channel.localAddress();
        User user = new User(channel, remoteAddress, localAddress2);
        IMessageExecutor iMessageExecutor = this.iMessageExecutorPool.getIMessageExecutor();
        Ukcp ukcp = new Ukcp(new KcpOutPutImp(), kcpListener, iMessageExecutor, channelConfig, this.channelManager);
        ukcp.user(user);
        this.channelManager.New(localAddress2, ukcp, null);
        iMessageExecutor.execute(() -> {
            try {
                ukcp.getKcpListener().onConnected(ukcp);
            } catch (Throwable throwable) {
                ukcp.getKcpListener().handleException(throwable, ukcp);
            }
        });
        this.hashedWheelTimer.newTimeout(new ScheduleTask(iMessageExecutor, ukcp, this.hashedWheelTimer), (long) ukcp.getInterval(), TimeUnit.MILLISECONDS);
        return ukcp;
    }

    public Ukcp connect(InetSocketAddress remoteAddress, ChannelConfig channelConfig, KcpListener kcpListener) {
        return connect(null, remoteAddress, channelConfig, kcpListener);
    }

    public void stop() {
        this.channelManager.getAll().forEach(ukcp -> {
            try {
                ukcp.close();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        if (this.iMessageExecutorPool != null) {
            this.iMessageExecutorPool.stop();
        }
        if (this.nioEventLoopGroup != null) {
            this.nioEventLoopGroup.shutdownGracefully();
        }
        if (this.hashedWheelTimer != null) {
            this.hashedWheelTimer.stop();
        }
    }

    public IChannelManager getChannelManager() {
        return this.channelManager;
    }
}
