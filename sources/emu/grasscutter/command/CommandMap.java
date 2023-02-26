package emu.grasscutter.command;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.player.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: grasscutter.jar:emu/grasscutter/command/CommandMap.class */
public final class CommandMap {
    private final Map<String, CommandHandler> commands;
    private final Map<String, CommandHandler> aliases;
    private final Map<String, Command> annotations;
    private final Map<String, Integer> targetPlayerIds;
    private static final String consoleId = "console";

    /*  JADX ERROR: Dependency scan failed at insn: 0x0004: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0004: INVOKE_CUSTOM r1, method: emu.grasscutter.command.CommandMap.registerCommand(java.lang.String, emu.grasscutter.command.CommandHandler):emu.grasscutter.command.CommandMap
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Registered command: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Registered command: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public emu.grasscutter.command.CommandMap registerCommand(java.lang.String r5, emu.grasscutter.command.CommandHandler r6) {
        /*
            r4 = this;
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Registered command: ]}
            r0.debug(r1)
            r0 = r5
            java.lang.String r0 = r0.toLowerCase()
            r5 = r0
            r0 = r6
            java.lang.Class r0 = r0.getClass()
            java.lang.Class<emu.grasscutter.command.Command> r1 = emu.grasscutter.command.Command.class
            java.lang.annotation.Annotation r0 = r0.getAnnotation(r1)
            emu.grasscutter.command.Command r0 = (emu.grasscutter.command.Command) r0
            r7 = r0
            r0 = r4
            java.util.Map<java.lang.String, emu.grasscutter.command.Command> r0 = r0.annotations
            r1 = r5
            r2 = r7
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r4
            java.util.Map<java.lang.String, emu.grasscutter.command.CommandHandler> r0 = r0.commands
            r1 = r5
            r2 = r6
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r7
            java.lang.String[] r0 = r0.aliases()
            int r0 = r0.length
            if (r0 <= 0) goto L_0x007e
            r0 = r7
            java.lang.String[] r0 = r0.aliases()
            r8 = r0
            r0 = r8
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r10 = r0
            r0 = r10
            r1 = r9
            if (r0 >= r1) goto L_0x007e
            r0 = r8
            r1 = r10
            r0 = r0[r1]
            r11 = r0
            r0 = r4
            java.util.Map<java.lang.String, emu.grasscutter.command.CommandHandler> r0 = r0.aliases
            r1 = r11
            r2 = r6
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r4
            java.util.Map<java.lang.String, emu.grasscutter.command.Command> r0 = r0.annotations
            r1 = r11
            r2 = r7
            java.lang.Object r0 = r0.put(r1, r2)
            int r10 = r10 + 1
            goto L_0x0050
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.command.CommandMap.registerCommand(java.lang.String, emu.grasscutter.command.CommandHandler):emu.grasscutter.command.CommandMap");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0004: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0004: INVOKE_CUSTOM r1, method: emu.grasscutter.command.CommandMap.unregisterCommand(java.lang.String):emu.grasscutter.command.CommandMap
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Unregistered command: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Unregistered command: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public emu.grasscutter.command.CommandMap unregisterCommand(java.lang.String r4) {
        /*
            r3 = this;
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r4
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Unregistered command: ]}
            r0.debug(r1)
            r0 = r3
            java.util.Map<java.lang.String, emu.grasscutter.command.CommandHandler> r0 = r0.commands
            r1 = r4
            java.lang.Object r0 = r0.get(r1)
            emu.grasscutter.command.CommandHandler r0 = (emu.grasscutter.command.CommandHandler) r0
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L_0x0020
            r0 = r3
            return r0
            r0 = r5
            java.lang.Class r0 = r0.getClass()
            java.lang.Class<emu.grasscutter.command.Command> r1 = emu.grasscutter.command.Command.class
            java.lang.annotation.Annotation r0 = r0.getAnnotation(r1)
            emu.grasscutter.command.Command r0 = (emu.grasscutter.command.Command) r0
            r6 = r0
            r0 = r3
            java.util.Map<java.lang.String, emu.grasscutter.command.Command> r0 = r0.annotations
            r1 = r4
            java.lang.Object r0 = r0.remove(r1)
            r0 = r3
            java.util.Map<java.lang.String, emu.grasscutter.command.CommandHandler> r0 = r0.commands
            r1 = r4
            java.lang.Object r0 = r0.remove(r1)
            r0 = r6
            java.lang.String[] r0 = r0.aliases()
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0089
            r0 = r6
            java.lang.String[] r0 = r0.aliases()
            r7 = r0
            r0 = r7
            int r0 = r0.length
            r8 = r0
            r0 = 0
            r9 = r0
            r0 = r9
            r1 = r8
            if (r0 >= r1) goto L_0x0089
            r0 = r7
            r1 = r9
            r0 = r0[r1]
            r10 = r0
            r0 = r3
            java.util.Map<java.lang.String, emu.grasscutter.command.CommandHandler> r0 = r0.aliases
            r1 = r10
            java.lang.Object r0 = r0.remove(r1)
            r0 = r3
            java.util.Map<java.lang.String, emu.grasscutter.command.Command> r0 = r0.annotations
            r1 = r10
            java.lang.Object r0 = r0.remove(r1)
            int r9 = r9 + 1
            goto L_0x005d
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.command.CommandMap.unregisterCommand(java.lang.String):emu.grasscutter.command.CommandMap");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x01C9: INVOKE_CUSTOM r-50, r-49
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0246: INVOKE_CUSTOM r-57
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0296: INVOKE_CUSTOM r-61
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x02B9: INVOKE_CUSTOM r-62
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
    /*  JADX ERROR: Failed to decode insn: 0x01C9: INVOKE_CUSTOM r0, r1, method: emu.grasscutter.command.CommandMap.invoke(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I)Ljava/lang/String;}, -]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I)Ljava/lang/String;}, -]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0246: INVOKE_CUSTOM r1, method: emu.grasscutter.command.CommandMap.invoke(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Command used by server console: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Command used by server console: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0296: INVOKE_CUSTOM r1, method: emu.grasscutter.command.CommandMap.invoke(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Timeout Command: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Timeout Command: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x02B9: INVOKE_CUSTOM r1, method: emu.grasscutter.command.CommandMap.invoke(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error Command : ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error Command : ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void invoke(emu.grasscutter.game.player.Player r9, emu.grasscutter.game.player.Player r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 742
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.command.CommandMap.invoke(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, java.lang.String):void");
    }

    public CommandMap() {
        this(false);
    }

    public CommandMap(boolean scan) {
        this.commands = new TreeMap();
        this.aliases = new TreeMap();
        this.annotations = new TreeMap();
        this.targetPlayerIds = new HashMap();
        if (scan) {
            scan();
        }
    }

    public static CommandMap getInstance() {
        return Grasscutter.getCommandMap();
    }

    public List<Command> getAnnotationsAsList() {
        return new ArrayList(this.annotations.values());
    }

    public Map<String, Command> getAnnotations() {
        return new LinkedHashMap(this.annotations);
    }

    public List<CommandHandler> getHandlersAsList() {
        return new ArrayList(this.commands.values());
    }

    public Map<String, CommandHandler> getHandlers() {
        return this.commands;
    }

    public CommandHandler getHandler(String label) {
        CommandHandler handler = this.commands.get(label);
        if (handler == null) {
            handler = this.aliases.get(label);
        }
        return handler;
    }

    private Player getTargetPlayer(String playerId, Player player, Player targetPlayer, List<String> args) {
        for (int i = 0; i < args.size(); i++) {
            if (args.get(i).startsWith("@")) {
                String arg = args.remove(i).substring(1);
                if (arg.equals("")) {
                    return null;
                }
                try {
                    Player targetPlayer2 = Grasscutter.getGameServer().getPlayerByUid(Integer.parseInt(arg), true);
                    if (targetPlayer2 != null) {
                        return targetPlayer2;
                    }
                    CommandHandler.sendTranslatedMessage(player, "commands.execution.player_exist_error", new Object[0]);
                    throw new IllegalArgumentException();
                } catch (NumberFormatException e) {
                    CommandHandler.sendTranslatedMessage(player, "commands.generic.invalid.uid", new Object[0]);
                    throw new IllegalArgumentException();
                }
            }
        }
        if (targetPlayer != null) {
            return targetPlayer;
        }
        if (!this.targetPlayerIds.containsKey(playerId)) {
            return player;
        }
        Player targetPlayer3 = Grasscutter.getGameServer().getPlayerByUid(this.targetPlayerIds.get(playerId).intValue(), true);
        if (targetPlayer3 != null) {
            return targetPlayer3;
        }
        CommandHandler.sendTranslatedMessage(player, "commands.execution.player_exist_error", new Object[0]);
        throw new IllegalArgumentException();
    }

    private boolean setPlayerTarget(String playerId, Player player, String targetUid) {
        String str;
        if (targetUid.equals("")) {
            this.targetPlayerIds.remove(playerId);
            CommandHandler.sendTranslatedMessage(player, "commands.execution.clear_target", new Object[0]);
            return true;
        }
        try {
            int uid = Integer.parseInt(targetUid);
            Player targetPlayer = Grasscutter.getGameServer().getPlayerByUid(uid, true);
            if (targetPlayer == null) {
                CommandHandler.sendTranslatedMessage(player, "commands.execution.player_exist_error", new Object[0]);
                return false;
            }
            this.targetPlayerIds.put(playerId, Integer.valueOf(uid));
            CommandHandler.sendTranslatedMessage(player, "commands.execution.set_target", targetUid);
            if (targetPlayer.isOnline()) {
                str = "commands.execution.set_target_online";
            } else {
                str = "commands.execution.set_target_offline";
            }
            CommandHandler.sendTranslatedMessage(player, str, targetUid);
            return true;
        } catch (NumberFormatException e) {
            CommandHandler.sendTranslatedMessage(player, "commands.generic.invalid.uid", new Object[0]);
            return false;
        }
    }

    private void scan() {
        Grasscutter.reflector.getTypesAnnotatedWith(Command.class).forEach(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
              (wrap: java.util.Set<java.lang.Class<?>> : 0x0007: INVOKE  (r0v2 'classes' java.util.Set<java.lang.Class<?>> A[REMOVE]) = 
              (wrap: org.reflections.Reflections : 0x0000: SGET  (r0v0 'reflector' org.reflections.Reflections A[REMOVE]) =  emu.grasscutter.Grasscutter.reflector org.reflections.Reflections)
              (wrap: java.lang.Class<? extends java.lang.annotation.Annotation> : 0x0005: CONST_CLASS   emu.grasscutter.command.Command.class)
             type: VIRTUAL call: org.reflections.Reflections.getTypesAnnotatedWith(java.lang.Class):java.util.Set)
              (wrap: java.util.function.Consumer : 0x000d: INVOKE_CUSTOM (r1v2 java.util.function.Consumer A[REMOVE]) = 
              (r3v0 'this' emu.grasscutter.command.CommandMap A[D('this' emu.grasscutter.command.CommandMap), DONT_INLINE, IMMUTABLE_TYPE, THIS])
            
             handle type: INVOKE_INSTANCE
             lambda: java.util.function.Consumer.accept(java.lang.Object):void
             call insn: ?: INVOKE  (r1 I:emu.grasscutter.command.CommandMap), (v1 java.lang.Class) type: VIRTUAL call: emu.grasscutter.command.CommandMap.lambda$scan$1(java.lang.Class):void)
             type: INTERFACE call: java.util.Set.forEach(java.util.function.Consumer):void in method: emu.grasscutter.command.CommandMap.scan():void, file: grasscutter.jar:emu/grasscutter/command/CommandMap.class
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
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            org.reflections.Reflections r0 = emu.grasscutter.Grasscutter.reflector
            r4 = r0
            r0 = r4
            java.lang.Class<emu.grasscutter.command.Command> r1 = emu.grasscutter.command.Command.class
            java.util.Set r0 = r0.getTypesAnnotatedWith(r1)
            r5 = r0
            r0 = r5
            r1 = r3
            void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                r1.lambda$scan$1(v1);
            }
            r0.forEach(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.command.CommandMap.scan():void");
    }
}
