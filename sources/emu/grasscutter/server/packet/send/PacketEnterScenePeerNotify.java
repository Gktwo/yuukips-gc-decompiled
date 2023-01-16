package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.EnterScenePeerNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketEnterScenePeerNotify.class */
public class PacketEnterScenePeerNotify extends BasePacket {
    public PacketEnterScenePeerNotify(Player player) {
        super(PacketOpcodes.EnterScenePeerNotify);
        setData(EnterScenePeerNotifyOuterClass.EnterScenePeerNotify.newBuilder().setDestSceneId(player.getSceneId()).setPeerId(player.getPeerId()).setHostPeerId(player.getWorld().getHost().getPeerId()).setEnterSceneToken(player.getEnterSceneToken()).build());
    }
}
