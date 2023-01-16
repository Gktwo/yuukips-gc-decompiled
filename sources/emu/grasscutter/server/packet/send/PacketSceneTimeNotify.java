package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SceneTimeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSceneTimeNotify.class */
public class PacketSceneTimeNotify extends BasePacket {
    public PacketSceneTimeNotify(Player player) {
        super(PacketOpcodes.SceneTimeNotify);
        setData(SceneTimeNotifyOuterClass.SceneTimeNotify.newBuilder().setSceneId(player.getSceneId()).setSceneTime((long) player.getScene().getSceneTime()).build());
    }
}
