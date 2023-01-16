package emu.grasscutter.game.managers.mapmark;

import emu.grasscutter.config.Configuration;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.proto.MapMarkPointTypeOuterClass;
import emu.grasscutter.net.proto.MarkMapReqOuterClass;
import emu.grasscutter.server.event.player.PlayerTeleportEvent;
import emu.grasscutter.server.packet.send.PacketMarkMapRsp;
import emu.grasscutter.server.packet.send.PacketSceneEntityAppearNotify;
import emu.grasscutter.utils.Position;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/mapmark/MapMarksManager.class */
public class MapMarksManager extends BasePlayerManager {
    public static final int mapMarkMaxCount = 150;

    /*  JADX ERROR: Dependency scan failed at insn: 0x000A: INVOKE_CUSTOM r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x000A: INVOKE_CUSTOM r0, r1, method: emu.grasscutter.game.managers.mapmark.MapMarksManager.getMapMarkKey(emu.grasscutter.utils.Position):java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, xz]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, xz]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String getMapMarkKey(emu.grasscutter.utils.Position r4) {
        /*
            r3 = this;
            r0 = r4
            float r0 = r0.getX()
            int r0 = (int) r0
            r1 = r4
            float r1 = r1.getZ()
            int r1 = (int) r1
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, xz]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.managers.mapmark.MapMarksManager.getMapMarkKey(emu.grasscutter.utils.Position):java.lang.String");
    }

    public MapMarksManager(Player player) {
        super(player);
    }

    public Map<String, MapMark> getMapMarks() {
        return getPlayer().getMapMarks();
    }

    public void handleMapMarkReq(MarkMapReqOuterClass.MarkMapReq req) {
        MarkMapReqOuterClass.MarkMapReq.Operation op = req.getOp();
        switch (op) {
            case OPERATION_ADD:
                MapMark createMark = new MapMark(req.getMark());
                if (!Configuration.GAME_OPTIONS.fishhookTeleport || createMark.getMapMarkPointType() != MapMarkPointTypeOuterClass.MapMarkPointType.MAP_MARK_POINT_TYPE_FISH_POOL) {
                    addMapMark(createMark);
                    break;
                } else {
                    teleport(this.player, createMark);
                    return;
                }
            case OPERATION_MOD:
                removeMapMark(new MapMark(req.getOld()).getPosition());
                addMapMark(new MapMark(req.getMark()));
                break;
            case OPERATION_DEL:
                removeMapMark(new MapMark(req.getMark()).getPosition());
                break;
        }
        if (op != MarkMapReqOuterClass.MarkMapReq.Operation.OPERATION_GET) {
            save();
        }
        this.player.getSession().send(new PacketMarkMapRsp(getMapMarks()));
    }

    public void removeMapMark(Position position) {
        getMapMarks().remove(getMapMarkKey(position));
    }

    public void addMapMark(MapMark mapMark) {
        if (getMapMarks().size() < 150) {
            getMapMarks().put(getMapMarkKey(mapMark.getPosition()), mapMark);
        }
    }

    private void teleport(Player player, MapMark mapMark) {
        float y;
        try {
            y = Float.parseFloat(mapMark.getName());
        } catch (Exception e) {
            y = 300.0f;
        }
        Position pos = mapMark.getPosition();
        player.getWorld().transferPlayerToScene(player, mapMark.getSceneId(), PlayerTeleportEvent.TeleportType.MAP, new Position(pos.getX(), y, pos.getZ()));
        player.getScene().broadcastPacket(new PacketSceneEntityAppearNotify(player));
    }
}
