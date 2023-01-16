package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.gacha.GachaSystem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetGachaInfoRsp.class */
public class PacketGetGachaInfoRsp extends BasePacket {
    public PacketGetGachaInfoRsp(GachaSystem manager, Player player) {
        super(1530);
        setData(manager.toProto(player));
    }
}
