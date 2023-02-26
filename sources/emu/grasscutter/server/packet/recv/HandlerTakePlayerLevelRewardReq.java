package emu.grasscutter.server.packet.recv;

import emu.grasscutter.data.GameData;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.TakePlayerLevelRewardReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketTakePlayerLevelRewardRsp;
import java.util.Set;

@Opcodes(156)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerTakePlayerLevelRewardReq.class */
public class HandlerTakePlayerLevelRewardReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        int rewardId;
        Player pl = session.getPlayer();
        synchronized (pl) {
            int level = TakePlayerLevelRewardReqOuterClass.TakePlayerLevelRewardReq.parseFrom(payload).getLevel();
            Set<Integer> rewardedLevels = session.getPlayer().getRewardedLevels();
            if (!rewardedLevels.contains(Integer.valueOf(level)) && (rewardId = GameData.getPlayerLevelDataMap().get(level).getRewardId()) != 0) {
                pl.getInventory().addItemParamDatas(GameData.getRewardDataMap().get(rewardId).getRewardItemList(), ActionReason.PlayerUpgradeReward);
                rewardedLevels.add(Integer.valueOf(level));
                pl.setRewardedLevels(rewardedLevels);
                pl.save();
                session.send(new PacketTakePlayerLevelRewardRsp(level, rewardId));
            }
        }
    }
}
