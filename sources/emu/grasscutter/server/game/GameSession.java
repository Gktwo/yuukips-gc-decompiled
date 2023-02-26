package emu.grasscutter.server.game;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.Account;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.server.event.game.SendPacketEvent;
import emu.grasscutter.server.game.GameSessionManager;
import emu.grasscutter.utils.Crypto;
import emu.grasscutter.utils.FileUtils;
import emu.grasscutter.utils.Language;
import java.io.File;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.Unpooled;

/* loaded from: grasscutter.jar:emu/grasscutter/server/game/GameSession.class */
public class GameSession implements GameSessionManager.KcpChannel {
    private final GameServer server;
    private GameSessionManager.KcpTunnel tunnel;
    private Account account;
    private Player player;
    private boolean useSecretKey;
    private int clientTime;
    private boolean isKick;
    private int lastClientSeq = 10;
    private boolean isRequest = false;
    private SessionState state = SessionState.WAITING_FOR_TOKEN;
    private long lastPingTime = System.currentTimeMillis();

    /* loaded from: grasscutter.jar:emu/grasscutter/server/game/GameSession$SessionState.class */
    public enum SessionState {
        WAITING_FOR_TOKEN,
        WAITING_FOR_LOGIN,
        PICKING_CHARACTER,
        ACTIVE,
        CLOSE
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x001B: INVOKE_CUSTOM r-2, r-1, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x001B: INVOKE_CUSTOM r1, r2, r3, method: emu.grasscutter.server.game.GameSession.logPacket(java.lang.String, int, byte[]):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, I)Ljava/lang/String;}, :  ()]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, I)Ljava/lang/String;}, :  ()]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void logPacket(java.lang.String r6, int r7, byte[] r8) {
        /*
            r5 = this;
            emu.grasscutter.config.ConfigContainer$Server r0 = emu.grasscutter.config.Configuration.SERVER
            java.util.Set<java.lang.Integer> r0 = r0.DebugBlacklist
            r1 = r7
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0023
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            r2 = r7
            java.lang.String r2 = emu.grasscutter.net.packet.PacketOpcodesUtils.getOpcodeName(r2)
            r3 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, I)Ljava/lang/String;}, :  ()]}
            r0.debug(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.game.GameSession.logPacket(java.lang.String, int, byte[]):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0060: INVOKE_CUSTOM r-14, r-13, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0060: INVOKE_CUSTOM r1, r2, r0, method: emu.grasscutter.server.game.GameSession.handleClose():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, J)Ljava/lang/String;},  | ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, J)Ljava/lang/String;},  | ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.server.game.GameSessionManager.KcpChannel
    public void handleClose() {
        /*
            r5 = this;
            r0 = r5
            emu.grasscutter.server.game.GameSession$SessionState r1 = emu.grasscutter.server.game.GameSession.SessionState.CLOSE
            r0.setState(r1)
            r0 = r5
            boolean r0 = r0.isLoggedIn()
            if (r0 == 0) goto L_0x0018
            r0 = r5
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            r6 = r0
            r0 = r6
            r1 = 1
            r0.onLogout(r1)
            r0 = r5
            boolean r0 = r0.isRequest
            if (r0 != 0) goto L_0x006b
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Unexpected Disconnect: {} "
            r2 = r5
            java.lang.String r2 = r2.getAddress()
            r0.warn(r1, r2)
            r0 = r5
            r1 = 0
            r0.IsLogout(r1)
            emu.grasscutter.server.game.Ratelimit r0 = new emu.grasscutter.server.game.Ratelimit
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "disconnected"
            r2 = 10
            r3 = 60
            r0.Set(r1, r2, r3)
            r0 = r6
            boolean r0 = r0.IsCount()
            if (r0 == 0) goto L_0x0055
            r0 = 0
            java.lang.String r1 = "We detected many disconnects"
            emu.grasscutter.server.game.GameServer.doExit(r0, r1)
            goto L_0x0068
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            int r1 = r1.GetCount()
            r2 = r6
            long r2 = r2.GetMs()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, J)Ljava/lang/String;},  | ]}
            r0.warn(r1)
            goto L_0x007d
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Disconnect Normal: {} "
            r2 = r5
            java.lang.String r2 = r2.getAddress()
            r0.warn(r1, r2)
            r0 = r5
            r1 = 1
            r0.IsLogout(r1)
            r0 = r5
            r1 = 0
            r0.tunnel = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.game.GameSession.handleClose():void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0008: INVOKE_CUSTOM r-3, r-2, r-1, r0
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0021: INVOKE_CUSTOM r-6, r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x0008: INVOKE_CUSTOM r1, r2, r3, r4, method: emu.grasscutter.server.game.GameSession.NowKick(java.lang.String, int, boolean, boolean):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Z, Z, Ljava/lang/String;)Ljava/lang/String;}, NowKick: ( | close  | logout ) ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Z, Z, Ljava/lang/String;)Ljava/lang/String;}, NowKick: ( | close  | logout ) ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0021: INVOKE_CUSTOM r4, r5, method: emu.grasscutter.server.game.GameSession.NowKick(java.lang.String, int, boolean, boolean):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, 
        
        ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, 
        
        ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void NowKick(java.lang.String r9, int r10, boolean r11, boolean r12) {
        /*
            r8 = this;
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r9
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Z, Z, Ljava/lang/String;)Ljava/lang/String;}, NowKick: ( | close  | logout ) ]}
            r0.warn(r1)
            r0 = r8
            emu.grasscutter.server.packet.send.PacketGetPlayerTokenRsp r1 = new emu.grasscutter.server.packet.send.PacketGetPlayerTokenRsp
            r2 = r1
            r3 = r10
            r4 = r9
            java.lang.String r5 = "messages.game.info"
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r5 = emu.grasscutter.utils.Language.translate(r5, r6)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, 

]}
            r2.<init>(r3, r4)
            r0.send(r1)
            r0 = r12
            if (r0 == 0) goto L_0x0041
            emu.grasscutter.server.game.GameSession$2 r0 = new emu.grasscutter.server.game.GameSession$2
            r1 = r0
            r2 = r8
            r3 = r9
            r4 = r11
            r1.<init>(r3, r4)
            r0.start()
            goto L_0x0047
            r0 = r8
            r1 = r9
            r2 = r11
            r0.Logout(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.game.GameSession.NowKick(java.lang.String, int, boolean, boolean):void");
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
    /*  JADX ERROR: Failed to decode insn: 0x0004: INVOKE_CUSTOM r1, method: emu.grasscutter.server.game.GameSession.Logout(java.lang.String, boolean):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Logout: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Logout: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void Logout(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r4
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Logout: ]}
            r0.warn(r1)
            r0 = r3
            r1 = r5
            r0.Logout(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.game.GameSession.Logout(java.lang.String, boolean):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x001B: INVOKE_CUSTOM r-7, r-6
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
    /*  JADX ERROR: Failed to decode insn: 0x001B: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.server.game.GameSession.setKick(java.lang.String, int):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I)Ljava/lang/String;}, Set Kick:  () ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I)Ljava/lang/String;}, Set Kick:  () ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void setKick(java.lang.String r6, int r7) {
        /*
            r5 = this;
            r0 = r5
            emu.grasscutter.game.Account r0 = r0.getAccount()
            if (r0 == 0) goto L_0x0026
            r0 = r5
            emu.grasscutter.game.Account r0 = r0.getAccount()
            r1 = 1
            r2 = r6
            r3 = r7
            r0.setKick(r1, r2, r3)
            r0 = r5
            r1 = 1
            r0.isKick = r1
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            r2 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I)Ljava/lang/String;}, Set Kick:  () ]}
            r0.warn(r1)
            goto L_0x002f
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "No Account"
            r0.warn(r1)
            r0 = r5
            r1 = 1
            r0.Logout(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.game.GameSession.setKick(java.lang.String, int):void");
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setUseSecretKey(boolean useSecretKey) {
        this.useSecretKey = useSecretKey;
    }

    public SessionState getState() {
        return this.state;
    }

    public void setState(SessionState state) {
        this.state = state;
    }

    public int getClientTime() {
        return this.clientTime;
    }

    public long getLastPingTime() {
        return this.lastPingTime;
    }

    public GameSession(GameServer server) {
        this.server = server;
    }

    public GameServer getServer() {
        return this.server;
    }

    public String getAddress() {
        try {
            return this.tunnel.getAddress().getAddress().getHostAddress();
        } catch (Exception e) {
            return "0.0.0.0";
        }
    }

    public void send_raw(byte[] d) {
        if (this.tunnel != null) {
            this.tunnel.writeData(d);
        }
    }

    public boolean useSecretKey() {
        return this.useSecretKey;
    }

    public String getAccountId() {
        return getAccount().getId();
    }

    public synchronized void setPlayer(Player player) {
        this.player = player;
        this.player.setSession(this);
        this.player.setAccount(getAccount());
    }

    public boolean isLoggedIn() {
        return getPlayer() != null;
    }

    public void updateLastPingTime(int clientTime) {
        this.clientTime = clientTime;
        this.lastPingTime = System.currentTimeMillis();
    }

    public int getNextClientSequence() {
        int i = this.lastClientSeq + 1;
        this.lastClientSeq = i;
        return i;
    }

    public void replayPacket(int opcode, String name) {
        File p = FileUtils.getPluginPath(name).toFile();
        if (p.exists()) {
            byte[] packet = FileUtils.read(p);
            BasePacket basePacket = new BasePacket(opcode);
            basePacket.setData(packet);
            send(basePacket);
        }
    }

    public void send(BasePacket packet) {
        if (packet.getOpcode() <= 0) {
            Grasscutter.getLogger().warn("Tried to send packet with missing cmd id!");
            return;
        }
        if (packet.shouldBuildHeader()) {
            packet.buildHeader(getNextClientSequence());
        }
        logPacket("SEND", packet.getOpcode(), packet.getData());
        SendPacketEvent event = new SendPacketEvent(this, packet);
        event.call();
        if (!event.isCanceled() && this.tunnel != null) {
            this.tunnel.writeData(event.getPacket().build());
        }
    }

    @Override // emu.grasscutter.server.game.GameSessionManager.KcpChannel
    public void onConnected(GameSessionManager.KcpTunnel tunnel) {
        this.tunnel = tunnel;
        Grasscutter.getLogger().info(Language.translate("messages.game.connect", getAddress()));
    }

    @Override // emu.grasscutter.server.game.GameSessionManager.KcpChannel
    public void handleReceive(byte[] bytes) {
        Crypto.xor(bytes, useSecretKey() ? Crypto.ENCRYPT_KEY : Crypto.DISPATCH_KEY);
        ByteBuf packet = Unpooled.wrappedBuffer(bytes);
        while (packet.readableBytes() > 0) {
            try {
                try {
                    if (packet.readableBytes() < 12) {
                        packet.release();
                        return;
                    }
                    int const1 = packet.readShort();
                    if (const1 != 17767) {
                        Grasscutter.getLogger().debug("Bad Data Package Received: got {} ,expect 17767", Integer.valueOf(const1));
                        packet.release();
                        return;
                    }
                    int opcode = packet.readShort();
                    int headerLength = packet.readShort();
                    int payloadLength = packet.readInt();
                    byte[] header = new byte[headerLength];
                    byte[] payload = new byte[payloadLength];
                    packet.readBytes(header);
                    packet.readBytes(payload);
                    int const2 = packet.readShort();
                    if (const2 != -30293) {
                        Grasscutter.getLogger().debug("Bad Data Package Received: got {} ,expect -30293", Integer.valueOf(const2));
                        packet.release();
                        return;
                    }
                    logPacket("RECV", opcode, payload);
                    getServer().getPacketHandler().handle(this, opcode, header, payload);
                } catch (Exception e) {
                    Grasscutter.getLogger().error("Error1: handleReceive", (Throwable) e);
                    packet.release();
                    return;
                }
            } catch (Throwable th) {
                packet.release();
                throw th;
            }
        }
        packet.release();
    }

    public void LogoutWait(final boolean foce_close, final int wait, final String msg) {
        new Thread() { // from class: emu.grasscutter.server.game.GameSession.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep((long) (1000 * wait));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GameSession.this.Logout(msg, foce_close);
                run();
            }
        }.start();
    }

    public void NowKick() {
        if (getAccount() != null) {
            NowKick(getAccount().getKickReason(), getAccount().getKickCodeReason(), false, false);
        }
    }

    public void NowKick(String msg) {
        NowKick(msg, 26, true, false);
    }

    public void KickWait(String msg) {
        NowKick(msg, 26, true, true);
    }

    public void NowKick(String msg, boolean isclose) {
        NowKick(msg, 26, isclose, false);
    }

    public void Logout(boolean foce_close) {
        this.isRequest = true;
        if (this.account != null) {
            Grasscutter.getLogger().warn("User {} ({}) currently logout={} kick={} stats={}", this.account.getId(), getAddress(), Boolean.valueOf(foce_close), Boolean.valueOf(isKick()), getState().name());
        } else {
            Grasscutter.getLogger().warn("Unknown user logout={}", Boolean.valueOf(foce_close));
        }
        IsLogout(foce_close);
    }

    public void IsLogout(boolean logout) {
        if (logout) {
            send(new BasePacket(180));
        } else {
            send(new BasePacket(160));
        }
        close_tunnel();
    }

    public void close_tunnel() {
        if (this.tunnel != null) {
            this.tunnel.close();
        } else {
            Grasscutter.getLogger().warn("Error close....");
        }
    }

    public boolean isKick() {
        return this.isKick;
    }

    public void setKick(String kickReason) {
        setKick(kickReason, 26);
    }

    public boolean isActive() {
        return getState() == SessionState.ACTIVE;
    }
}
