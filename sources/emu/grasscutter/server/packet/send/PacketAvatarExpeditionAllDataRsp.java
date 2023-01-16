package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.expedition.ExpeditionInfo;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javassist.compiler.TokenId;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarExpeditionAllDataRsp.class */
public class PacketAvatarExpeditionAllDataRsp extends BasePacket {
    public PacketAvatarExpeditionAllDataRsp(Map<Long, ExpeditionInfo> expeditionInfo, int expeditionCountLimit) {
        super(PacketOpcodes.AvatarExpeditionAllDataRsp);
        setData(AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRsp.newBuilder().addAllOpenExpeditionList(List.of((Object[]) new Integer[]{Integer.valueOf((int) TokenId.CHAR), 305, 304, 303, 302, 301, 206, 105, 204, 104, 203, 103, 202, 101, 102, 201, 106, 205, 401, 402, 403, 404, 405, 406})).setExpeditionCountLimit(expeditionCountLimit).putAllExpeditionInfoMap((Map) expeditionInfo.entrySet().stream().collect(Collectors.toMap(e -> {
            return (Long) e.getKey();
        }, e -> {
            return ((ExpeditionInfo) e.getValue()).toProto();
        }))).build());
    }
}
