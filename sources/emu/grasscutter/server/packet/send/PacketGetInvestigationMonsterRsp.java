package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.world.WorldDataSystem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetInvestigationMonsterRsp.class */
public class PacketGetInvestigationMonsterRsp extends BasePacket {
    public PacketGetInvestigationMonsterRsp(Player player, WorldDataSystem worldDataManager, List<Integer> cityIdListList) {
        super(PacketOpcodes.GetInvestigationMonsterRsp);
        GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRsp.Builder resp = GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRsp.newBuilder();
        cityIdListList.forEach(id -> {
            resp.addAllMonsterList(worldDataManager.getInvestigationMonstersByCityId(player, id.intValue()));
        });
        setData(resp.build());
    }
}
