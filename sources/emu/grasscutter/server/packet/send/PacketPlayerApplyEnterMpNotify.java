package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerApplyEnterMpNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerApplyEnterMpNotify.class */
public class PacketPlayerApplyEnterMpNotify extends BasePacket {
    public PacketPlayerApplyEnterMpNotify(Player srcPlayer) {
        super(PacketOpcodes.PlayerApplyEnterMpNotify);
        setData(PlayerApplyEnterMpNotifyOuterClass.PlayerApplyEnterMpNotify.newBuilder().setSrcPlayerInfo(srcPlayer.getOnlinePlayerInfo()).build());
    }
}
