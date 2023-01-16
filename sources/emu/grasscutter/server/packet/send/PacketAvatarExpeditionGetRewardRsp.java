package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.expedition.ExpeditionInfo;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass;
import java.util.Collection;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarExpeditionGetRewardRsp.class */
public class PacketAvatarExpeditionGetRewardRsp extends BasePacket {
    public PacketAvatarExpeditionGetRewardRsp(Map<Long, ExpeditionInfo> expeditionInfo, Collection<GameItem> items) {
        super(PacketOpcodes.AvatarExpeditionGetRewardRsp);
        AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRsp.Builder proto = AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRsp.newBuilder();
        expeditionInfo.forEach(key, e -> {
            proto.putExpeditionInfoMap(key.longValue(), e.toProto());
        });
        items.forEach(item -> {
            proto.addItemList(item.toItemParam());
        });
        setData(proto.build());
    }
}
