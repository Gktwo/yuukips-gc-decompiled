package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DelMailRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDelMailRsp.class */
public class PacketDelMailRsp extends BasePacket {
    public PacketDelMailRsp(Player player, List<Integer> toDeleteIds) {
        super(PacketOpcodes.DelMailRsp);
        setData(DelMailRspOuterClass.DelMailRsp.newBuilder().addAllMailIdList(toDeleteIds).build());
    }
}
