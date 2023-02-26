package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.AttackResultOuterClass;
import emu.grasscutter.net.proto.CombatInvocationsNotifyOuterClass;
import emu.grasscutter.net.proto.CombatInvokeEntryOuterClass;
import emu.grasscutter.net.proto.EntityMoveInfoOuterClass;
import emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass;
import emu.grasscutter.net.proto.EvtBeingHitInfoOuterClass;
import emu.grasscutter.net.proto.MotionInfoOuterClass;
import emu.grasscutter.net.proto.MotionStateOuterClass;
import emu.grasscutter.server.event.entity.EntityMoveEvent;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.utils.Position;

@Opcodes(323)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerCombatInvocationsNotify.class */
public class HandlerCombatInvocationsNotify extends PacketHandler {
    private float cachedLandingSpeed = 0.0f;
    private long cachedLandingTimeMillisecond = 0;
    private boolean monitorLandingEvent = false;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0033: INVOKE_CUSTOM r-1, r0, r0, r1
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x00CA: INVOKE_CUSTOM r-7, r-6, r-5, r-4, r-3, r-2
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x00DC: INVOKE_CUSTOM r-9, r-8
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
    /*  JADX ERROR: Failed to decode insn: 0x0033: INVOKE_CUSTOM r1, r0, r2, r3, method: emu.grasscutter.server.packet.recv.HandlerCombatInvocationsNotify.handleFallOnGround(emu.grasscutter.server.game.GameSession, emu.grasscutter.game.entity.GameEntity, emu.grasscutter.net.proto.MotionStateOuterClass$MotionState):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, Ljava/lang/String;)Ljava/lang/String;}, MOTION_FALL_ON_GROUND received after /ms.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, Ljava/lang/String;)Ljava/lang/String;}, MOTION_FALL_ON_GROUND received after /ms.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x00CA: INVOKE_CUSTOM r1, r2, r3, r4, r5, r6, method: emu.grasscutter.server.packet.recv.HandlerCombatInvocationsNotify.handleFallOnGround(emu.grasscutter.server.game.GameSession, emu.grasscutter.game.entity.GameEntity, emu.grasscutter.net.proto.MotionStateOuterClass$MotionState):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F, F, F, F, F, F)Ljava/lang/String;}, /	LandingSpeed: 	DamageFactor: 	Damage: 	NewHP: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F, F, F, F, F, F)Ljava/lang/String;}, /	LandingSpeed: 	DamageFactor: 	Damage: 	NewHP: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x00DC: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.server.packet.recv.HandlerCombatInvocationsNotify.handleFallOnGround(emu.grasscutter.server.game.GameSession, emu.grasscutter.game.entity.GameEntity, emu.grasscutter.net.proto.MotionStateOuterClass$MotionState):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F, F)Ljava/lang/String;}, /	LandingSpeed: 0	No damage]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F, F)Ljava/lang/String;}, /	LandingSpeed: 0	No damage]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private void handleFallOnGround(emu.grasscutter.server.game.GameSession r10, emu.grasscutter.game.entity.GameEntity r11, emu.grasscutter.net.proto.MotionStateOuterClass.MotionState r12) {
        /*
        // Method dump skipped, instructions count: 283
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.packet.recv.HandlerCombatInvocationsNotify.handleFallOnGround(emu.grasscutter.server.game.GameSession, emu.grasscutter.game.entity.GameEntity, emu.grasscutter.net.proto.MotionStateOuterClass$MotionState):void");
    }

    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        GameEntity entity;
        for (CombatInvokeEntryOuterClass.CombatInvokeEntry entry : CombatInvocationsNotifyOuterClass.CombatInvocationsNotify.parseFrom(payload).getInvokeListList()) {
            switch (entry.getArgumentType()) {
                case COMBAT_TYPE_ARGUMENT_EVT_BEING_HIT:
                    EvtBeingHitInfoOuterClass.EvtBeingHitInfo hitInfo = EvtBeingHitInfoOuterClass.EvtBeingHitInfo.parseFrom(entry.getCombatData());
                    AttackResultOuterClass.AttackResult attackResult = hitInfo.getAttackResult();
                    Player player = session.getPlayer();
                    try {
                        if (attackResult.getAttackerId() == player.getTeamManager().getCurrentAvatarEntity().getId() || !player.getAbilityManager().isAbilityInvulnerable()) {
                            player.getAttackResults().add(attackResult);
                            player.getEnergyManager().handleAttackHit(hitInfo);
                            break;
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        break;
                    }
                    break;
                case COMBAT_TYPE_ARGUMENT_ENTITY_MOVE:
                    EntityMoveInfoOuterClass.EntityMoveInfo moveInfo = EntityMoveInfoOuterClass.EntityMoveInfo.parseFrom(entry.getCombatData());
                    Scene scene = session.getPlayer().getScene();
                    if (!(scene == null || (entity = scene.getEntityById(moveInfo.getEntityId())) == null)) {
                        MotionInfoOuterClass.MotionInfo motionInfo = moveInfo.getMotionInfo();
                        MotionStateOuterClass.MotionState motionState = motionInfo.getState();
                        EntityMoveEvent event = new EntityMoveEvent(entity, new Position(motionInfo.getPos()), new Position(motionInfo.getRot()), motionState);
                        event.call();
                        entity.move(event.getPosition(), event.getRotation());
                        entity.setLastMoveSceneTimeMs(moveInfo.getSceneTime());
                        entity.setLastMoveReliableSeq(moveInfo.getReliableSeq());
                        entity.setMotionState(motionState);
                        session.getPlayer().getStaminaManager().handleCombatInvocationsNotify(session, moveInfo, entity);
                        if (motionState == MotionStateOuterClass.MotionState.MOTION_STATE_LAND_SPEED) {
                            this.cachedLandingSpeed = motionInfo.getSpeed().getY();
                            this.cachedLandingTimeMillisecond = System.currentTimeMillis();
                            this.monitorLandingEvent = true;
                        }
                        if (this.monitorLandingEvent && motionState == MotionStateOuterClass.MotionState.MOTION_STATE_FALL_ON_GROUND) {
                            this.monitorLandingEvent = false;
                            handleFallOnGround(session, entity, motionState);
                        }
                        if (motionState != MotionStateOuterClass.MotionState.MOTION_STATE_NOTIFY) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;
                case COMBAT_TYPE_ARGUMENT_ANIMATOR_PARAMETER_CHANGED:
                    EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfo paramInfo = EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfo.parseFrom(entry.getCombatData());
                    if (paramInfo.getIsServerCache()) {
                        entry = entry.toBuilder().setCombatData(paramInfo.toBuilder().setIsServerCache(false).build().toByteString()).build();
                        break;
                    }
                    break;
            }
            session.getPlayer().getCombatInvokeHandler().addEntry(entry.getForwardType(), entry);
        }
    }
}
