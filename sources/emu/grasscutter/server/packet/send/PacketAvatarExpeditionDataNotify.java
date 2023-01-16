package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.expedition.ExpeditionInfo;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarExpeditionDataNotifyOuterClass;
import java.util.Map;
import java.util.stream.Collectors;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarExpeditionDataNotify.class */
public class PacketAvatarExpeditionDataNotify extends BasePacket {
    public PacketAvatarExpeditionDataNotify(Map<Long, ExpeditionInfo> expeditionInfo) {
        super(PacketOpcodes.AvatarExpeditionDataNotify);
        setData(AvatarExpeditionDataNotifyOuterClass.AvatarExpeditionDataNotify.newBuilder().putAllExpeditionInfoMap((Map) expeditionInfo.entrySet().stream().collect(Collectors.toMap(e -> {
            return (Long) e.getKey();
        }, e -> {
            return ((ExpeditionInfo) e.getValue()).toProto();
        }))).build());
    }
}
