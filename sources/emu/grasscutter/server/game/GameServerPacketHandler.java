package emu.grasscutter.server.game;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.server.event.game.ReceivePacketEvent;
import emu.grasscutter.server.game.GameSession;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/server/game/GameServerPacketHandler.class */
public class GameServerPacketHandler {
    private final Int2ObjectMap<PacketHandler> handlers = new Int2ObjectOpenHashMap();

    /*  JADX ERROR: Dependency scan failed at insn: 0x004B: INVOKE_CUSTOM r-6, r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x004B: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.server.game.GameServerPacketHandler.registerHandlers(java.lang.Class<? extends emu.grasscutter.net.packet.PacketHandler>):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Registered  s]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Registered  s]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void registerHandlers(java.lang.Class<? extends emu.grasscutter.net.packet.PacketHandler> r6) {
        /*
            r5 = this;
            org.reflections.Reflections r0 = new org.reflections.Reflections
            r1 = r0
            java.lang.String r2 = "emu.grasscutter.server.packet"
            r3 = 0
            org.reflections.scanners.Scanner[] r3 = new org.reflections.scanners.Scanner[r3]
            r1.<init>(r2, r3)
            r7 = r0
            r0 = r7
            r1 = r6
            java.util.Set r0 = r0.getSubTypesOf(r1)
            r8 = r0
            r0 = r8
            java.util.Iterator r0 = r0.iterator()
            r9 = r0
            r0 = r9
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x003b
            r0 = r9
            java.lang.Object r0 = r0.next()
            r10 = r0
            r0 = r5
            r1 = r10
            java.lang.Class r1 = (java.lang.Class) r1
            r0.registerPacketHandler(r1)
            goto L_0x001c
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r5
            it.unimi.dsi.fastutil.ints.Int2ObjectMap<emu.grasscutter.net.packet.PacketHandler> r1 = r1.handlers
            int r1 = r1.size()
            r2 = r6
            java.lang.String r2 = r2.getSimpleName()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Registered  s]}
            r0.debug(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.game.GameServerPacketHandler.registerHandlers(java.lang.Class):void");
    }

    public GameServerPacketHandler(Class<? extends PacketHandler> handlerClass) {
        registerHandlers(handlerClass);
    }

    public void registerPacketHandler(Class<? extends PacketHandler> handlerClass) {
        try {
            Opcodes opcode = (Opcodes) handlerClass.getAnnotation(Opcodes.class);
            if (opcode != null && !opcode.disabled() && opcode.value() > 0) {
                this.handlers.put(opcode.value(), (int) ((PacketHandler) handlerClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])));
            }
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error: registerPacketHandler", (Throwable) e);
        }
    }

    public void handle(GameSession session, int opcode, byte[] header, byte[] payload) {
        PacketHandler handler = this.handlers.get(opcode);
        if (handler != null) {
            try {
                GameSession.SessionState state = session.getState();
                if (opcode != 20) {
                    if (opcode == 105) {
                        if (state != GameSession.SessionState.WAITING_FOR_TOKEN) {
                            return;
                        }
                    } else if (opcode == 187) {
                        if (state != GameSession.SessionState.WAITING_FOR_LOGIN) {
                            return;
                        }
                    } else if (opcode == 169) {
                        if (state != GameSession.SessionState.PICKING_CHARACTER) {
                            return;
                        }
                    } else if (state == GameSession.SessionState.CLOSE) {
                        session.close_tunnel();
                        return;
                    } else if (state != GameSession.SessionState.ACTIVE) {
                        return;
                    }
                }
                ReceivePacketEvent event = new ReceivePacketEvent(session, opcode, payload);
                event.call();
                if (!event.isCanceled()) {
                    handler.handle(session, header, event.getPacketData());
                }
            } catch (Exception e) {
                Grasscutter.getLogger().error("Error: handle", (Throwable) e);
            }
        } else {
            session.logPacket("Unhandled packet", opcode, payload);
        }
    }
}
