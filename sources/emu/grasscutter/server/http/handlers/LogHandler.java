package emu.grasscutter.server.http.handlers;

import emu.grasscutter.server.http.Router;
import p013io.javalin.Javalin;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/handlers/LogHandler.class */
public final class LogHandler implements Router {
    /*  JADX ERROR: Dependency scan failed at insn: 0x0007: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0007: INVOKE_CUSTOM r1, method: emu.grasscutter.server.http.handlers.LogHandler.cloud(io.javalin.http.Context):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Cloud URL: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Cloud URL: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void cloud(p013io.javalin.http.Context r3) {
        /*
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r3
            java.lang.String r1 = r1.url()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Cloud URL: ]}
            r0.warn(r1)
            r0 = r3
            java.lang.String r1 = "https://ps.yuuki.me/command"
            r0.redirect(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.http.handlers.LogHandler.cloud(io.javalin.http.Context):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0014: INVOKE_CUSTOM r-1, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0014: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.server.http.handlers.LogHandler.raw(io.javalin.http.Context):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, RAW Unknown : ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, RAW Unknown : ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void raw(p013io.javalin.http.Context r5) {
        /*
            r0 = r5
            java.lang.String r0 = r0.body()
            r6 = r0
            r0 = r6
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x001c
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r5
            java.lang.String r1 = r1.endpointHandlerPath()
            r2 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, RAW Unknown : ]}
            r0.debug(r1)
            r0 = r5
            emu.grasscutter.server.http.objects.JsonResponse r1 = new emu.grasscutter.server.http.objects.JsonResponse
            r2 = r1
            r3 = 404(0x194, float:5.66E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.<init>(r3)
            io.javalin.http.Context r0 = r0.json(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.http.handlers.LogHandler.raw(io.javalin.http.Context):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0071: INVOKE_CUSTOM r-3, r-2, r-1
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0087: INVOKE_CUSTOM r-3
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
    /*  JADX ERROR: Failed to decode insn: 0x0071: INVOKE_CUSTOM r1, r2, r3, method: emu.grasscutter.server.http.handlers.LogHandler.loginfo(io.javalin.http.Context):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Integer;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Log (ID: ) (Action: ) (RAW: )]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Integer;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Log (ID: ) (Action: ) (RAW: )]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0087: INVOKE_CUSTOM r1, method: emu.grasscutter.server.http.handlers.LogHandler.loginfo(io.javalin.http.Context):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, RAW Log Info: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, RAW Log Info: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void loginfo(p013io.javalin.http.Context r5) {
        /*
            r0 = r5
            java.lang.String r0 = r0.body()
            r6 = r0
            r0 = r6
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x008f
            r0 = r6
            java.lang.Class<emu.grasscutter.server.http.log.LogWeb[]> r1 = emu.grasscutter.server.http.log.LogWeb[].class
            java.lang.Object r0 = emu.grasscutter.utils.JsonUtils.decode(r0, r1)
            emu.grasscutter.server.http.log.LogWeb[] r0 = (emu.grasscutter.server.http.log.LogWeb[]) r0
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L_0x007f
            r0 = r7
            int r0 = r0.length
            r1 = 1
            if (r0 <= r1) goto L_0x007f
            r0 = r7
            r8 = r0
            r0 = r8
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r10 = r0
            r0 = r10
            r1 = r9
            if (r0 >= r1) goto L_0x007f
            r0 = r8
            r1 = r10
            r0 = r0[r1]
            r11 = r0
            r0 = r11
            emu.grasscutter.server.http.log.UploadContent r0 = r0.getUploadContent()
            if (r0 != 0) goto L_0x0049
            r0 = r11
            emu.grasscutter.server.http.log.UploadContent r0 = r0.getUploadContent()
            emu.grasscutter.server.http.log.LogInfo r0 = r0.getLogInfo()
            if (r0 == 0) goto L_0x0079
            r0 = r11
            emu.grasscutter.server.http.log.UploadContent r0 = r0.getUploadContent()
            emu.grasscutter.server.http.log.LogInfo r0 = r0.getLogInfo()
            r12 = r0
            r0 = r12
            java.lang.Integer r0 = r0.getActionId()
            r13 = r0
            r0 = r12
            java.lang.String r0 = r0.getActionName()
            r14 = r0
            r0 = r12
            java.lang.String r0 = r0.getCBody()
            r15 = r0
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r13
            r2 = r14
            r3 = r15
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Integer;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Log (ID: ) (Action: ) (RAW: )]}
            r0.debug(r1)
            int r10 = r10 + 1
            goto L_0x0029
            goto L_0x008f
            r7 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, RAW Log Info: ]}
            r0.warn(r1)
            r0 = r5
            emu.grasscutter.server.http.objects.JsonResponse r1 = new emu.grasscutter.server.http.objects.JsonResponse
            r2 = r1
            r2.<init>()
            io.javalin.http.Context r0 = r0.json(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.http.handlers.LogHandler.loginfo(io.javalin.http.Context):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0087: INVOKE_CUSTOM r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x009D: INVOKE_CUSTOM r-7
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
    /*  JADX ERROR: Failed to decode insn: 0x0087: INVOKE_CUSTOM r1, r2, r3, r4, r5, r6, r7, method: emu.grasscutter.server.http.handlers.LogHandler.logcrash(io.javalin.http.Context):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/Integer;, Ljava/lang/Integer;, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Crash : (Code: ) (UID: ) (MSG: ) | (OS: ) (MD: ) (Version ) ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/Integer;, Ljava/lang/Integer;, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Crash : (Code: ) (UID: ) (MSG: ) | (OS: ) (MD: ) (Version ) ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x009D: INVOKE_CUSTOM r1, method: emu.grasscutter.server.http.handlers.LogHandler.logcrash(io.javalin.http.Context):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, RAW Log Crash: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, RAW Log Crash: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void logcrash(p013io.javalin.http.Context r9) {
        /*
            r0 = r9
            java.lang.String r0 = r0.body()
            r10 = r0
            r0 = r10
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00a5
            r0 = r10
            java.lang.Class<emu.grasscutter.server.http.error.LogError[]> r1 = emu.grasscutter.server.http.error.LogError[].class
            java.lang.Object r0 = emu.grasscutter.utils.JsonUtils.decode(r0, r1)
            emu.grasscutter.server.http.error.LogError[] r0 = (emu.grasscutter.server.http.error.LogError[]) r0
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L_0x0095
            r0 = r11
            int r0 = r0.length
            r1 = 1
            if (r0 <= r1) goto L_0x0095
            r0 = r11
            r12 = r0
            r0 = r12
            int r0 = r0.length
            r13 = r0
            r0 = 0
            r14 = r0
            r0 = r14
            r1 = r13
            if (r0 >= r1) goto L_0x0095
            r0 = r12
            r1 = r14
            r0 = r0[r1]
            r15 = r0
            r0 = r15
            emu.grasscutter.server.http.error.UploadContent r0 = r0.getUploadContent()
            if (r0 == 0) goto L_0x008f
            r0 = r15
            emu.grasscutter.server.http.error.UploadContent r0 = r0.getUploadContent()
            r16 = r0
            r0 = r16
            java.lang.String r0 = r0.getClientIp()
            r17 = r0
            r0 = r16
            java.lang.String r0 = r0.getVersion()
            r18 = r0
            r0 = r16
            java.lang.String r0 = r0.getDeviceModel()
            r19 = r0
            r0 = r16
            java.lang.String r0 = r0.getDeviceName()
            r20 = r0
            r0 = r16
            java.lang.Integer r0 = r0.getError_Code()
            r21 = r0
            r0 = r16
            java.lang.String r0 = r0.getMessage()
            r22 = r0
            r0 = r16
            java.lang.Integer r0 = r0.getUserId()
            r23 = r0
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r17
            r2 = r21
            r3 = r23
            r4 = r22
            r5 = r20
            r6 = r19
            r7 = r18
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/Integer;, Ljava/lang/Integer;, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Crash : (Code: ) (UID: ) (MSG: ) | (OS: ) (MD: ) (Version ) ]}
            r0.error(r1)
            int r14 = r14 + 1
            goto L_0x0029
            goto L_0x00a5
            r11 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r10
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, RAW Log Crash: ]}
            r0.warn(r1)
            r0 = r9
            emu.grasscutter.server.http.objects.JsonResponse r1 = new emu.grasscutter.server.http.objects.JsonResponse
            r2 = r1
            r2.<init>()
            io.javalin.http.Context r0 = r0.json(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.http.handlers.LogHandler.logcrash(io.javalin.http.Context):void");
    }

    @Override // emu.grasscutter.server.http.Router
    public void applyRoutes(Javalin javalin) {
        allRoutes(javalin, "/log", LogHandler::raw);
        allRoutes(javalin, "/common/h5log/log/batch", LogHandler::raw);
        allRoutes(javalin, "/log/sdk/upload", LogHandler::raw);
        allRoutes(javalin, "/sdk/upload", LogHandler::raw);
        allRoutes(javalin, "/h5/upload", LogHandler::raw);
        allRoutes(javalin, "/sdk/dataUpload", LogHandler::loginfo);
        allRoutes(javalin, "/crash/dataUpload", LogHandler::logcrash);
        allRoutes(javalin, "/ys/event/*/*", LogHandler::cloud);
        allRoutes(javalin, "/event/*/*", LogHandler::cloud);
        allRoutes(javalin, "/v5/*", LogHandler::raw);
        allRoutes(javalin, "/snsconf", LogHandler::raw);
        allRoutes(javalin, "/openid", LogHandler::raw);
        allRoutes(javalin, "/dinfo", LogHandler::raw);
        allRoutes(javalin, "/dsign", LogHandler::raw);
        allRoutes(javalin, "/conn", LogHandler::raw);
        allRoutes(javalin, "/device-fp/api/getExtList", LogHandler::raw);
        allRoutes(javalin, "/*/combo/granter/api/getFont", LogHandler::raw);
        allRoutes(javalin, "/privacy/policy/authorization/status", LogHandler::raw);
        allRoutes(javalin, "/data_abtest_api/config/experiment/list", LogHandler::raw);
    }
}
