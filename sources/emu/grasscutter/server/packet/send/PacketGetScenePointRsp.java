package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetScenePointRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetScenePointRsp.class */
public class PacketGetScenePointRsp extends BasePacket {
    public PacketGetScenePointRsp(Player player, int sceneId) {
        super(PacketOpcodes.GetScenePointRsp);
        GetScenePointRspOuterClass.GetScenePointRsp.Builder p = GetScenePointRspOuterClass.GetScenePointRsp.newBuilder().setSceneId(sceneId);
        p.addAllUnlockedPointList(player.getUnlockedScenePoints(sceneId));
        p.addAllUnlockAreaList(player.getUnlockedSceneAreas(sceneId));
        p.addAllUnhidePointList(player.getUnlockedScenePoints(sceneId));
        setData(p);
    }
}
