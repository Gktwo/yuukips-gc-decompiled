package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ProfilePictureOuterClass;
import emu.grasscutter.net.proto.SetPlayerHeadImageRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSetPlayerHeadImageRsp.class */
public class PacketSetPlayerHeadImageRsp extends BasePacket {
    public PacketSetPlayerHeadImageRsp(Player player) {
        super(PacketOpcodes.SetPlayerHeadImageRsp);
        setData(SetPlayerHeadImageRspOuterClass.SetPlayerHeadImageRsp.newBuilder().setProfilePicture(ProfilePictureOuterClass.ProfilePicture.newBuilder().setAvatarId(player.getHeadImage())).build());
    }
}
