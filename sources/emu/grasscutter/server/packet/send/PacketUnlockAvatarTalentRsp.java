package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.UnlockAvatarTalentRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketUnlockAvatarTalentRsp.class */
public class PacketUnlockAvatarTalentRsp extends BasePacket {
    public PacketUnlockAvatarTalentRsp(Avatar avatar, int talentId) {
        super(PacketOpcodes.UnlockAvatarTalentRsp);
        setData(UnlockAvatarTalentRspOuterClass.UnlockAvatarTalentRsp.newBuilder().setAvatarGuid(avatar.getGuid()).setTalentId(talentId).build());
    }
}
