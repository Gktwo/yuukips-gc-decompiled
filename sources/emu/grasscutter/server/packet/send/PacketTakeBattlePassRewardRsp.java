package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketTakeBattlePassRewardRsp.class */
public class PacketTakeBattlePassRewardRsp extends BasePacket {
    public PacketTakeBattlePassRewardRsp(List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> takeOptionList, List<GameItem> rewardItems) {
        super(PacketOpcodes.TakeBattlePassRewardRsp);
        TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRsp.Builder proto = TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRsp.newBuilder().addAllTakeOptionList(takeOptionList);
        if (rewardItems != null) {
            for (GameItem item : rewardItems) {
                proto.addItemList(ItemParamOuterClass.ItemParam.newBuilder().setItemId(item.getItemId()).setCount(item.getCount()));
            }
        }
        setData(proto);
    }
}
