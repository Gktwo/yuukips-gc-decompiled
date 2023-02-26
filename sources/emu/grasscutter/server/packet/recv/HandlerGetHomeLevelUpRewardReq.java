package emu.grasscutter.server.packet.recv;

import emu.grasscutter.data.GameData;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetHomeLevelUpRewardReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetHomeLevelUpRewardRsp;
import java.util.Set;

@Opcodes(PacketOpcodes.GetHomeLevelUpRewardReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetHomeLevelUpRewardReq.class */
public class HandlerGetHomeLevelUpRewardReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        int rewardId;
        Player pl = session.getPlayer();
        synchronized (pl) {
            int level = GetHomeLevelUpRewardReqOuterClass.GetHomeLevelUpRewardReq.parseFrom(payload).getLevel();
            Set<Integer> homeRewardedLevels = session.getPlayer().getHomeRewardedLevels();
            if (!homeRewardedLevels.contains(Integer.valueOf(level)) && (rewardId = GameData.getHomeWorldLevelDataMap().get(level).getRewardId()) != 0) {
                pl.getInventory().addItemParamDatas(GameData.getRewardDataMap().get(rewardId).getRewardItemList(), ActionReason.GetHomeLevelupReward);
                homeRewardedLevels.add(Integer.valueOf(level));
                pl.setHomeRewardedLevels(homeRewardedLevels);
                pl.save();
                pl.getHome().onClaimReward(pl);
                session.send(new PacketGetHomeLevelUpRewardRsp(level, rewardId));
            }
        }
    }
}
