package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AiSyncInfoOuterClass;
import emu.grasscutter.net.proto.EntityAiSyncNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketEntityAiSyncNotify.class */
public class PacketEntityAiSyncNotify extends BasePacket {
    public PacketEntityAiSyncNotify(EntityAiSyncNotifyOuterClass.EntityAiSyncNotify notify) {
        super(354, true);
        EntityAiSyncNotifyOuterClass.EntityAiSyncNotify.Builder proto = EntityAiSyncNotifyOuterClass.EntityAiSyncNotify.newBuilder();
        for (Integer num : notify.getLocalAvatarAlertedMonsterListList()) {
            proto.addInfoList(AiSyncInfoOuterClass.AiSyncInfo.newBuilder().setEntityId(num.intValue()).setHasPathToTarget(true));
        }
        setData(proto);
    }
}
