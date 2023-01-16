package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.expedition.ExpeditionInfo;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarExpeditionCallBackRsp.class */
public class PacketAvatarExpeditionCallBackRsp extends BasePacket {
    public PacketAvatarExpeditionCallBackRsp(Map<Long, ExpeditionInfo> expeditionInfo) {
        super(PacketOpcodes.AvatarExpeditionCallBackRsp);
        AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRsp.Builder proto = AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRsp.newBuilder();
        expeditionInfo.forEach(key, e -> {
            proto.putExpeditionInfoMap(key.longValue(), e.toProto());
        });
        setData(proto.build());
    }
}
