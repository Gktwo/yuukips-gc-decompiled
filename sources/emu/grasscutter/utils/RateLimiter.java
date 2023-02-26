package emu.grasscutter.utils;

import com.google.common.util.concurrent.AtomicLongMap;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import p013io.javalin.http.HttpResponseException;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "blocks" is null
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:894)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:367)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:119)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:49)
    */
/* loaded from: grasscutter.jar:emu/grasscutter/utils/RateLimiter.class */
public class RateLimiter {
    private static final Map<String, RateLimiter> RATE_LIMITER_MAP = new ConcurrentHashMap();
    private final AtomicLongMap<String> map;
    private final long limit;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0019: INVOKE_CUSTOM r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x0019: INVOKE_CUSTOM r1, method: emu.grasscutter.utils.RateLimiter.<init>(java.lang.String, long, java.util.concurrent.TimeUnit, long):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, rate-limiter-]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, rate-limiter-]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private RateLimiter(java.lang.String r9, long r10, java.util.concurrent.TimeUnit r12, long r13) {
        /*
            r8 = this;
            r0 = r8
            r0.<init>()
            r0 = r8
            com.google.common.util.concurrent.AtomicLongMap r1 = com.google.common.util.concurrent.AtomicLongMap.create()
            r0.map = r1
            r0 = r8
            r1 = r13
            r0.limit = r1
            com.google.common.util.concurrent.ThreadFactoryBuilder r0 = new com.google.common.util.concurrent.ThreadFactoryBuilder
            r1 = r0
            r1.<init>()
            r1 = r9
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, rate-limiter-]}
            com.google.common.util.concurrent.ThreadFactoryBuilder r0 = r0.setNameFormat(r1)
            java.util.concurrent.ThreadFactory r0 = r0.build()
            java.util.concurrent.ScheduledExecutorService r0 = java.util.concurrent.Executors.newSingleThreadScheduledExecutor(r0)
            r1 = r8
            void r1 = () -> { // java.lang.Runnable.run():void
                r1.lambda$new$4();
            }
            r2 = r10
            r3 = r10
            r4 = r12
            java.util.concurrent.ScheduledFuture r0 = r0.scheduleAtFixedRate(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.utils.RateLimiter.<init>(java.lang.String, long, java.util.concurrent.TimeUnit, long):void");
    }

    static {
        Executors.newSingleThreadScheduledExecutor(new ThreadFactoryBuilder().setNameFormat("rate-limiter-cleaner").build()).scheduleAtFixedRate(() -> {
            RATE_LIMITER_MAP.values().forEach(rateLimiter -> {
                rateLimiter.map.removeAllZeros();
            });
        }, 1, 1, TimeUnit.MINUTES);
    }

    private boolean rateLimit(String key) {
        return this.limit == this.map.getAndUpdate(key, counter -> {
            return counter == this.limit ? counter : counter + 1;
        });
    }

    public static RateLimiter getRateLimiter(String name, long decrementDelay, TimeUnit unit) {
        return getRateLimiter(name, decrementDelay, unit, 1);
    }

    public static RateLimiter getRateLimiter(String name, long decrementDelay, TimeUnit unit, long limit) {
        return RATE_LIMITER_MAP.computeIfAbsent(name, $ -> {
            return new RateLimiter(name, decrementDelay, unit, limit);
        });
    }

    public static void rateLimit(String name, String key, long decrementDelay, TimeUnit unit) {
        rateLimit(name, key, decrementDelay, unit, 1);
    }

    public static void rateLimit(String name, String key, long decrementDelay, TimeUnit unit, long limit) {
        if (getRateLimiter(name, decrementDelay, unit, limit).rateLimit(key)) {
            throw new HttpResponseException(429, "Rate limit exceeded", Map.of());
        }
    }
}
