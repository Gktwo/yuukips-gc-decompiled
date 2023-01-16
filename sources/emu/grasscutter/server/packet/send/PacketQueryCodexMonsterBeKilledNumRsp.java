package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketQueryCodexMonsterBeKilledNumRsp.class */
public class PacketQueryCodexMonsterBeKilledNumRsp extends BasePacket {
    public PacketQueryCodexMonsterBeKilledNumRsp(Player player, List<Integer> codexList) {
        super(PacketOpcodes.QueryCodexMonsterBeKilledNumRsp);
        QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRsp.Builder proto = QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRsp.newBuilder();
        codexList.forEach(animal -> {
            if (player.getCodex().getUnlockedAnimal().containsKey(animal)) {
                proto.addCodexIdList(animal.intValue()).addBeKilledNumList(player.getCodex().getUnlockedAnimal().get(animal).intValue()).addBeCapturedNumList(0);
            }
        });
        setData(proto);
    }
}
