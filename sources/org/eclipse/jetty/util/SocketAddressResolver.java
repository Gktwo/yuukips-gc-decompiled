package org.eclipse.jetty.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/SocketAddressResolver.class */
public interface SocketAddressResolver {
    void resolve(String str, int i, Promise<List<InetSocketAddress>> promise);

    @ManagedObject("The synchronous address resolver")
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/SocketAddressResolver$Sync.class */
    public static class Sync implements SocketAddressResolver {
        @Override // org.eclipse.jetty.util.SocketAddressResolver
        public void resolve(String host, int port, Promise<List<InetSocketAddress>> promise) {
            try {
                InetAddress[] addresses = InetAddress.getAllByName(host);
                List<InetSocketAddress> result = new ArrayList<>(addresses.length);
                for (InetAddress address : addresses) {
                    result.add(new InetSocketAddress(address, port));
                }
                if (result.isEmpty()) {
                    promise.failed(new UnknownHostException());
                } else {
                    promise.succeeded(result);
                }
            } catch (Throwable x) {
                promise.failed(x);
            }
        }
    }

    @ManagedObject("The asynchronous address resolver")
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/SocketAddressResolver$Async.class */
    public static class Async implements SocketAddressResolver {
        private static final Logger LOG = Log.getLogger(SocketAddressResolver.class);
        private final Executor executor;
        private final Scheduler scheduler;
        private final long timeout;

        public Async(Executor executor, Scheduler scheduler, long timeout) {
            this.executor = executor;
            this.scheduler = scheduler;
            this.timeout = timeout;
        }

        public Executor getExecutor() {
            return this.executor;
        }

        public Scheduler getScheduler() {
            return this.scheduler;
        }

        @ManagedAttribute(value = "The timeout, in milliseconds, to resolve an address", readonly = true)
        public long getTimeout() {
            return this.timeout;
        }

        @Override // org.eclipse.jetty.util.SocketAddressResolver
        public void resolve(String host, int port, Promise<List<InetSocketAddress>> promise) {
            this.executor.execute(()
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  
                  (wrap: java.util.concurrent.Executor : 0x0001: IGET  (r0v1 java.util.concurrent.Executor A[REMOVE]) = 
                  (r6v0 'this' org.eclipse.jetty.util.SocketAddressResolver$Async A[D('this' org.eclipse.jetty.util.SocketAddressResolver$Async), IMMUTABLE_TYPE, THIS])
                 org.eclipse.jetty.util.SocketAddressResolver.Async.executor java.util.concurrent.Executor)
                  (wrap: java.lang.Runnable : 0x0008: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
                  (r6v0 'this' org.eclipse.jetty.util.SocketAddressResolver$Async A[D('this' org.eclipse.jetty.util.SocketAddressResolver$Async), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                  (r9v0 'promise' org.eclipse.jetty.util.Promise<java.util.List<java.net.InetSocketAddress>> A[D('promise' org.eclipse.jetty.util.Promise<java.util.List<java.net.InetSocketAddress>>), DONT_INLINE])
                  (r7v0 'host' java.lang.String A[D('host' java.lang.String), DONT_INLINE])
                  (r8v0 'port' int A[D('port' int), DONT_INLINE])
                
                 handle type: INVOKE_DIRECT
                 lambda: java.lang.Runnable.run():void
                 call insn: ?: INVOKE  
                  (r1 I:org.eclipse.jetty.util.SocketAddressResolver$Async)
                  (r2 I:org.eclipse.jetty.util.Promise)
                  (r3 I:java.lang.String)
                  (r4 I:int)
                 type: DIRECT call: org.eclipse.jetty.util.SocketAddressResolver.Async.lambda$resolve$1(org.eclipse.jetty.util.Promise, java.lang.String, int):void)
                 type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: org.eclipse.jetty.util.SocketAddressResolver.Async.resolve(java.lang.String, int, org.eclipse.jetty.util.Promise<java.util.List<java.net.InetSocketAddress>>):void, file: grasscutter.jar:org/eclipse/jetty/util/SocketAddressResolver$Async.class
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
                Caused by: java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
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
                	... 15 more
                */
            /*
                this = this;
                r0 = r6
                java.util.concurrent.Executor r0 = r0.executor
                r1 = r6
                r2 = r9
                r3 = r7
                r4 = r8
                void r1 = () -> { // java.lang.Runnable.run():void
                    r1.lambda$resolve$1(r2, r3, r4);
                }
                r0.execute(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.SocketAddressResolver.Async.resolve(java.lang.String, int, org.eclipse.jetty.util.Promise):void");
        }
    }
}
