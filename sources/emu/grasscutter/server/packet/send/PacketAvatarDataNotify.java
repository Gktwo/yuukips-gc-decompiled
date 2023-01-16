package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarDataNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarDataNotify.class */
public class PacketAvatarDataNotify extends BasePacket {
    public PacketAvatarDataNotify(Player player) {
        super((int) PacketOpcodes.AvatarDataNotify, true);
        AvatarDataNotifyOuterClass.AvatarDataNotify.Builder proto = AvatarDataNotifyOuterClass.AvatarDataNotify.newBuilder().setCurAvatarTeamId(player.getTeamManager().getCurrentTeamId()).setChooseAvatarGuid(player.getTeamManager().getCurrentCharacterGuid()).addAllOwnedFlycloakList(player.getFlyCloakList()).addAllOwnedCostumeList(player.getCostumeList());
        player.getAvatars().forEach(avatar -> {
            proto.addAvatarList(avatar.toProto());
        });
        player.getTeamManager().getTeams().forEach(id, teamInfo -> {
            proto.putAvatarTeamMap(id.intValue(), teamInfo.toProto(player));
            if (id.intValue() > 4) {
                proto.addBackupAvatarTeamOrderList(id.intValue());
            }
        });
        Avatar mainCharacter = player.getAvatars().getAvatarById(player.getMainCharacterId());
        if (mainCharacter != null) {
            proto.setChooseAvatarGuid(mainCharacter.getGuid());
        }
        setData(proto.build());
    }
}
