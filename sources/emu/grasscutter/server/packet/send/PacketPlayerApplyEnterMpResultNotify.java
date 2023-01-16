package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerApplyEnterMpResultNotify.class */
public class PacketPlayerApplyEnterMpResultNotify extends BasePacket {
    public PacketPlayerApplyEnterMpResultNotify(Player target, boolean isAgreed, PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotify.Reason reason) {
        super(PacketOpcodes.PlayerApplyEnterMpResultNotify);
        setData(PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotify.newBuilder().setTargetUid(target.getUid()).setTargetNickname(target.getNickname()).setIsAgreed(isAgreed).setReason(reason).build());
    }

    public PacketPlayerApplyEnterMpResultNotify(int targetId, String targetName, boolean isAgreed, PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotify.Reason reason) {
        super(PacketOpcodes.PlayerApplyEnterMpResultNotify);
        setData(PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotify.newBuilder().setTargetUid(targetId).setTargetNickname(targetName).setIsAgreed(isAgreed).setReason(reason).build());
    }
}
