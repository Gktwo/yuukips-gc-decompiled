package org.greenrobot.eventbus.util;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;

/* loaded from: grasscutter.jar:org/greenrobot/eventbus/util/AsyncExecutor.class */
public class AsyncExecutor {
    private final Executor threadPool;
    private final Constructor<?> failureEventConstructor;
    private final EventBus eventBus;
    private final Object scope;

    /* loaded from: grasscutter.jar:org/greenrobot/eventbus/util/AsyncExecutor$RunnableEx.class */
    public interface RunnableEx {
        void run() throws Exception;
    }

    /* loaded from: grasscutter.jar:org/greenrobot/eventbus/util/AsyncExecutor$Builder.class */
    public static class Builder {
        private Executor threadPool;
        private Class<?> failureEventType;
        private EventBus eventBus;

        private Builder() {
        }

        public Builder threadPool(Executor threadPool) {
            this.threadPool = threadPool;
            return this;
        }

        public Builder failureEventType(Class<?> failureEventType) {
            this.failureEventType = failureEventType;
            return this;
        }

        public Builder eventBus(EventBus eventBus) {
            this.eventBus = eventBus;
            return this;
        }

        public AsyncExecutor build() {
            return buildForScope(null);
        }

        public AsyncExecutor buildForScope(Object executionContext) {
            if (this.eventBus == null) {
                this.eventBus = EventBus.getDefault();
            }
            if (this.threadPool == null) {
                this.threadPool = Executors.newCachedThreadPool();
            }
            if (this.failureEventType == null) {
                this.failureEventType = ThrowableFailureEvent.class;
            }
            return new AsyncExecutor(this.threadPool, this.eventBus, this.failureEventType, executionContext);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static AsyncExecutor create() {
        return new Builder().build();
    }

    private AsyncExecutor(Executor threadPool, EventBus eventBus, Class<?> failureEventType, Object scope) {
        this.threadPool = threadPool;
        this.eventBus = eventBus;
        this.scope = scope;
        try {
            this.failureEventConstructor = failureEventType.getConstructor(Throwable.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e);
        }
    }

    public void execute(RunnableEx runnable) {
        this.threadPool.execute(()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
              (wrap: java.util.concurrent.Executor : 0x0001: IGET  (r0v1 java.util.concurrent.Executor A[REMOVE]) = 
              (r4v0 'this' org.greenrobot.eventbus.util.AsyncExecutor A[D('this' org.greenrobot.eventbus.util.AsyncExecutor), IMMUTABLE_TYPE, THIS])
             org.greenrobot.eventbus.util.AsyncExecutor.threadPool java.util.concurrent.Executor)
              (wrap: java.lang.Runnable : 0x0006: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
              (r4v0 'this' org.greenrobot.eventbus.util.AsyncExecutor A[D('this' org.greenrobot.eventbus.util.AsyncExecutor), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r5v0 'runnable' org.greenrobot.eventbus.util.AsyncExecutor$RunnableEx A[D('runnable' org.greenrobot.eventbus.util.AsyncExecutor$RunnableEx), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r1 I:org.greenrobot.eventbus.util.AsyncExecutor), (r2 I:org.greenrobot.eventbus.util.AsyncExecutor$RunnableEx) type: DIRECT call: org.greenrobot.eventbus.util.AsyncExecutor.lambda$execute$0(org.greenrobot.eventbus.util.AsyncExecutor$RunnableEx):void)
             type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: org.greenrobot.eventbus.util.AsyncExecutor.execute(org.greenrobot.eventbus.util.AsyncExecutor$RunnableEx):void, file: grasscutter.jar:org/greenrobot/eventbus/util/AsyncExecutor.class
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
            	... 15 more
            */
        /*
            this = this;
            r0 = r4
            java.util.concurrent.Executor r0 = r0.threadPool
            r1 = r4
            r2 = r5
            void r1 = () -> { // java.lang.Runnable.run():void
                r1.lambda$execute$0(r2);
            }
            r0.execute(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.util.AsyncExecutor.execute(org.greenrobot.eventbus.util.AsyncExecutor$RunnableEx):void");
    }
}
