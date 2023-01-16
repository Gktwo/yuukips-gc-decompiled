package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.BattlePassCurScheduleUpdateNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketBattlePassCurScheduleUpdateNotify.class */
public class PacketBattlePassCurScheduleUpdateNotify extends BasePacket {
    public PacketBattlePassCurScheduleUpdateNotify(Player player) {
        super(PacketOpcodes.BattlePassCurScheduleUpdateNotify);
        BattlePassCurScheduleUpdateNotifyOuterClass.BattlePassCurScheduleUpdateNotify.Builder proto = BattlePassCurScheduleUpdateNotifyOuterClass.BattlePassCurScheduleUpdateNotify.newBuilder();
        proto.setHaveCurSchedule(true).setCurSchedule(player.getBattlePassManager().getScheduleProto()).build();
        setData(proto.build());
    }
}
