package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ProudSkillChangeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketProudSkillChangeNotify.class */
public class PacketProudSkillChangeNotify extends BasePacket {
    public PacketProudSkillChangeNotify(Avatar avatar) {
        super(1024);
        setData(ProudSkillChangeNotifyOuterClass.ProudSkillChangeNotify.newBuilder().setAvatarGuid(avatar.getGuid()).setEntityId(avatar.getEntityId()).setSkillDepotId(avatar.getSkillDepotId()).addAllProudSkillList(avatar.getProudSkillList()).build());
    }
}
