package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.expedition.ExpeditionInfo;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarExpeditionStartRsp.class */
public class PacketAvatarExpeditionStartRsp extends BasePacket {
    public PacketAvatarExpeditionStartRsp(Map<Long, ExpeditionInfo> expeditionInfo) {
        super(PacketOpcodes.AvatarExpeditionStartRsp);
        AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRsp.Builder proto = AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRsp.newBuilder();
        expeditionInfo.forEach(key, e -> {
            proto.putExpeditionInfoMap(key.longValue(), e.toProto());
        });
        setData(proto.build());
    }
}
