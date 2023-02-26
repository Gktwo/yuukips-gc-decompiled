package emu.grasscutter.game.chat;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.CommandMap;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.proto.ChatInfoOuterClass;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.packet.send.PacketPlayerChatNotify;
import emu.grasscutter.server.packet.send.PacketPrivateChatNotify;
import emu.grasscutter.server.packet.send.PacketPullPrivateChatRsp;
import emu.grasscutter.server.packet.send.PacketPullRecentChatRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: grasscutter.jar:emu/grasscutter/game/chat/ChatSystem.class */
public class ChatSystem implements ChatSystemHandler {
    static final String PREFIXES = "[/!]";
    static final Pattern RE_PREFIXES = Pattern.compile(PREFIXES);
    static final Pattern RE_COMMANDS = Pattern.compile("\n[/!]");
    private final Map<Integer, Map<Integer, List<ChatInfoOuterClass.ChatInfo>>> history = new HashMap();
    private final GameServer server;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0011: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0038: INVOKE_CUSTOM r-4, r0
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0045: INVOKE_CUSTOM r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x0011: INVOKE_CUSTOM r0, method: emu.grasscutter.game.chat.ChatSystem.handleServerChat(emu.grasscutter.game.player.Player, java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, chat-]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, chat-]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0038: INVOKE_CUSTOM r1, r0, method: emu.grasscutter.game.chat.ChatSystem.handleServerChat(emu.grasscutter.game.player.Player, java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, You can chat again after  sec]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, You can chat again after  sec]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0045: INVOKE_CUSTOM r1, method: emu.grasscutter.game.chat.ChatSystem.handleServerChat(emu.grasscutter.game.player.Player, java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Chat Normal (): {} - {} - {}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Chat Normal (): {} - {} - {}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private void handleServerChat(emu.grasscutter.game.player.Player r9, java.lang.String r10) {
        /*
            r8 = this;
            emu.grasscutter.config.ConfigContainer$Game r0 = emu.grasscutter.config.Configuration.GAME_INFO
            emu.grasscutter.config.ConfigContainer$ConsoleAccount r0 = r0.serverAccount
            boolean r0 = r0.globalChatEnabled
            if (r0 != 0) goto L_0x000d
            return
            r0 = r9
            int r0 = r0.getUid()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, chat-]}
            r11 = r0
            emu.grasscutter.server.game.Ratelimit r0 = new emu.grasscutter.server.game.Ratelimit
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r12
            r1 = r11
            r2 = 180(0xb4, float:2.52E-43)
            r3 = 1
            r0.Set(r1, r2, r3)
            r0 = r12
            boolean r0 = r0.m1192Is()
            if (r0 == 0) goto L_0x0041
            r0 = r9
            r1 = r12
            long r1 = r1.GetMs()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, You can chat again after  sec]}
            r0.dropMessage(r1)
            return
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r11
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Chat Normal (): {} - {} - {}]}
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r12
            long r5 = r5.GetMs()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = r12
            int r5 = r5.GetCount()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r4] = r5
            r3 = r2
            r4 = 2
            r5 = r10
            r3[r4] = r5
            r0.info(r1, r2)
            emu.grasscutter.config.ConfigContainer$Game r0 = emu.grasscutter.config.Configuration.GAME_INFO
            emu.grasscutter.config.ConfigContainer$ConsoleAccount r0 = r0.serverAccount
            java.lang.String r0 = r0.globalChatFormat
            java.lang.String r1 = "{nickName}"
            r2 = r9
            java.lang.String r2 = r2.getNickname()
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.String r1 = "{uid}"
            r2 = r9
            int r2 = r2.getUid()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.String r1 = "{message}"
            r2 = r10
            java.lang.String r0 = r0.replace(r1, r2)
            r10 = r0
            r0 = r8
            emu.grasscutter.server.game.GameServer r0 = r0.server
            java.util.Map r0 = r0.getPlayers()
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
            r13 = r0
            r0 = r13
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00c8
            r0 = r13
            java.lang.Object r0 = r0.next()
            emu.grasscutter.game.player.Player r0 = (emu.grasscutter.game.player.Player) r0
            r14 = r0
            r0 = r14
            r1 = r9
            if (r0 == r1) goto L_0x00c5
            r0 = r14
            r1 = r10
            r0.dropMessage(r1)
            goto L_0x00a3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.chat.ChatSystem.handleServerChat(emu.grasscutter.game.player.Player, java.lang.String):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0051: INVOKE_CUSTOM r-4, r-3
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
    /*  JADX ERROR: Failed to decode insn: 0x0051: INVOKE_CUSTOM r2, r3, method: emu.grasscutter.game.chat.ChatSystem.sendServerWelcomeMessages(emu.grasscutter.game.player.Player):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, 
        
        Server Info:
        DockerGS 
        Based Grasscutter]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, 
        
        Server Info:
        DockerGS 
        Based Grasscutter]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private void sendServerWelcomeMessages(emu.grasscutter.game.player.Player r8) {
        /*
            r7 = this;
            emu.grasscutter.config.ConfigContainer$Game r0 = emu.grasscutter.config.Configuration.GAME_INFO
            emu.grasscutter.config.ConfigContainer$JoinOptions r0 = r0.joinOptions
            r9 = r0
            r0 = r9
            int[] r0 = r0.welcomeEmotes
            if (r0 == 0) goto L_0x002e
            r0 = r9
            int[] r0 = r0.welcomeEmotes
            int r0 = r0.length
            if (r0 <= 0) goto L_0x002e
            r0 = r7
            r1 = r8
            int r1 = r1.getUid()
            r2 = r9
            int[] r2 = r2.welcomeEmotes
            r3 = 0
            r4 = r9
            int[] r4 = r4.welcomeEmotes
            int r4 = r4.length
            r5 = 1
            int r4 = r4 - r5
            int r3 = emu.grasscutter.utils.Utils.randomRange(r3, r4)
            r2 = r2[r3]
            r0.sendPrivateMessageFromServer(r1, r2)
            java.lang.String r0 = ""
            r10 = r0
            r0 = r9
            java.lang.String r0 = r0.welcomeMessage
            if (r0 == 0) goto L_0x0048
            r0 = r9
            java.lang.String r0 = r0.welcomeMessage
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0048
            r0 = r9
            java.lang.String r0 = r0.welcomeMessage
            r10 = r0
            r0 = r7
            r1 = r8
            int r1 = r1.getUid()
            r2 = r10
            java.lang.String r3 = emu.grasscutter.config.ConfigContainer.dockergs_v
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, 

Server Info:
DockerGS 
Based Grasscutter]}
            r0.sendPrivateMessageFromServer(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.chat.ChatSystem.sendServerWelcomeMessages(emu.grasscutter.game.player.Player):void");
    }

    public ChatSystem(GameServer server) {
        this.server = server;
    }

    @Override // emu.grasscutter.game.chat.ChatSystemHandler
    public GameServer getServer() {
        return this.server;
    }

    private boolean tryInvokeCommand(Player sender, Player target, String rawMessage) {
        if (!RE_PREFIXES.matcher(rawMessage.substring(0, 1)).matches()) {
            return false;
        }
        for (String line : rawMessage.substring(1).split("\n[/!]")) {
            CommandMap.getInstance().invoke(sender, target, line);
        }
        return true;
    }

    private void putInHistory(int uid, int partnerId, ChatInfoOuterClass.ChatInfo info) {
        this.history.computeIfAbsent(Integer.valueOf(uid), x -> {
            return new HashMap();
        }).computeIfAbsent(Integer.valueOf(partnerId), x -> {
            return new ArrayList();
        }).add(info);
    }

    @Override // emu.grasscutter.game.chat.ChatSystemHandler
    public void clearHistoryOnLogout(Player player) {
        this.history.remove(Integer.valueOf(player.getUid()));
    }

    @Override // emu.grasscutter.game.chat.ChatSystemHandler
    public void handlePullPrivateChatReq(Player player, int partnerId) {
        player.sendPacket(new PacketPullPrivateChatRsp(this.history.computeIfAbsent(Integer.valueOf(player.getUid()), x -> {
            return new HashMap();
        }).computeIfAbsent(Integer.valueOf(partnerId), x -> {
            return new ArrayList();
        })));
    }

    @Override // emu.grasscutter.game.chat.ChatSystemHandler
    public void handlePullRecentChatReq(Player player) {
        if (!this.history.computeIfAbsent(Integer.valueOf(player.getUid()), x -> {
            return new HashMap();
        }).containsKey(99)) {
            sendServerWelcomeMessages(player);
        }
        List<ChatInfoOuterClass.ChatInfo> getchat = this.history.get(Integer.valueOf(player.getUid())).get(99);
        if (getchat != null) {
            int historyLength = getchat.size();
            player.sendPacket(new PacketPullRecentChatRsp(getchat.subList(Math.max(historyLength - 3, 0), historyLength)));
        }
    }

    @Override // emu.grasscutter.game.chat.ChatSystemHandler
    public void sendPrivateMessageFromServer(int targetUid, String message) {
        Player target;
        if (message != null && message.length() != 0 && (target = getServer().getPlayerByUid(targetUid)) != null) {
            PacketPrivateChatNotify packet = new PacketPrivateChatNotify(99, targetUid, message);
            putInHistory(targetUid, 99, packet.getChatInfo());
            target.sendPacket(packet);
        }
    }

    @Override // emu.grasscutter.game.chat.ChatSystemHandler
    public void sendPrivateMessageFromServer(int targetUid, int emote) {
        Player target = getServer().getPlayerByUid(targetUid);
        if (target != null) {
            PacketPrivateChatNotify packet = new PacketPrivateChatNotify(99, targetUid, emote);
            putInHistory(targetUid, 99, packet.getChatInfo());
            target.sendPacket(packet);
        }
    }

    @Override // emu.grasscutter.game.chat.ChatSystemHandler
    public void sendPrivateMessage(Player player, int targetUid, String message) {
        if (message != null && message.length() != 0) {
            Player target = getServer().getPlayerByUid(targetUid);
            if (target != null || targetUid == 99) {
                PacketPrivateChatNotify packet = new PacketPrivateChatNotify(player.getUid(), targetUid, message);
                player.sendPacket(packet);
                putInHistory(player.getUid(), targetUid, packet.getChatInfo());
                if (tryInvokeCommand(player, target, message)) {
                    return;
                }
                if (target != null) {
                    target.sendPacket(packet);
                    putInHistory(targetUid, player.getUid(), packet.getChatInfo());
                    return;
                }
                handleServerChat(player, message);
            }
        }
    }

    @Override // emu.grasscutter.game.chat.ChatSystemHandler
    public void sendPrivateMessage(Player player, int targetUid, int emote) {
        if (player != null) {
            Grasscutter.getLogger().info("Chat Emoji0: {} > {} | {}", Integer.valueOf(player.getUid()), Integer.valueOf(targetUid), Integer.valueOf(emote));
            Player target = getServer().getPlayerByUid(targetUid);
            if (target != null && targetUid != 99) {
                PacketPrivateChatNotify packet = new PacketPrivateChatNotify(player.getUid(), target.getUid(), emote);
                player.sendPacket(packet);
                putInHistory(player.getUid(), targetUid, packet.getChatInfo());
                if (target != null) {
                    target.sendPacket(packet);
                    putInHistory(targetUid, player.getUid(), packet.getChatInfo());
                }
            }
        }
    }

    @Override // emu.grasscutter.game.chat.ChatSystemHandler
    public void sendTeamMessage(Player player, int channel, String message) {
        if (message != null && message.length() != 0 && !tryInvokeCommand(player, null, message) && player != null) {
            player.getWorld().broadcastPacket(new PacketPlayerChatNotify(player, channel, message));
        }
    }

    @Override // emu.grasscutter.game.chat.ChatSystemHandler
    public void sendTeamMessage(Player player, int channel, int icon) {
        if (player != null) {
            player.getWorld().broadcastPacket(new PacketPlayerChatNotify(player, channel, icon));
        }
    }
}
