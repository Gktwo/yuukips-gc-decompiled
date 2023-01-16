package kcp.highway.threadPool.netty;

import java.util.concurrent.atomic.AtomicInteger;
import kcp.highway.threadPool.IMessageExecutor;
import kcp.highway.threadPool.IMessageExecutorPool;
import p013io.netty.channel.DefaultEventLoopGroup;
import p013io.netty.channel.EventLoopGroup;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/netty/NettyMessageExecutorPool.class */
public class NettyMessageExecutorPool implements IMessageExecutorPool {
    private EventLoopGroup eventExecutors;
    protected static final AtomicInteger index = new AtomicInteger();

    public NettyMessageExecutorPool(int workSize) {
        this.eventExecutors = new DefaultEventLoopGroup(workSize, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: IPUT  
              (wrap: io.netty.channel.DefaultEventLoopGroup : 0x000f: CONSTRUCTOR  (r1v0 io.netty.channel.DefaultEventLoopGroup A[REMOVE]) = 
              (r7v0 'workSize' int A[D('workSize' int)])
              (wrap: java.util.concurrent.ThreadFactory : 0x000a: INVOKE_CUSTOM (r4v0 java.util.concurrent.ThreadFactory A[REMOVE]) = 
             handle type: INVOKE_STATIC
             lambda: java.util.concurrent.ThreadFactory.newThread(java.lang.Runnable):java.lang.Thread
             call insn: ?: INVOKE  (v0 java.lang.Runnable) type: STATIC call: kcp.highway.threadPool.netty.NettyMessageExecutorPool.lambda$new$0(java.lang.Runnable):java.lang.Thread)
             call: io.netty.channel.DefaultEventLoopGroup.<init>(int, java.util.concurrent.ThreadFactory):void type: CONSTRUCTOR)
              (r6v0 'this' kcp.highway.threadPool.netty.NettyMessageExecutorPool A[D('this' kcp.highway.threadPool.netty.NettyMessageExecutorPool), IMMUTABLE_TYPE, THIS])
             kcp.highway.threadPool.netty.NettyMessageExecutorPool.eventExecutors io.netty.channel.EventLoopGroup in method: kcp.highway.threadPool.netty.NettyMessageExecutorPool.<init>(int):void, file: grasscutter.jar:kcp/highway/threadPool/netty/NettyMessageExecutorPool.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:900)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:711)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:393)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:462)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r0.<init>()
            r0 = r6
            io.netty.channel.DefaultEventLoopGroup r1 = new io.netty.channel.DefaultEventLoopGroup
            r2 = r1
            r3 = r7
            void r4 = (v0) -> { // java.util.concurrent.ThreadFactory.newThread(java.lang.Runnable):java.lang.Thread
                return lambda$new$0(v0);
            }
            r2.<init>(r3, r4)
            r0.eventExecutors = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.threadPool.netty.NettyMessageExecutorPool.<init>(int):void");
    }

    @Override // kcp.highway.threadPool.IMessageExecutorPool
    public IMessageExecutor getIMessageExecutor() {
        return new NettyMessageExecutor(this.eventExecutors.next());
    }

    @Override // kcp.highway.threadPool.IMessageExecutorPool
    public void stop() {
        if (!this.eventExecutors.isShuttingDown()) {
            this.eventExecutors.shutdownGracefully();
        }
    }
}
