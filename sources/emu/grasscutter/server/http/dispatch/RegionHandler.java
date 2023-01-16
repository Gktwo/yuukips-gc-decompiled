package emu.grasscutter.server.http.dispatch;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass;
import emu.grasscutter.server.event.dispatch.QueryAllRegionsEvent;
import emu.grasscutter.server.http.Router;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p013io.javalin.Javalin;
import p013io.javalin.http.Context;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/dispatch/RegionHandler.class */
public final class RegionHandler implements Router {
    private static final Map<String, RegionData> regions = new ConcurrentHashMap();
    private static String regionListResponse;

    /*  JADX ERROR: Dependency scan failed at insn: 0x002E: INVOKE_CUSTOM r0, r1, r2
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
    /*  JADX ERROR: Failed to decode insn: 0x002E: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.server.http.dispatch.RegionHandler.initialize():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, I)Ljava/lang/String;}, http://:]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, I)Ljava/lang/String;}, http://:]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private void initialize() {
        /*
            r10 = this;
            emu.grasscutter.config.ConfigContainer$Encryption r0 = emu.grasscutter.config.Configuration.HTTP_ENCRYPTION
            boolean r0 = r0.useInRouting
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = "s"
            goto L_0x0010
            java.lang.String r0 = ""
            emu.grasscutter.config.ConfigContainer$HTTP r1 = emu.grasscutter.config.Configuration.HTTP_INFO
            java.lang.String r1 = r1.accessAddress
            emu.grasscutter.config.ConfigContainer$HTTP r2 = emu.grasscutter.config.Configuration.HTTP_INFO
            java.lang.String r2 = r2.bindAddress
            java.lang.String r1 = emu.grasscutter.config.Configuration.m1214lr(r1, r2)
            emu.grasscutter.config.ConfigContainer$HTTP r2 = emu.grasscutter.config.Configuration.HTTP_INFO
            int r2 = r2.accessPort
            emu.grasscutter.config.ConfigContainer$HTTP r3 = emu.grasscutter.config.Configuration.HTTP_INFO
            int r3 = r3.bindPort
            int r2 = emu.grasscutter.config.Configuration.m1216lr(r2, r3)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, I)Ljava/lang/String;}, http://:]}
            r11 = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r12 = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r13 = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            emu.grasscutter.config.ConfigContainer$Dispatch r2 = emu.grasscutter.config.Configuration.DISPATCH_INFO
            emu.grasscutter.config.ConfigContainer$Region[] r2 = r2.regions
            java.util.List r2 = java.util.List.of(r2)
            r1.<init>(r2)
            r14 = r0
            emu.grasscutter.config.ConfigContainer$Server r0 = emu.grasscutter.config.Configuration.SERVER
            emu.grasscutter.Grasscutter$ServerRunMode r0 = r0.runMode
            emu.grasscutter.Grasscutter$ServerRunMode r1 = emu.grasscutter.Grasscutter.ServerRunMode.HYBRID
            if (r0 == r1) goto L_0x0073
            r0 = r14
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0073
            r0 = 0
            java.lang.String r1 = "[Dispatch] There are no game servers available. Exiting due to unplayable state."
            emu.grasscutter.server.game.GameServer.doExit(r0, r1)
            goto L_0x00b1
            r0 = r14
            int r0 = r0.size()
            if (r0 != 0) goto L_0x00b1
            r0 = r14
            emu.grasscutter.config.ConfigContainer$Region r1 = new emu.grasscutter.config.ConfigContainer$Region
            r2 = r1
            java.lang.String r3 = "os_usa"
            emu.grasscutter.config.ConfigContainer$Dispatch r4 = emu.grasscutter.config.Configuration.DISPATCH_INFO
            java.lang.String r4 = r4.defaultName
            emu.grasscutter.config.ConfigContainer$Game r5 = emu.grasscutter.config.Configuration.GAME_INFO
            java.lang.String r5 = r5.accessAddress
            emu.grasscutter.config.ConfigContainer$Game r6 = emu.grasscutter.config.Configuration.GAME_INFO
            java.lang.String r6 = r6.bindAddress
            java.lang.String r5 = emu.grasscutter.config.Configuration.m1214lr(r5, r6)
            emu.grasscutter.config.ConfigContainer$Game r6 = emu.grasscutter.config.Configuration.GAME_INFO
            int r6 = r6.accessPort
            emu.grasscutter.config.ConfigContainer$Game r7 = emu.grasscutter.config.Configuration.GAME_INFO
            int r7 = r7.bindPort
            int r6 = emu.grasscutter.config.Configuration.m1216lr(r6, r7)
            java.lang.String r7 = ""
            r8 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            boolean r0 = r0.add(r1)
            r0 = r14
            r1 = r13
            r2 = r11
            r3 = r12
            void r1 = (v3) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$initialize$0(r1, r2, r3, v3);
            }
            r0.forEach(r1)
            java.lang.String r0 = "{\"sdkenv\":\"2\",\"checkdevice\":\"false\",\"loadPatch\":\"false\",\"showexception\":\"false\",\"regionConfig\":\"pm|fk|add\",\"downloadMode\":\"0\"}"
            byte[] r0 = r0.getBytes()
            r15 = r0
            r0 = r15
            byte[] r1 = emu.grasscutter.utils.Crypto.DISPATCH_KEY
            emu.grasscutter.utils.Crypto.xor(r0, r1)
            emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass$QueryRegionListHttpRsp$Builder r0 = emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRsp.newBuilder()
            r1 = r12
            emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass$QueryRegionListHttpRsp$Builder r0 = r0.addAllRegionList(r1)
            byte[] r1 = emu.grasscutter.utils.Crypto.DISPATCH_SEED
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFrom(r1)
            emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass$QueryRegionListHttpRsp$Builder r0 = r0.setClientSecretKey(r1)
            r1 = r15
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFrom(r1)
            emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass$QueryRegionListHttpRsp$Builder r0 = r0.setClientCustomConfigEncrypted(r1)
            r1 = 1
            emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass$QueryRegionListHttpRsp$Builder r0 = r0.setEnableLoginPc(r1)
            emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass$QueryRegionListHttpRsp r0 = r0.build()
            r16 = r0
            r0 = r16
            com.google.protobuf.ByteString r0 = r0.toByteString()
            byte[] r0 = r0.toByteArray()
            java.lang.String r0 = emu.grasscutter.utils.Utils.base64Encode(r0)
            emu.grasscutter.server.http.dispatch.RegionHandler.regionListResponse = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.http.dispatch.RegionHandler.initialize():void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x00BF: INVOKE_CUSTOM r-8, r-7, r-6, r-5, r-4
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
    /*  JADX ERROR: Failed to decode insn: 0x00BF: INVOKE_CUSTOM r1, r2, r3, r4, r5, method: emu.grasscutter.server.http.dispatch.RegionHandler.queryCurrentRegion(io.javalin.http.Context):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Client  () (KEY: ) (SEED: ) request: query_cur_region/]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Client  () (KEY: ) (SEED: ) request: query_cur_region/]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void queryCurrentRegion(p013io.javalin.http.Context r7) {
        /*
        // Method dump skipped, instructions count: 613
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.http.dispatch.RegionHandler.queryCurrentRegion(io.javalin.http.Context):void");
    }

    public RegionHandler() {
        try {
            initialize();
        } catch (Exception exception) {
            Grasscutter.getLogger().error("Failed to initialize region data.", (Throwable) exception);
        }
    }

    @Override // emu.grasscutter.server.http.Router
    public void applyRoutes(Javalin javalin) {
        javalin.get("/query_region_list", RegionHandler::queryRegionList);
        javalin.get("/query_cur_region/{region}", RegionHandler::queryCurrentRegion);
    }

    private static void queryRegionList(Context ctx) {
        QueryAllRegionsEvent event = new QueryAllRegionsEvent(regionListResponse);
        event.call();
        ctx.result(event.getRegionList());
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/server/http/dispatch/RegionHandler$RegionData.class */
    public static class RegionData {
        private final QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp regionQuery;
        private final String base64;

        public RegionData(QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp prq, String b64) {
            this.regionQuery = prq;
            this.base64 = b64;
        }

        public QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp getRegionQuery() {
            return this.regionQuery;
        }

        public String getBase64() {
            return this.base64;
        }
    }

    public static QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp getCurrentRegion() {
        try {
            if (Configuration.SERVER.runMode == Grasscutter.ServerRunMode.HYBRID) {
                return regions.get("os_usa").getRegionQuery();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
